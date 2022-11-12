<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="customerSearchURL" value="/admin/customer"></c:url>
<c:url var="APIBuildingurl" value="/api/building"></c:url>
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
			<div class="alert alert-danger">Xóa thất bại</div>
		</c:if>
		<c:if test="${param.alert == 'success'}">
			<div class="alert alert-success">Xóa thành công</div>
		</c:if>
		<div class="border border-secondary pt-3">
			<form:form modelAttribute="customerSearch"
				action="${customerSearchURL}" id="searchForm" method="GET">
				<div class="row m-0">
					<div class="col-6">
						<div class="form-group">
							<label for="inputNameCustomer">Tên khách hàng</label> <input
								type="text" class="form-control" id="inputNameCustomer"
								name="name" value="${customerSearch.name}" /> <small></small>
						</div>
					</div>
					<div class="col-6">
						<div class="form-group">
							<label for="inputPhoneNumber">Số điện thoại</label> <input
								type="text" class="form-control" id="inputPhoneNumber"
								name="phoneNumber" value="${customerSearch.phoneNumber}" /> <small></small>
						</div>
					</div>
				</div>
				<div class="row m-0">
					<div class="col-6">
						<div class="form-group">
							<label for="gender">Giới tính</label> <select
								class="form-control" id="gender" name="gender"
								value="${customerSearch.gender}">
								<option value="">-- Chọn giới tính --</option>
								<c:forEach var="item" items="${gender}">
									<option value="${item.key}">${item.value}</option>
								</c:forEach>
							</select> <small></small>
						</div>
					</div>
					<div class="col-6">
						<div class="form-group">
							<label for="empoloyeeOfCharge">Nhân Viên Phụ Trách</label> <select
								class="form-control" id="empoloyeeOfCharge"
								name="managerId" value="${customerSearch.managerId}">
								<option value="">-- Chọn Nhân Viên Phụ Trách --</option>
								<c:forEach var="item" items="${empoloyeeOfCharge}">
									<option value="${item.id}">${item.fullName}</option>
								</c:forEach>
							</select> <small></small>
						</div>
					</div>
				</div>
				<div class="m-3">
					<button type="submit" id="btnSearch" class="btn btn-success">
						Tìm kiếm</button>
				</div>
			</form:form>
		</div>
		<div class="text-end mt-1">
			<a href="<c:url value='/admin/users-create'></c:url>"> <i
				class="btn btn-outline-secondary fas fa-plus-square"></i></a>
		</div>
		<div class="row m-3">
			<table class="w-100 table table-bordered text-center">
				<thead>
					<tr>
						<th class="text-center"><input type="checkbox" id="" value="" />
						</th>
						<th>Tên khách hàng</th>
						<th>Nhân viên quản lý</th>
						<th>Số điện thoại</th>
						<th>Email</th>
						<th>Thao tác</th>
					</tr>
				</thead>
				<tbody id="resultTable">
					<c:forEach var="item" items="${customerResponse}">
						<tr>
							<td><input type="checkbox" id="${item.id}" value="" /></td>
							<td>${item.fullName}</td>
							<td>${item.fullNameManage}</td>
							<td>${item.phoneNumber}</td>
							<td>${item.email}</td>
							<td>
								<div class="d-inline-flex">
									<a href="<c:url value='/admin/users-update?id=${item.id}'></c:url>"><i id="${item.id}" class="btn fas fa-edit p-1"></i></a>
									<a href="#"><i id="${item.id}" class="btn fas fa-trash p-1"></i></a>
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<script>
		$("#btnSearch").on("click", function(event) {
			event.preventDefault();
			$("#searchForm").submit();
		});
		function deleteBuilding(id) {
			let data = {};
			data["id"] = id;
			$.ajax({
				url : "${APIBuildingurl}",
				type : "DELETE",
				contentType : "application/json",
				data : JSON.stringify(data),
				//dataType: "json",
				success : function() {
					window.location.href = '${buldingSearchURL}?alert=success';
				},
				error : function() {
					window.location.href = '${buldingSearchURL}?alert=fail';
				},
			});
		}
	</script>
</body>

</html>