package JogoExame;

public interface ICartasJogadorSet {

	public void adicionaCartas(Carta carta[]);
	public void alternaTurno();
	public void cartaSelecionada(int numCarta);
	public boolean getUsada(int num);
}
