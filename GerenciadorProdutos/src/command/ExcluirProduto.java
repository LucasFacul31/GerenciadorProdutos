package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produto;
import service.ProdutoService;

public class ExcluirProduto implements Command {

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
		
		Produto produto = new Produto();
		produto.setCodigo(codigo);

		ProdutoService produtoService = new ProdutoService();
		Produto existe = produtoService.consultar(codigo);
		
		if (!existe.isValid()) {
			request.setAttribute("mensagem", "Produto não encontrado.");
		} else {
			produtoService.excluir(produto);
			request.setAttribute("mensagem", "Produto excluído com sucesso!");
		}
		RequestDispatcher view = request.getRequestDispatcher("excluir.jsp");
		view.forward(request, response);
	}

}
