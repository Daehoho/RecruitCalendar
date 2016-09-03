<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공채 정보 등록</title>
</head>
<body>
<h1>공채 정보 등록</h1>
<form action='add' method='post'>
종류 : <input type='text' name='kind'><br>
기업 이름 : <input type='text' name='name'><br>
시작 날짜 : <input type='date' name='start'><br>
마감 날짜 : <input type='date' name='end'><br>
관련 링크 : <input type='text' name='url'><br>
<input type='submit' value='등록'>
<input type='reset' value='취소'>
</form>
</body>
</html>