<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="pageTitle" value="Tạo Mới Dịch Vụ"/>
<c:set var="pageContent">
    <h3>${pageTitle}</h3>
    <form method="post">
        <div class="form-group">
            <label for="maDV">Mã Dịch Vụ</label>
            <input type="text"
                   id="maDV"
                   class="form-control ${empty error.maDV ? '' : 'is-invalid'}"
                   name="maDV"
                   value="${dichVu.maDV}"
            >
            <div class="invalid-feedback">${error.maDV}</div>
        </div>
        <div class="form-group">
            <label for="tenDV">Tên Dịch Vụ</label>
            <input type="text"
                   id="tenDV"
                   class="form-control ${empty error.tenDV ? '' : 'is-invalid'}"
                   name="tenDV"
                   value="${dichVu.tenDV}"
            >
            <div class="invalid-feedback">${error.tenDV}</div>
        </div>
        <div class="form-group">
            <label for="donViTinh">Đơn Vị Tính</label>
            <select id="donViTinh"
                    class="form-control ${empty error.donViTinh ? '' : 'is-invalid'}"
                    name="donViTinh"
            >
                <option value="" ${empty dichVu.donViTinh ? 'selected' : ''} disabled>...</option>
                <option value="Kg" $${dichVu.donViTinh eq 'Kg' ? 'selected' : ''}>Kg</option>
                <option value="Cái" ${dichVu.donViTinh eq 'Cái' ? 'selected' : ''}>Cái</option>
                <option value="Lít" ${dichVu.donViTinh eq 'Lít' ? 'selected' : ''}>Lít</option>
            </select>
            <div class="invalid-feedback">${error.donViTinh}</div>
        </div>
        <div class="form-group">
            <label for="donGia">Đơn Giá</label>
            <input type="text"
                   id="donGia"
                   class="form-control ${empty error.donGia ? '' : 'is-invalid'}"
                   name="donGia"
                   value="${dichVu.donGia}"
            >
            <div class="invalid-feedback">${error.donGia}</div>
        </div>
        <div class="text-success">${successMessage}</div>
        <button type="submit" class="btn btn-primary">${pageTitle}</button>
    </form>
    <script>
        $(document).ready(function () {
            let maDV = $('#maDV');
            let tenDV = $('#tenDV');
            let donViTinh = $('#donViTinh');
            let donGia = $('#donGia');

            [maDV, tenDV, donViTinh, donGia].forEach(item => item.on('input', function () {
                $(this).removeClass('is-invalid');
            }))
        })
    </script>
</c:set>

<%@include file="/WEB-INF/views/layout/main.jsp" %>