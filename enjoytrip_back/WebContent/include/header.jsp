<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- ======= Header ======= -->

<header id="header" class="header d-flex align-items-center">
	<div
		class="container-fluid container-xl d-flex align-items-center justify-content-between">
		<a href="${root}" class="logo d-flex align-items-center"> <!-- Uncomment the line below if you also wish to use an image logo -->
			<!-- <img src="assets/img/logo.png" alt=""> -->
			<h1>
				Enjoy Trip<span>.</span>
			</h1>
		</a>
		<nav id="navbar" class="navbar">
			<ul>
				<c:if test="${empty userInfo}">
					<li><a href="#" data-bs-toggle="modal" data-bs-target="#login">로그인</a></li>
					<li><a href="#" data-bs-toggle="modal" data-bs-target="#join">회원가입</a></li>
				</c:if>
				<c:if test="${not empty userInfo}">
					<li><a href="${root}/user?action=mypage">마이페이지</a></li>
					<li><a href="${root}/user?action=signout">로그아웃</a></li>
				</c:if>
			</ul>
		</nav>
		<!-- .navbar -->

		<i class="mobile-nav-toggle mobile-nav-show bi bi-list"></i> <i
			class="mobile-nav-toggle mobile-nav-hide d-none bi bi-x"></i>
	</div>
</header>
<!-- End Header -->