<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<div><a href="javascript:history.back(-1)">뒤로가기</a></div>
	<form action="./writeBoard.do" method="post">
	
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id" id="id" value=${loginDto.id} readonly="readonly"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" id="title" class="form-control input-lg"></td>
			<tr>
			<tr>
				<th>내용</th>
				<td><textarea cols="50" name="content" id="content" class="form-control"></textarea></td>
			</tr>
			<tr>
				<td colspan="3" style="text-align: center;">
					<input type="submit" value="새글저장">
					<input type="reset" value="다시작성">
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>