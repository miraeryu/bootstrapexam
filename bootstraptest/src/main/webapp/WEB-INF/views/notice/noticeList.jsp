<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.6.0.min.js"></script>
</head>
<body>
	<div align="center">
		<div>
			<h1>공지사항 목록</h1>
		</div>
		<div>
			<form id="frm" action="" method="post">
				<select id="key" name="key">
					<option value="1">전체</option>
					<option value="2">작성자</option>
					<option value="3">제목</option>
					<option value="4">내용</option>
				</select> <input type="text" id="val" name="val"> <input
					type="button" onclick="search2();" value="검색"><p>
			</form>
		</div>
		<div>
			<table border="1" id="ta">
				<thead>
					<tr>
						<th width="100">글번호</th>
						<th width="150">작성자</th>
						<th width="250">제목</th>
						<th width="150">작성일자</th>
						<th width="100">조회수</th>
						<th width="200">첨부파일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list }" var="notice">
						<tr>
							<td align="center">${notice.id }</td>
							<td align="center">${notice.writer }</td>
							<td align="center">${notice.title }</td>
							<td align="center">${notice.wdate }</td>
							<td align="center">${notice.hit }</td>
							<td align="center">${notice.fileName }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div><p>
			<input type="button" value="글작성"
				onclick="location.href='noticeInputForm.do'">
		</div>
	</div>
	<script type="text/javascript">
	function search(){
		let fields = ['id','writer','title','wdate','hit','fileName'];
		let allTr = document.querySelectorAll('tbody>tr');
		let k = document.getElemetById("key").value;
		let v = document.getElemetById("val").value;
		allTr.forEach(function (tr){
			tr.remove();
		});
		let list = document.querySelector('tbody');
		let param = "key=" + frm.key.value + "&val=" + frm.val.value;
		fetch('ajaxSearchList.do',{
			method: 'POST',
			headers: {'Content-Type':'application/x-www-form-urlencoded'},
			body : param
		})
		.then(response => response.json()) //json type으로 결과 받음
		.then(data => {
			console.log(data);
			data.forEach(d =>{ //json data를 한행씩 읽음
				let tr =document.createElement('tr');
				fields.forEach(f =>{ //한 행의 데이터에서
					let td = document.createElement('td');
					td.innerHTML = d[f]; //필드값과 일치 키값에서 데이터를 가져와서 td에 넣음
					tr.appendChild(td);
				})
				list.appendChild(tr);
			})
		})
	}
	function search2(){
		$.ajax({
			url : "ajaxSearchList.do",
			type : "post",
			data : {"key":$("#key").val(),"val":$("#val").val()},
			dataType : "json",
			success : function(data){
				htmlConvert(data);
			},error : function(){
				//실패시 구현
			}
		});
		
	}
	
	function htmlConvert(data){
		$("tbody").remove(); // tbody 제거
		let tb = $("<tbody/>");
		$.each(data, function(index, item){
			let tr = $("<tr/>").append(
					$("<td/>").text(item.id),
					$("<td/>").text(item.writer),
					$("<td/>").text(item.title),
					$("<td/>").text(item.wdate),
					$("<td/>").text(item.hit),
					$("<td/>").text(item.fileName)
			);
			tb.append(tr);
		});
		$("#ta").append(tb);
	}
</script>
</body>
</html>