package JogoExame;

import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;

public class Frame implements IFrame, IFramePlayer {

	private final static boolean RIGHT_TO_LEFT = false;
	public static String DIRETORIO = Frame.class.getResource(".").getPath();
	private static Tabuleiro tabuleiro;
	private static Carta c1[];
	private static Carta c2[];
	private static CartasJogador j1;
	private static CartasJogador j2;
	private static JButton[] buttonPontuacao;
	private static JButton[][] button;
	private static GridBagConstraints c[][];
	private static GridBagConstraints[] gridPontuacao;
	private  static GridBagConstraints C;
	private static int pontuacaoj1 = 0;
	private  static int pontuacaoj2 = 0;
	
	public Frame(){
		tabuleiro = new Tabuleiro();
		c1 = new Carta[6];
		c2 = new Carta[6];
		j1 = new CartasJogador(1);
		j2 = new CartasJogador(2);
		
		c1[0] = new Carta(7, 3, 4, 1, 0, 1);
		c1[1] = new Carta(3, 5, 5, 1, 1, 1);
		c1[2] = new Carta(2, 6, 3, 7, 2, 1);
		c1[3] = new Carta(4, 1, 6, 3, 3, 1);
		c1[4] = new Carta(2, 4, 1, 6, 4, 1);
		c1[5] = new Carta(5, 3, 3, 5, 5, 1);
		
		c2[0] = new Carta(6, 6, 2, 1, 0, 2);
		c2[1] = new Carta(2, 7, 5, 1, 1, 2);
		c2[2] = new Carta(5, 2, 7, 3, 2, 2);
		c2[3] = new Carta(3, 1, 5, 6, 3, 2);
		c2[4] = new Carta(4, 4, 3, 5, 4, 2);
		c2[5] = new Carta(6, 2, 1, 4, 5, 2);
		
		button = new JButton[3][3];
		c = new GridBagConstraints[3][3];
		buttonPontuacao = new JButton[2];
		gridPontuacao = new GridBagConstraints[2];
		
		j1.adicionaCartas(c1);
		j2.adicionaCartas(c2);
		
	}
	
	public void createFrame() {

        JFrame frame = new JFrame("Tabuleiro");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JFrame carta1 = new JFrame("Cartas");
        carta1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JFrame carta2 = new JFrame("Cartas");
        carta2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        FrameTabuleiro(frame.getContentPane(), frame);
        FrameCartas(carta1.getContentPane(), carta1, 1);
        FrameCartas(carta2.getContentPane(), carta2, 2);
   
        frame.pack();
        frame.setVisible(true);
        
        carta1.pack();
        carta1.setVisible(true);
        
        carta2.pack();
        carta2.setVisible(true);
      
    }

