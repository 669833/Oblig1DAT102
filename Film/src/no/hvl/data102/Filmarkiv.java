package no.hvl.data102;

import no.hvl.data102.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {
	private int antall;
	private Film[] arkiv;

	public Filmarkiv(int n) {
		arkiv = new Film[n];
		antall = 0;
	}

	public Film finnFilm(int nr) {
		for (int i = 0; i < arkiv.length; i++) {
			if (arkiv[i].getFilmnr() == nr) {
				return arkiv[i];
			}

		}
		return null;
	}

//	public int antallSjanger(Sjanger sjanger) {
//		int Sjangrer = 0;
//
//		for (int i = 0; i < antall; i++) {
//			if (sjanger == arkiv[i].getSjanger()) {
//				Sjangrer++;
//			}
//		}
//		return Sjangrer;
//	}

	private Film[] trimTab(Film[] tab, int n) {
		// n er antall elementer
		Film[] nytab = new Film[n];
		int i = 0;
		while (i < n) {
			nytab[i] = tab[i];
			i++;
		}
		return nytab;
	}

	private void utvid() {
		Film[] tab = new Film[antall * 2];
		for (int i = 0; i < arkiv.length; i++) {
			tab[i] = arkiv[i];
			arkiv = tab;
		}
	}

	public void leggTilFilm(Film nyFilm) {
		if (antall == arkiv.length) {
			utvid();
		} else {
			arkiv[antall] = nyFilm;
			antall++;
		}
	}

	public boolean slettFilm(int filmnr) {
		boolean funnet = false;
		boolean slettet = false;
		for (int i = 0; i < arkiv.length && !funnet; i++) {
			if (arkiv[i].getFilmnr() == filmnr) {
				arkiv[i] = arkiv[arkiv.length - 1];
				arkiv[arkiv.length - 1] = null;
				antall--;
				slettet = true;
				funnet = true;
			}

		}
		return slettet;

	}

	public Film[] soekTittel(String delstreng) {
		int index = 0;
		Film[] tittelfilm = new Film[antall];
		for (int i = 0; i < arkiv.length; i++) {
			if (arkiv[i].getTittel().toLowerCase().contains(delstreng)) {
				tittelfilm[index] = arkiv[i];
				index++;
			}
		}
		trimTab(tittelfilm, antall);
		return tittelfilm;
	}

	public Film[] soekProdusent(String delstreng) {
		int index = 0;
		Film[] produsentfilm = new Film[antall];
		for (int i = 0; i < arkiv.length; i++) {
			if (arkiv[i].getFilmskaper().toLowerCase().contains(delstreng)) {
				produsentfilm[index] = arkiv[i];
				index++;
			}
		}
		trimTab(produsentfilm, antall);
		return produsentfilm;

	}

	public int antall(Sjanger sjanger) {
		int antaller = 0;
		for (int i = 0; i < antall; i++) {
			if (arkiv[i].getSjanger()==sjanger) {
				antaller++;
			}
		}
		return antaller;
	}

	public int antall() {
		return antall;
	}

}
