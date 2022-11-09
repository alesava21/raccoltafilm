package it.prova.raccoltafilm.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.mysql.cj.conf.HostInfo;

import it.prova.raccoltafilm.model.Film;
import it.prova.raccoltafilm.model.Regista;
import it.prova.raccoltafilm.model.Sesso;
import it.prova.raccoltafilm.model.Utente;

public class UtilityForm {

	public static Regista createRegistaFromParams(String nomeInputParam, String cognomeInputParam,
			String nickNameInputParam, String dataDiNascitaStringParam, String sessoParam) {

		Regista result = new Regista(nomeInputParam, cognomeInputParam, nickNameInputParam);
		result.setSesso(StringUtils.isBlank(sessoParam)?null:Sesso.valueOf(sessoParam));
		result.setDataDiNascita(parseDateArrivoFromString(dataDiNascitaStringParam));
		return result;
	}
	public static Regista createRegistaFromParams(String nomeInputParam, String cognomeInputParam,
			String nickNameInputParam, String dataDiNascitaStringParam, String sessoParam, String idRegistaInputParm) {

		Regista result = new Regista(nomeInputParam, cognomeInputParam, nickNameInputParam, idRegistaInputParm);
		result.setSesso(StringUtils.isBlank(sessoParam)?null:Sesso.valueOf(sessoParam));
		result.setDataDiNascita(parseDateArrivoFromString(dataDiNascitaStringParam));
		result.setId(NumberUtils.isCreatable(idRegistaInputParm)?Long.parseLong(idRegistaInputParm):null);
		return result;
	}
	
	public static Regista createRegistaFromParams1(String nomeInputParam, String cognomeInputParam,
			String nickNameInputParam, String dataDiNascitaStringParam, String sessoParam) {

		Regista result = new Regista(nomeInputParam, cognomeInputParam, nickNameInputParam);
		result.setSesso(StringUtils.isBlank(sessoParam)?null:Sesso.valueOf(sessoParam));
		result.setDataDiNascita(parseDateArrivoFromString(dataDiNascitaStringParam));
		return result;
	}
	
	public static boolean validateRegistaBean1(Regista registaToBeValidated1) {
		// prima controlliamo che non siano vuoti i parametri
		if (StringUtils.isBlank(registaToBeValidated1.getNome())
				|| StringUtils.isBlank(registaToBeValidated1.getCognome())
				|| StringUtils.isBlank(registaToBeValidated1.getNickName()) 
				|| registaToBeValidated1.getSesso() == null
				|| registaToBeValidated1.getDataDiNascita() == null) {
			return false;
		}
		return true;
	}

	public static boolean validateRegistaBean(Regista registaToBeValidated) {
		// prima controlliamo che non siano vuoti i parametri
		if (StringUtils.isBlank(registaToBeValidated.getNome())
				|| StringUtils.isBlank(registaToBeValidated.getCognome())
				|| StringUtils.isBlank(registaToBeValidated.getNickName()) 
				|| registaToBeValidated.getSesso() == null
				|| registaToBeValidated.getDataDiNascita() == null
				|| registaToBeValidated.getId() == null) {
			return false;
		}
		return true;
	}
	
	public static Film createFilmFromParams(String titoloInputParam, String genereInputParam,
			String minutiDurataInputParam, String dataPubblicazioneStringParam, String registaIdStringParam) {

		Film result = new Film(titoloInputParam, genereInputParam);
		if (NumberUtils.isCreatable(minutiDurataInputParam)) {
			result.setMinutiDurata(Integer.parseInt(minutiDurataInputParam));
		}
		result.setDataPubblicazione(parseDateArrivoFromString(dataPubblicazioneStringParam));
		if (NumberUtils.isCreatable(registaIdStringParam)) {
			result.setRegista(new Regista(Long.parseLong(registaIdStringParam)));
		}
		return result;
	}

	public static boolean validateFilmBean(Film filmToBeValidated) {
		// prima controlliamo che non siano vuoti i parametri
		if (StringUtils.isBlank(filmToBeValidated.getTitolo())
				|| StringUtils.isBlank(filmToBeValidated.getGenere())
				|| filmToBeValidated.getMinutiDurata() == null 
				|| filmToBeValidated.getMinutiDurata() < 1
				|| filmToBeValidated.getDataPubblicazione() == null
				|| filmToBeValidated.getRegista() == null
				|| filmToBeValidated.getRegista().getId() == null 
				|| filmToBeValidated.getRegista().getId() < 1) {
			return false;
		}
		return true;
	}
	
	public static Film createFilmFromParams1(String titoloInputParam, String genereInputParam,
			String minutiDurataInputParam, String dataPubblicazioneStringParam, String registaIdStringParam, String idFilm) {

		Film result = new Film(titoloInputParam, genereInputParam);
		if(NumberUtils.isCreatable(idFilm)) {
			result.setId(Long.parseLong(idFilm));
		}
		
		if (NumberUtils.isCreatable(minutiDurataInputParam)) {
			result.setMinutiDurata(Integer.parseInt(minutiDurataInputParam));
		}
		result.setDataPubblicazione(parseDateArrivoFromString(dataPubblicazioneStringParam));
		if (NumberUtils.isCreatable(registaIdStringParam)) {
			result.setRegista(new Regista(Long.parseLong(registaIdStringParam)));
		}
		return result;
	}

	public static boolean validateFilmBean1(Film filmToBeValidated) {
		// prima controlliamo che non siano vuoti i parametri
		if (StringUtils.isBlank(filmToBeValidated.getTitolo())
				|| StringUtils.isBlank(filmToBeValidated.getGenere())
				|| filmToBeValidated.getMinutiDurata() == null 
				|| filmToBeValidated.getMinutiDurata() < 1
				|| filmToBeValidated.getDataPubblicazione() == null
				|| filmToBeValidated.getRegista() == null
				|| filmToBeValidated.getRegista().getId() == null 
				|| filmToBeValidated.getRegista().getId() < 1
				|| filmToBeValidated.getId() == null) {
			return false;
		}
		return true;
	}
	
	public static Utente createUtenteFromParams(String nomeInputParam, String cognomeInputParam,
			String userNameInputParam, String dataCreazioneStringParam) {

		Utente result = new Utente(nomeInputParam, cognomeInputParam, userNameInputParam);
		result.setDateCreated(parseDateArrivoFromString(dataCreazioneStringParam));
		return result;
	}

	public static boolean validateUtenteBean(Utente utenteToBeValidated) {
		// prima controlliamo che non siano vuoti i parametri
		if (StringUtils.isBlank(utenteToBeValidated.getNome()) 
				|| StringUtils.isBlank(utenteToBeValidated.getCognome())
				|| StringUtils.isBlank(utenteToBeValidated.getUsername())
				|| utenteToBeValidated.getDateCreated() == null) {
			return false;
		}
		return true;
	}
	
	public static Utente createUtenteFromParams(String nomeInputParam, String cognomeInputParam,
			String userNameInputParam, String passwordParam, Date dataCreazione) {

		Utente result = new Utente(nomeInputParam, cognomeInputParam, userNameInputParam, passwordParam, dataCreazione);
		return result;
	}

	public static Date parseDateArrivoFromString(String dataDiNascitaStringParam) {
		if (StringUtils.isBlank(dataDiNascitaStringParam))
			return null;

		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(dataDiNascitaStringParam);
		} catch (ParseException e) {
			return null;
		}
	}
}
