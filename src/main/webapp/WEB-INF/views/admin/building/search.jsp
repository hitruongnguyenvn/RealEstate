<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="buldingSearchURL" value="/admin/building"></c:url>
<c:url var="APIBuildingurl" value="/api/building"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Building</title>
</head>

<body>
	<div class="container px-4">
		<h1 class="mt-4">Tòa nhà</h1>
		<ol class="breadcrumb mb-4">
			<li class="breadcrumb-item"><a
				href="<c:url value='/admin/home'></c:url>">Dashboard</a></li>
			<li class="breadcrumb-item active">Tòa nhà</li>
		</ol>
		<c:if test="${param.alert == 'fail'}">
			<div class="alert alert-danger">	
				Xóa thất bại
			</div>
		</c:if>
		<c:if test="${param.alert == 'success'}">
			<div class="alert alert-success">	
				Xóa thành công
			</div>
		</c:if>	
		<div class="border border-secondary pt-3">
			<form:form modelAttribute="buildingSearch"
				action="${buldingSearchURL}" id="searchForm" method="GET">
				<div class="row m-0">
					<div class="col-6">
						<div class="form-group">
							<label for="inputNameBuilding">Tên tòa nhà</label> <input
								type="text" class="form-control" id="inputNameBuilding"
								name="name" value="${buildingSearch.name}" /> <small></small>
						</div>
					</div>
					<div class="col-3">
						<div class="form-group">
							<label for="city">Thành phố</label> <select class="form-control"
								name="city" id="city" disabled>
								<option value="">-- Chọn thành phố --</option>
							</select> <small></small>
						</div>
					</div>
					<div class="col-3">
						<div class="form-group">
							<label for="unit">Quận</label> <select class="form-control"
								name="district" id="district">
								<option value="">-- Chọn Quận --</option>
								<c:forEach var="item" items="${district}">
									<option value="${item.id}">${item.name}</option>
								</c:forEach>
							</select> <small></small>
						</div>
					</div>
				</div>
				<div class="row m-0">
					<div class="col-6">
						<div class="form-group">
							<label for="inputWard">Phường</label> <input type="text"
								class="form-control" id="inputWard" name="ward"
								value="${buildingSearch.ward}" /> <small></small>
						</div>
					</div>
					<div class="col-6">
						<div class="form-group">
							<label for="inputStreet">Đường</label> <input type="text"
								class="form-control" id="inputStreet" name="street" value="" />
							<small></small>
						</div>
					</div>
				</div>
				<div class="row m-0">
					<div class="col-3">
						<div class="form-group">
							<label for="inputAreaTo">Diện tích từ</label> <input type="text"
								class="form-control" id="inputAreaTo" name="areaTo" value="" />
							<small></small>
						</div>
					</div>
					<div class="col-3">
						<div class="form-group">
							<label for="inputAreaFrom">Diện tích đến</label> <input
								type="text" class="form-control" id="inputAreaFrom"
								name="areaFrom" value="" /> <small></small>
						</div>
					</div>
					<div class="col-3">
						<div class="form-group">
							<label for="inputPriceTo">Giá từ</label> <input type="text"
								class="form-control" id="inputPriceTo" name="priceTo" value="" />
							<small></small>
						</div>
					</div>
					<div class="col-3">
						<div class="form-group">
							<label for="inputPriceFrom">Giá đến</label> <input type="text"
								class="form-control" id="inputPriceFrom" name="priceFrom"
								value="" /> <small></small>
						</div>
					</div>
				</div>
				<div class="row m-0">
					<div class="col-3">
						<div class="form-group">
							<label for="inputNameManager">Tên quản lý</label> <input
								type="text" class="form-control" id="inputNameManager"
								name="managerName" value="" /> <small></small>
						</div>
					</div>
					<div class="col-3">
						<div class="form-group">
							<label for="inputNumberOfBasement">Số điện thoại quản lý</label>
							<input type="text" class="form-control"
								id="inputPhoneNumberManager" name="managerPhoneNumber" value="" />
							<small></small>
						</div>
					</div>
					<div class="col-3">
						<div class="form-group">
							<label for="inputNumberOfBasement">Số tầng hầm</label> <input
								type="text" class="form-control" id="inputNumberOfBasement"
								name="numberOfBasement" value="" /> <small></small>
						</div>
					</div>
					<div class="col-3">
						<div class="form-group">
							<label for="empoloyeeOfCharge">Nhân viên phụ trách</label> <select
								class="form-control" name="usersId" id="empoloyeeOfCharge">
								<option value="">-- Chọn Nhân viên --</option>
								<c:forEach var="item" items="${empoloyeeOfCharge}">
									<option value="${item.id}">${item.fullName}</option>
								</c:forEach>
							</select> <small></small>
						</div>
					</div>
				</div>
				<div class="m-0 ml-3">
				<c:forEach var="item" items="${buildingType}">
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="checkbox" id="${item.id}"
							value="${item.code}" name="buildingType" /> <small></small> <label
							class="form-check-label" for="phongTro">${item.name}</label>
					</div>
				</c:forEach>
				</div>
				<div class="m-3">
					<button type="button" id="btnSearch" class="btn btn-success">
						Tìm kiếm</button>
				</div>
			</form:form>
		</div>
		<div class="text-end mt-1">
			<a href="<c:url value='/admin/building-create'></c:url>"> <i
				class="btn btn-outline-secondary fas fa-plus-square"></i></a>
		</div>
		<div class="row m-3">
			<table class="w-100 table table-bordered text-center">
				<thead>
					<tr>
						<th class="text-center"><input type="checkbox" id="" value="" /></th>
						<th>Tên tòa nhà</th>
						<th>Địa chỉ</th>
						<th>Tên quản lý</th>
						<th>Số điện thoại</th>
						<th>Diện tích - Giá thuê</th>
						<th>Tầng trống</th>
						<th>Thao tác</th>
					</tr>
				</thead>
				<tbody id="resultTable">
					<c:forEach var="item" items="${buildingReponse}">
						<tr>
							<td><input type="checkbox" id="${item.id}" value="" /></td>
							<td>${item.name}</td>
							<td>${item.address}</td>
							<td>${item.managerName}</td>
							<td>${item.managerPhoneNumber}</td>
							<td><c:forEach var="itemAreaAndPrice"
									items="${item.areaEmpty}">
								${itemAreaAndPrice} <br>
							</c:forEach></td>
							<td><c:forEach var="itemAreaEmpty" items="${item.floorEmpty}">
								${itemAreaEmpty} <br>
							</c:forEach></td>
							<td>
								<div class="d-inline-flex">
									<c:if test="${item.checkUserBuilding == true}">
										<a href="<c:url value='/admin/building-update/${item.id}'></c:url>">
											<i id="${item.id}" class="btn fas fa-edit p-1"></i>
										</a>
										<a>
											<i id="${item.id}" class="btn fas fa-trash p-1" onclick="deleteBuilding(${item.id})"></i>
										</a>
									</c:if>	
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<script>
		let buildingTypes = "${buildingSearch.buildingType}";
		$("#district").val("${buildingSearch.district}");
		if (buildingTypes.includes("khach-san")) {
			$("#khachSan")[0].checked = true;
		}
		if (buildingTypes.includes("can-ho")) {
			$("#canHo")[0].checked = true;
		}
		if (buildingTypes.includes("phong-tro")) {
			$("#phongTro")[0].checked = true;
		}
		$("#btnSearch").on("click", function(event) {
			event.preventDefault();
			$("#searchForm").submit();
		});
		
		function deleteBuilding(id){
			let data = {};
			data["id"] = id;
			  $.ajax({
		          url: "${APIBuildingurl}",
		          type: "DELETE",
		          contentType: "application/json",
		          data: JSON.stringify(data),
		          //dataType: "json",
		          success: function (){
		        	window.location.href = '${buldingSearchURL}?alert=success';
		          },    	 
		          error: function () {		        	  
					window.location.href = '${buldingSearchURL}?alert=fail';
		          },
		        });
		}
	</script>
</body>

</html>