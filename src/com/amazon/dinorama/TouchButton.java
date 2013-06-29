package com.amazon.dinorama;

import android.content.res.Resources;
import android.graphics.BitmapFactory;

public class TouchButton extends DisplayableObject {
	
	public static int size = 64;
	
	public TouchButtonDirection type;
	
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
		int image;
		switch(dir) {
		case HI_ATK: image = R.drawable.arrow_up;
		case LO_ATK: image = R.drawable.arrow_down;
		case HI_BLK: image = R.drawable.arrow_hi;
		case LO_BLK: image = R.drawable.arrow_lo;
		case LEFT: image = R.drawable.arrow_left;
		default: image = R.drawable.arrow_right;
		}
		setImageDisplayed(BitmapFactory.decodeResource(res, image));
	}
	
	public boolean hit(double x, double y) {
		return (x >= originX && x <= originX+size && y >= originY && y <= originY+size);
	}
	
}
