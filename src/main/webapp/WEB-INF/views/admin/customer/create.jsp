<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIUserrl" value="/api/users"></c:url>
<c:url var="usersCreateUrl" value="/admin/users-create"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer</title>
</head>

<body>
	<div class="container px-4">
		<h1 class="mt-4">Khách hàng</h1>
		<ol class="breadcrumb mb-4">
			<li class="breadcrumb-item"><a
				href="<c:url value='/admin/home'></c:url>">Dashboard</a></li>
			<li class="breadcrumb-item active">Khách hàng</li>
		</ol>
		<c:if test="${param.alert == 'fail'}">
			<div class="alert alert-danger">Thêm thất bại</div>
		</c:if>
		<c:if test="${param.alert == 'success'}">
			<div class="alert alert-success">Thêm thành công</div>
		</c:if>
		<div class="border border-secondary pt-3">
			<form action="" id="createFrom" method="POST">
				<div class="row m-0">
					<div class="col-6">
						<div class="form-group">
							<label for="inputUserName">Tên người dùng</label> <input
								type="text" class="form-control" id="inputUserName"
								name="userName" value="" /> <small></small>
						</div>
					</div>
					<div class="col-6">
						<div class="form-group">
							<label for="inputNameBuilding">Họ và tên</label> <input
								type="text" class="form-control" id="inputFullName" name="name"
								value="" /> <small></small>
						</div>
					</div>
				</div>
				<div class="row m-0">
					<div class="col-6">
						<div class="form-group">
							<label for="inputEmail">Email</label> <input type="text"
								class="form-control" id="inputEmail" name="email" value="" /> <small></small>
						</div>
					</div>
					<div class="col-6">
						<div class="form-group">
							<label for="inputName">Số điện thoại</label> <input type="text"
								class="form-control" id="inputPhoneNumber" name="phoneNumber"
								value="" /> <small></small>
						</div>
					</div>
				</div>
				<div class="row m-0">
					<div class="col-6">
						<div class="form-group">
							<label for="gender">Giới tính</label> <select
								class="form-control" id="gender" name="gender">
								<option value="">-- Chọn giới tính --</option>
								<c:forEach var="item" items="${gender}">
									<option value="${item.key}">${item.value}</option>
								</c:forEach>
							</select> <small></small>
						</div>
					</div>
					<div class="col-6"></div>
				</div>
				<div class="m-3">
					<button type="submit" id="btnCreate" class="btn btn-success">
						Thêm khách hàng</button>
				</div>
			</form>
		</div>
	</div>
	<script>
		$("#btnCreate").on("click", function(event) {
			event.preventDefault();
			let regexPhone = /^[0-9]{10}$/;
			let regexUserName = /^[a-z0-9]+$/;
			showEmptyOrInvalid($("#inputUserName"), regexUserName, "Tên người dùng không hợp lệ");
			showEmptyOrInvalid($("#inputFullName"), null, "");
			showEmptyOrInvalid($("#inputPhoneNumber"), regexPhone, "Số điện thoại gồm 10 kí tự số");
			showEmptyOrInvalid($("#gender"), null, "");
			if ($(".text-danger").text().length != 0){
				return;
			}
			let data = {};
			let formData = $("#createFrom").serializeArray();
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});
			$.ajax({
				url : "${APIUserrl}",
				type : "POST",
				contentType : "application/json",
				data : JSON.stringify(data),
				dataType : "json",
				success : function(result) {
					window.location.href = '${usersCreateUrl}?alert=success';
				},
				error : function(result) {
					let data=result.responseText;
					let jsonResponse = JSON.parse(data);
					let error = jsonResponse["error"];
					console.log(result.responseText);
					if(error == 'Username Already Exist') {
						showError($("#inputUserName"), "Tên người dùng đã tồn tại");
					} else {
						window.location.href = '${usersCreateUrl}?alert=fail';
					}
				},
			});
		});
	</script>
</body>

</html>