<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>${message}</h1>
<ul>
    <c:forEach var="user" items="${users}">
        <li>${user.id} &nbsp; - ${user.name}</li>
    </c:forEach>
</ul>
<hr/>
>

<form:form action="saveUser" method="post" modelAttribute="user">
    <div>
        <p>Name</p>
        <form:input path="name"/>
        <form:errors path="name" cssstyle="color:red"/>
    </div>

    <input name="" value="Save" type="submit">
    <input name="" value="Reset" type="reset">
</form:form>
