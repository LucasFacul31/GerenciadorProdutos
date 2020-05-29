package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;

@WebServlet(name = "Controller.do", urlPatterns = { "/Controller.do" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doExecute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doExecute(request, response);
	}

	protected void doExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// Descobrir qual o comando deve ser executado: CadastrarProduto
			String comando = request.getParameter("command");
			// Declarando um command:
			Command command = (Command) Class.forName("command." + comando).newInstance();
			// Solicitando a execução da ação do comando:
			command.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
