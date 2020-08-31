<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
var imgObj = document.getElementById("QRimg");
var url = "/com/testcode?";
imgObj.src = url;
</script>
<body>
<div>
	<img id="QRimg" width="200" height="200" src="${QRsrc }"/>
</div>
</body>
</html>