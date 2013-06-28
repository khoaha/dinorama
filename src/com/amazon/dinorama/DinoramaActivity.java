package com.amazon.dinorama;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DinoramaActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
    }
    
    public void pickArcadeMode(View view){
    	Intent myIntent = new Intent(DinoramaActivity.this, CharacterSelectActivity.class);
    	myIntent.putExtra("game_mode", "arcade"); //Optional parameters
    	DinoramaActivity.this.startActivity(myIntent);
    }
    
    public void pickCampaignMode(View view){
    	Intent myIntent = new Intent(DinoramaActivity.this, CharacterSelectActivity.class);
    	myIntent.putExtra("game_mode", "campaign"); //Optional parameters
    	DinoramaActivity.this.startActivity(myIntent);
    }
}