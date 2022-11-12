<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIUpdateBuildingUrl" value="/api/building"></c:url>
<c:url var="APIUpdateAreUrl" value="/api/area"></c:url>
<c:url var="APIUpdateAssignmentBuilding" value="/api/building/assignment"></c:url>
<c:url var="buildingUpdateUrl" value="/admin/building-update"></c:url>
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
			<li class="breadcrumb-item active">Cập nhật tòa nhà</li>
		</ol>
		 <c:if test="${param.alert == 'fail'}">
			<div class="alert alert-danger">	
				Cập nhật thất bại
			</div>
		</c:if>
		<c:if test="${param.alert == 'success'}">
			<div class="alert alert-success">	
				Cập nhật thành công
			</div>
		</c:if>	
		<div class="border border-secondary pt-3">
			<form action="" id="updateForm" method="PUT">
				<div class="row m-0">
					<div class="col-6">
						<div class="form-group">
							<label for="inputNameBuilding">Tên tòa nhà</label> <input
								type="text" class="form-control" id="inputNameBuilding"
								name="name" value="${building.name}" /> <small></small>
						</div>
					</div>
					<div class="col-3">
						<div class="form-group">
							<label for="city">Thành phố</label> <select class="form-control"
								name="cityId" id="city" disabled>
								<option value="">-- Chọn thành phố --</option>
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
								class="form-control" id="inputWard" name="ward"
								value="${building.ward}" /> <small></small>
						</div>
					</div>
					<div class="col-6">
						<div class="form-group">
							<label for="inputStreet">Đường</label> <input type="text"
								class="form-control" id="inputStreet" name="street"
								value="${building.street}" /> <small></small>
						</div>
					</div>
				</div>
				<div class="row m-0">
					<div class="col-3">
						<div class="form-group">
							<label for="inputNameManager">Tên quản lý</label> <input
								type="text" class="form-control" id="inputNameManager"
								name="managerName" value="${building.managerName}" /> <small></small>
						</div>
					</div>
					<div class="col-3">
						<div class="form-group">
							<label for="inputNumberOfBasement">Số điện thoại quản lý</label>
							<input type="text" class="form-control"
								id="inputPhoneNumberManager" name="managerPhoneNumber"
								value="${building.managerPhoneNumber}" /> <small></small>
						</div>
					</div>
					<div class="col-3">
						<div class="form-group">
							<label for="inputNumberOfBasement">Số tầng hầm</label> <input
								type="text" class="form-control" id="inputNumberOfBasement"
								name="numberOfBasement" value="${building.numberOfBasement}" />
							<small></small>
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
								<option value="1">Hết diện tích trống</option>
								<option value="0">Còn diện tích trống</option>
							</select> <small></small>
						</div>
					</div>

					<div class="col-3">
						<div class="form-group">
							<label for="inputDirections">Hướng</label> <input type="text"
								class="form-control" id="inputDirections" name="directions"
								value="${building.directions}" /> <small></small>
						</div>
					</div>
					<div class="col-3">
						<div class="form-group">
							<label for="inputLevel">Hạng</label> <input type="text"
								class="form-control" id="inputLevel" name="level"
								value="${building.level}" /> <small></small>
						</div>
					</div>
					<div class="col-3">
						<div class="form-group">
							<label for="inputNumberOfBasement">Map</label> <input type="text"
								class="form-control" id="inputMap" name="map"
								value="${building.map}" /> <small></small>
						</div>
					</div>
				</div>
				<div class="m-3">
					<button type="submit" id="btnUpdate" class="btn btn-success">
						Cập nhật</button>
				</div>
			</form>
		</div>
		<div class="row m-3">
			<table class="w-100 table table-bordered text-center">
				<thead>
					<tr>
						<th>Tầng</th>
						<th>Diện tích(m2)</th>
						<th>Giá</th>
						<th>Tình trạng</th>
						<th>Thao tác</th>
					</tr>
				</thead>
				<tbody id="resultTable">
					<c:forEach var="item" items="${area}">
						<tr>
							<td>${item.floor}</td>
							<td>${item.area}</td>
							<td>${item.price}</td>
							<td>${item.statusString}</td>
							<td>
								<div class="d-inline-flex">
									<i id="${item.id}" class="btn fas fa-edit p-1"
										data-toggle="modal" data-target="#updateAreaModal"
										onclick='updateArea(${item.id}, ${item.floor}, ${item.area}, ${item.price}, ${item.status})'></i>
									<i id="${item.id}" class="btn fas fa-trash p-1" onclick="deletaArea(${item.id})"></i>
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="row m-0">
			<div class="col-2">
				<button type="submit" id="btnAssignment"
					class="btn btn-outline-secondary" data-toggle="modal"
					data-target="#assignmentModal">Quản trị viên</button>
			</div>
			<div class="col-2">
				<button type="submit" id="btnAddArea"
					class="btn btn-outline-secondary" data-toggle="modal"
					data-target="#addAreaModal">Thêm diện tích</button>
			</div>
		</div>
		<!-- Modal Update Area -->
		<div class="modal fade" id="updateAreaModal" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="updateAreaModalLabel">Cập nhật
							diện tích</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form action="" id="updateAreaForm" method="PUT">
							<div class="row">
								<div class="col-2">
									<div class="form-group">
										<label for="inputUpdateFloor">Tầng</label> <input type="text"
											class="form-control" id="inputUpdateFloor" name="floor"
											value="" /> <small></small>
									</div>
								</div>
								<div class="col-3">
									<div class="form-group">
										<label for="inputUpdateArea">Diện tích</label> <input
											type="text" class="form-control" id="inputUpdateArea"
											name="area" value="" /> <small></small>
									</div>
								</div>
								<div class="col-3">
									<div class="form-group">
										<label for="inputUpdateFloor">Giá</label> <input type="text"
											class="form-control" id="inputUpdatePrice" name="price"
											value="" /> <small></small>
									</div>
								</div>
								<div class="col-4">
									<div class="form-group">
										<label for="empoloyeeOfCharge">Tình trạng</label> <select
											class="form-control" name="status" id="statusForUpdate">
											<option value="0">Chưa thuê</option>
											<option value="1">Đã thuê</option>
										</select> <small></small>
									</div>
								</div>
							</div>
							<input type="hidden" id="inputUpdateId" name="id" value="" />
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Đóng</button>
						<button type="button" id="btnUpdateArea" class="btn btn-primary">
							Lưu thay đổi</button>
					</div>
				</div>
			</div>
		</div>
		<!-- Modal Add Area -->
		<div class="modal fade" id="addAreaModal" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="addAreaModalLabel">Thêm diện tích
						</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form action="" id="addAreaForm" method="POST">
						<div class="row">
							<div class="col-2">
								<div class="form-group">
									<label for="inputAddFloor">Tầng</label> <input type="text"
										class="form-control" id="inputAddFloor" name="floor" value=""/> <small></small>
								</div>
							</div>
							<div class="col-3">
								<div class="form-group">
									<label for="inputAddArea">Diện tích</label> <input type="text"
										class="form-control" id="inputAddArea" name="area" value=""/> <small></small>
								</div>
							</div>
							<div class="col-3">
								<div class="form-group">
									<label for="inputAddFloor">Giá</label> <input type="text"
										class="form-control" id="inputAddPrice" name="price" value=""/> <small></small>
								</div>
							</div>
							<div class="col-4">
								<div class="form-group">
									<label for="empoloyeeOfCharge">Tình trạng</label> <select
										class="form-control" name="status" id="statusForAdd">
										<option value="0">Chưa thuê</option>
										<option value="1">Đã thuê</option>
									</select> <small></small>
								</div>
							</div>
						</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Đóng</button>
						<button type="button" id="btnAddAreaModal" class="btn btn-primary">
							Thêm</button>
					</div>
				</div>
			</div>
		</div>
		<!-- Modal Assignment-->
		<div class="modal fade" id="assignmentModal" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="assignmentModalLabel">Giao nhân
							viên quản lý tòa nhà</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<table class="w-100 table table-bordered">
							<thead>
								<tr>
									<th>Chọn nhân viên</th>
									<th>Tên nhân viên</th>
								</tr>
							</thead>
							<tbody id="resultTableAssginment">
								<c:forEach var="item" items="${users}">
									<tr>
										<td><input type="checkbox" id="cbUsers${item.id}" value="${item.id}" /></td>
										<td>${item.fullName}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Đóng</button>
						<button type="button" id="btnAssignmentEmployee"
							class="btn btn-primary">Lưu thay đổi</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		$("#district").val("${building.districtId}");
		$("#buildingType").val("${building.buildingTypeId}");
		$("#status").val("${building.status}");
		
		$("#btnUpdate").on("click", function(event) {
			event.preventDefault();
			let buildingId = "${building.id}";
			let data = {};
		       let formData = $("#updateForm").serializeArray();
		       $.each(formData, function (i, v) {
		         data["" + v.name + ""] = v.value;
		       });
		       data["id"] = buildingId;
		       update(data, buildingId);
		});
		
		function update(data, buildingId) {
		        $.ajax({
		          url: "${APIUpdateBuildingUrl}",
		          type: "PUT",
		          contentType: "application/json",
		          data: JSON.stringify(data),
		          dataType: "json",
		          success: function (result) {
		        	window.location.href = '${buildingUpdateUrl}/'+result.id+'?alert=success';
		          },
		          error: function (result) {
		        	console.log(result.responseText);			        	  
					window.location.href = '${buildingUpdateUrl}/'+buildingId+'?alert=fail';;
		          },
		        });
		 }
		
		function updateArea(id, floor, area, price, status){
			$("#inputUpdateId").val(id);
			$("#inputUpdateFloor").val(floor);
			$("#inputUpdateArea").val(area);
			$("#inputUpdatePrice").val(price);
			$("#statusForUpdate").val(status);
		}
		
		function deletaArea(id){
			let buildingId = "${building.id}";
			let data = {};
			data["id"] = id;
			data["buildingId"] =  buildingId;
			  $.ajax({
		          url: "${APIUpdateAreUrl}",
		          type: "DELETE",
		          contentType: "application/json",
		          data: JSON.stringify(data),
		          dataType: "json",
		          success: function (result) {
		        	  window.location.href = '${buildingUpdateUrl}/'+result+'?alert=success';
		          },
		          error: function (result) {
			        	console.log(result.responseText);			        	  
						window.location.href = '${buildingUpdateUrl}/'+buildingId+'?alert=fail';
		            //console.log("fail");
		          },
		        });
		}
		
		$("#btnUpdateArea").on("click", function(event) {
			event.preventDefault();
			let regexPrice = /^[0-9]+(\.[0-9]{1,2})?$/;
			let regexFloor = /^-?[0-9]+$/;
			let regexArea = /^[0-9]+$/;
			showEmptyOrInvalid($("#inputUpdateFloor"), regexFloor, "Số tầng không hợp lệ");
			showEmptyOrInvalid($("#inputUpdatePrice"), regexPrice, "Giá không hợp lệ");
			showEmptyOrInvalid($("#inputUpdateArea"), regexArea, "Diện tích không hợp lệ");
			showEmptyOrInvalid($("#statusForUpdate"), null, "");
			if ($(".text-danger").text().length != 0){
				return;
			}
			let data = {};
			let buildingId = "${building.id}";
		    let formData = $("#updateAreaForm").serializeArray();
		     $.each(formData, function (i, v) {
		         data["" + v.name + ""] = v.value;
		       });
		     data["buildingId"] = buildingId;
		       $.ajax({
			          url: "${APIUpdateAreUrl}",
			          type: "PUT",
			          contentType: "application/json",
			          data: JSON.stringify(data),
			          dataType: "json",
			          success: function (result) {
			        	window.location.href = '${buildingUpdateUrl}/'+result.buildingId+'?alert=success';
			          },
			          error: function (result) {
			        	console.log(result.responseText);			        	  
						window.location.href = '${buildingUpdateUrl}/'+buildingId+'?alert=fail';
			          },
			        });
		});
		$("#btnAddAreaModal").on("click", function(event) {	
			event.preventDefault();
			let regexPrice = /^[0-9]+(\.[0-9]{1,2})?$/;
			let regexFloor = /^-?[0-9]+$/;
			let regexArea = /^[0-9]+$/;
			showEmptyOrInvalid($("#inputAddFloor"), regexFloor, "Số tầng không hợp lệ");
			showEmptyOrInvalid($("#inputAddPrice"), regexPrice, "Giá không hợp lệ");
			showEmptyOrInvalid($("#inputAddArea"), regexArea, "Diện tích không hợp lệ");
			if ($(".text-danger").text().length != 0){
				return;
			}
			let data = {};
			let buildingId = "${building.id}";
		    let formData = $("#addAreaForm").serializeArray();
		     $.each(formData, function (i, v) {
		         data["" + v.name + ""] = v.value;
		       });
		     data["buildingId"] = buildingId;
		       $.ajax({
			          url: "${APIUpdateAreUrl}",
			          type: "POST",
			          contentType: "application/json",
			          data: JSON.stringify(data),
			          dataType: "json",
			          success: function (result) {
			        	window.location.href = '${buildingUpdateUrl}/'+result.buildingId+'?alert=success';
			          },
			          error: function (result) {
			        	console.log(result.responseText);			        	  
						window.location.href = '${buildingUpdateUrl}/'+buildingId+'?alert=fail';
			          },
			        });
		});
		let idsOld = [];
		$("#btnAssignment").on("click", function(event) {
			event.preventDefault();
			<c:forEach var="item" items="${usersManagement}">
				idsOld.push("${item.id}");
				$("#cbUsers${item.id}")[0].checked = true;
			</c:forEach>
		});
		$("#btnAssignmentEmployee").on("click", function(event) {
			event.preventDefault();
			let data = {};
			let idsNew = $('tbody input[type=checkbox]:checked').map(function () {
	        	return $(this).val();
	   		 }).get();
			//or
			/*let idsNew = $('#resultTableAssginment input[type=checkbox]:checked').map(function () {
	        	return $(this).val();
	   		 }).get();*/
	   		let buildingId = "${building.id}";
			data["idsOld"] = idsOld;
			data["idsNew"] = idsNew;
			data["buildingId"] = buildingId;
		       $.ajax({
			          url: "${APIUpdateAssignmentBuilding}",
			          type: "POST",
			          contentType: "application/json",
			          data: JSON.stringify(data),
			          dataType: "json",
			          success: function (result) {
			        	  window.location.href = '${buildingUpdateUrl}/'+result+'?alert=success';
			          },
			          error: function (result) {
			            //console.log("fail");
			        	console.log(result.responseText);
						window.location.href = '${buildingUpdateUrl}/'+buildingId+'?alert=fail';
			          },
			   });
		});
		
	</script>
</body>
</html>