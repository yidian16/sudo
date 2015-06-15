package com.example.helloword;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

public class Tabledialog extends Dialog {
	
	private int [] used =new int [9];
	private GameView Gmv ;
	private View keyLis[] =new View [9] ; 

	public Tabledialog(Context context,int [] used,GameView Gmv) {
		super(context);
		this.used =used;
		this.Gmv =Gmv;
		
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		
		setContentView(R.layout.tableview);
		GetView();
		
		setLis();
		
		for(int i=0;i<used.length;i++){
			
			if(used[i]!=0){
				keyLis[used[i]-1].setVisibility(View.INVISIBLE);
			}
			
		}
		
		//if(used.length!=0)
		   
		
		//
	}
	
	
	private void GetView(){
		keyLis[0] = findViewById(R.id.button1);
		keyLis[1] = findViewById(R.id.button2);
		keyLis[2] = findViewById(R.id.button3);
		keyLis[3] = findViewById(R.id.button4);
		keyLis[4] = findViewById(R.id.button5);
		keyLis[5] = findViewById(R.id.button6);
		keyLis[6] = findViewById(R.id.button7);
		keyLis[7] = findViewById(R.id.button8);
		keyLis[8] = findViewById(R.id.button9);
		
	}
	
	private void setLis(){
		for(int  i=0;i<9;i++){
			final int   t = i+1;
			keyLis[i].setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					System.out.println("setOnClickListener调用了setLis函数"+t);
					// TODO Auto-generated method stub
					Gmv.returnNum(t);
					dismiss();
					
				}
			});
		}
	}
	

}
