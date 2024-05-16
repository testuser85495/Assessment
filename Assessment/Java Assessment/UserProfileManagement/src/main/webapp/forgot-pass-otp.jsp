<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Otp</title>
</head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<style>
/* .container {
	width: 400px;
	display: flex;
	align-content: center;
	justify-content: center;
} */
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
										<h3 class="mb-5 text-uppercase">OTP </h3>
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
										<%
										String email = (String) request.getAttribute("email");
										%>
										<%
										int otp = (Integer) (request.getAttribute("otp"));
										%>

										<input type="hidden" name="email" value="<%=email%>">
										<input type="hidden" name="otp1" value="<%=otp%>"> <label
											class="form-label" for="form3Example1n">OTP</label>
										<div data-mdb-input-init class="form-outline">
											<input type="text" id="form3Example1n" name="otp2"
												class="form-control form-control-lg" />
										</div>
										<div class="d-flex justify-content-end pt-3">
											<button type="submit" data-mdb-button-init value="Verify otp"
												name="action" data-mdb-ripple-init
												class="btn btn-warning btn-lg ms-2">Verify</button>
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