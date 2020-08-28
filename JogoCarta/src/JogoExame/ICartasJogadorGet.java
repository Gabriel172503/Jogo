package JogoExame;

public interface ICartasJogadorGet {
	
	public int getnumJogador();
	public Carta getCarta(int n);
	public void usada(int num);
	public boolean getTurno();
	public void cartaSelecionada(int numCarta) ;
}
