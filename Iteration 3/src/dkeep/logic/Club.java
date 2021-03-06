package dkeep.logic;

import java.util.Random;

public class Club {
	Random rand = new Random();
	private int x, y, prevX, prevY;
	private char Ch;
	
	public Club (int x, int y, char Ch){
		this.x = x;
		this.y = y;
		prevX = x;
		prevY = y;
		this.Ch = Ch;
		
	}
	
	public Club (int x, int y){ //construtor default
		this(x, y, '*');
	}
	
	public int getX() {return x;}
	
	public int getY() {return y;}
	
	public int getPrevX() {return prevX;}
	
	public int getPrevY() {return prevY;}
	
	public char getCh() {return Ch;}
	
	public void setX(int x) { this.x = x;}
	
	public void setY(int y) { this.y = y;}
	
	public void setPrevX(int x) { this.prevX = x;}
	
	public void setPrevY(int y) { this.prevY = y;}
	
	public void setCh (char Ch) { this.Ch = Ch; }
	
	public void move (MapLevel currentMap, int xOgre, int yOgre) {
		boolean possibleMove = false;
		do {
			int randomNum2 = rand.nextInt(4); // random entre [min, max] : int randomNum = rand.nextInt((max - min) + 1) + min;
			switch (randomNum2) {
			case 0: // Taco apontado para cima
				if ((currentMap.isAboveWall(xOgre, yOgre - 1)) || (currentMap.isOnTheDoor(xOgre, yOgre - 1))) {
					possibleMove = false;
				}else {
					prevX = x; prevY = y;
					x = xOgre; y = yOgre - 1;
					Ch = currentMap.isAboveKey(x, y) ? '$' : '*';
					possibleMove = true;
				}
				break;
			case 1: // Taco apontado para baixo
				if ((currentMap.isAboveWall(xOgre, yOgre + 1)) || (currentMap.isOnTheDoor(xOgre, yOgre + 1))) {
					possibleMove = false;
				} else {
					prevX = x; prevY = y;
					x = xOgre; y = yOgre + 1;
					Ch = currentMap.isAboveKey(x, y) ? '$' : '*';
					possibleMove = true;
				}
				break;
			case 2: // Taco apontado para a esquerda
				if ((currentMap.isAboveWall(xOgre - 1, yOgre)) || (currentMap.isOnTheDoor(xOgre - 1, yOgre))) {
					possibleMove = false;
				} else {
					prevX = x; prevY = y;
					x = xOgre - 1; y = yOgre;
					Ch = currentMap.isAboveKey(x, y) ? '$' : '*';
					possibleMove = true;
				}
				break;
			case 3: // Taco apontado para a direita
				if ((currentMap.isAboveWall(xOgre + 1, yOgre)) || (currentMap.isOnTheDoor(xOgre + 1, yOgre))) {
					possibleMove = false;
				}else {
					prevX = x; prevY = y;
					x = xOgre + 1; y = yOgre;
					Ch = currentMap.isAboveKey(x, y) ? '$' : '*';
					possibleMove = true;
				}
				break;
			}
		} while (!possibleMove);
	}
}