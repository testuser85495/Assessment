<%@page import="model.user"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change Password</title>
</head>
<style>
h6 {
	color: red;
}
</style>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<body>
	<%
	user u = null;
	if (session.getAttribute("data") != null) {
		u = (user) session.getAttribute("data");
	} else {
		response.sendRedirect("login.jsp");
	}
	%>
	<!-- Navbar -->
	<nav class="navbar navbar-expand-lg navbar-light bg-body-tertiary">
		<!-- Container wrapper -->
		<div class="container-fluid">
			<!-- Collapsible wrapper -->
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<!-- Navbar brand -->
				<a class="navbar-brand mt-2 mt-lg-0" href="index.jsp">Profile
					Management </a>

			</div>
			<!-- Collapsible wrapper -->

			<!-- Right elements -->
			<div class="d-flex align-items-center">
				<!-- Icon -->
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" href="index.jsp">Home </a></li>
				</ul>
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" href="logout.jsp">Logout
							(<%=u.getFname()%>)
					</a></li>
				</ul>
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link"
						href="Changepassword.jsp">Change Password</a></li>
				</ul>
			</div>
			<!-- Right elements -->
		</div>
		<!-- Container wrapper -->
	</nav>
	<!-- Navbar -->




	<section class="h-100 bg-dark">
		<div class="container py-5 h-100">
			<form action="usercontroller" method="post">
				<div
					class="row d-flex justify-content-center align-items-center h-100">
					<div class="col">
						<div class="card card-registration my-4">
							<div class="row g-0">
								<div class="col-xl-6 d-none d-xl-block">
									<img
										src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/img4.webp"
										alt="Sample photo" class="img-fluid"
										style="border-top-left-radius: .25rem; border-bottom-left-radius: .25rem;" />
								</div>

								<div class="col-xl-6">
									<div class="card-body p-md-5 text-black">
										<h3 class="mb-5 text-uppercase">Change Password</h3>
										<%
										String msg = (String) request.getAttribute("msg");
										String msg1 = (String) request.getAttribute("msg1");
										if (msg != null) {
										%>
										<h6>
											<%
											out.print(msg);
											%>
										</h6>
										<%
										}
										%>
										<%
										if (msg1 != null) {
										%>
										<h6>
											<%
											out.print(msg1);
											%>
										</h6>
										<%
										}
										%>
										<input type="hidden" name="id" value="<%=u.getId()%>">
										<div data-mdb-input-init class="form-outline mb-4">
											<label class="form-label" for="form3Example97">Old
												Password</label> <input type="text" id="form3Example97" name="opd"
												class="form-control form-control-lg" />
										</div>

										<div data-mdb-input-init class="form-outline mb-4">
											<label class="form-label" for="form3Example8">New
												Password</label> <input type="password" id="form3Example8"
												name="npd" class="form-control form-control-lg" />
										</div>
										<div data-mdb-input-init class="form-outline mb-4">
											<label class="form-label" for="form3Example8">Confirm
												Password</label> <input type="password" id="form3Example8"
												name="cpd" class="form-control form-control-lg" />
										</div>

										<div class="d-flex justify-content-end pt-3">
											<button type="submit" data-mdb-button-init
												value="Change password" name="action" data-mdb-ripple-init
												class="btn btn-warning btn-lg ms-2">Change Password</button>
										</div>
									</div>
								</div>

							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</section>


</body>
</html>