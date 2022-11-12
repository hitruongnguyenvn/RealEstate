<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Unknown</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="<c:url value='/web/assets/favicon.ico'></c:url>" />
<!-- Bootstrap icons-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="<c:url value='/web/css/styles.css'></c:url>" rel="stylesheet" />
</head>
<body>
<%@include file="/common/web/header.jsp"%>
<dec:body></dec:body>
<%@include file="/common/web/footer.jsp"%>

 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
 <!-- Core theme JS-->
 <script src="<c:url value='/web/js/scripts.js'></c:url>"></script>
</body>
</html>