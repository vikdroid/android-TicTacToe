package com.vikram.tictactoe;

import java.util.Arrays;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class TicTacToe extends Activity implements View.OnClickListener{
	int count;
	int[][] win = {{1,2,3},{1,5,9},{1,4,7},{3,6,9},{4,5,6},{7,8,9},{3,5,7},{3,5,8}};
	int[] xarr = new int[5];
	int[] oarr = new int[5];
	int countx, counto;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tic_tac_toe);
		init();
	}
	
	private void init() {
		ImageButton ImgButton = (ImageButton)findViewById(R.id.btn1);
		ImgButton.setOnClickListener(this);
		ImgButton = (ImageButton)findViewById(R.id.btn2);
		ImgButton.setOnClickListener(this);
		ImgButton = (ImageButton)findViewById(R.id.btn3);
		ImgButton.setOnClickListener(this);
		ImgButton = (ImageButton)findViewById(R.id.btn4);
		ImgButton.setOnClickListener(this);
		ImgButton = (ImageButton)findViewById(R.id.btn5);
		ImgButton.setOnClickListener(this);
		ImgButton = (ImageButton)findViewById(R.id.btn6);
		ImgButton.setOnClickListener(this);
		ImgButton = (ImageButton)findViewById(R.id.btn7);
		ImgButton.setOnClickListener(this);
		ImgButton = (ImageButton)findViewById(R.id.btn8);
		ImgButton.setOnClickListener(this);
		ImgButton = (ImageButton)findViewById(R.id.btn9);
		ImgButton.setOnClickListener(this);
		
	}

	public void stop()
	{
		count=0;
    	countx=0;
    	counto=0;
    	ImageButton ImgButton = (ImageButton)findViewById(R.id.btn1);
		ImgButton.setClickable(false);
		ImgButton = (ImageButton)findViewById(R.id.btn2);
		ImgButton.setClickable(false);
		ImgButton = (ImageButton)findViewById(R.id.btn3);
		ImgButton.setClickable(false);
		ImgButton = (ImageButton)findViewById(R.id.btn4);
		ImgButton.setClickable(false);
		ImgButton = (ImageButton)findViewById(R.id.btn5);
		ImgButton.setClickable(false);
		ImgButton = (ImageButton)findViewById(R.id.btn6);
		ImgButton.setClickable(false);
		ImgButton = (ImageButton)findViewById(R.id.btn7);
		ImgButton.setClickable(false);
		ImgButton = (ImageButton)findViewById(R.id.btn8);
		ImgButton.setClickable(false);
		ImgButton = (ImageButton)findViewById(R.id.btn9);
		ImgButton.setClickable(false);
	}
	
	
	
		public void onClick(View v) {
			ImageButton b = (ImageButton) v;
			TextView tv = (TextView)findViewById(R.id.title);
			if(count%2==0){
				b.setBackgroundResource(R.drawable.x);
				xarr[countx] = Integer.parseInt((String)b.getTag());
				b.setClickable(false);
				tv.setText("Turn: Player2");
				count++;
				countx++;
				if(countx>=3) {
					for(int i=0; i<8; i++) {
						if(Arrays.toString(xarr).contains(String.valueOf(win[i][0]))&&Arrays.toString(xarr).contains(String.valueOf(win[i][1]))&&Arrays.toString(xarr).contains(String.valueOf(win[i][2]))) {
							stop();
							tv.setText("Player1: win!");
							
						}
					}
				}
			}
			else {
				b.setBackgroundResource(R.drawable.o);
				oarr[counto] = Integer.parseInt((String)b.getTag());
				b.setClickable(false);
				tv.setText("Turn: Player1");
				count++;
				counto++;
				if(counto>=3){
					for(int i=0; i<8; i++) {
						if(Arrays.toString(oarr).contains(String.valueOf(win[i][0]))&&Arrays.toString(oarr).contains(String.valueOf(win[i][1]))&&Arrays.toString(oarr).contains(String.valueOf(win[i][2]))) {
							stop();
							tv.setText("Palyer2: win!!");
						}
					}
				}
			}
		}
	
	

	public void close(View v){
		finish();
	}
	
	public void restart(View v) {
		setContentView(R.layout.activity_tic_tac_toe);
		init();
	}
}
