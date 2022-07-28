package filters;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginFilter implements Filter {

	private FilterConfig config;

	public void init(FilterConfig config) {
		this.config = config;
	}

	public void destroy() {
		config = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws ServletException, IOException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		HttpSession session = req.getSession();
//		session.setAttribute("location", req.getRequestURI());
		Object account = session.getAttribute("memberVO");
		if (account == null ) {		//憭望��
			System.out.println("222222222");
			session.setAttribute("location", req.getRequestURI());
			res.sendRedirect(req.getContextPath() + "/front_end/member/MemberLogin.jsp");
			return;
		} else {	
			//����
			
			chain.doFilter(request, response);
		}
	}
}