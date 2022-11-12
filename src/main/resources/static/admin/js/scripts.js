/*!
 * Start Bootstrap - SB Admin v7.0.5 (https://startbootstrap.com/template/sb-admin)
 * Copyright 2013-2022 Start Bootstrap
 * Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-sb-admin/blob/master/LICENSE)
 */
//
// Scripts
//


$("select").focus(function() {
	$(this).addClass("text-danger"); // tô màu cho chỗ focus
	$(this).next().text(""); // đến element kế nó để thêm nội dung
});

$("input").focus(function() {
	$(this).addClass("text-danger"); // tô màu cho chỗ focus
	$(this).next().text(""); // đến element kế nó để thêm nội dung
});

function showError(element, message) {
	element.next().text(message);
	element.next().addClass("text-danger");
}

function showSuccess(element) {
	element.removeClass("text-danger");
}

function showEmptyOrInvalid(elemet, regex, messageInvalid) {
	if (elemet.val() == "") {
		showError(elemet, "Không được để trống");
		return false;
	}
	if (regex == null) {
		showSuccess(elemet);
		return false;
	}
	if (regex.test(elemet.val())) {
		showSuccess(elemet);
		return true;
	} else {
		showError(elemet, messageInvalid);
		return false;
	}
}

window.addEventListener("DOMContentLoaded", (event) => {
	// Toggle the side navigation
	const sidebarToggle = document.body.querySelector("#sidebarToggle");
	if (sidebarToggle) {
		// Uncomment Below to persist sidebar toggle between refreshes
		// if (localStorage.getItem('sb|sidebar-toggle') === 'true') {
		//     document.body.classList.toggle('sb-sidenav-toggled');
		// }
		sidebarToggle.addEventListener("click", (event) => {
			event.preventDefault();
			document.body.classList.toggle("sb-sidenav-toggled");
			localStorage.setItem(
				"sb|sidebar-toggle",
				document.body.classList.contains("sb-sidenav-toggled")
			);
		});
	}
});


