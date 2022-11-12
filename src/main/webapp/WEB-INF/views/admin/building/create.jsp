<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIBuildingUrl" value="/api/building"></c:url>
<c:url var="buildingCreateUrl" value="/admin/building-create"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container px-4">
		<h1 class="mt-4">Tòa nhà</h1>
		<ol class="breadcrumb mb-4">
			<li class="breadcrumb-item"><a
				href="<c:url value='/admin/home'></c:url>">Dashboard</a></li>
			<li class="breadcrumb-item active">Thêm tòa nhà</li>
		</ol>
    	<c:if test="${param.alert == 'fail'}">
			<div class="alert alert-danger">	
				Thêm tòa nhà thất bại
			</div>
		</c:if>
		<c:if test="${param.alert == 'success'}">
			<div class="alert alert-success">	
				Thêm tòa nhà thành công
			</div>
		</c:if>	
		<div class="border border-secondary pt-3">
			<form action="" id="createFrom" method="POST">
				<div class="row m-0">
					<div class="col-6">
						<div class="form-group">
							<label for="inputNameBuilding">Tên tòa nhà</label> <input
								type="text" class="form-control" id="inputNameBuilding"
								name="name" value="" /> <small></small>
						</div>
					</div>
					<div class="col-3">
						<div class="form-group">
							<label for="city">Thành phố</label> <select class="form-control"
								name="city" id="city" disabled>
								<option value="">-- Chọn thành phố --</option>
								<option value="DN">Sài Gòn</option>
								<option value="HN">Đà Nẵng</option>
							</select> <small></small>
						</div>
					</div>
					<div class="col-3">
						<div class="form-group">
							<label for="unit">Quận</label> <select class="form-control"
								name="districtId" id="district">
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
								class="form-control" id="inputWard" name="ward" value="" /> <small></small>
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
					<div class="col-12">
						<div class="form-group">
							<label for="inputAreaTo">Diện tích (Tầng-DiệnTích-Giá;)</label> <input
								type="text" class="form-control" id="inputArea" name="area"
								value="" placeholder="VD: 1-20-25000;2-30-30000;" /> <small></small>
						</div>
					</div>
				</div>
				<div class="row m-0">
					<div class="col-3">
						<div class="form-group">
							<label for="inputNameManager">Tên quản lý</label> <input
								type="text" class="form-control" id="inputManagerName"
								name="managerName" value="" /> <small></small>
						</div>
					</div>
					<div class="col-3">
						<div class="form-group">
							<label for="inputNumberOfBasement">Số điện thoại quản lý</label>
							<input type="text" class="form-control"
								id="inputManagerPhoneNumber" name="managerPhoneNumber" value="" />
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
							<label for="buildingType">Loại tòa nhà</label> <select
								class="form-control" name="buildingTypeId" id="buildingType">
								<option value="">-- Chọn loại tòa nhà --</option>
								<c:forEach var="item" items="${buildingType}">
									<option value="${item.id}">${item.name}</option>
								</c:forEach>
							</select> <small></small>
						</div>
					</div>
				</div>
				<div class="row m-0">
					<div class="col-3">
						<div class="form-group">
							<label for="empoloyeeOfCharge">Tình trạng</label> <select
								class="form-control" name="status" id="status">
								<option value="1">Còn diện tích trống</option>
								<option value="0">Hết diện tích trống</option>
							</select> <small></small>
						</div>
					</div>

					<div class="col-3">
						<div class="form-group">
							<label for="inputDirections">Hướng</label> <input type="text"
								class="form-control" id="inputDirections" name="directions"
								value="" /> <small></small>
						</div>
					</div>
					<div class="col-3">
						<div class="form-group">
							<label for="inputLevel">Hạng</label> <input type="text"
								class="form-control" id="inputLevel" name="level" value="" /> <small></small>
						</div>
					</div>
					<div class="col-3">
						<div class="form-group">
							<label for="inputNumberOfBasement">Map</label> <input type="text"
								class="form-control" id="inputMap" name="map" value="" /> <small></small>
						</div>
					</div>
				</div>
				<div class="m-3">
					<button type="button" id="btnAdd" class="btn btn-success">
						Thêm</button>
				</div>
			</form>
		</div>
	</div>
	<script>
		$("#btnAdd").on("click", function(event) {
			event.preventDefault();
			let regex = /^(-{0,1}[0-9]{1,}-[0-9]{1,}-[0-9]{1,};){1,}$/;
			let inputArea = $("#inputArea");
			let buildingType = $("#buildingType");
			let nameBuilding = $("#inputNameBuilding");
			let district =  $("#district");
			showEmptyOrInvalid(inputArea, regex, "Diện tích không hợp lệ");
			showEmptyOrInvalid(buildingType, null, "");
			showEmptyOrInvalid(nameBuilding, null, "");
			showEmptyOrInvalid(district, null, "");
			if ($(".text-danger").text().length != 0){
				return;
			}
			let data = {};
			let formData = $("#createFrom").serializeArray();
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});
			$.ajax({
				url : "${APIBuildingUrl}",
				type : "POST",
				contentType : "application/json",
				data : JSON.stringify(data),
				dataType : "json",
				success : function(result) {
					window.location.href = '${buildingCreateUrl}?alert=success';
					/*$("#inputNameBuilding").val(result.name);
					 $("#district").val(result.districtId);
					 $("#inputWard").val(result.ward);
					 $("#inputStreet").val(result.street);
					 $("#inputArea").val(result.area);
					 $("#inputManagerName").val(result.managerName);
					 $("#inputManagerPhoneNumber").val(result.managerPhoneNumber);
					 $("#inputNumberOfBasement").val(result.numberOfBasement);
					 $("#buildingType").val(result.buildingTypeId);
					 $("#status").val(result.status);
					 $("#inputDirections").val(result.directions);
					 $("#inputLevel").val(result.level);
					 $("#inputMap").val(result.map);*/

				},
				error : function(result) {
					//let data=result.responseText;
					//let jsonResponse = JSON.parse(data);
					//console.log(jsonResponse["error"]);
					console.log(result.responseText);
					window.location.href = '${buildingCreateUrl}?alert=fail';
				},
			});
		});
	</script>
</body>
</html>