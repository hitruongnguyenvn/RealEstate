<%@page import="com.unknown.utils.SecurityUtils"%>
<%@include file="/common/taglib.jsp"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container px-4 px-lg-5">
		<a class="navbar-brand" href="#!">Unknown</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="<c:url value='/home'></c:url>">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="#!">About</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
					role="button" data-bs-toggle="dropdown" aria-expanded="false">Shop</a>
					<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
						<li><a class="dropdown-item" href="#!">All Products</a></li>
						<li><hr class="dropdown-divider" /></li>
						<li><a class="dropdown-item" href="#!">Popular Items</a></li>
						<li><a class="dropdown-item" href="#!">New Arrivals</a></li>
					</ul></li>
			</ul>
			<security:authorize access="isAnonymous()">
				<a class="nav-link active" aria-current="page" href="<c:url value='/login'></c:url>">Login</a>
			</security:authorize>
			<security:authorize access="isAuthenticated()">
				<a class="nav-link active" aria-current="page" href="#">Welcome, <%=SecurityUtils.getPrincipal().getFullName()%></a>
				<a class="nav-link active" aria-current="page" href="<c:url value='/logout'></c:url>">Logout</a>
			</security:authorize>
		</div>
	</div>
</nav>