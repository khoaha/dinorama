package com.amazon.dinorama;

import android.app.Activity;
import android.os.Bundle;

public class GameActivity extends Activity {
	
	protected GameView gameView;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameView = new GameView(this);
        setContentView(gameView);
    }
    
    @Override
    protected void onPause() {
    	super.onPause();
    	gameView.activate(false);
    }
    
    @Override
    protected void onStart() {
    	super.onStart();
    	gameView.activate(true);
    }
    
    @Override
    protected void onResume() {
    	super.onResume();
    	gameView.activate(true);
    }
    
    @Override
    protected void onRestart() {
    	super.onRestart();
    	gameView.activate(true);
    }
}