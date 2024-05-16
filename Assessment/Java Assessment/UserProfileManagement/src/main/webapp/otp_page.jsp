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
.container {
	width: 400px;
	display: flex;
	align-content: center;
	justify-content: center;
}
</style>
<body>
	<form method="post" action="usercontroller">
		<div class="container">
		<%String msg1 = (String) request.getAttribute("msg1"); %>
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
			<div class="col-md-6 mb-4">
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
					<button type="submit" data-mdb-button-init value="Verify"
						name="action" data-mdb-ripple-init
						class="btn btn-warning btn-lg ms-2">Verify</button>
				</div>
			</div>
		</div>
	</form>
</body>
</html>