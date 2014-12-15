
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html>

 <table>
    <tr>
        <th >Combintion of songName and artistName should be unique. </th>
        <th> Return to Homepage and enter different values again</th>
        
 </tr>
 </table>

<div>

	<sf:form method="GET" action="/listings" commandName="listings">
		<fieldset>
			<table>

				<tr>
					<th><input type="Submit" value="HOMEPAGE" /></th>
				</tr>
				<tr />
			</table>
		</fieldset>
	</sf:form>
</div>
</html>