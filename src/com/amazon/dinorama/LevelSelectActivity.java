package com.amazon.dinorama;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class LevelSelectActivity extends Activity {
	
	String mode;
	int dinoNum;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.character_select_screen);
        Intent intent = getIntent();
        mode = intent.getStringExtra("game_mode");
        dinoNum = intent.getIntExtra("dinoNum", 1);
    
	}
	
	
}
