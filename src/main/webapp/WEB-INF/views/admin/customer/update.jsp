<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIUserUrl" value="/api/users"></c:url>
<c:url var="APIAreaUrl" value="/api/area"></c:url>
<c:url var="APITransactionsUrl" value="/api/transactions"></c:url>
<c:url var="usersUpdateUrl" value="/admin/users-update"></c:url>
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
			<div class="alert alert-danger">Cập nhật thất bại</div>
		</c:if>
		<c:if test="${param.alert == 'success'}">
			<div class="alert alert-success">Cập nhật thành công</div>
		</c:if>
		<div class="border border-secondary pt-3">
			<form action="" id="updateFrom" method="POST">
				<div class="row m-0">
					<div class="col-6">
						<div class="form-group">
							<label for="inputNameBuilding">Tên khách hàng</label> <input
								type="text" class="form-control" id="inputNameCustomer"
								name="name" value="${usersReponse.fullName}" /> <small></small>
						</div>
					</div>
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
				</div>
				<div class="row m-0">
					<div class="col-6">
						<div class="form-group">
							<label for="inputEmail">Email</label> <input type="text"
								class="form-control" id="inputEmail" name="email"
								value="${usersReponse.email}" /> <small></small>
						</div>
					</div>
					<div class="col-6">
						<div class="form-group">
							<label for="inputName">Số điện thoại</label> <input type="text"
								class="form-control" id="inputPhoneNumber" name="phoneNumber"
								value="${usersReponse.phoneNumber}" /> <small></small>
						</div>
					</div>
				</div>
				<div class="row m-0">
					<div class="col-6">
						<div class="form-group">
							<label for="empoloyeeOfCharge">Nhân Viên Phụ Trách</label> <select
								class="form-control" id="empoloyeeOfCharge"
								name="empoloyeeOfCharge">
								<option value="">-- Chọn Nhân Viên Phụ Trách --</option>
								<c:forEach var="item" items="${empoloyeeOfCharge}">
									<option value="${item.id}">${item.fullName}</option>
								</c:forEach>
							</select> <small></small>
						</div>
					</div>
				</div>
				<div class="m-3">
					<button type="submit" id="btnUpdate" class="btn btn-success">
						Cập nhật khách hàng</button>
				</div>
			</form>
		</div>
		<div class="border border-secondary pt-3 mt-2">
			<div class="row m-0">
				<h3 class="pr-3">Chăm sóc khách hàng</h3>
				<div class="row m-0">
					<table class="w-100 table table-bordered text-center">
						<thead>
							<tr>
								<th>Building</th>
								<th>Tầng</th>
								<th>Diện tích</th>
								<th>Giá</th>
								<th>Loại giao dịch</th>
								<th>Ghi Chú</th>
							</tr>
						</thead>
						<tbody id="resultTable">
							<c:forEach var="item" items="${transactions}">
								<tr>
									<td>${item.buildingName}</td>
									<td>${item.floor}</td>
									<td>${item.area}</td>
									<td>${item.price}</td>
									<td>${item.transactionType}</td>
									<td>${item.note}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="text-end mt-1">
			<i class="btn btn-outline-info fas fa-plus-square"
				data-toggle="modal" data-target="#addTransaction"></i>
		</div>
	</div>
	<!-- Modal Transaction -->
	<div class="modal fade bd-example-modal-lg" id="addTransaction"
		tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"
		aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="#">Tòa nhà</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="row m-3">
						<table class="w-100 table table-bordered text-center">
							<thead>
								<tr>
									<th>Tên tòa nhà</th>
									<th>Địa chỉ</th>
									<th>Tên quản lý</th>
									<th>Diện tích - Giá thuê</th>
								</tr>
							</thead>
							<tbody id="">
								<c:forEach var="item" items="${buildingReponse}">
									<tr>
										<td><a href="" data-toggle="modal"
											data-target="#addTransactionArea"
											onclick="transactionArea(${item.id})">${item.name}</a></td>
										<td>${item.address}</td>
										<td>${item.managerName}</td>
										<td><c:forEach var="itemAreaAndPrice"
												items="${item.areaEmpty}">
								${itemAreaAndPrice} <br>
											</c:forEach></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Đóng</button>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal Transaction Area -->
	<div class="modal fade bd-example-modal-lg" id="addTransactionArea"
		tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"
		aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="addAreaModalLabel">Diện tích</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="row m-3">
						<table class="w-100 table table-bordered text-center" id="resultTable">
							<thead>
								<tr>
									<th>Tầng</th>
									<th>Diện tích(m2)</th>
									<th>Giá</th>
									<th>Tình trạng</th>
									<th class="text-center"><input type="checkbox" id=""
										value="" /></th>
								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
					</div>
					<div class="row m-0">
						<div class="col-6">
							<div class="form-group">
								<label for="transactionType">Loại Giao Dịch</label> <select
									class="form-control" name="tranType" id="tranType">
									<option value="">-- Chọn Loại Giao Dịch --</option>
									<c:forEach var="item" items="${transactionsType}">
										<option value="${item.id}">${item.name}</option>
									</c:forEach>
								</select> <small></small>
							</div>
						</div>
						<div class="col-6">
							<div class="form-group">
								<label for="inputNote">Ghi Chú</label> <input type="text"
									class="form-control" id="inputNote" /> <small></small>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Đóng</button>
					<button type="button" id="btnAddTransactionsArea" class="btn btn-primary">
						Lưu</button>
				</div>
			</div>
		</div>
	</div>
	<script>
	$("#gender").val("${usersReponse.gender}");
	
	$("#btnAddTransactionsArea").on("click", function(event) {
		showEmptyOrInvalid($("#tranType"), null, "");
		if ($("#tranType").next().text().length != 0){
			return;
		}
		let data = getData();
		let id = "${usersReponse.id}";
		$.ajax({
			url : "${APITransactionsUrl}",
			type : "POST",
			contentType : "application/json",
			data : JSON.stringify(data),
			dataType : "json",
			success : function(result) {
				window.location.href = '${usersUpdateUrl}?id='+id+'&alert=success';
			},
			error : function(result) {
				window.location.href = '${usersUpdateUrl}?id='+id+'&alert=fail';
			},
		});
	});
	
	function getData() {
		let data = {};
		data["areaIds"] = $('#resultTable tbody input[type=checkbox]:checked').map(function () {
	        		return $(this).val();
	        	}).get();
		data["customerId"] = "${usersReponse.id}";
		data["employeeId"] = "${usersReponse.manageId}";
		data["note"] = document.getElementById("inputNote").value;
		data["transactionTypeId"] = document.getElementById("tranType").value;
		//console.log(transactionId);
		return data;
	}
	
	$("#btnUpdate").on("click", function(event) {
		event.preventDefault();
		let regexPhone = /^[0-9]{10}$/;
		showEmptyOrInvalid($("#inputNameCustomer"), null, "");
		showEmptyOrInvalid($("#inputPhoneNumber"), regexPhone, "Số điện thoại gồm 10 kí tự số");
		showEmptyOrInvalid($("#gender"), null, "");
		if ($("#inputNameCustomer").next().text().length != 0){
			return;
		}
		if ($("#inputPhoneNumber").next().text().length != 0){
			return;
		}
		if ($("#gender").next().text().length != 0){
			return;
		}
		let data = {};
		let id = "${usersReponse.id}";
		data["id"] = id;
		let formData = $("#updateFrom").serializeArray();
		$.each(formData, function(i, v) {
			data["" + v.name + ""] = v.value;
		});
		$.ajax({
			url : "${APIUserUrl}",
			type : "PUT",
			contentType : "application/json",
			data : JSON.stringify(data),
			dataType : "json",
			success : function(result) {
				window.location.href = '${usersUpdateUrl}?id='+id+'&alert=success';
			},
			error : function(result) {
				window.location.href = '${usersUpdateUrl}?id='+id+'&alert=fail';
			},
		});
	});
	function transactionArea(buildingId) {
		$.ajax({
			url : "${APIAreaUrl}?buildingId="+buildingId+"",
			type : "GET",
			//contentType : "application/json",
			//data : JSON.stringify(data),
			dataType : "json",
			success : function(result) {
				 let row = displayData(result)
				  $('#resultTable tbody').html(row);
				 //console.log(row);
				//window.location.href = '${usersCreateUrl}?id='+id+'&alert=success';
			},
			error : function(result) {
				//window.location.href = '${usersUpdateUrl}?id='+id+'&alert=fail';
			},
		});
	}
	function rowData(object) {
	  	let row = '<tr>';
		row += '<td>'+object.floor+'</td>';
		row += '<td>'+object.area+'</td>';
		row += '<td>'+object.price+'</td>';
		row += '<td>'+object.statusString+'</td>';
		row += '<td><input type=checkbox id='+object.id+' value='+object.id+' /></td>';
		row += '</tr>';
	 return row;
	}
	function displayData(arrayObject) {
		  let row = "";
		  for (let index = 0; index < arrayObject.length; index++) {
			    row += rowData(arrayObject[index]);
			}
		  return row;
	}

	</script>
</body>

</html>