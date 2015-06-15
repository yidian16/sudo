package com.example.helloword;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.view.MotionEvent;
import android.view.View;

public class GameView extends View {

	
	
	private float width ;
	private float height ;
	private int TouchX;
	private int TouchY;
	private GameData Gd =new GameData();
	
	private int [] getUsedNum = new int [9] ;
	
	
	
	

	public GameView(Context context) {
		super(context);
		//System.out.println("GameView调用了无参的构造函数");
		// TODO Auto-generated constructor stub
	}
    	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		
		//在ondraw时候 宽高已经确定
		
		width = getWidth()/9f;
	    height = getHeight()/9f;
		Paint drawPaintGroud = new Paint();
		Paint drawPaintLitte = new Paint();
		Paint drawPaintMiddle = new Paint();
		Paint drawPaintDeep = new Paint();
		drawPaintGroud.setColor(getResources().getColor(R.color.backgroud));
		//canvas.drawColor(getResources().getColor(R.color.backgroud));
		drawPaintLitte.setColor(getResources().getColor(R.color.litte));
		drawPaintMiddle.setColor(getResources().getColor(R.color.middle));
		drawPaintDeep.setColor(getResources().getColor(R.color.deep));
		
		canvas.drawRect(0, 0,getWidth(),getHeight(), drawPaintGroud);
		//画出9宫格
		for(int i=0;i<9;i++){
			//drawPaint.
    		canvas.drawLine(i*width, 0, i*width,getHeight(), drawPaintLitte);
    		canvas.drawLine(i*width+2, 0, i*width+2,getHeight(), drawPaintMiddle);
    		canvas.drawLine(0, i*height,getWidth(), i*height, drawPaintLitte);
    		canvas.drawLine(0, i*height+2,getWidth(), i*height+2, drawPaintMiddle);
    		
    	}
		for(int i=0;i<9;i++){
			if(i%3==0){
				canvas.drawLine(i*width, 0, i*width,getHeight(), drawPaintDeep);
				canvas.drawLine(0, i*height,getWidth(), i*height, drawPaintDeep);
			}
    	}
		// 显示数字
		Paint charPaint =new Paint();
		//canvas.drawText(text, index, count, x, y, paint);
		charPaint.setTextAlign(Paint.Align.CENTER);
		charPaint.setTextSize(height*0.75f);
		//charPaint.setColor(Color.BLACK);
		FontMetrics fm = charPaint.getFontMetrics();
		float frony = height/2-(fm.ascent+fm.descent)/2;
		float fronx = width/2;
		
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
				canvas.drawText(Gd.GetStrFromStr(i, j), i*width+fronx, j*height+frony, charPaint);
		}
		
		super.onDraw(canvas);
		
	
	}
	
	
	 public boolean onTouchEvent( MotionEvent event ){
		// TODO Auto-generated method stub
		if( event.getAction()!= MotionEvent.ACTION_DOWN )
			return super.onTouchEvent(event);
		
			
			// 获得点击坐标
			TouchX = (int)(event.getX()/width);
			TouchY = (int)(event.getY()/height);
			/*
		   for(int i:Gd.getUsedNum(TouchX,TouchY)){
			   System.out.println("usedNum"+i);
		   }*/
		   Tabledialog Td =new Tabledialog(getContext(), Gd.getUsedNum(TouchX,TouchY), this);
		   Td.show();
		   return true;
		
	}
	
	public void returnNum(int Num){
		if( Gd.refreshStr(TouchX,TouchY , Num))
			invalidate();
	       
		
	}
	

}
