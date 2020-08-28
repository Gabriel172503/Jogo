package JogoExame;

import java.awt.Container;

public interface IFramePlayer {

	public void inserecartaTabuleiro(Container pane, int x, int y);
	public void comparaCartas(Container pane, int x, int y);
	public void Pontuacao(Container pane, int tipoPontuacao, int jogador);
	public void selecionaCartaJ1(int num) throws JogoException1, JogoException2;
	public void selecionaCartaJ2(int num) throws JogoException1, JogoException2;
}
