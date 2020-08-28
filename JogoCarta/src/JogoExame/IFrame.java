package JogoExame;

import java.awt.Container;

import javax.swing.JFrame;

public interface IFrame {

	public void createFrame();
	public void FrameTabuleiro(Container pane, JFrame frame);
	public void FrameCartas(Container pane, JFrame frame, int jogador);
	
}