package it.prova.raccoltafilm.web.servlet.utente;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.raccoltafilm.model.Ruolo;
import it.prova.raccoltafilm.model.Utente;
import it.prova.raccoltafilm.service.MyServiceFactory;
import it.prova.raccoltafilm.service.RuoloService;
import it.prova.raccoltafilm.service.UtenteService;
import it.prova.raccoltafilm.utility.UtilityForm;

@WebServlet("/admin/ExecuteInsertUtenteServlet")
public class ExecuteInsertUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UtenteService utenteService;
	private RuoloService ruoloService;

	public ExecuteInsertUtenteServlet() {
		this.ruoloService = MyServiceFactory.getRuoloServiceInstance();
		this.utenteService = MyServiceFactory.getUtenteServiceInstance();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// estraggo input
		String usernameParam = request.getParameter("username");
		String passwordParam = request.getParameter("password");
		String confermaPassParam = request.getParameter("passwordConferma");
		String nomeParam = request.getParameter("nome");
		String cognomeParam = request.getParameter("cognome");
		String[] ruoliParam = request.getParameterValues("ruoli");

		Utente utenteInstance = new Utente(usernameParam, passwordParam, nomeParam, cognomeParam, new Date());
		Set<Ruolo> ruoliUtente = new HashSet<>();

		try {
			if (ruoliParam != null) {
				for (String stringId : ruoliParam) {

					Ruolo ruoloInstance = null;

					if (NumberUtils.isCreatable(stringId)) {
						ruoloInstance = ruoloService.caricaSingoloElemento(Long.parseLong(stringId));
					}
					if (ruoloInstance != null) {
						ruoliUtente.add(ruoloInstance);
					}
				}
			}

			utenteInstance.setRuoli(ruoliUtente);

			if (!UtilityForm.validateUtenteBean(utenteInstance) || !passwordParam.equals(confermaPassParam)) {
				request.setAttribute("insert_utente_attr", utenteInstance);
				request.setAttribute("ruoli_list_attribute", ruoloService.listAll());
				List<Long> idRuoli = new ArrayList<>();
				for (Ruolo ruolo : ruoliUtente) {
					idRuoli.add(ruolo.getId());
				}
				request.setAttribute("ruoli_assegnati", idRuoli);
				request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
				request.getRequestDispatcher("/utente/insert.jsp").forward(request, response);
				return;
			}

			utenteService.inserisciNuovo(utenteInstance);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/utente/insert.jsp").forward(request, response);
			return;
		}

		response.sendRedirect("ExecuteListUtenteServlet?operationResult=SUCCESS");
	}
}
