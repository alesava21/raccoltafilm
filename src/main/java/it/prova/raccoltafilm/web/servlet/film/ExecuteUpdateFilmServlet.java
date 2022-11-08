package it.prova.raccoltafilm.web.servlet.film;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.raccoltafilm.model.Film;
import it.prova.raccoltafilm.service.FilmService;
import it.prova.raccoltafilm.service.MyServiceFactory;
import it.prova.raccoltafilm.service.RegistaService;
import it.prova.raccoltafilm.utility.UtilityForm;

@WebServlet("/ExecuteUpdateFilmServlet")
public class ExecuteUpdateFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// injection del Service
	private FilmService filmService;
	private RegistaService registaService;

	public ExecuteUpdateFilmServlet() {
		this.filmService = MyServiceFactory.getFilmServiceInstance();
		this.registaService = MyServiceFactory.getRegistaServiceInstance();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parametroIdFilmDaModificare = request.getParameter("idDaInviareComeParametro");
		String titoloInputParam = request.getParameter("titolo");
		String genereInputParam = request.getParameter("genere");
		String minutiInputParam = request.getParameter("minutiDurata");
		String dataPubblicazioneInputParam = request.getParameter("dataPubblicazione");
		String idregista = request.getParameter("regista.id");

		try {
			Film filmInstance = UtilityForm.createFilmFromParams1(titoloInputParam, genereInputParam, minutiInputParam,
					dataPubblicazioneInputParam, idregista, parametroIdFilmDaModificare);
			if (!UtilityForm.validateFilmBean1(filmInstance)) {
				request.setAttribute("filmDaAggiornare", filmInstance);
				request.setAttribute("registi_list_attribute", registaService.listAllElements());
				request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
				request.getRequestDispatcher("/film/update.jsp").forward(request, response);
				return;

			}

			filmService.aggiorna(filmInstance);
			request.setAttribute("film_list_attribute", filmService.listAllElements());
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("home").forward(request, response);
			return;
		}
		response.sendRedirect("ExecuteListFilmServlet?operationResult=SUCCESS");
	}

}
