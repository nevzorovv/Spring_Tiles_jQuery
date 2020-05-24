<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table">
    <thead>
    <tr>
        <th scope="col" onclick="sort_id();">id</th>
        <th scope="col" onclick="sort_manufacturer();">Manufacturer</th>
        <th scope="col" onclick="sort_model();">Model</th>
        <th scope="col" onclick="sort_price();">Price</th>
        <th scope="col" onclick="sort_color();">Color</th>
    </tr>
    </thead>
    <tbody class="tbody">
    <c:forEach items="${filteredProducts}" var="product">
        <tr>
            <th scope="row" class="id">${product.id}</th>
            <td class="manufacturer" id="${product.manufacturer}">${product.manufacturer}</td>
            <td class="model">${product.model}</td>
            <td class="price">${product.price}</td>
            <td class="color">${product.color}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<input type="hidden" id="id_order" value="asc">
<input type="hidden" id="manufacturer_order" value="asc">
<input type="hidden" id="model_order" value="asc">
<input type="hidden" id="price_order" value="asc">
<input type="hidden" id="color_order" value="asc">