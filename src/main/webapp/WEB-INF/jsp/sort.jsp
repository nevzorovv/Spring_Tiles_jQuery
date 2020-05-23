<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

Sort by:<br/>
<div class="btn-group">
    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        <c:if test="${chosenProperty == null}">
            Property
        </c:if>
        <c:if test="${chosenProperty != null}">
            ${chosenProperty}
        </c:if>
    </button>
    <div class="dropdown-menu">
        <a class="dropdown-item" href="/sortrequest?property=default">Default</a>
        <div class="dropdown-divider"></div>
        <c:forEach items="${properties}" var="property">
            <button class="dropdown-item" href="/sortrequest?property=${property}&direction=${chosenDirection}">${property}</button>
        </c:forEach>
    </div>
</div>
<div class="btn-group">
    <button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        <c:if test="${chosenDirection == null}">
            Direction
        </c:if>
        <c:if test="${chosenDirection != null}">
            ${chosenDirection}
        </c:if>
    </button>
    <div class="dropdown-menu">
        <a class="dropdown-item" href="/sortrequest?direction=increasing">Increasing</a>
        <a class="dropdown-item" href="/sortrequest?direction=decreasing">Decreasing</a>
    </div>
</div><br/>