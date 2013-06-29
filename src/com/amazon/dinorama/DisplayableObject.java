package com.amazon.dinorama;

import android.content.res.Resources;
import android.graphics.Bitmap;

public class DisplayableObject {
	Bitmap imageDisplayed;
	int originX;
	int originY;
	Resources res;
	
	public DisplayableObject(Resources res, int originX, int originY){
		this.originX = originX;
		this.originY = originY;
	}
	
	public void setImageDisplayed(Bitmap bitmap){
		this.imageDisplayed = bitmap;
	}
	
	public Bitmap getImageDisplayed(){
		return imageDisplayed;
	}
	
	public int getX(){
		return originX;
	}
	
	public int getY(){
		return originY;
	}
	
	public void update(){}
}
