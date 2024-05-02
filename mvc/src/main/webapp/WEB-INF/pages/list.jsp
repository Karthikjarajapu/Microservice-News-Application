<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List News</title>
</head>
<body>
    <h1>List News</h1>
    <ul>
        <c:forEach var="news" items="${newsList}">
            <li>${news.title}</li>
            <!-- Display other news details as needed -->
        </c:forEach>
    </ul>
</body>
</html>
