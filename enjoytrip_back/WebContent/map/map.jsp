<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/include/head.jsp"%>


<body>

	<%@ include file="/include/header.jsp"%>
	<%@ include file="/include/confirm.jsp" %>
	<main id="main"> <!-- 메인 컨텐츠 시작 -->
	<div class="container">
		<!-- 관광지 조회 섹션 -->
		<section id="search" class="search">
			<!-- 관광지 조회 타이틀 -->
			<div class="row d-flex justify-content-center">
				<div class="col-lg-6 text-center">
					<h2 class="fw-bold">관광지 조회</h2>
				</div>
			</div>
			<!-- 타이틀 종료 -->

			<div class="row d-flex justify-content-center ">
				<div class="col-lg-10 text-center">
					<form class="d-flex my-3" onsubmit="return false;" role="search">
						<select id="search-area" class="form-select me-2">
							<option value="0" selected>검색 할 지역 선택</option>
							<c:forEach var="article" items="${sido}">
								<option value="${article.sidoCode}" id="">${article.sidoName}</option>
							</c:forEach>
						</select> <select id="search-area-area" class="form-select me-2">
							<option value="0" selected>검색 할 세부지역 선택</option>
						</select> <select id="search-content-id" class="form-select me-2">
							<option value="0" selected>관광지 유형</option>
							<option value="12">관광지</option>
							<option value="14">문화시설</option>
							<option value="15">축제공연행사</option>
							<option value="25">여행코스</option>
							<option value="28">레포츠</option>
							<option value="32">숙박</option>
							<option value="38">쇼핑</option>
							<option value="39">음식점</option>
						</select>
						<button id="btn-search" class="btn btn-outline-success"
							type="button">검색</button>
					</form>
				</div>
			</div>
			<!-- kakao map start -->
			<div id="map" class="mt-3" style="width: 100%; height: 550px">
				<script type="text/javascript"
					src="//dapi.kakao.com/v2/maps/sdk.js?appkey=54bc1b9c7746df1f03acaf0a07564944"></script>
			</div>
			<!-- kakao map end -->

		</section>
		<!-- End 관광지 조회 섹션 -->
	</div>
	<!-- 메인 컨텐츠 --> </main>
	<!-- End #main -->


	<%@ include file="/include/footer.jsp"%>

	<a href="#"
		class="scroll-top d-flex align-items-center justify-content-center"><i
		class="bi bi-arrow-up-short"></i></a>

	<div id="preloader"></div>

	<%@ include file="/include/modals.jsp"%>
	<%@ include file="/include/jsinclude.jsp"%>

	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=54963ba8b27648e7471f4438db6499e7&libraries=services,clusterer,drawing"></script>
	<script type="module" src="${root}/assets/js/map.js"></script>

</body>

</html>