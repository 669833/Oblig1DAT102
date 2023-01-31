package no.hvl.data102.klient;

import java.util.Scanner;
import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.*;
import no.hvl.data102.Film;
import no.hvl.data102.Sjanger;
import no.hvl.data102.adt.FilmarkivADT;

public class Tekstgrensesnitt {

	// lese opplysningene om en FILM fra tastatur
	public Film lesFilm() {
		int filmnr = 0, år = 0;
		String filmskaper = "", tittel = "", filmselsskap = "";
		Sjanger sjanger = null;

		String txtfilmnr = showInputDialog("Skriv filmnr");
		filmnr = parseInt(txtfilmnr);

		String txtår = showInputDialog("Skriv året på filmen");
		år = parseInt(txtår);

		filmskaper = showInputDialog("Skriv filmskaper");

		tittel = showInputDialog("Skriv tittel");

		filmselsskap = showInputDialog("Skriv filmselsskap");
		int i=0;
		Sjanger tab[]= new Sjanger[5];
		for (Sjanger sjang : Sjanger.values()) {
			tab[i]=sjang;
			i++;
		}
		String sjang = showInputDialog(null,tab);
		sjang = sjang.toUpperCase();
		sjanger = Sjanger.finnSjanger(sjang);

		Film film = new Film(filmnr, filmskaper, tittel, år, filmselsskap, sjanger);
		return film;

	}

	// vise en film med alle opplysninger på skjerm (husk tekst for sjanger)
	public void visFilm(Film film) {
		System.out.println(film.toString());
	}

	// Skrive ut alle Filmer med en spesiell delstreng i tittelen
	public void skrivUtFilmDelstrengITittel(FilmarkivADT filma, String delstreng) {
		Film[] filmsamling = filma.soekTittel(delstreng);
		for (int i = 0; i < filma.antall(); i++) {
			if (filmsamling[i] != null) {
				System.out.println(filmsamling[i].getTittel());
			}
		}
	}

	// Skriver ut alle Filmer av en produsent / en gruppe
	public void skrivUtFilmProdusent(FilmarkivADT filma, String delstreng) {
		Film[] filmsamling = filma.soekTittel(delstreng);
		for (int i = 0; i < filma.antall(); i++) {
			if (filmsamling[i] != null) {
				System.out.println(filmsamling[i].getFilmskaper());
			}
		}
	}

	// Skrive ut en enkel statistikk som inneholder antall Filmer totalt
	// og hvor mange det er i hver sjanger
	public void skrivUtStatistikk(FilmarkivADT filma) {
		System.out.println("Antall cd-er totalt" + " "+filma.antall());
		for (Sjanger sjang : Sjanger.values()) {
			//Fikse sjang
			System.out.println("Antall " + sjang + " CD-er: " + filma.antall(sjang.finnSjanger(sjang.name())));
		}
	}
}