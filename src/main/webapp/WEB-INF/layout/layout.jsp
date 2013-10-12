<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
<head>
    <title><tiles:insertAttribute name="title"/></title>
</head>
<body>

<div>
    <tiles:insertAttribute name="header"/>
</div>
<br/>

<tiles:insertAttribute name="body"/>
<br/>

<div>
    <tiles:insertAttribute name="footer"/>
</div>
<br/>

</body>
</html>