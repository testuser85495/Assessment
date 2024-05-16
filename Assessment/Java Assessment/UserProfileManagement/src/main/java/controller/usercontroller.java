package controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;

import doa.UserDoa;
import model.user;
import servicess.serviceOTP;

/**
 * Servlet implementation class usercontroller
 */
@WebServlet("/usercontroller")
public class usercontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public usercontroller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("register")) {
			user u = new user();
			u.setFname(request.getParameter("fname"));
			u.setLname(request.getParameter("lname"));
			u.setEmail(request.getParameter("email"));
			u.setMobile(Long.parseLong(request.getParameter("mobile")));
			u.setAddress(request.getParameter("address"));
			u.setGender(request.getParameter("gender"));
			u.setPassword(request.getParameter("password"));
			u.setStatus("pending");
			String password = request.getParameter("password");
			String cpassword = request.getParameter("cpassword");
			String email = request.getParameter("email");
			boolean flag = UserDoa.checkEmail(email);
			System.out.println(u);
			if (password.equals(cpassword)) {
				if (flag == false) {
					UserDoa.register(u);
					Random r = new Random();
					int num = r.nextInt(9999);
					serviceOTP s = new serviceOTP();
					s.sendMail(email, num);
					request.setAttribute("email", email);
					request.setAttribute("otp", num);
					request.getRequestDispatcher("otp_page.jsp").forward(request, response);
				}
				else {
					request.setAttribute("msg1", "Email AllReady Registered");
					request.getRequestDispatcher("register.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("msg", "password & confirm password not match");
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}
		} 
		else if (action.equalsIgnoreCase("verify")) {
			String email = request.getParameter("email");
			int otp1 = Integer.parseInt(request.getParameter("otp1"));
			int otp2 = Integer.parseInt(request.getParameter("otp2"));
			if (otp1 == otp2) {
				user u1 = new user();
				u1.setEmail(request.getParameter("email"));
				u1.setStatus("complete");
				UserDoa.statuschange(email, u1);
				response.sendRedirect("login.jsp");
			}
			else {
				request.setAttribute("email", email);
				request.setAttribute("otp", otp1);
				request.setAttribute("msg1", "OTP NOT MATCH");
				request.getRequestDispatcher("otp_page.jsp").forward(request, response);
			}

		}
		else if (action.equalsIgnoreCase("login")) {
			user u = new user();
			u.setEmail(request.getParameter("email"));
			u.setPassword(request.getParameter("password"));
			System.out.println(u);
			String email = request.getParameter("email");
			boolean flag = UserDoa.checkEmail(email);
			if (flag == true) {
				user u1 = UserDoa.login(u);
				if (u1 != null) {
					HttpSession session = request.getSession();
					session.setAttribute("data", u1);
					request.getRequestDispatcher("main.jsp").forward(request, response);
				} else {
					request.setAttribute("msg", "Password Is Incorrect");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}

			} else {
				request.setAttribute("msg1", "Account Not Register");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}

		} else if (action.equalsIgnoreCase("Change password")) {
			int id = Integer.parseInt(request.getParameter("id"));
			String opd = request.getParameter("opd");
			boolean flag = UserDoa.passwordcheck(id, opd);
			String npd = request.getParameter("npd");
			String cpd = request.getParameter("cpd");
			if (flag == true) {
				if (npd.equals(cpd)) {
					UserDoa.updatepassword(id, npd);
					HttpSession session = request.getSession();
					response.sendRedirect("login.jsp");

				} else {
					request.setAttribute("msg", "New password & confirm password not match");
					request.getRequestDispatcher("Changepassword.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("msg1", "old password Incorrect");
				request.getRequestDispatcher("Changepassword.jsp").forward(request, response);
				System.out.println("old password Incorrect");
			}

		}
		else if (action.equalsIgnoreCase("Forgot password")) {
			String email = request.getParameter("email");
			boolean flag = UserDoa.checkEmail(email);
			if (flag == true) {
				user u = new user();
				Random r=new Random();
				int num = r.nextInt(9999);
				serviceOTP s = new serviceOTP();
				s.sendMail(email, num);
				request.setAttribute("email", email);
				request.setAttribute("otp", num);
				request.getRequestDispatcher("forgot-pass-otp.jsp").forward(request, response);
			}
			else {
				request.setAttribute("msg1", "Account Not Register");
				request.getRequestDispatcher("forgotpassword.jsp").forward(request, response);
			}
		}
		else if (action.equalsIgnoreCase("verify otp")) {
			String email = request.getParameter("email");
			int otp1 = Integer.parseInt(request.getParameter("otp1"));
			int otp2 = Integer.parseInt(request.getParameter("otp2"));
			if (otp1 == otp2) {
				request.setAttribute("email", email);
				request.setAttribute("otp", otp1);
				request.getRequestDispatcher("new-password.jsp").forward(request, response);
			}
			else {
				request.setAttribute("email", email);
				request.setAttribute("otp", otp1);
				request.setAttribute("msg1", "OTP NOT MATCH");
				request.getRequestDispatcher("forgot-pass-otp.jsp").forward(request, response);
			}
		}
		else if (action.equalsIgnoreCase("new password")) {
			String email = request.getParameter("email");
			String npassword = request.getParameter("npassword");
			String cpassword = request.getParameter("cpassword");
			if (npassword.equals(cpassword)) {
				UserDoa.changepassword(email, npassword);
				response.sendRedirect("login.jsp");
			}
			else {
				request.setAttribute("msg", "New password & confirm password not match");
				request.getRequestDispatcher("new-password.jsp").forward(request, response);
			}
		}
	}

}
