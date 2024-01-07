<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="">
    <ul class="list-group">
        <a class="list-group-item list-group-item-action ${pageContext.request.requestURI eq '/WEB-INF/views/may/create.jsp' ? 'active': ''}"
           href="/may/create">Tạo Mới Máy</a>
        <a class="list-group-item list-group-item-action ${pageContext.request.requestURI eq '/WEB-INF/views/khachhang/create.jsp' ? 'active': ''}"
           href="/khachhang/create">Tạo Mới Khách Hàng</a>
        <a class="list-group-item list-group-item-action ${pageContext.request.requestURI eq '/WEB-INF/views/dichvu/create.jsp' ? 'active': ''}"
           href="/dichvu/create">Tạo Dịch Vụ</a>
        <a class="list-group-item list-group-item-action ${pageContext.request.requestURI eq '/WEB-INF/views/may/showAll.jsp' ? 'active': ''}"
           href="/may">Danh Sách Máy</a>
        <a class="list-group-item list-group-item-action ${pageContext.request.requestURI eq '/WEB-INF/views/khachhang/showAll.jsp' ? 'active': ''}"
           href="/khachhang">Danh Sách Khách Hàng</a>
        <a class="list-group-item list-group-item-action ${pageContext.request.requestURI eq '/WEB-INF/views/dichvu/showAll.jsp' ? 'active': ''}"
           href="/dichvu">Danh Sách Dịch Vụ</a>
        <a class="list-group-item list-group-item-action ${pageContext.request.requestURI eq '/WEB-INF/views/may/use.jsp' ? 'active': ''}"
           href="/sudungmay">Sử Dụng Máy</a>
        <a class="list-group-item list-group-item-action ${pageContext.request.requestURI eq '/WEB-INF/views/dichvu/use.jsp' ? 'active': ''}"
           href="/sudungdichvu">Sử Dụng Dịch Vụ</a>
        <a class="list-group-item list-group-item-action ${pageContext.request.requestURI eq '/WEB-INF/views/statistic.jsp' ? 'active': ''}"
           href="/statistic">Thống Kê</a>
    </ul>
</nav>
