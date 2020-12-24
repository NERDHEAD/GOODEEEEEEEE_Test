<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 보기</title>
</head>
<body>
<div>
	<table border="1" style="margin: 0px auto;">
		<tr>
			<th>아이디</th><td>${dto.id}</td>
		</tr>
		<tr>
			<th>제목</th><td>${dto.title}</td>
		</tr>
		<tr>
			<th>내용</th><td>${dto.content}</td>
		</tr>
		<tr>
			<th>등록일</th><td>
			<fmt:formatDate value="${dto.regdate}" type="date"/>
			</td>
		</tr>
	</table>
		<form style="text-align: center;">
		<input type="hidden" name="seq" value="${dto.seq}">
		<div>
			<input type="button" value="완전삭제" onclick="delreal()">
			<input type="button" value="글글수정" onclick="modify()">
			<input type="button" value="답글작성" onclick="reply()">
		</div>
		</form>
</div>
<script type="text/javascript">
	function delreal(){
		var form = document.forms[0];
		form.action = "./delBoard.do";
		form.method = "post";
		form.submit();
	}
	
	function modify(){
		var form = document.forms[0];
		form.action = "./moveModifyBoard.do";
		form.method = "post";
		form.submit();
	}
	
	function reply(){
		var form = document.forms[0];
		form.action = "./moveReplyBoard.do";
		form.method = "post";
		form.submit();
	}
	
</script>
</body>
</html>