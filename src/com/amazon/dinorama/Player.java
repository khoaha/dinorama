package com.amazon.dinorama;

public class Player {
	private int health = 100;
	private int dinoType = 0;
	
	private boolean facingRight = true;
	private double xPosition;
	private double yPosition;
	
	private final long speed = 5;
	
	public Player(int dinoType, 
				boolean facingRight,
				double xPosition,
				double yPosition){
		this.facingRight = facingRight;
		this.dinoType = dinoType;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
	}
	
	public void moveRight(double deltaTime){
		xPosition += speed*deltaTime;
	}
	
	public void moveLeft(double deltaTime){
		xPosition -= speed*deltaTime;
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
