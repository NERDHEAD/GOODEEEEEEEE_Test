<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="container">
<jsp:useBean id="pho" class="com.nerdhead.edu.usebean.ReplyPhoto" scope="page"/>
	<form action="./multiDel.do" method="post">
	<table border="1" style="margin: 0px auto;">
		<tr>
			<th><input type="checkbox" id="allCheck" onclick="checkAll(this.checked)"></th>
			<th>연번</th>
			<th>아이디</th>
			<th>제목</th>
			<th>refer</th>
     		<th>step</th>
      		<th>depth</th>
			<th>등록일</th>
			<!-- 관리자 -->
		</tr>
			<c:forEach var="dto" items="${selAll}" varStatus="vs">
			<tr>
				<td><input type="checkbox" name="ch" value="${dto.seq}"></td>
				<td>${vs.count}</td>	
				<td>${dto.id}</td>
				<c:choose>
					<c:when test="${dto.delflag eq 'Y'}">
						<td>
							<p style="color: red;">관리자의 의해 삭제됨</p>
						</td>
					</c:when>
					<c:otherwise>
						<td>
							<jsp:setProperty property="depth" name="pho" value="${dto.depth}"/>
							<jsp:getProperty property="photo" name="pho"/>
							<a href="./detailBoard.do?seq=${dto.seq}">${dto.title}</a>
						</td>
					</c:otherwise>
				</c:choose>
				<td>${dto.refer}</td>
				<td>${dto.step}</td>
				<td>${dto.depth}</td>
				<td>
<%-- 				<fmt:parseDate var="patternDate" value="${dto.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/> --%>
<%-- 				<fmt:formatDate value="${patternDate}" pattern="yyyy-MM-dd"/> --%>
				<fmt:formatDate value="${dto.regdate}" type="date"/>
				</td>
			</tr>
			</c:forEach>
		<!-- .Date -->
	</table>
		<div style="text-align: center">
			<input type="submit" value="다중삭제">
			<input type="button" value="새 글 입력" onclick="location.href='./writeBoard.do'">
		</div>
	</form>
	
	<script type="text/javascript">
	function checkAll(bool) {
		var chs = document.getElementsByName("ch");
		for (var i = 0; i < chs.length; i++) {
			chs[i].checked = bool;
		}
	}
	</script>
</div>
</body>
</html>