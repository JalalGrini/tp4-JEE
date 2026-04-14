package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

/**
 * Servlet Filter implementation class SessionFilter
 */
public class SessionFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public SessionFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        
        boolean loggedIn = (session != null && session.getAttribute("user") != null);
        String requestURI = req.getRequestURI();
        User currentUser = (session != null) ? (User) session.getAttribute("user") : null;

        if (loggedIn) {
            if (requestURI.endsWith("login.jsp")) {
            	if ("admin".equals(currentUser.getRole())) {
            		res.sendRedirect(req.getContextPath() + "/index.jsp"); // Admin -> index
                } else {
                	res.sendRedirect(req.getContextPath() + "/list.jsp");  // User -> list
                }
            } else {
                // If logged in and going to Home, let them through
                chain.doFilter(request, response);
            }
        } else {
            boolean isLoginPage = requestURI.endsWith("login.jsp") || requestURI.endsWith("/loginhandler");
            if (isLoginPage) {
                chain.doFilter(request, response); // let them see login
            } else {
            	res.sendRedirect(req.getContextPath() + "/login.jsp"); // block everything else
            }
   
        }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
