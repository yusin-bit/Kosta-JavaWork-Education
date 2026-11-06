<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%!
    // 입력값에 HTML 문자가 있어도 코드로 실행하지 않고 글자로 보여준다.
    private String escapeHtml(Object value) {
        if (value == null) return "";
        return value.toString().replace("&", "&amp;").replace("<", "&lt;")
                .replace(">", "&gt;").replace("\"", "&quot;").replace("'", "&#39;");
    }
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>입력 성공</title>
</head>
<body>
    <h1>입력 성공</h1>
    <p>입력한 아이디: <strong><%= escapeHtml(request.getAttribute("id")) %></strong></p>
    <p><a href="<%= request.getContextPath() %>/index.html">입력 화면으로 돌아가기</a></p>
</body>
</html>
