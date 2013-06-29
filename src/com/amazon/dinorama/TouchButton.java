package com.amazon.dinorama;

import android.content.res.Resources;
import android.graphics.BitmapFactory;

public class TouchButton extends DisplayableObject {
	
	public static int size = 128;
	
	public TouchButtonDirection type;
	
	protected boolean tapped = false;
	
	protected enum TouchButtonDirection {
		HI_ATK,
		LO_ATK,
		HI_BLK,
		LO_BLK,
		LEFT,
		RIGHT
	}

	public TouchButton(Resources res, int originX, int originY, TouchButtonDirection dir) {
		super(res, originX, originY);
		type = dir;
		setImage();
	}
	
	public boolean hit(double x, double y) {
		tapped = x >= originX && x <= originX+size && y >= originY && y <= originY+size;
		return tapped;
	}
	
	public void release() {
		tapped = false;
	}
	
	protected void setImage() {
		int image;
		if (!tapped)
			switch(type) {
			case HI_ATK: image = R.drawable.attackbuttonhigh; break;
			case LO_ATK: image = R.drawable.attackbuttonlow; break;
			case HI_BLK: image = R.drawable.arrow_hi; break;
			case LO_BLK: image = R.drawable.arrow_lo; break;
			case LEFT: image = R.drawable.directionbuttonleft; break;
			default: image = R.drawable.directionbuttonright;
			}
		else
			switch(type) {
			case HI_ATK: image = R.drawable.attackbuttonpressedhigh; break;
			case LO_ATK: image = R.drawable.attackbuttonpressedlow; break;
			case HI_BLK: image = R.drawable.arrow_hi; break;
			case LO_BLK: image = R.drawable.arrow_lo; break;
			case LEFT: image = R.drawable.directionbuttonpressedleft; break;
			default: image = R.drawable.directionbuttonpressedright;
			}
		setImageDisplayed(BitmapFactory.decodeResource(res, image));
	}
	
	@Override
	public void update() {
		setImage();
	}
	
	public String toString() {
		return type.name();
	}
}
