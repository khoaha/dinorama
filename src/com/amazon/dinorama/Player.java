package com.amazon.dinorama;

public class Player {
	private int health = 100;
	private int dinoType = 0;
	
	private boolean facingRight = true;
	private long xPosition;
	private long yPosition;
	
	private final long speed = 5;
	
	public Player(int dinoType, 
				boolean facingRight,
				long xPosition,
				long yPosition){
		this.facingRight = facingRight;
		this.dinoType = dinoType;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
	}
	
	public void moveRight(){
		xPosition += speed;
	}
	
	public void moveLeft(){
		xPosition -= speed;
	}
	
	public void flipPlayer(){
		facingRight = false;
	}
	
	public PlayerActions attackHigh(){
		return PlayerActions.HIGHATTACK;
	}
	
	public PlayerActions attackLow(){
		return PlayerActions.LOWATTACK;
	}
	
	public PlayerActions blockHigh(){
		return PlayerActions.HIGHBLOCK;
	}
	
	public PlayerActions blockLow(){
		return PlayerActions.LOWBLOCK;
	}
}
