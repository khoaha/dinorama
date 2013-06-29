package com.amazon.dinorama;

public class GameLogic {
	private Player user;
	private Player ai;
	private int hitBoxDistance = 480 + 32;
	
	public GameLogic(Player user, Player ai){
		this.user = user;
		this.ai = ai;
	}
	
	public void update(){
		userAttacks();
		aiAttacks();
		checkOrientation();
		
		System.out.println("AIH:"+GlobalVariables.AIHealth);
	}

	public void userAttacks(){
		if(user.isAttacking()){
			if(!ai.isAttacking()){
				int displacement = Math.abs(ai.getX() - user.getX());
				if(displacement < hitBoxDistance){
					GlobalVariables.AIHealth -= 10;
				}
			}
		}
	}
	
	public void aiAttacks(){
		if(ai.isAttacking()){
			if(!user.isAttacking()){
				int displacement = Math.abs(ai.getX() - user.getX());
				if(displacement < hitBoxDistance){
					GlobalVariables.playerHealth -= 10;
				}
			}
		}
	}
	
	//should be called on update
	public void checkOrientation(){
		if(user.getX() < ai.getX()){
			if(user.getScaleX() == -1){
				user.setXScale(1);
			}
			if(ai.getScaleX() == 1){
				ai.setXScale(-1);
			}
		}else{
			if(user.getScaleX() == 1){
				user.setXScale(-1);
			}
			if(ai.getScaleX() == -1){
				ai.setXScale(1);
			}
		}
	}
	
	
	
	
	
}
