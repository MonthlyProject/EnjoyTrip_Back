<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>

  <c:if test="${empty userInfo}">
	<script>
	alert("로그인이 필요한 페이지입니다.");
	location.href = "${root}";
	</script>
  </c:if>