package com.amazon.dinorama;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class CharacterSelectActivity extends Activity {
	
	MediaPlayer song;
	String mode = "default";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.character_select_screen);
        Intent intent = getIntent();
        mode = intent.getStringExtra("game_mode");
        
        song = MediaPlayer.create(CharacterSelectActivity.this, R.raw.character_select);
        song.setLooping(true);
        song.start();
	}
	
	public void pickedDinoOne(View view){
		Intent myIntent = new Intent(CharacterSelectActivity.this, LevelSelectActivity.class);
		myIntent.putExtra("game_mode", mode);
    	myIntent.putExtra("dinoNum", 1); //Optional parameters
    	song.stop();
    	CharacterSelectActivity.this.startActivity(myIntent);
	}
	
	public void pickedDinoTwo(View view){
		Intent myIntent = new Intent(CharacterSelectActivity.this, LevelSelectActivity.class);
		myIntent.putExtra("game_mode", mode);
    	myIntent.putExtra("dinoNum", 2); //Optional parameters
    	song.stop();
    	CharacterSelectActivity.this.startActivity(myIntent);
	}
	
	public void pickedDinoThree(View view){
		Intent myIntent = new Intent(CharacterSelectActivity.this, LevelSelectActivity.class);
		myIntent.putExtra("game_mode", mode);
    	myIntent.putExtra("dinoNum", 3); //Optional parameters
    	song.stop();
    	CharacterSelectActivity.this.startActivity(myIntent);
	}
	
	public void pickedDinoFour(View view){
		Intent myIntent = new Intent(CharacterSelectActivity.this, LevelSelectActivity.class);
		myIntent.putExtra("game_mode", mode);
    	myIntent.putExtra("dinoNum", 4); //Optional parameters
    	song.stop();
    	CharacterSelectActivity.this.startActivity(myIntent);
	}

}
