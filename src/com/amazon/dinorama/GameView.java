package com.amazon.dinorama;

import java.util.ArrayList;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
	private SurfaceHolder sh;
	private final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
	
	private Resources res;
	private GameThread thread;
	
	private Canvas canvas;
	
	private ArrayList<DisplayableObject> objects = new ArrayList<DisplayableObject>();
	private TouchButton[] buttons = new TouchButton[6];
	
	public GameView(Context context) {
		super(context);
		sh = getHolder();
		sh.addCallback(this);
		paint.setColor(Color.BLUE);
		paint.setStyle(Style.FILL);
		
		res = getResources();
		
		// adding the callback (this) to the surface holder to intercept events
		getHolder().addCallback(this);
		// make the GamePanel focusable so it can handle events
		setFocusable(true);
		
		// create the game loop thread
		thread = new GameThread(getHolder(), this);
	}
	
	public void createButtons() {
		objects.add(new TouchButton(res, 0, 0, TouchButton.TouchButtonDirection.LO_ATK));
		objects.add(new TouchButton(res, 64, 0, TouchButton.TouchButtonDirection.LO_BLK));
		objects.add(new TouchButton(res, 128, 0, TouchButton.TouchButtonDirection.RIGHT));
		objects.add(new TouchButton(res, 0, 64, TouchButton.TouchButtonDirection.HI_ATK));
		objects.add(new TouchButton(res, 64, 64, TouchButton.TouchButtonDirection.HI_BLK));
		objects.add(new TouchButton(res, 128, 64, TouchButton.TouchButtonDirection.LEFT));
	}
	
	public void init() {
		synchronized(objects) {
			for (int i=0; i<100; i++)
				objects.add(new TestItem(res, (int)(Math.random()*1280), (int)(Math.random()*800)));
		}
	}
	
	public void render(Canvas canvas) {
		// clear canvas
		canvas.drawColor(Color.BLACK);
		
		// draw everything
		synchronized(objects) {
			for (DisplayableObject o : objects)
				canvas.drawBitmap(o.getImageDisplayed(), o.getX(), o.getY(), new Paint());
		}
	}

	public void update() {
		// update everything
		synchronized(objects) {
		for (DisplayableObject o : objects)
			o.update();
		}
	}
	
	public void surfaceCreated(SurfaceHolder holder) {
		thread.setRunning(true);
		thread.start();
		init();
	}
	
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
	}
	
	public void surfaceDestroyed(SurfaceHolder holder) {
		boolean retry = true;
		while (retry) {
			try {
				thread.join();
				retry = false;
			} catch (InterruptedException e) {
				// try again shutting down the thread
			}
		}
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		double x = event.getX();
		double y = event.getY();
		return true;
	}
}
