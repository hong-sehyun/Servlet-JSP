package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import membership.MemberDAO;
import membership.MemberDTO;

@WebServlet(urlPatterns = "/13Servlet/MemberAuth.mvc", initParams = {
		@WebInitParam(name = "admin_id", value = "nakja") })
public class MemberAuth extends HttpServlet {

	private static final long serialVersionUID = 1L;
	MemberDAO dao;

	@Override
	public void init() throws ServletException {
		ServletContext application = this.getServletContext();

		String driver = application.getInitParameter("MySQLDriver");
		String connectUrl = application.getInitParameter("MySQLUrl");
		String sId = application.getInitParameter("MySQLId");
		String sPass = application.getInitParameter("MySQLPwd");

		dao = new MemberDAO(driver, connectUrl, sId, sPass);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String admin_id = this.getInitParameter("admin_id");

		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		System.out.println(id+","+pass);
		MemberDTO memberDTO = dao.getMemberDTO(id, pass);

		String memberName = null;
		if (memberDTO != null)
			memberName = memberDTO.getName();

		if (memberName != null) {
			req.setAttribute("authMessage", memberName + "회원님 반갑");
		} else {
			if (admin_id.equals(id))
				req.setAttribute("authMessage", admin_id + "는 최고 관리자");
			else
				req.setAttribute("authMessage", "귀하는 회원 아님");
		}
		req.getRequestDispatcher("/13Servlet/MemberAuth.jsp").forward(req, resp);
	}

	@Override
	public void destroy() {
		dao.close();
	}
}
