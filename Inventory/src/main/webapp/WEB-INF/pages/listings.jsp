<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
 
 <html>
 <head>
 <style>
    .error {
        color: red; font-weight: bold;
    }
</style>
 </head>
 <div>
<h2>New song Form</h2>
<sf:form method="POST"  action="/add" commandName="listings">
<fieldset>
<table >

<tr>
<th><label for="songName">songName</label></th>
<td><sf:input path="songName" id="songName"/></td>
<td align="left"><sf:errors path="songName" cssClass="error"/></td>
</tr>
<tr>
<th><label for="artistName">artistName</label></th>
<td><sf:input path="artistName" id="artistName"/></td>
<td align="left"><sf:errors path="artistName" cssClass="error"/></td>
</tr>
<tr>
<th><label for="albumName">albumName</label></th>
<td><sf:input path="albumName" id="albumName"/></td>
<td align="left"><sf:errors path="albumName" cssClass="error"/></td>
</tr>
<tr>
<th><label for="quantityInStock">quantityInStock</label></th>
<td><sf:input path="quantityInStock" id="quantityInStock"/></td>
<td align="left"><sf:errors path="quantityInStock" cssClass="error"/></td>
</tr>
<tr>
<th><label for="unitPrice">unitPrice</label></th>
<td><sf:input path="unitPrice" id="unitPrice"/></td>
<td align="left"><sf:errors path="unitPrice" cssClass="error"/></td>
</tr>
<tr>
<th><label for="category">categoryName</label></th>
<td><sf:input path="categoryName" id="categoryName"/></td>
<td align="left"><sf:errors path="categoryName" cssClass="error"/></td>
</tr>
<tr>

<th><input type="Submit" value="Submit"/></th>
<td></td>
</tr>
</table>
</fieldset>
</sf:form>
 
</div>
<div>

<h2>Search for Song By Song Name or Artist Name</h2>
<sf:form method="POST"  action="/searchBySongName" commandName="listings">
<fieldset>
<table >
<tr>
<th><label for="songName">Enter songName or artistName</label></th>
<td><sf:input path="songName" id="songName"/></td>
<th><input type="Submit" value="Submit"/></th>
</tr>
<tr/>
</table>
</fieldset>
</sf:form>
</div>


<h3>Inventory List</h3>
<c:if test="${!empty lists}">
    <table class="tg">
    <tr>
       <!--  <th width="20">id</th>
 -->        <th width="100">songName</th>
        <th width="100">artistName</th>
           <th width="100">albumName</th>
        <th width="100">quantity</th>
           <th width="100">unitPrice</th>
           <th width="100">totalPrice</th>
        <th width="100">category</th>
        <th width="60">Edit</th>
        <th width="60">Delete</th>
    </tr>
    <c:forEach items="${lists}" var="listValue">
        <tr>
    <%--         <td>${listValue.id}</td> --%>
            <td>${listValue.songName}</td>
            <td>${listValue.artistName}</td>
            <td>${listValue.albumName}</td>
            <td>${listValue.quantityInStock}</td>
            <td>${listValue.unitPrice}</td>
            <td>${listValue.totalPrice}</td>
            <td>${listValue.categoryName}</td>
            <td><a href="<c:url value='/edit/${listValue.id}' />" >Edit</a></td>
            <td><a href="<c:url value='/remove/${listValue.id}' />" >Delete</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>

</html>
