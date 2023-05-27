<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 로그인 modal start -->
<div class="modal fade" id="login" data-bs-backdrop="static"
	data-bs-keyboard="false" tabindex="-1"
	aria-labelledby="staticBackdropLabel" aria-hidden="true">
	<div class="modal-dialog modal-md">
		<div class="modal-content">
			<form id="form-signin" action="">
			<input type="hidden" name="action" value="signin">
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">로그인</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<div class="mb-3">
						<div class="row text-center">
							<div class="col-3">아이디</div>
							<div class="col">
								<input type="text" class="form-control" id="loginId"
									placeholder="아이디" name="loginId" />
							</div>
						</div>
					</div>
					<div class="mb-3">
						<div class="row text-center">
							<div class="col-3">비밀번호</div>
							<div class="col">
								<input type="password" class="form-control" id="loginPassword"
									placeholder="비밀번호" name="loginPassword" />
							</div>
						</div>
					</div>

				</div>
				<!-- Modal footer -->
				<div class="modal-footer">
                    <button type="button" id="btn-signin" class="btn btn-primary btn-sm">
                        로그인
                    </button>
					<a href="#" data-bs-toggle="modal" data-bs-target="#bwFinder">
						<button type="button" id="btn-poll-create"
							class="btn btn-secondary btn-sm">비밀번호찾기</button>
					</a>
					<button type="button" class="btn btn-outline-danger btn-sm"
						data-bs-dismiss="modal">취소</button>
				</div>
			</form>
		</div>
	</div>
</div>
<!-- 로그인 modal end -->

<!-- 비밀번호찾기 modal start -->
<div class="modal fade" id="bwFinder" data-bs-backdrop="static"
	data-bs-keyboard="false" tabindex="-1"
	aria-labelledby="staticBackdropLabel" aria-hidden="true">
	<div class="modal-dialog modal-md">
		<div class="modal-content">
			<!-- Modal Header -->
			<div class="modal-header">
				<h4 class="modal-title">비밀번호 찾기</h4>
				<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
			</div>

			<!-- Modal body -->
			<div class="modal-body">
				<form action="">
					<div class="mb-3">
						<div class="row text-center">
							<div class="col-3">이름</div>
							<div class="col">
								<input type="text" class="form-control" id="pwFinderName"
									placeholder="이름" name="pwFinderName" />
							</div>
						</div>
					</div>
					<div class="mb-3">
						<div class="row text-center">
							<div class="col-3">아이디</div>
							<div class="col">
								<input type="text" class="form-control" id="pwFinderId"
									placeholder="아이디" name="pwFinderId" />
							</div>
						</div>
					</div>
					<div class="mb-3">
						<div class="row text-center">
							<div class="col-3">이메일</div>
							<div class="col-3">
								<input type="text" class="form-control" id="pwFinderEmailId"
									placeholder="이메일" name="pwFinderEmailId" />
							</div>
							<div class="col-1">
								<span class="input-group-text">@</span>
							</div>
							<div class="col">
								<select name="pwFinderEmailDomain" id="pwFinderEmailDomain"
									class="custom-select form-control">
									<option value="">도메인선택</option>
									<option value="ssafy.com">ssafy.com</option>
									<option value="google.com">google.com</option>
									<option value="naver.com">naver.com</option>
								</select>
							</div>
						</div>
					</div>
				</form>
			</div>

			<!-- Modal footer -->
			<div class="modal-footer">
				<button type="button" id="btn-poll-create"
					class="btn btn-primary btn-sm">비밀번호찾기</button>
				<button type="button" class="btn btn-outline-danger btn-sm"
					data-bs-dismiss="modal">취소</button>
			</div>
		</div>
	</div>
</div>
<!-- 비밀번호찾기 modal end -->

<!-- 회원가입 modal start -->
<div class="modal fade" id="join" data-bs-backdrop="static"
	data-bs-keyboard="false" tabindex="-1"
	aria-labelledby="staticBackdropLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<form id="form-signup" method="post" action="">
			<input type="hidden" name="action" value="signup">
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Enjoy Trip 회원가입</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">

					<div class="mb-3">
						<div class="row text-center">
							<div class="col-3">이름</div>
							<div class="col">
								<input type="text" class="form-control" id="joinName"
									placeholder="이름" name="joinName" />
							</div>
						</div>
					</div>
					<div class="mb-3">
						<div class="row text-center">
							<div class="col-3">아이디</div>
							<div class="col">
								<input type="text" class="form-control" id="joinId"
									placeholder="아이디" name="joinId" />
							</div>
						</div>
					</div>
					<div class="mb-3">
						<div class="row text-center">
							<div class="col-3">비밀번호</div>
							<div class="col">
								<input type="password" class="form-control" id="joinPassword"
									placeholder="비밀번호" name="joinPassword" />
							</div>
						</div>
					</div>
					<div class="mb-3">
						<div class="row text-center">
							<div class="col-3">비밀번호확인</div>
							<div class="col">
								<input type="password" class="form-control" id="joinPwCheck"
									placeholder="비밀번호확인" name="joinPwCheck" />
							</div>
						</div>
					</div>
					<div class="mb-3">
						<div class="row text-center">
							<div class="col-3">이메일</div>
							<div class="col-3">
								<input type="text" class="form-control" id="joinEmailId"
									placeholder="이메일" name="joinEmailId" />
							</div>
							<div class="col-1">
								<span class="input-group-text">@</span>
							</div>
							<div class="col">
								<select name="joinEmailDomain" id="joinEmailDomain"
									class="custom-select form-control">
									<option value="">도메인선택</option>
									<option value="ssafy.com">ssafy.com</option>
									<option value="google.com">google.com</option>
									<option value="naver.com">naver.com</option>
								</select>
							</div>
						</div>
					</div>

				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
                    <button type="button" id="btn-singup" class="btn btn-primary btn-sm">
                        회원가입
                    </button>
					<button type="button" class="btn btn-outline-danger btn-sm"
						data-bs-dismiss="modal">취소</button>
				</div>
			</form>
		</div>
	</div>
</div>
    <script>    
	document.querySelector("#btn-singup").addEventListener("click", function () {
		if (!document.querySelector("#joinName").value) {
          alert("이름 입력!!");
          return;
        } else if (!document.querySelector("#joinId").value) {
          alert("아이디 입력!!");
          return;
        } else if (!document.querySelector("#joinPassword").value) {
          alert("비밀번호 입력!!");
          return;
        } else if (document.querySelector("#joinPassword").value != document.querySelector("#joinPwCheck").value) {
          alert("비밀번호 확인!!");
          return;
        } else {
          let form = document.querySelector("#form-signup");
          form.setAttribute("action", "${root}/user");
          form.submit();
        }
	});
	document.querySelector("#btn-signin").addEventListener("click", function () {
		if (!document.querySelector("#loginId").value) {
          alert("아이디 입력!!");
          return;
        } else if (!document.querySelector("#loginPassword").value) {
          alert("비밀번호 입력!!");
          return;
        } else {
          let form = document.querySelector("#form-signin");
          form.setAttribute("action", "${root}/user");
          form.submit();
        }
	});
    </script>
<!-- 회원가입 modal end -->