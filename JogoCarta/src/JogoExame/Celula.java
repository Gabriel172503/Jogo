package JogoExame;

public class Celula implements ICelula {

	private Carta c;
	private boolean temCarta = false;
	
	public int getValor(String s) {
		return c.getValor(s);
	}
	
	public void insereCarta(Carta C) {
		this.c = C;
		this.temCarta = true;
	}
	
	public Carta getCarta() {
		return c;
	}
	
	public boolean comparaValor(Celula b, String c1, String c2) {
		return c.comparaValores(b.getCarta(), c1, c2);
	}
			
	public boolean getTemCarta() {
		return temCarta;
	}
	
	public int getNumCarta() {
		return c.getNumCarta();
	}
	
	public void alteraAtribuido() {
		c.alteraAtribuido();
	}
	
	public int getAtribuido() {
		return c.getAtribuido();
	}
	
	public int getPertence() {
		return c.getPertence();
	}
	
	public void capturada() {
		c.capturada();
	}
	
	public boolean getCapturada() {
		return c.getCapturada();
	}
}
