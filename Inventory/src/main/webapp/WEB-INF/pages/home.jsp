
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
 
<div>
<h2>New song Form</h2>
 
<sf:form method="GET">
<fieldset>
<table > 
<tr>
<th><label for="listings">List All Songs</label></th>
<td><input type="submit" value="listings" formaction="listings"/></td>
</tr>
<tr>
<th><label for="add">Add new Song</label></th>
<td><input type="submit" value="add" formaction="addsong"/></td>
</tr>
<tr>
<th><label for="edit">Edit a Song</label></th>
<td><input type="submit" value="edit" formaction="edit"/></td>
</tr>
<tr>
<th><label for="search">Search for song</label></th>
<td><input type="submit" value="searchsong"/></td>
</tr>
<tr>
<th><label for="delete">delete a song</label></th>
<td><input type="submit" value="deletesong"/></td>
</tr>
</table>
</fieldset>
</sf:form>
 
</div>
