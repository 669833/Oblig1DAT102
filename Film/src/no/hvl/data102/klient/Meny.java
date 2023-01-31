package no.hvl.data102.klient;

import no.hvl.data102.Film;
import no.hvl.data102.Sjanger;
import no.hvl.data102.adt.FilmarkivADT;
import no.hvl.data102.Filmarkiv;
import no.hvl.data102.klient.*;

public class Meny {
	private Tekstgrensesnitt tekstgr;
	private FilmarkivADT filmarkiv;

	public Meny(FilmarkivADT filmarkiv) {
		tekstgr = new Tekstgrensesnitt();
		this.filmarkiv = filmarkiv;
	}

	public void start() {

		Film fanta = new Film(1, "George", "Nyestetittel", 1991, "Selskap", Sjanger.ACTION);
		Film fanta2 = new Film(2, "Lucas", "Verstedagen", 1831, "Selskap", Sjanger.HISTORY);
		Film fanta3 = new Film(3, "Jenny", "Bestedagen", 2001, "Selskap", Sjanger.SCIFI);
		Film fanta4 = new Film(4, "Olav", "Kontanto", 1453, "Selskap", Sjanger.ACTION);
		Film fanta5 = new Film(5, "Olav", "Overalt", 1600, "Selskap", Sjanger.DRAMA);
		Film fanta6 = new Film(6, "Targeni", "Kuensherre", 1800, "Selskap", Sjanger.SCIFI);
		filmarkiv.leggTilFilm(fanta);
		filmarkiv.leggTilFilm(fanta2);
		filmarkiv.leggTilFilm(fanta3);
		filmarkiv.leggTilFilm(fanta4);
		filmarkiv.leggTilFilm(fanta5);
		filmarkiv.leggTilFilm(fanta6);
		tekstgr.skrivUtStatistikk(filmarkiv);
		Film brukerfilm = tekstgr.lesFilm();
		filmarkiv.leggTilFilm(brukerfilm);
		tekstgr.skrivUtStatistikk(filmarkiv);
		tekstgr.visFilm(brukerfilm);
	}
}
