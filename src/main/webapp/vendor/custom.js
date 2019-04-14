$(document).ready(function() {
	$("#sendMessageButton").click(function(event) {
		var form=$("#contactForm")[0];
		form.classList.remove('was-validated');
		if (form.checkValidity() === false) {
	          event.preventDefault();
	          event.stopPropagation();
	          form.classList.add('was-validated');
	        }else{
	    		var data=JSON.stringify(getMessageFormData());
	    		postCmsFormData("message","add",getMessageFormData());
	    		form.reset();
	        }
	});
});
function getMessageFormData() {
	var json = {
		"name" : $("#inputName").val(),
		"email" : $("#inputEmail").val(),
		"mobile" : $("#inputMobile").val(),
		"content" : $("#inputContent").val()
	};
	return json;
}
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
function postCmsFormData(table,action,json) {
	var data=JSON.stringify(json);
	$.ajax({
		contentType : "application/json",
		type : 'POST',
		url : "/"+table+"/"+action,
		data : data,
		dataType : "json",
		success : function(response) {
			if(response.success){
				showMessage('success','Success',"We've got your note, and we will give a reply as soon as possible. Please check your E-mail.");
			}else{
				showMessage('danger','Error',response.message);
			}
		},
		error : function(response) {
			showMessage('danger','Error',response.message);
		}
	});
}
function showMessage(type,title,content){
	$('#modalLongTitle').html(title);
	$('#modalBody').html(content);
	$('#modalAlert').addClass("alert-"+type);
	$('#modalCenter').modal('show');
}