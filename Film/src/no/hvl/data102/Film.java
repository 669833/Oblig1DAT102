package no.hvl.data102;

import java.util.Objects;

public class Film {
	private int filmnr;
	private String filmskaper;
	private String tittel;
	private int år;
	private Sjanger sjanger;
	private String filmselsskap;

	public Film() {

	}

	public Film(int filmnr, String filmskaper, String tittel, int år, String filmselsskap, Sjanger sjanger) {
		this.filmnr = filmnr;
		this.filmselsskap = filmskaper;
		this.tittel = tittel;
		this.år = år;
		this.filmselsskap = filmselsskap;
		this.sjanger = sjanger;

	}

	public int getFilmnr() {
		return filmnr;
	}

	public void setFilmnr(int filmnr) {
		this.filmnr = filmnr;
	}

	public String getFilmskaper() {
		return filmskaper;
	}

	public void setFilmskaper(String filmskaper) {
		this.filmskaper = filmskaper;
	}

	public String getTittel() {
		return tittel;
	}

	public void setTittel(String tittel) {
		this.tittel = tittel;
	}

	public int getÅr() {
		return år;
	}

	public void setÅr(int år) {
		this.år = år;
	}

	public String getFilmselsskap() {
		return filmselsskap;
	}

	public void setFilmselsskap(String filmselsskap) {
		this.filmselsskap = filmselsskap;
	}

	public Sjanger getSjanger() {
		return sjanger;
	}

	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}

	@Override
	public int hashCode() {
		return Objects.hash(filmnr);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return filmnr == other.filmnr;
	}
	@Override
	public String toString() {
		return "Filmnr " + filmnr +" filmskaper "+ filmskaper +" Tittel "+ tittel+ " r " +år +" Sjanger " +sjanger +" Filmselskap "+ filmselsskap;	}

}
