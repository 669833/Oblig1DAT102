package no.hvl.data102;
import no.hvl.data102.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {
	private int antall;
	private LinearNode<Film> forste;
	
	public Filmarkiv2(){
		antall=0;
		forste=null;
	}
	@Override
	public Film finnFilm(int nr) {
		boolean funnet = false;
		LinearNode<Film> film =null;
		LinearNode<Film> aktuell=forste;
		for(int soek = 0; soek<antall && !funnet;soek++) {
			if(aktuell.getElement().equals(nr)) {
				funnet= true;
				film=aktuell;
			}else {
				aktuell=aktuell.getNeste();
			}
			
		}
		return film.getElement();
	}
	@Override
	public void leggTilFilm(Film nyfilm) {
		LinearNode<Film> nynode = new LinearNode<Film>(nyfilm);
		nynode.setNeste(forste);
		forste=nynode;
		antall++;
	}
	@Override
	public boolean slettFilm(int filmnr) {
		boolean slett=false;
		LinearNode<Film> aktuell = forste;
		for (int soek = 0; soek < antall; soek++) {
			if(aktuell.getElement().equals(finnFilm(filmnr))) {
				Film forsteEl=forste.getElement();
				aktuell.setElement( forsteEl);
				forste=forste.getNeste();
				antall--;
				slett=true;
			}else {
				aktuell.getNeste();
				
			}
		}
		return slett;
	}
	@Override
	public Film[] soekTittel(String delstreng) {
		int index=0;
		Film[] tittelfilm = new Film[antall];
		LinearNode<Film> aktuell = forste;
		for (int soek = 0; soek < antall; soek++) {
			if (aktuell.getElement().getTittel().equals(delstreng)) {
				tittelfilm[index]=aktuell.getElement();
				index++;
			} else {
				aktuell = aktuell.getNeste();
			}
		}
		trimTab(tittelfilm,index);
		return tittelfilm;
	
	}
	@Override
	public int antall(Sjanger sjanger) {
		int antsjanger=0;
		LinearNode<Film> aktuell = forste;
		for (int soek = 0; soek < antall; soek++) {
			if(aktuell.getElement().getSjanger().equals(sjanger)) {
				antsjanger++;
			}else {
				aktuell.getNeste();
			}
		}
		return antall;
	}
	@Override
	public int antall() {
		return antall;
	}
	@Override
	public Film[] soekProdusent(String delstreng) {
		int index=0;
		Film[] tab = new Film [antall];
		LinearNode<Film> aktuell = forste;
		for (int soek = 0; soek < antall; soek++) {
			if(aktuell.getElement().getFilmskaper().equals(delstreng)) {
				tab[index]=aktuell.getElement();
				index++;
			} else {
				aktuell.getNeste();
			}
		}
		trimTab(tab,index);
		return tab;
	}
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
}
