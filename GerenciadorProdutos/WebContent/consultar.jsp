<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Produto,java.text.NumberFormat,java.util.Locale"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Consulta de produto</title>
</head>
<body>
<%
	if (request.getAttribute("resultado") != null) {
		Produto p = (Produto) request.getAttribute("resultado");
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		out.println("<h1>Dados do produto:</h1>");
		out.println("<p><b>Código: </b>" + p.getCodigo() + "</p>");
		out.println("<p><b>Nome: </b>" + p.getNome() + "</p>");
		out.println("<p><b>Descrição: </b>" + p.getDescricao() + "</p>");
		out.println("<p><b>Valor: </b>" + numberFormat.format(p.getValor()) + "</p>");
		out.println("<p><b>Estoque: </b>" + p.getEstoque() + "</p>");
	}
%>
	<br>
	<br>
	${ requestScope.mensagem }
	<form action="Controller.do" method="post">
		<input type="hidden" name="command" value="ConsultarProduto">
		<h1>Consulta de produto</h1>
		<div style="margin-bottom: 1rem;">
			Código do produto: <input type="number" name="codigo_pro" required>
		</div>
		<div>
			<input type="submit" value="Consultar">
		</div>
	</form>
	<br>
	<br>
	<a href="index.jsp">Voltar</a>
</body>
</html>