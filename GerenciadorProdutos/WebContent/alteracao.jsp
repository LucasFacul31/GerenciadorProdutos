<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alteração de produto</title>
</head>
<body>
	${ requestScope.mensagem }
	<form action="Controller.do" method="post">
		<input type="hidden" name="command" value="AlterarProduto">
		<h1>Alteração de produto</h1>
		<div style="margin-bottom: 1rem;">
			Código do produto: <input type="number" name="codigo_pro"
				required>
		</div>
		<h2 style="margin: 1rem 0;">Novos dados do produto:</h2>
		<div style="margin-bottom: 1rem;">
			Nome: <input type="text" name="nome_pro" required>
		</div>
		<div style="margin-bottom: 1rem;">
			Descrição: <input type="text" name="descricao_pro" required>
		</div>
		<div style="margin-bottom: 1rem;">
			Valor: <input type="number" name="valor_pro" required>
		</div>
		<div style="margin-bottom: 1rem;">
			Estoque: <input type="number" name="estoque_pro" required>
		</div>
		<div>
			<input type="submit" value="Atualizar dados">
		</div>
	</form>
	<br>
	<br>
	<a href="index.jsp">Voltar</a>
</body>
</html>