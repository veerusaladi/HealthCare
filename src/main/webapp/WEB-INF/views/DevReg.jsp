<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib prefix="form"  uri="http://www.springframework.org/tags/form"%> 
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="save" method="POST" modelAttribute="dev">
<pre> 
CODE   :<form:input path="code"/>
NAME   :<form:input path="name"/>
 project:<form:select path="project.pid">
        <form:option value="">--select--</form:option>
        <form:options items="${pros}" itemLabel="pcode"
                        itemValue="pid"/>
                        </form:select> 
SALARY :<form:input path="salary"/>
   <input type="submit" value="Register"/>
</pre>
</form:form>
${msg}
<br/>
</body>
</html>
