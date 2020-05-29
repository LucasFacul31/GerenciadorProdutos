<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Exclusão de produto</title>
</head>
<body>
	${ requestScope.mensagem }
	<form action="Controller.do" method="post">
		<input type="hidden" name="command" value="ExcluirProduto">
		<h1>Exclusão de produto</h1>
		<div style="margin-bottom: 1rem;">
			Código do produto: <input type="number" name="codigo_pro" required>
		</div>
		<div>
			<input type="submit" value="Excluir">
		</div>
	</form>
	<br>
	<br>
	<a href="index.jsp">Voltar</a>
</body>
</html>