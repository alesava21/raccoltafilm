package it.prova.raccoltafilm.web.servlet.regista;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.raccoltafilm.model.Regista;
import it.prova.raccoltafilm.service.MyServiceFactory;
import it.prova.raccoltafilm.utility.UtilityForm;

@WebServlet("/ExecuteUpdateRegistaServlet")
public class ExecuteUpdateRegistaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parametroIdRegistaDaModificare = request.getParameter("idDaInviareComeParametro");
		String nomeInputParam = request.getParameter("nome");
		String cognomeInputParam = request.getParameter("cognome");
		String nickNameInputParam = request.getParameter("nickName");
		String dataDiNascitaInputParm = request.getParameter("dataDiNascita");
		String sessoInputParam = request.getParameter("sesso");
		
		
		Regista registaInstance = UtilityForm.createRegistaFromParams(nomeInputParam, cognomeInputParam, nickNameInputParam, dataDiNascitaInputParm, sessoInputParam, parametroIdRegistaDaModificare);
		
		if (!UtilityForm.validateRegistaBean(registaInstance)) {
			
				request.setAttribute("RegistaDaAggiornare", registaInstance);
			
			request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
			request.getRequestDispatcher("/regista/update").forward(request, response);
			return;
			
		}
		
		try {
			MyServiceFactory.getRegistaServiceInstance().aggiorna(registaInstance);
			request.setAttribute("registi_list_attribute", MyServiceFactory.getRegistaServiceInstance().listAllElements());
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/regista/list.jsp").forward(request, response);
			return;
		}
		response.sendRedirect("ExecuteListRegistaServlet?operationResult=SUCCESS");
		
	}

}
