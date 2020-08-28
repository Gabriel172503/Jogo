package JogoExame;

public class Tabuleiro implements ITabuleiro {

private Celula tabuleiro[][];
	
	Tabuleiro(){
		int i, j;
		tabuleiro = new Celula[3][3];
		
		for(i=0; i<3; i++) {
			for(j=0; j<3; j++) {
				tabuleiro[i][j] = new Celula();
			}
		}
	}
	
	public void insereCarta(Carta c, int x, int y) {
		tabuleiro[x][y].insereCarta(c);
		//comparaCelulas(x, y);
	}
	
    public int getNumCarta(int x, int y) {
    	return tabuleiro[x][y].getNumCarta();
    }
    
    public boolean comparaAtribuido(Celula c, int x, int y) {
    	if(tabuleiro[x][y].getAtribuido() != c.getAtribuido()) {
    		return true;
    	}
    	return false;
    }
    
    public boolean getCapturada(int x, int y) {
    	return tabuleiro[x][y].getCapturada();
    }
    
    public int getAtribuido(int x, int y) {
    	return tabuleiro[x][y].getAtribuido();
    }
    
    public int getPertence(int x, int y) {
    	return tabuleiro[x][y].getPertence();
    }
    
    public void capturada(int x, int y) {
    	tabuleiro[x][y].capturada();
    }
    
    public void alteraAtribuido(int x, int y) {
    	tabuleiro[x][y].alteraAtribuido();
    }
	
	public boolean comparaCelulas(int x, int y, String s) {
		if(s == "top") {
			if(x != 0) {
				if(tabuleiro[x-1][y].getTemCarta() && comparaAtribuido(tabuleiro[x-1][y], x, y)) {	
					return tabuleiro[x][y].comparaValor(tabuleiro[x-1][y], "top", "bot");
				}
			}		
		    return false;		
		}
		if(s == "bot") {
			if(x != 2) {
				if(tabuleiro[x+1][y].getTemCarta() && comparaAtribuido(tabuleiro[x+1][y], x, y)) {	
					return tabuleiro[x][y].comparaValor(tabuleiro[x+1][y], "bot", "top");
				}
			}		
		    return false;		
		}
		if(s == "left") {
			if(y != 0) {
				if(tabuleiro[x][y-1].getTemCarta() && comparaAtribuido(tabuleiro[x][y-1], x, y)) {			
					return tabuleiro[x][y].comparaValor(tabuleiro[x][y-1], "left", "right");
				}
			}		
		    return false;		
		}
		if(s == "right") {
			if(y != 2) {
				if(tabuleiro[x][y+1].getTemCarta() && comparaAtribuido(tabuleiro[x][y+1], x, y)) {	
					return tabuleiro[x][y].comparaValor(tabuleiro[x][y+1], "right", "left");
				}
			}		
		    return false;		
		}
		return false;
	}

}