	public void FrameTabuleiro(Container pane, JFrame frame) {
        int i, j;
    	
        C = new GridBagConstraints();
        
        if (RIGHT_TO_LEFT) {
            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }

        Icon icon = new ImageIcon("/C:/Users/gabri/eclipse-workspace/Jogo - exame/bin/Jogo/" + "cartaVazia.PNG");
        
        pane.setLayout(new GridBagLayout());
    	
    	for(i=0; i<3; i++) {  		
    		for(j=0; j<3; j++) {
    			c[i][j] = new GridBagConstraints();
    			button[i][j] = new JButton(icon);    	
    	        c[i][j].weightx = 0;	
    	    	c[i][j].fill = GridBagConstraints.HORIZONTAL;
    	    	c[i][j].ipady = 0;
    	    	c[i][j].gridx = j;
    	    	c[i][j].gridy = i;
    	    	pane.add(button[i][j], c[i][j]);    	
    		}
    	}
	
	C.fill = GridBagConstraints.HORIZONTAL;
	C.weightx = 0;
	C.ipady = 12;
	C.gridwidth = 3;
	C.gridx = 0;
	C.gridy = 3;
	pane.add(new JSeparator(JSeparator.HORIZONTAL) ,C);
	
	buttonPontuacao[0] = new JButton("Pontuacao Jogador 1 " + ":  " + pontuacaoj1);
	gridPontuacao[0] = new GridBagConstraints();
	gridPontuacao[0].fill = GridBagConstraints.HORIZONTAL;
	gridPontuacao[0].weightx = 0.0;
	gridPontuacao[0].ipady = 15;
	gridPontuacao[0].gridwidth = 3;
	gridPontuacao[0].gridx = 0;
	gridPontuacao[0].gridy = 4;
	pane.add(buttonPontuacao[0], gridPontuacao[0]);
	
	C.fill = GridBagConstraints.HORIZONTAL;
	C.weightx = 0;
	C.ipady = 2;
	C.gridwidth = 6;
	C.gridx = 0;
	C.gridy = 5;
	pane.add(new JSeparator(JSeparator.HORIZONTAL) ,C);
	
	buttonPontuacao[1] = new JButton("Pontuacao Jogador 2 " + ":  " + pontuacaoj2);
	gridPontuacao[1] = new GridBagConstraints();
	gridPontuacao[1].fill = GridBagConstraints.HORIZONTAL;
	gridPontuacao[1].weightx = 0.0;
	gridPontuacao[1].ipady = 15;
	gridPontuacao[1].gridwidth = 3;
	gridPontuacao[1].gridx = 0;
	gridPontuacao[1].gridy = 6;
	pane.add(buttonPontuacao[1], gridPontuacao[1]);
	
	for(i=0; i<3; i++) {
		for(j=0; j<3; j++) {
			@SuppressWarnings("deprecation")
			final Integer inneri = new Integer(i);
			@SuppressWarnings("deprecation")
			final Integer innerj = new Integer(j);
			button[i][j].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		        	
		        	inserecartaTabuleiro(pane, inneri, innerj);        	
		            SwingUtilities.updateComponentTreeUI(frame);
		        }
			});
		}
	}
		
	}
	
	public void inserecartaTabuleiro(Container pane, int x, int y) {
		if(j1.getCartaSelecionada() >= 0) {
			Icon icon = new ImageIcon(DIRETORIO + "j" + j1.getnumJogador() + "carta" + (j1.getCartaSelecionada() + 1) + ".PNG");
			pane.remove(button[x][y]);    	
			button[x][y] = new JButton(icon);   	
	    	pane.add(button[x][y], c[x][y]);
	    	tabuleiro.insereCarta(j1.getCarta(j1.getCartaSelecionada()), x, y);
			j1.cartaSelecionada(-1);
			j1.alternaTurno();
			j2.alternaTurno();
			Pontuacao(pane, 0, 1);
			comparaCartas(pane, x, y);
		}
		if(j2.getCartaSelecionada() >= 0) {
			Icon icon = new ImageIcon(DIRETORIO + "j" + j2.getnumJogador() + "carta" + (j2.getCartaSelecionada() + 1) + ".PNG");
			pane.remove(button[x][y]);	    	
			button[x][y] = new JButton(icon);   	
	    	pane.add(button[x][y], c[x][y]);
	    	tabuleiro.insereCarta(j2.getCarta(j2.getCartaSelecionada()), x, y);
			j2.cartaSelecionada(-1);
			j1.alternaTurno();
			j2.alternaTurno();
			Pontuacao(pane, 0, 2);
			comparaCartas(pane, x, y);
		}
	}
	
	
	public void comparaCartas(Container pane, int x, int y) {
		Icon icon;
		if(tabuleiro.comparaCelulas(x, y, "top")) {
			if(tabuleiro.getCapturada(x-1, y)) {
				icon = new ImageIcon(DIRETORIO + "j" + tabuleiro.getPertence(x-1, y) + "carta" + (tabuleiro.getNumCarta(x-1, y) + 1) + ".PNG");
			}else {
				icon = new ImageIcon(DIRETORIO + "j" + tabuleiro.getPertence(x-1, y) + "carta" + (tabuleiro.getNumCarta(x-1, y) + 1) + "capt" + ".PNG");
			}
			pane.remove(button[x-1][y]);	    	
			button[x-1][y] = new JButton(icon);   	
	    	pane.add(button[x-1][y], c[x-1][y]);
	    	tabuleiro.capturada(x-1, y);
	    	tabuleiro.alteraAtribuido(x-1, y);
	    	Pontuacao(pane, 1, tabuleiro.getPertence(x, y));
		}
		if(tabuleiro.comparaCelulas(x, y, "bot")) {
			if(tabuleiro.getCapturada(x+1, y)) {
				icon = new ImageIcon(DIRETORIO + "j" + tabuleiro.getPertence(x+1, y) + "carta" + (tabuleiro.getNumCarta(x+1, y) + 1) + ".PNG");
			}else {
			    icon = new ImageIcon(DIRETORIO + "j" + tabuleiro.getPertence(x+1, y) + "carta" + (tabuleiro.getNumCarta(x+1, y) + 1) + "capt" + ".PNG");
			}
			pane.remove(button[x+1][y]);	    	
			button[x+1][y] = new JButton(icon);   	
	    	pane.add(button[x+1][y], c[x+1][y]);
	    	tabuleiro.capturada(x+1, y);
	    	tabuleiro.alteraAtribuido(x+1, y);
	    	Pontuacao(pane, 1, tabuleiro.getPertence(x, y));
		}
		if(tabuleiro.comparaCelulas(x, y, "left")) {
			if(tabuleiro.getCapturada(x, y-1)) {
				icon = new ImageIcon(DIRETORIO + "j" + tabuleiro.getPertence(x, y-1) + "carta" + (tabuleiro.getNumCarta(x, y-1) + 1) + ".PNG");
			}else {
			    icon = new ImageIcon(DIRETORIO + "j" + tabuleiro.getPertence(x, y-1) + "carta" + (tabuleiro.getNumCarta(x, y-1) + 1) + "capt" + ".PNG");
			}
			pane.remove(button[x][y-1]);	    	
			button[x][y-1] = new JButton(icon);   	
	    	pane.add(button[x][y-1], c[x][y-1]);
	    	tabuleiro.capturada(x, y-1);
	    	tabuleiro.alteraAtribuido(x, y-1);
	    	Pontuacao(pane, 1, tabuleiro.getPertence(x, y));
		}
		if(tabuleiro.comparaCelulas(x, y, "right")) {
			if(tabuleiro.getCapturada(x, y+1)) {
				icon = new ImageIcon(DIRETORIO + "j" + tabuleiro.getPertence(x, y+1) + "carta" + (tabuleiro.getNumCarta(x, y+1) + 1) + ".PNG");
			}else {
			    icon = new ImageIcon(DIRETORIO + "j" + tabuleiro.getPertence(x, y+1) + "carta" + (tabuleiro.getNumCarta(x, y+1) + 1) + "capt" + ".PNG");
			}
			pane.remove(button[x][y+1]);	    	
			button[x][y+1] = new JButton(icon);   	
	    	pane.add(button[x][y+1], c[x][y+1]);
	    	tabuleiro.capturada(x, y+1);
	    	tabuleiro.alteraAtribuido(x, y+1);
	    	Pontuacao(pane, 1, tabuleiro.getPertence(x, y));
		}
	}
	
	public void Pontuacao(Container pane, int tipoPontuacao, int jogador) {
		if(tipoPontuacao == 0) {
			if(jogador == 1) {
				pontuacaoj1++;
			}else {
				pontuacaoj2++;
			}
		}
		if(tipoPontuacao == 1) {
			if(jogador == 1) {
				pontuacaoj1++;
				pontuacaoj2--;
			}else {
				pontuacaoj2++;
				pontuacaoj1--;
			}
		}
		
		pane.remove(buttonPontuacao[0]);
		buttonPontuacao[0] = new JButton("Pontuacao Jogador 1 " + ": " + pontuacaoj1);
		pane.add(buttonPontuacao[0], gridPontuacao[0]);
		
		pane.remove(buttonPontuacao[1]);
		buttonPontuacao[1] = new JButton("Pontuacao Jogador 2 " + ": " + pontuacaoj2);
		pane.add(buttonPontuacao[1], gridPontuacao[1]);
	}
	
	
    public void FrameCartas(Container pane, JFrame frame, int jogador) {
    	
    	int i, j;
    	
        if (RIGHT_TO_LEFT) {
            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }

        JButton buttonJogador;
        JButton button[] = new JButton[6]; 
        Icon icon[] = new Icon[6];
        
        for(i=0; i<6; i++) {
          j = i+1;
          icon[i] = new ImageIcon(DIRETORIO + "j" + jogador + "carta" + j + ".PNG");
        }
        
        pane.setLayout(new GridBagLayout());
    	GridBagConstraints c[] = new GridBagConstraints[9];
    	for(i=0; i<6; i++) {
    		c[i] = new GridBagConstraints();
    	}
    	GridBagConstraints C = new GridBagConstraints();
	
	    for(i=0; i<6; i++) {
		
		button[i] = new JButton(icon[i]);
		c[i].fill = GridBagConstraints.HORIZONTAL;
		c[i].ipady = 0;
		c[i].weightx = 0;
		c[i].gridx = i;
		c[i].gridy = 2;
		pane.add(button[i], c[i]);
		
	    }
	
	buttonJogador = new JButton("Cartas Jogador " + jogador);
	C.fill = GridBagConstraints.HORIZONTAL;
	C.weightx = 0;
	C.ipady = 4;
	C.gridwidth = 6;
	C.gridx = 0;
	C.gridy = 0;
	pane.add(buttonJogador, C);
	
	C.fill = GridBagConstraints.HORIZONTAL;
	C.weightx = 0;
	C.ipady = 2;
	C.gridwidth = 6;
	C.gridx = 0;
	C.gridy = 1;
	pane.add(new JSeparator(JSeparator.HORIZONTAL) ,C);
		
	for(i=0; i<6; i++) {
		@SuppressWarnings("deprecation")
		final Integer inneri = new Integer(i);
		button[i].addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	if(jogador == 1) {
	        	try {
					selecionaCartaJ1(inneri);
				} catch (JogoException1 e1) {
					System.out.println("n eh seu turno, turno do jogador 2");
					e1.printStackTrace();
				}catch (JogoException2 e2) {
					System.out.println("Carta ja foi usada");
					e2.printStackTrace();
				}
	        	}
	        	if(jogador == 2) {
	        	try {
					selecionaCartaJ2(inneri);
				} catch (JogoException1 e1) {
					System.out.println("N eh seu turno, turno do jogador 1");
					e1.printStackTrace();
				} catch (JogoException2 e2) {
					System.out.println("Carta ja foi usada");
					e2.printStackTrace();
				}
	        	}
	        	SwingUtilities.updateComponentTreeUI(frame);
	        }
	    });
	}
	
    }
    
    public void selecionaCartaJ1(int num) throws JogoException1, JogoException2 {
    	if(j1.getTurno()) {
    		if(!j1.getUsada(num)) {
    			j1.cartaSelecionada(num);
    			j1.usada(num);
    		}else {
    			throw new JogoException2();
    		}
    	}else {
    		throw new JogoException1();
    	}
    }
    
    public void selecionaCartaJ2(int num) throws JogoException1, JogoException2{
    	if(j2.getTurno()) {
    		    if(!j2.getUsada(num)) {
    			   j2.cartaSelecionada(num);
    			   j2.usada(num);
    		    }else {
        			throw new JogoException2();
        		}
    		
    	}else {
    		throw new JogoException1();
    	}
    }

}
