<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
 
 <html>
 
<h3>Searched List</h3>
<c:if test="${!empty lists}">
    <table class="tg">
    <tr>
        <th width="10">id</th>
        <th width="100">songName</th>
        <th width="100">artistName</th>
           <th width="100">albumName</th>
        <th width="100">quantityInStock</th>
           <th width="100">unitPrice</th>
        <th width="100">category</th>
       
    </tr>
    <c:forEach items="${lists}" var="listValue">
        <tr>
            <td>${listValue.id}</td>
            <td>${listValue.songName}</td>
            <td>${listValue.artistName}</td>
            <td>${listValue.albumName}</td>
            <td>${listValue.quantityInStock}</td>
            <td>${listValue.unitPrice}</td>
            <td>${listValue.categoryName}</td>
          
        </tr>
        <tr></tr>
    </c:forEach>
    </table>
</c:if>

<div>

<sf:form method="GET"  action="/listings" commandName="listings">
<fieldset>
<table >

<tr>
<th><input type="Submit" value="HOMEPAGE" /></th>
</tr>
<tr/>
</table>
</fieldset>
</sf:form>
</div>
</html>