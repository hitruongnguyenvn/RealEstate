<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home for Admin</title>
<link href="<c:url value='/admin/css/styles.css'></c:url>" rel="stylesheet" />
<link href="<c:url value='/bootstrap/css/bootstrap.min.css'></c:url>" rel="stylesheet" />
<link href="<c:url value='/fontAwesome/css/all.css'></c:url>" rel="stylesheet" />
<script src='<c:url value='/jquery/jquery-3.6.0.min.js'></c:url>'></script>
</head>
<body class="sb-nav-fixed">
	<%@include file="/common/admin/header.jsp"%>
	<div id="layoutSidenav">
		<%@include file="/common/admin/menu.jsp"%>
		<div id="layoutSidenav_content">
			<main>
				<dec:body></dec:body>
			</main>
			<%@include file="/common/admin/footer.jsp"%>
		</div>
	</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src='<c:url value='/bootstrap/js/bootstrap.min.js'></c:url>'></script>
<script src='<c:url value='/admin/js/scripts.js'></c:url>'></script>
</body>
</html>