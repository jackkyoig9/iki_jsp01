<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Excel</title>
<%@ include file="../include/header.jsp" %>
<script>
$(function(){
	$("#btn_exceldown_ajax").bind("click", function(){
		console.log("btn_exceldown>> ");
		fn_exceldown_ajax();
	});
});

function fn_exceldown_ajax(){
	console.log("fn_exceldown>> ");
	$.ajax({
		url: "${path}/excel/excel01.do",
		data: _form.serialize(),
		//data: param,
		type: "POST",
		//async: false,
		success: function (result) {
			console.log("fn_exceldown>> success>> "+result);
			var response = JSON.parse(data);
	        window.location = '/Report/Download?fileGuid=' + response.FileGuid 
	                           + '&filename=' + response.FileName;
		}//,
		/* error: function (e) {
			alert(e);
		} */
	});
}

function fn_exceldown(){
	console.log("fn_exceldown>> ${path}");
	$("#form_excel").attr("${path}/excel/excel01.do");
	$("#form_excel").submit();
}
</script>
</head>
<body>
<br>
<div class="container">
	<h2>Excel</h2>
	<div>
		<form id="form_excel" method="POST">
			<button id="btn_exceldown" onclick="fn_exceldown();">다운로드</button>
			<!-- <button id="btn_exceldown_ajax">다운로드</button> -->
			<input type="hidden" id="" name="" />
		</form>
	</div>
</div>
</body>
</html>