package com.amazon.dinorama;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

public class LevelSelectActivity extends Activity {
	
	private static final int RESULT_LOAD_IMAGE = 100;
	
	String mode;
	int dinoNum;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_select_screen);
        Intent intent = getIntent();
        mode = intent.getStringExtra("game_mode");
        dinoNum = intent.getIntExtra("dinoNum", 1);

	}
	
	public void pickedLevelOne(View view){
		LevelBitmapWrapper.bitmap = scaleDownBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.background_1), 480); //change this to R.drawable.LEVEL_NAME
		Intent myIntent = new Intent(LevelSelectActivity.this, GameActivity.class);
		myIntent.putExtra("game_mode", mode);
		myIntent.putExtra("dinoNum", dinoNum);
    	LevelSelectActivity.this.startActivity(myIntent);
	}
	public void pickedLevelTwo(View view){
		LevelBitmapWrapper.bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.tempbg); //change this to R.drawable.LEVEL_NAME
		Intent myIntent = new Intent(LevelSelectActivity.this, GameActivity.class);
		myIntent.putExtra("game_mode", mode);
		myIntent.putExtra("dinoNum", dinoNum);
    	LevelSelectActivity.this.startActivity(myIntent);
	}
	public void pickedLevelThree(View view){
		LevelBitmapWrapper.bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.tempbg); //change this to R.drawable.LEVEL_NAME
		Intent myIntent = new Intent(LevelSelectActivity.this, GameActivity.class);
		myIntent.putExtra("game_mode", mode);
		myIntent.putExtra("dinoNum", dinoNum);
    	LevelSelectActivity.this.startActivity(myIntent);
	}
	public void pickedLevelFour(View view){
		LevelBitmapWrapper.bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.tempbg); //change this to R.drawable.LEVEL_NAME
		Intent myIntent = new Intent(LevelSelectActivity.this, GameActivity.class);
		myIntent.putExtra("game_mode", mode);
		myIntent.putExtra("dinoNum", dinoNum);
    	LevelSelectActivity.this.startActivity(myIntent);
	}
	public void pickedLevelFive(View view){
		LevelBitmapWrapper.bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.tempbg); //change this to R.drawable.LEVEL_NAME
		Intent myIntent = new Intent(LevelSelectActivity.this, GameActivity.class);
		myIntent.putExtra("game_mode", mode);
		myIntent.putExtra("dinoNum", dinoNum);
    	LevelSelectActivity.this.startActivity(myIntent);
	}

	
	public void getUserPhoto(View view){
		Intent i = new Intent( Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, RESULT_LOAD_IMAGE);  
	}
	
	@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
         
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
 
            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();
 
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
             
            ImageView imageView = (ImageView) findViewById(R.id.imgView);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
            
            LevelBitmapWrapper.bitmap = BitmapFactory.decodeFile(picturePath);
            
            Intent myIntent = new Intent(LevelSelectActivity.this, GameActivity.class);
    		myIntent.putExtra("game_mode", mode);
    		myIntent.putExtra("dinoNum", dinoNum);
        	LevelSelectActivity.this.startActivity(myIntent);
            
        }
     
     
    }
	
	public Bitmap scaleDownBitmap(Bitmap photo, int newHeight) {

		float densityMultiplier = this.getResources().getDisplayMetrics().density;        

		int h= (int) (newHeight*densityMultiplier);
		int w= (int) (h * photo.getWidth()/((double) photo.getHeight()));

		photo=Bitmap.createScaledBitmap(photo, w, h, true);

		return photo;
	}
	
}