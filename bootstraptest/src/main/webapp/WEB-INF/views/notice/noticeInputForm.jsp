<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<div><h1>공지사항 등록</h1></div>
	<div>
		<!-- 파일업로드 메소드는 post 파일은 2진데이터이므로 enctype이 다름-->
		<form id="frm" action="noticeInput.do" method="post" enctype="multipart/form-data">
			<div>
				<table border = "1">
					<tr>
						<th width="150">작성자</th>
						<td width="150"><input type="text" id="writer" name="writer" required="required"></td>
						<th width="150">작성일자</th>
						<td width="150"><input type="date" id="wdate" name="wdate" required="required"></td>
					</tr>
					<tr>
						<th>제목</th>
						<td colspan="3"><input type="text" size="60" id="title" name="title" required="required"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3"><textarea rows="10" cols="63" id="subject" name="subject"></textarea></td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td colspan="3">
							<input type="file" id="file" name="file">
						</td>
					</tr>
				</table>
			</div><br>
			<div>
				<input type="submit" value="저장"	>
				<input type="reset" value="취소"	>
				<input type="button" value="목록가기"	onclick="location.href='noticeList.do'">
			</div>
		</form>
	</div>
</div>
</body>
</html>