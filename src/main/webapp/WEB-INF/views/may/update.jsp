<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="pageTitle" value="Cập Nhật Máy"/>
<c:set var="pageContent">
    <h3>${pageTitle}</h3>
    <form method="post">
        <div class="form-group">
            <label for="maMay">Mã Máy</label>
            <input type="text"
                   id="maMay"
                   class="form-control ${empty error.maMay ? '' : 'is-invalid'}"
                   name="maMay"
                   value="${may.maMay}"
                   readonly
            >
            <div class="invalid-feedback">${error.maMay}</div>
        </div>
        <div class="form-group">
            <label for="viTri">Vị Trí</label>
            <input type="text"
                   id="viTri"
                   class="form-control ${empty error.viTri ? '' : 'is-invalid'}"
                   name="viTri"
                   value="${may.viTri}"
            >
        </div>
        <div class="form-group">
            <label for="trangThai">Trạng Thái</label>
            <select id="trangThai"
                    class="form-control ${empty error.trangThai ? '' : 'is-invalid'}"
                    name="trangThai"
            >
                <option value="" ${empty may.trangThai ? 'selected' : ''} disabled>...</option>
                <option value="Rảnh" $${may.trangThai eq 'Rảnh' ? 'selected' : ''}>Rảnh</option>
                <option value="Đang sử dụng" ${may.trangThai eq 'Đang sử dụng' ? 'selected' : ''}>Đang sử dụng</option>
                <option value="Đang sửa chữa" ${may.trangThai eq 'Đang sửa chữa' ? 'selected' : ''}>Đang sửa chữa
                </option>
            </select>
            <div class="invalid-feedback">${error.trangThai}</div>
        </div>
        <div class="text-success">${successMessage}</div>
        <button type="submit" class="btn btn-primary">${pageTitle}</button>
    </form>
    <script>
        $(document).ready(function () {
            let maMay = $('#maMay');
            let viTri = $('#viTri');
            let trangThai = $('#trangThai');

            [maMay, viTri].forEach(item => item.on('input', function () {
                $(this).removeClass('is-invalid');
            }))
            trangThai.on('input', function () {
                $(this).removeClass('is-invalid')
            })
        })
    </script>
</c:set>

<%@include file="/WEB-INF/views/layout/main.jsp" %>