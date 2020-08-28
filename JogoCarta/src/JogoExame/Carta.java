package JogoExame;

public class Carta implements ICarta {

	private boolean usada = false;
	private boolean selecionada = false;
	private boolean capturadaJoposto = false;
	private int top, bot, left, right;
	private int numCarta;
	private int atribuidoJogador;
	private int pertenceJogador;
	
	Carta(int top, int bot, int left, int right, int numCarta, int pertenceJogador) {
		this.top = top;
		this.bot = bot;
		this.left = left;
		this.right = right;
		this.numCarta = numCarta;
		this.atribuidoJogador = pertenceJogador;
		this.pertenceJogador = pertenceJogador;
	}
	
	public int getAtribuido() {
		return atribuidoJogador;
	}
	
	public void alteraAtribuido() {
		if(atribuidoJogador == 1) {
			this.atribuidoJogador = 2;
		}else {
			this.atribuidoJogador = 1;
		}
	}
	
	public int getPertence() {
		return pertenceJogador;
	}
	
	public void capturada() {
		if(capturadaJoposto) {
			this.capturadaJoposto = false;
		}else {
			this.capturadaJoposto = true;
		}
	}
	
	public boolean getCapturada() {
		return capturadaJoposto;
	}
	
	public void usada() {
		this.usada = true;
		this.selecionada = false;
	}
	
	public void selecionada() {
		this.selecionada = true;
	}
	
	public boolean getUsada() {
		return usada;
	}
	
	public boolean getSelecionada() {
		return selecionada;
	}
	
	public int getNumCarta() {
		return numCarta;
	}
	
	public boolean comparaValores(Carta b, String c1, String c2) {
		if(getValor(c1) > b.getValor(c2)) {
			return true;
		}
	return false;	
	}

	
	public int getValor(String s) {
		if(s == "top") {
			return top;
		}
		if(s == "bot") {
			return bot;
		}
		if(s == "left") {
			return left;
		}
		if(s == "right") {
			return right;
		}
		return 0;
	}
}
