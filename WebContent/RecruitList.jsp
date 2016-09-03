<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공채 일정 목록</title>
</head>
<body>
<h1>공채 일정 목록</h1>
<p><a href='add'>공채 일정 등록</a></p>
<c:forEach var="recruit" items="${recruits}">
${recruit.kind},
${recruit.name},
${recruit.start} ~ ${recruit.end},
<a href='${recruit.url}' target='_blank'>url</a><br>
</c:forEach>
</body>
</html>