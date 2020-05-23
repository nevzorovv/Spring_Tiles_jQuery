<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

Filter:<br/>
<form method="get" action="/tiles">
    <input type="hidden" name="enableFilter" value="true">
    Select manufacturers:<br/>
    <%--<%=request.getParameterValues("manufacturer")%>--%>
    <c:forEach items="${manufacturers}" var="manufacturer">
        <c:if test="${manufacturer.checked == null || manufacturer.checked == false}">
            <input type="checkbox" name="manufacturer" value="${manufacturer.manufacturer}">${manufacturer.manufacturer}
        </c:if>
        <c:if test="${manufacturer.checked == true}">
            <input type="checkbox" name="manufacturer" value="${manufacturer.manufacturer}" checked>${manufacturer.manufacturer}
        </c:if>
    </c:forEach><br/>
    Price interval:<br/>
    <c:if test="${priceFormatError != null}">
        <span style="color: crimson; font-weight: lighter">Price must be positive only</span><br/>
    </c:if>
    <input type="number" name="minPrice" value="${minPrice}"> - <input type="number" name="maxPrice" value="${maxPrice}"><br/>
    Choose colors:<br/>
    <c:forEach items="${colors}" var="color">
        <c:if test="${color.checked == null || color.checked == false}">
            <input type="checkbox" name="color" value="${color.color}">${color.color}
        </c:if>
        <c:if test="${color.checked == true}">
            <input type="checkbox" name="color" value="${color.color}" checked>${color.color}
        </c:if>
    </c:forEach><br/>
    <button type="submit">Find</button>
</form>
<a href="/tiles"><button>Reset</button></a>

