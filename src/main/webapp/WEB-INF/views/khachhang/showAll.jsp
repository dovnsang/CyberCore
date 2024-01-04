<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="pageTitle" value="Danh Sách Khách Hàng"/>
<c:set var="pageContent">
  <div class="d-flex justify-content-between">
    <h3>${pageTitle}</h3>
    <%@include file="../common/searchbox.jsp"%>
  </div>
  <table class="table table-hover">
    <thead>
    <tr>
      <th>Mã khách hàng</th>
      <th>Tên khách hàng</th>
      <th>Địa chỉ</th>
      <th>Số điện thoại</th>
      <th>Địa chỉ email</th>
      <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="khachHang" varStatus="status" items="${itemList}">
      <tr>
        <td>${khachHang.maKH}</td>
        <td>${khachHang.tenKH}</td>
        <td>${khachHang.diaChi}</td>
        <td>${khachHang.soDienThoai}</td>
        <td>${khachHang.diaChiEmail}</td>
        <td class="d-flex">
          <a href="/khachhang/update/${khachHang.maKH}" class="btn btn-primary mr-2">Cập
            nhật
          </a>
          <button class="btn btn-danger" data-toggle="modal" data-target="#deleteModal${khachHang.maKH}">Xoá
          </button>
        </td>
      </tr>
      <!-- Delete Modal -->
      <div class="modal fade" id="deleteModal${khachHang.maKH}" tabindex="-1">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title">Xác Nhận Xoá</h5>
              <button type="button" class="close" data-dismiss="modal">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
              Bạn có chắc muốn xoá ${khachHang.maKH}
            </div>
            <div class="modal-footer">
              <a href="/may/delete/${khachHang.maKH}" class="btn btn-danger">Đồng ý</a>
              <button type="button" class="btn btn-secondary" data-dismiss="modal">Huỷ</button>
            </div>
          </div>
        </div>
      </div>
    </c:forEach>
    </tbody>
  </table>
  <%@include file="../common/pagination.jsp" %>
</c:set>
<%@include file="../layout/main.jsp" %>