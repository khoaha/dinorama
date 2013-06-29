package com.amazon.dinorama;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GameOverActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over_screen);
	}
	
	public void initiateReplay(View view){
		//add code here that passes necessary information and initiates a GameActivity
	}
	
	public void initiateCharacterSelect(View view){
		Intent myIntent = new Intent(GameOverActivity.this, CharacterSelectActivity.class);
    	// add extra parameters to myIntent using myIntent.putExtra("game_mode", mode); for CharacterSelectActivity
    	GameOverActivity.this.startActivity(myIntent);
	}
	
	public void initiateLevelSelect(View view){
		Intent myIntent = new Intent(GameOverActivity.this, LevelSelectActivity.class);
    	// add extra parameters to myIntent using 
		// myIntent.putExtra("game_mode", mode); for CharacterSelectActivity and
		// myIntent.putExtra("dinoNum", INT);
    	GameOverActivity.this.startActivity(myIntent);
	}
	
	public void initiateMainMenu(View view){
		Intent myIntent = new Intent(GameOverActivity.this, DinoramaActivity.class);
    	GameOverActivity.this.startActivity(myIntent);
	}
	
}
