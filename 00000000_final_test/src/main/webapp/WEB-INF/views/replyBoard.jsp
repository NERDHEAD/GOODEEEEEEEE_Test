<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="container">
	<form action="./replyResult.do" method="post">
		<input type="hidden" name="seq" value="${dto.seq}">.
		
		<table class="table">
			
			<tr>
				<th>아이디: </th>
				<td class="form-group"><input class="form-control" type="text" name="id" maxlength="10" value="${loginDto.id}" readonly="readonly"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td class="form-group"><input class="form-control" type="text" name="title" required="required"></td>
			</tr>
			
			<tr>
				<th id="conTxt">내용<br>(원본)</th>
				<td class="form-group">
					<input type="hidden" id="chkContent" value="Y">
					<input type="hidden" id="hideContent" value="${dto.content}">
					<textarea class="form-control" rows="5" cols="50" id="txtArea" name="content" required="required" onclick="contentCheck()">원본글&gt;${dto.content}</textarea>
				</td>
			</tr>
			
			<tr>
				<th>작성일</th>
				<td>
				<fmt:formatDate value="${dto.regdate}" type="date"/>
				</td>
			</tr>
			
			<tr>
				<th colspan="2">
				<input type="submit" value="답글입력">
				<input id="replyReset" type="reset" value="입력초기화">
				</th>
			</tr>
			
		</table>
	</form>
</div>
<script type="text/javascript">
	function contentCheck(){
		var obj1 = document.getElementById("hideContent").value;
		var obj2 = document.getElementById("txtArea").value;
		var obj3 = obj2.replace("원본글>","");
	//	alert(obj3);
		if(obj1 == obj3){
			document.getElementById("txtArea").value="";
			document.getElementById("conTxt").innerHTML="내용<br>작성중";
			
		}
	}
</script>
</body>
</html>