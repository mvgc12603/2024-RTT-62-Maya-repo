<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<section class="title-section">
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">Order #${order.id}</h1>
            <p class="fs-4 text-center mb-3">Total: $${orderTotal}</p>
        </div>
    </div>
</section>

<div class="container d-flex flex-column align-items-center">
    <div class="mt-3 d-inline px-5 p-4 pb-2 border mb-4 border-1 rounded-2">
        <p class="fs-5"><span class="fw-bold">Customer: </span>${order.customer.customerName}</p>
        <p class="fs-5"><span class="fw-bold">Order Date: </span>${order.orderDate}</p>
        <p class="fs-5"><span class="fw-bold">Status: </span>${order.status}</p>


    </div>

    <table class="table table-hover table-striped table-bordered">
        <tr>
            <th class="text-center">Product ID</th>
            <th>Product Name</th>
            <th class="text-end">Quantity</th>
            <th class="text-end">Price Each</th>
            <th class="text-end">Total</th>
        </tr>
        <h2 class="text-center mb-3">${orderDetailList.size()} Products</h2>

        <c:forEach items="${orderDetailList}" var="orderDetail">
            <tr>
                <td class="text-center">${orderDetail.productId}</td>
                <td>${orderDetail.productName}</td>
                <td class="text-end">${orderDetail.quantityOrdered}</td>
                <td class="text-end">$${orderDetail.priceEach}</td>
                <td>${detail.quantity_ordered}</td>
                <td class="text-end">$${orderDetail.total}</td>
            </tr>
        </c:forEach>
    </table>
</div>


<jsp:include page="../include/footer.jsp"/>