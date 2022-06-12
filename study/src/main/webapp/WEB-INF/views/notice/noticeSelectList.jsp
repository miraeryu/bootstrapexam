<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <!-- Custom fonts for this template -->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
<style type="text/css">
tr.row:hover {
	background-color: lightyellow;
}
</style>
</head>
<body>
	<div align="center">
		<h1 class="h3 mb-2 text-gray-800">공지사항</h1>
		<p class="mb-4">
			DataTables is a third party plugin that is used to generate the demo
			table below. For more information about DataTables, please visit the
			<a target="_blank" href="https://datatables.net">official
				DataTables documentation</a>.
		</p>

		<!-- DataTales Example -->
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">공지사항 목록</h6>
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered" id="dataTable" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th>글번호</th>
								<th>작성자</th>
								<th>제목</th>
								<th>작성일자</th>
								<th>조회수</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${notices }" var="n">
								<tr>
									<td>${n.id }</td>
									<td>${n.writer }</td>
									<td>${n.title }</td>
									<td>${n.wdate }</td>
									<td>${n.hit }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div>
			<form id="frm" action="noticeSelect.do" method="post">
				<input type="hidden" id="id" name="id">
			</form>
		</div>
		<script type="text/javascript">
		<!-- 로드될때 웹페이지에 적용/라이브러리>헤더에 작성, 화면이 나온 이후에 작동시키고 싶을 경우(클릭 등)>마지막 div 밑에 작성 -->
			function noticeSelect(id) {
				//location.href = "noticeSelect.do?id=" + id;
				frm.id.value = id;
				frm.submit();

			}
		</script>
		    <!-- Page level plugins -->
    <script src="vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="js/demo/datatables-demo.js"></script>
</body>
</html>