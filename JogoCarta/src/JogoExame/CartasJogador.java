package JogoExame;

public class CartasJogador implements ICartasJogador {

	private Carta cartasJogador[];
	private boolean meuTurno;
	private int cartaSelecionada = -1;
	private int numJogador;
	
	CartasJogador(int numJogador){
		this.numJogador = numJogador;
		cartasJogador = new Carta[6];
		
		if(numJogador == 1) {
			meuTurno = true;
		}else {
			meuTurno = false;
		}
	}
	
	public int getnumJogador() {
		return numJogador;
	}
	
	public void adicionaCartas(Carta carta[]) {
		cartasJogador = carta;	
	}
	
	public void alternaTurno() {
		if(meuTurno) {
			meuTurno = false;
		}else {
			meuTurno = true;
		}
	}
	
	public Carta getCarta(int n) {
		return cartasJogador[n];
	}
	
	public void usada(int num) {
		cartasJogador[num].usada();
	}
	
	public boolean getUsada(int num) {
		return cartasJogador[num].getUsada();
	}
	
	public boolean getTurno() {
		return meuTurno;
	}
	
	public void cartaSelecionada(int numCarta) {
		this.cartaSelecionada = numCarta;
	}
	
	public int getCartaSelecionada() {
		return cartaSelecionada;
	}

}
