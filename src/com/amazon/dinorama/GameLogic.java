package com.amazon.dinorama;

public class GameLogic {
	private Player user;
	private Player ai;
	private int hitBoxDistance = 480 + 32;
	
	public GameLogic(Player user, Player ai){
		this.user = user;
		this.ai = ai;
	}
	
	//get scale x
	//deduct health
	public void userAttacks(){
		if(!ai.isAttacking()){
			int displacement = Math.abs(ai.getX() - ai.getY());
			if(displacement < hitBoxDistance){
				
			}
		}
	}
	
	public void aiAttacks(){
		
	}
	
	//flip
	//get origin
	
	
	
}
