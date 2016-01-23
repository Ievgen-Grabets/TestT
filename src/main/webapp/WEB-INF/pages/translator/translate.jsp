<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Translate</title>
</head>
<body>
    <h5><b>We are will trnslate here !!</b></h5>

    <form action="/translate/doTransl" method="post">
        Input Language:
        <select name="languageIn">
            <c:forEach var="language" items="${translatorDto.languages}">
                <c:choose>
                    <c:when test="${translatorDto.languageIn == language.languageName}">
                        <option selected>${language.languageName}</option>
                    </c:when>
                    <c:otherwise>
                        <option>${language.languageName}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select><br>
        <textarea rows="7" cols="70" name="textIn" autofocus maxlength="350">${translatorDto.textIn}</textarea><br><br>
        Output Language:
        <select name="languageOut">
            <c:forEach var="language" items="${translatorDto.languages}">
                <c:choose>
                    <c:when test="${translatorDto.languageOut == language.languageName}">
                        <option selected>${language.languageName}</option>
                    </c:when>
                    <c:otherwise>
                        <option>${language.languageName}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select><br>
        <textarea rows="7" cols="70" name="textOut" readonly>${translatorDto.textOut}</textarea><br><br>
        <input type="submit" value="Translate !">
    </form>

    <br>
    <a href="/">Home</a>
</body>
</html>
