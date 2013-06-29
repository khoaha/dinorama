package com.amazon.dinorama;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Player extends DisplayableObject {
	//Images
	private HashMap<Integer, ArrayList<Bitmap>> playerImages;
	
	private void initImageMap(){
		playerImages = new HashMap<Integer, ArrayList<Bitmap>>();
		Bitmap idle, step1, step2, hA1, hA2, lA1, lA2, hB, lB;
		if(dinoType == 1){
			playerImages.put(Integer.valueOf(1), new ArrayList<Bitmap>());
			idle = BitmapFactory.decodeResource(res, R.drawable.stego_1);
			hA1 = BitmapFactory.decodeResource(res, R.drawable.stego_2);
			hA2 = BitmapFactory.decodeResource(res, R.drawable.stego_3);
			lA1 = BitmapFactory.decodeResource(res, R.drawable.stego_4);
			lA2 = BitmapFactory.decodeResource(res, R.drawable.stego_5);
			step1 = BitmapFactory.decodeResource(res, R.drawable.stego_6);
			step2 = BitmapFactory.decodeResource(res, R.drawable.stego_7);
			
			playerImages.get(dinoType).add(idle);
			playerImages.get(dinoType).add(hA1);
			playerImages.get(dinoType).add(hA2);
			playerImages.get(dinoType).add(lA1);
			playerImages.get(dinoType).add(lA2);
			playerImages.get(dinoType).add(step1);
			playerImages.get(dinoType).add(step2);
			
			//Add Blocking
		}
		
	}
	
	//Constants
	private final int speed = 5;
	
	//Stats
	private int dinoType = 1;
	private int health = 100;

	//State
	private PlayerState currentState = PlayerState.IDLE;
	private int stateCounter = 0;
	
	public Player(int dinoType, Resources res, int originX, int originY){
		super(res, originX, originY);
		this.dinoType = dinoType;
		initImageMap();
	}
	
	
	private void idle(){
		ArrayList<Bitmap> images = playerImages.get(dinoType);
		setImageDisplayed(images.get(1));
		stateCounter = 0;
	}
	
	private void step(){
		ArrayList<Bitmap> images = playerImages.get(dinoType);
		
		if(stateCounter == 0){
			setImageDisplayed(images.get(5));
		}else if(stateCounter == 10){
			setImageDisplayed(images.get(6));
		}else if(stateCounter == 20){
			stateCounter = 0;
			currentState = PlayerState.IDLE;
		}
	}
	
	private void movementRight(){
		step();
		originX += speed;
	}
	private void movementLeft(){
		step();
		originY -= speed;
	}
	
	public void update(){
		stateCounter++;
		if(currentState == PlayerState.IDLE){
			idle();
		}else if(currentState == PlayerState.MOVERIGHT){
			movementRight();
		}else if(currentState == PlayerState.MOVELEFT){
			movementLeft();
		}else if(currentState == PlayerState.HIGHATTACK){
			
		}else if(currentState == PlayerState.LOWATTACK){
			
		}else if(currentState == PlayerState.LOWBLOCK){
			
		}else if(currentState == PlayerState.HIGHBLOCK){
			
		}
	}	
	
	public void moveRight(){
		currentState = PlayerState.MOVERIGHT;
	}
	
	public void moveLeft(){
		currentState = PlayerState.MOVELEFT;
	}
	
	
	//hitting buttons changes state and resolves state conflicts
	

}
