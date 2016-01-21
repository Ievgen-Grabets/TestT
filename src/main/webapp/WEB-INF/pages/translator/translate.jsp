<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Translate</title>
</head>
<body>
    <h5><b>We are will trnslate here !!</b></h5>

    <form action="/doTransl" method="post">
        Input Language: ${translator.languageIn}
        <select name="languageIn">
            <c:forEach var="language" items="${translator.languages}">
                <option>${language.languageName}</option>
            </c:forEach>
        </select><br>
        <textarea rows="7" cols="70" name="textIn" autofocus maxlength="350">${translator.textIn}</textarea><br><br>
        Output Language: ${translator.languageOut}
        <select name="languageOut">
            <c:forEach var="language" items="${translator.languages}">
                <option>${language.languageName}</option>
            </c:forEach>
        </select><br>
        <textarea rows="7" cols="70" name="textOut" readonly>${translator.textOut}</textarea><br><br>
        <input type="submit" value="Translate !">
    </form>

    <br>
    <a href="/">Home</a>
</body>
</html>
