<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    boolean emptyInput = "아이디를 입력해 주세요.".equals(request.getAttribute("errorMessage"));
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>입력 실패</title>
</head>
<body>
    <h1>입력 실패</h1>
    <p>알림을 확인하면 로그인 화면으로 돌아갑니다.</p>
    <a id="loginLink" href="${pageContext.request.contextPath}/index.html">로그인 화면으로 돌아가기</a>
    <script>
        // 알림창에서 확인을 누른 뒤에 다음 줄이 실행된다.
        alert("<%= emptyInput ? "아이디를 입력해 주세요." : "처리 중 오류가 발생했습니다. 다시 시도해 주세요." %>");
        window.location.replace(document.getElementById("loginLink").href);
    </script>
</body>
</html>
