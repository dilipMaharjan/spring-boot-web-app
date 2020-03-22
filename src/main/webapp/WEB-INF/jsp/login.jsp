<%@ include file="common/header.jspf"%>
<%@ include file="common/nav.jspf"%>
<div class="cotnainer">
	<p style="color: red;">${errorMessage}</p>
	<form class="form" method="POST">
		<input type="text" name="username" /> <input type="password"
			name="password" /> <input type="submit" value="Login" />
	</form>
</div>
<%@ include file="common/footer.jspf"%>