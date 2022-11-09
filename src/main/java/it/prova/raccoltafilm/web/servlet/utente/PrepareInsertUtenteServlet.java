package it.prova.raccoltafilm.web.servlet.utente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.raccoltafilm.service.MyServiceFactory;
import it.prova.raccoltafilm.service.UtenteService;

@WebServlet("/admin/PrepareInsertUtenteServlet")
public class PrepareInsertUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UtenteService utenteService;
	
	public PrepareInsertUtenteServlet() {
		this.utenteService = MyServiceFactory.getUtenteServiceInstance();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("utenti_list_attribute", utenteService.listAll());
		} catch (Exception e) {
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("home").forward(request, response);
			return;
		}
		
		request.getRequestDispatcher("/utente/insert.jsp").forward(request, response);
	}

}
