package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produto;
import service.ProdutoService;

public class AlterarProduto implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome_pro");
		String descricao = request.getParameter("descricao_pro");
		String parameterCodigo = request.getParameter("codigo_pro");
		String parameterValor= request.getParameter("valor_pro");
		String parameterEstoque = request.getParameter("estoque_pro");
		int codigo;
		double valor;
		int estoque;
		
		if (nome == "" || nome == null || nome.length() <= 0 || nome.isEmpty()) {
			request.setAttribute("mensagem", "Informe o nome do produto!");
			return;
		}
		
		if (descricao == "" || descricao == null || descricao.length() <= 0 || descricao.isEmpty()) {
			request.setAttribute("mensagem", "Informe a descrição do produto!");
			return;
		}
		
		if (parameterCodigo == "" || parameterCodigo == null || parameterCodigo.length() <= 0 || parameterCodigo.isEmpty()) {
			request.setAttribute("mensagem", "Informe o código do produto!");
			return;
		} else {
			codigo = Integer.parseInt(parameterCodigo);
		}
		
		if (parameterValor == "" || parameterValor == null || parameterValor.length() <= 0 || parameterValor.isEmpty()) {
			request.setAttribute("mensagem", "Informe o valor do produto!");
			return;
		} else {
			valor = Double.parseDouble(parameterValor.replace(',', '.'));
		}
		
		if (parameterEstoque == "" || parameterEstoque == null || parameterEstoque.length() <= 0 || parameterEstoque.isEmpty()) {
			request.setAttribute("mensagem", "Informe o estoque do produto!");
			return;
		} else {
			estoque = Integer.parseInt(parameterEstoque);
		}

		Produto produto = new Produto();
		produto.setCodigo(codigo);
		produto.setDescricao(descricao);
		produto.setEstoque(estoque);
		produto.setNome(nome);
		produto.setValor(valor);

		ProdutoService produtoService = new ProdutoService();
		Produto existe = produtoService.consultar(codigo);

		if (!existe.isValid()) {
			request.setAttribute("mensagem", "Produto não encontrado.");
		} else {
			produtoService.alterar(produto);
			request.setAttribute("mensagem", "Produto alterado com sucesso!");
		}
		RequestDispatcher view = request.getRequestDispatcher("alteracao.jsp");
		view.forward(request, response);
	}

}
