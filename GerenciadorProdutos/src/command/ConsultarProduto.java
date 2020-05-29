package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produto;
import service.ProdutoService;

public class ConsultarProduto implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parameterCodigo = request.getParameter("codigo_pro");
		int codigo;

		if (parameterCodigo == "" || parameterCodigo == null || parameterCodigo.length() <= 0
				|| parameterCodigo.isEmpty()) {
			request.setAttribute("mensagem", "Informe o código do produto!");
			return;
		} else {
			codigo = Integer.parseInt(parameterCodigo);
		}

		ProdutoService produtoService = new ProdutoService();
		Produto resultado = produtoService.consultar(codigo);

		if (!resultado.isValid()) {
			request.setAttribute("mensagem", "Produto não encontrado.");
		} else {
			request.setAttribute("resultado", resultado);
		}
		
		// Despachar o usuário à parte de visão (apresentação - view):
		RequestDispatcher view = request.getRequestDispatcher("consultar.jsp");
		view.forward(request, response);
	}

}
