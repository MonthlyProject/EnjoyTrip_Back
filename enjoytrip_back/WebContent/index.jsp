<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/include/head.jsp"%>

<body>
	<%@ include file="include/header.jsp"%>

	<!-- ======= Hero Section ======= -->
	<section id="hero" class="hero">
		<div class="container position-relative">
			<div class="row gy-5" data-aos="fade-in">
				<div
					class="col-lg-6 order-2 order-lg-1 d-flex flex-column justify-content-center text-center text-lg-start">
					<h2>
						Welcome to <span>Enjoy Trip</span>
					</h2>
					<p>Enjoy Trip is ready to be your best travel mate !</p>
					<div class="d-flex justify-content-center justify-content-lg-start">
						<a href="#about" class="btn-get-started">Get Started</a> <a
							href="https://youtu.be/CcCjvSZQ-Xc"
							class="glightbox btn-watch-video d-flex align-items-center"><i
							class="bi bi-play-circle"></i><span>Watch Video</span></a>
					</div>
				</div>
				<div class="col-lg-6 order-1 order-lg-2">
					<img
						src="https://i0.wp.com/www.korvia.com/wp-content/uploads/2015/11/image-header-live-in-jeju.jpg?fit=960%2C640&ssl=1"
						class="img-fluid rounded-3" alt="" data-aos="zoom-out"
						data-aos-delay="100" />	
				</div>
			</div>
		</div>

		<div class="icon-boxes position-relative">
			<div class="container position-relative">
				<div class="row gy-4 mt-5">
					<div class="col-xl-3 col-md-6" data-aos="fade-up"
						data-aos-delay="100">
						<div class="icon-box">
							<div class="icon">
								<i class="bi bi-geo-alt"></i>
							</div>
							<h4 class="title">
								<a href="${root}/map?action=area" class="stretched-link">관광지
									조회</a>
							</h4>
						</div>
					</div>
					<!--End Icon Box -->

					<div class="col-xl-3 col-md-6" data-aos="fade-up"
						data-aos-delay="200">
						<div class="icon-box">
							<div class="icon">
								<i class="bi bi-patch-check-fill"></i>
							</div>
							<h4 class="title">
								<a href="" class="stretched-link">공지사항</a>
							</h4>
						</div>
					</div>
					<!--End Icon Box -->

					<div class="col-xl-3 col-md-6" data-aos="fade-up"
						data-aos-delay="300">
						<div class="icon-box">
							<div class="icon">
								<i class="bi bi-card-heading"></i>
							</div>
							<h4 class="title">
								<a href="${root}/article?action=list&pgno=1&key=&word="
									class="stretched-link">게시판</a>
							</h4>
						</div>
					</div>
					<!--End Icon Box -->

					<div class="col-xl-3 col-md-6" data-aos="fade-up"
						data-aos-delay="500">
						<div class="icon-box">
							<div class="icon">
								<i class="bi bi-star-fill"></i>
							</div>
							<h4 class="title">
								<a href="" class="stretched-link">관심 목록</a>
							</h4>
						</div>
					</div>
					<!--End Icon Box -->
				</div>
			</div>
		</div>
	</section>
	<!-- End Hero Section -->

	<main id="main"></main>
	<!-- End #main -->

	<%@ include file="/include/footer.jsp"%>

	<%@ include file="/include/modals.jsp" %>
	
	<a href="#"
		class="scroll-top d-flex align-items-center justify-content-center"><i
		class="bi bi-arrow-up-short"></i></a>

	<div id="preloader"></div>


	<%@ include file="/include/jsinclude.jsp"%>
</body>

</html>