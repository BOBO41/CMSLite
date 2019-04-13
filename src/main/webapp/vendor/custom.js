
function onKeyDown(event) {
	var e = event || window.event || arguments.callee.caller.arguments[0];
	if (e && e.keyCode == 27) { // Esc

	}
	if (e && e.keyCode == 113) { // F2

	}
	if (e && e.keyCode == 13) { // enter
		$("#searchform").submit();
	}
}