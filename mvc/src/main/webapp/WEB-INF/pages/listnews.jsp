<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List News</title>
    <style>
        .news-card {
            display: flex;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            padding: 10px;
        }

        .news-content {
            flex: 1;
            padding-right: 10px;
        }

        .news-image {
            flex: 1;
            max-width: 500px; /* Adjust as needed */
        }

        /* Optional: Styles for image aspect ratio */
        .news-image img {
            width: 100%;
            height: auto;
        }
    </style>
</head>
<body>
    <h1>List of News Articles</h1>
    <c:forEach var="news" items="${newsList}">
        <div class="news-card">
            <div class="news-content">
                <h3>${news.title}</h3>
                <p>${news.content}</p>
            </div>
            <div class="news-image">
                <img src="${news.imageUrl}" alt="${news.title} Image">
            </div>
        </div>
    </c:forEach>
</body>
</html>
