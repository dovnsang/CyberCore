<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>${pageTitle}</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
    <script src="<c:url value="/resources/js/jquery-3.7.1.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
    <style>
        .navbar {
            height: 60px;
        }

        .sidebar {
            height: calc(100vh - 60px);
        }

        .main-content {
            max-height: calc(100vh - 60px);
            height: 100%;
            overflow-y: auto;
        }
    </style>
</head>
<body>
<!-- Image and text -->
<nav class="navbar navbar-light bg-light">
    <a class="navbar-brand" href="#">
        <img src="/resources/images/logo.jpg" width="30" height="30" class="d-inline-block align-top"
             alt="">
        CyberCore
    </a>
</nav>
<div class="container-fluid row vw-100">
    <nav class="sidebar col-2">
        <div class="sidebar-sticky pt-3">
            <ul class="nav flex-column">
                <li class="nav-item">
                    <a class="nav-link" href="/may/create">Tạo Mới Máy</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/khachhang/create">Tạo Mới Khách Hàng</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/dichvu/create">Tạo Dịch Vụ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/may">Danh Sách Máy</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/khachhang">Danh Sách Khách Hàng</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/dichvu">Danh Sách Dịch Vụ</a>
                </li>
            </ul>
        </div>
    </nav>
    <div class="main-content col-10 pt-3">
        ${pageContent}
    </div>
</div>
</body>
</html>
