package com.amazon.dinorama;

public class GlobalVariables {

	public static int playerHealth = 100;
	public static int AIHealth = 100;
	
	public static int healthBarX = 25;
	public static int healthBarY = 20;
	
	public static int getPlayerHealth(){
		return playerHealth;
	}
	public static int getAIHealth(){
		return AIHealth;
	}
	
	public static void setPlayerHealth(int health){
		playerHealth = health;
	}
	public static void setAIHealth(int health){
		AIHealth = health;
	}
	
	public static int getHealthBarX(){
		return healthBarX;
	}
	public static int getHealthBarY(){
		return healthBarY;
	}}
