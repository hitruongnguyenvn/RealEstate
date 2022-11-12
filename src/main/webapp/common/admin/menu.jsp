<%@page import="com.unknown.utils.SecurityUtils"%>
<%@include file="/common/taglib.jsp"%>
<div id="layoutSidenav_nav">
	<nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
		<div class="sb-sidenav-menu">
			<div class="nav">
				<div class="sb-sidenav-menu-heading">Core</div>
				<a class="nav-link" href="#">
					<div class="sb-nav-link-icon">
						<i class="fas fa-tachometer-alt"></i>
					</div> Dashboard
				</a>
				<div class="sb-sidenav-menu-heading">Quan Ly</div>
				<a class="nav-link" href="<c:url value='/admin/building'></c:url>">
					<div class="sb-nav-link-icon">
						<i class="fas fa-columns"></i>
					</div> Toa nha
				</a> <a class="nav-link" href="<c:url value='#'></c:url>">
					<div class="sb-nav-link-icon">
						<i class="fas fa-book-open"></i>
					</div> Nhan Vien
				</a> <a class="nav-link" href="<c:url value='/admin/customer'></c:url>">
					<div class="sb-nav-link-icon">
						<i class="fas fa-book-open"></i>
					</div> Khach Hang
				</a>
			</div>
		</div>
		<div class="sb-sidenav-footer">
			<div class="small">Logged in as: <%=SecurityUtils.getPrincipal().getFullName()%></div>
		</div>
	</nav>
</div>
