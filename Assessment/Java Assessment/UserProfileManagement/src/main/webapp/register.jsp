<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registation Form</title>
</head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<style>
.card-registration .select-input.form-control[readonly]:not([disabled])
	{
	font-size: 1rem;
	line-height: 2.15;
	padding-left: .75em;
	padding-right: .75em;
}

.card-registration .select-arrow {
	top: 13px;
}
h6{color:red;}
</style>
<body>
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
										<h3 class="mb-5 text-uppercase">Student registration form</h3>
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
										<%if(msg1 != null){ 
										%>
										<h6>
											<%
											out.print(msg1);
											%>
										</h6>
										<%} %>
										
										<div class="row">
											<div class="col-md-6 mb-4">
												<label class="form-label" for="form3Example1m">First
													name</label>
												<div data-mdb-input-init class="form-outline">
													<input type="text" id="form3Example1m" name="fname"
														class="form-control form-control-lg" />
												</div>
											</div>
											<div class="col-md-6 mb-4">
												<label class="form-label" for="form3Example1n">Last
													name</label>
												<div data-mdb-input-init class="form-outline">
													<input type="text" id="form3Example1n" name="lname"
														class="form-control form-control-lg" />
												</div>
											</div>
										</div>
										<div data-mdb-input-init class="form-outline mb-4">
											<label class="form-label" for="form3Example97">Email
												ID</label> <input type="text" id="form3Example97" name="email"
												class="form-control form-control-lg" />
										</div>
										<div data-mdb-input-init class="form-outline mb-4">
											<label class="form-label" for="form3Example97">Mobile</label>
											<input type="text" id="form3Example97" name="mobile"
												class="form-control form-control-lg" />
										</div>
										<div data-mdb-input-init class="form-outline mb-4">
											<label class="form-label" for="form3Example8">Address</label>
											<input type="text" id="form3Example8" name="address"
												class="form-control form-control-lg" />
										</div>
										<div
											class="d-md-flex justify-content-start align-items-center mb-4 py-2">

											<p class="mb-0 me-4">Gender</p>

											<div class="form-check form-check-inline mb-0 me-4">
												<label class="form-check-label" for="femaleGender">Female</label>
												<input class="form-check-input" type="radio" name="gender"
													id="femaleGender" value="female" />

											</div>

											<div class="form-check form-check-inline mb-0 me-4">
												<label class="form-check-label" for="maleGender">Male</label>
												<input class="form-check-input" type="radio" name="gender"
													id="maleGender" value="male" />

											</div>
										</div>
										<div data-mdb-input-init class="form-outline mb-4">
											<label class="form-label" for="form3Example8">Password</label>
											<input type="password" id="form3Example8" name="password"
												class="form-control form-control-lg" />
										</div>
										<div data-mdb-input-init class="form-outline mb-4">
											<label class="form-label" for="form3Example8">Confirm
												Password</label> <input type="password" id="form3Example8"
												name="cpassword" class="form-control form-control-lg" />
										</div>
										<div class="d-flex justify-content-end pt-3">
											<button type="submit" data-mdb-button-init value="Register"
												name="action" data-mdb-ripple-init
												class="btn btn-warning btn-lg ms-2">Submit form</button>
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