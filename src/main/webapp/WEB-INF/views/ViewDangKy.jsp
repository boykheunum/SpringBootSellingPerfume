<%@ include file="/Common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form method="POST" action="${userEntity}"
		modelAttribute="userEntity">
		<label>Username</label>
		<form:input type="text" path="username" />
		<label>Password</label>
		<form:input type="text" path="password" />
		<label>Phone</label>
		<form:input type="text" path="phone" />
		<label>Email</label>
		<form:input type="text" path="email" />
		<label>Adress</label>
		<form:input type="text" path="adress"/>
		<label>Avatar</label>
		<form:input type="text" path="avatar"/>
		<label>Sex</label>
		<form:input type="text" path="sex"/>
		<label>Lương</label>
		<form:input type="text" path="luong"/>
		<label>Status</label>
		<form:input type="text" path="status"/>
		<button type="submit">save</button>
	</form:form>
	
</body>
<script></script>
</html>