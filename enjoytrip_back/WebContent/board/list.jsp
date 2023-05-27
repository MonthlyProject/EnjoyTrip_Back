<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/head.jsp"%>
<body>
	<%@ include file="/include/header.jsp"%>
	<%@ include file="/include/confirm.jsp"%>
	<div class="pt-4 container">
		<div class="mb-4 text-center">
			<h2 class="fw-bold">게시판</h2>
			<div class="mt-4 container">
				<div class="row mb-2 justify-content-between">
					<div class="mr-auto ml-2 col-auto">
						<button type="button"
							onclick="location.href='${root}/article?action=mvwrite'"
							class="btn btn-secondary">글쓰기</button>
					</div>
					<div class="mr-2 col-auto">
						<form class="row row-cols-lg-auto g-3 align-items-center">
							<div class="col-auto">
								<label class="visually-hidden" for="inlineFormSelectPref">Preference</label>
								<select class="form-select" id="inlineFormSelectPref">
									<option name="key" id="key" selected>검색조건</option>
									<option value="article_no">글번호</option>
									<option value="subject">제목</option>
									<option value="user_id">작성자</option>
								</select>
							</div>

							<div class="col-auto">
								<input type="text" name="word" id="word"
									class="mr-1 form-control" placeholder="검색어 입력" />
							</div>

							<div class="col-auto">
								<button type="button" id="btn-search"
									class="btn btn-outline-primary">검색</button>
							</div>
						</form>
					</div>
				</div>
				<div class="row">
					<table class="table">
						<thead>
							<tr>
								<th scope="col">글번호</th>
								<th scope="col">제목</th>
								<th scope="col">작성자</th>
								<th scope="col">조회수</th>
								<th scope="col">작성일</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="article" items="${articles}">
								<tr class="text-center"
									onclick="location.href='${root}/article?action=view&articleno=${article.articleNo}'">
									<th scope="row">${article.articleNo}</th>
									<td class="text-start"><a href="#"
										class="article-title link-dark" data-no="${article.articleNo}"
										style="text-decoration: none">
											${article.subject} </a></td>
									<td>${article.userId}</td>
									<td>${article.hit}</td>
									<td>${article.registerTime}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="row">${navigation.navigator}</div>
			</div>
		</div>
	</div>
	<form id="form-param" method="get" action="">
		<input type="hidden" id="p-action" name="action" value=""> <input
			type="hidden" id="p-pgno" name="pgno" value=""> <input
			type="hidden" id="p-key" name="key" value=""> <input
			type="hidden" id="p-word" name="word" value="">
	</form>
	<script>
      document.querySelector("#btn-search").addEventListener("click", function () {
    	  let form = document.querySelector("#form-search");
          form.setAttribute("action", "${root}/article");
          form.submit();
      });
      
      let pages = document.querySelectorAll(".page-link");
      pages.forEach(function (page) {
        page.addEventListener("click", function () {
          console.log(this.parentNode.getAttribute("data-pg"));
          document.querySelector("#p-action").value = "list";
       	  document.querySelector("#p-pgno").value = this.parentNode.getAttribute("data-pg");
       	  document.querySelector("#p-key").value = "${param.key}";
       	  document.querySelector("#p-word").value = "${param.word}";
          document.querySelector("#form-param").submit();
        });
      });
    </script>

	<main id="main"></main>
	<!-- End #main -->

	<%@ include file="/include/footer.jsp"%>

	<a href="#"
		class="scroll-top d-flex align-items-center justify-content-center"><i
		class="bi bi-arrow-up-short"></i></a>

	<div id="preloader"></div>


	<%@ include file="/include/modals.jsp"%>
	<%@ include file="/include/jsinclude.jsp"%>
</body>

</html>