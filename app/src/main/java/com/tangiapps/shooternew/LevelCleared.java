package com.tangiapps.shooternew;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
public class LevelCleared {
	public float blockW, blockH;
	Paint paint = new Paint();
	Paint pp = new Paint();
	Paint wspp = new Paint();
	RectF rectBack = new RectF();
	Paint ppaint = new Paint();
	Paint stpaint = new Paint();
	Rect next,home;
	

	Activity activityRef;
	public LevelCleared(Activity activityRef){
		this.activityRef=activityRef;
	}
	public LevelCleared(){
		
	}
	
	// Gravitational effetcts
	
			private float xoffset,g=4,v,limitX=ApplicationView.displayH * .3f;
			private boolean startAnimation,stopAnimation,bauncy;
			private void claculateOffset(){
				float speed=ApplicationView.displayW*0.02083333333333333333333333333333f;
				limitX=ApplicationView.displayH * .2f;
				if(bauncy){
					float temp=limitX*.9f;
					{
						
						g=(temp-v)*.1f<3?3:(temp-v)*.1f;
						v-=g;
						Log.i("animation", "v="+(int)v+"limitx="+(int)temp);
						if(Math.abs(temp-v)<2)
							stopAnimation=true;
					}
				}else{
					g+=g*.1f>speed?speed:g*.1f;
				
					v=g;
				}
				if(v>=limitX)
					bauncy=true;
				xoffset=v-ApplicationView.displayH * .2f;
				Log.i("animation", "offset="+g);
			}
			
			
			

	public void drawLevelComplete(Canvas c) {

		if(!startAnimation){
			startAnimation=true;
			stopAnimation=false;
			xoffset=0;
			g=1;
			v=0;
			bauncy=false;
			Log.i("animation", "started");
		}
		
		if(!stopAnimation)
			claculateOffset();
		
		
		// AnimatedView.backmove=true;
		blockW = ApplicationView.blockW;
		blockH = ApplicationView.blockH;
		paint.setColor(Color.BLACK);
		paint.setAlpha(225);

		stpaint.setStyle(Style.STROKE);
		stpaint.setStrokeWidth(3);
		stpaint.setColor(Color.BLUE);

		
		Rect rect=new Rect((int)(0),(int)(0),(int)(ApplicationView.displayW),(int)(ApplicationView.displayH));
		

		c.drawRect(rect, paint);
		//c.drawRoundRect(rect, 20, 20, stpaint);

		


		pp.setTextSize(ApplicationView.displayH / 15);
		pp.setAntiAlias(true);
		pp.setSubpixelText(true);
	
		pp.setStyle(Style.STROKE);
		
		pp.setStrokeWidth(3);
		pp.setColor(Color.BLACK );
		wspp.setTextSize(ApplicationView.displayH / 15);
		
		wspp.setAntiAlias(true);
		wspp.setSubpixelText(true);
		wspp.setTypeface(AppActivity.text);
		pp.setTypeface(AppActivity.text);
		
		
		wspp.setColor(Color.WHITE);
	
		
		
			c.drawText(
					ApplicationView.contxt.getString(R.string.LevelComplted),
					(int) ((ApplicationView.displayW * (.5)) - ((pp
							.measureText(ApplicationView.contxt
									.getString(R.string.LevelComplted))) * (0.50))),
					(float) (ApplicationView.displayH * .25+xoffset), pp);
			c.drawText(
					ApplicationView.contxt.getString(R.string.LevelComplted),
					(int) ((ApplicationView.displayW * (.5)) - ((wspp
							.measureText(ApplicationView.contxt
									.getString(R.string.LevelComplted))) * (0.50))),
					(float) (ApplicationView.displayH * .25+xoffset), wspp);
		

		
		
		pp.setTextSize(ApplicationView.displayH / 20);
		wspp.setTextSize(ApplicationView.displayH / 20);
		c.drawText(
				ApplicationView.contxt.getString(R.string.Level) + ": "
						+ ApplicationView.levelno,
				(int) ((ApplicationView.displayW * (.45)) - ((pp
						.measureText(ApplicationView.contxt.getString(R.string.Level))) * (0.50))),
				(float) (ApplicationView.displayH * .4+xoffset), pp);
		c.drawText(
				ApplicationView.contxt.getString(R.string.Level) + ": "
						+ ApplicationView.levelno,
				(int) ((ApplicationView.displayW * (.45)) - ((pp
						.measureText(ApplicationView.contxt.getString(R.string.Level))) * (0.50))),
				(float) (ApplicationView.displayH * .4+xoffset), wspp);
		//***************************
		
//		c.drawText(
//				ApplicationView.contxt.getString(R.string.score) + ": "
//						+ ApplicationView.total_score,
//				(int) ((ApplicationView.displayW * (.4)) - ((pp
//						.measureText(ApplicationView.contxt.getString(R.string.score))) * (0.50))),
//				(float) (ApplicationView.displayH * .5+xoffset), pp);
//		c.drawText(
//				ApplicationView.contxt.getString(R.string.score) + ": "
//						+ ApplicationView.total_score,
//				(int) ((ApplicationView.displayW * (.4)) - ((pp
//						.measureText(ApplicationView.contxt.getString(R.string.score))) * (0.50))),
//				(float) (ApplicationView.displayH * .5+xoffset), wspp);
		
		
		
		// home
		if (ApplicationView.isMenuBtnPressed == false) {
			c.drawBitmap(LoadImage.home, (float) (ApplicationView.displayW*.15f),
					(float) (ApplicationView.displayH*.7+xoffset), null);
		} else {
			c.drawBitmap(LoadImage.home1, (float) (ApplicationView.displayW*.15f),
					(float) (ApplicationView.displayH*.7+xoffset), null);
		}
		
		//next
		
		if (ApplicationView.isNextBtnPressed == false) {
			c.drawBitmap(LoadImage.next, (float) ((ApplicationView.displayW*.85)-LoadImage.next.getWidth()),
					(float) (ApplicationView.displayH*.7+xoffset), null);
		
		} else {
		c.drawBitmap(LoadImage.next1, (float) ((ApplicationView.displayW*.85)-LoadImage.next.getWidth()),
				(float) (ApplicationView.displayH*.7+xoffset), null);

		}
		
		
		

	}
	
	
	public void onTouchDown(int x_dn, int y_dn) {

		home=new Rect((int)(ApplicationView.displayW*.15f),(int)(ApplicationView.displayH*.7+xoffset),(int)(ApplicationView.displayW*.15f+LoadImage.home.getWidth()),(int)(ApplicationView.displayH*.7+LoadImage.home.getHeight()+xoffset));
		next=new Rect((int)(ApplicationView.displayW*.85f-LoadImage.next.getWidth()),(int)(ApplicationView.displayH*.7+xoffset),(int)(ApplicationView.displayW*.85f-LoadImage.next.getWidth()+LoadImage.home.getWidth()),(int)(ApplicationView.displayH*.7+LoadImage.home.getHeight()+xoffset));
		
	
		if(home.contains(x_dn, y_dn)){
			ApplicationView.isMenuBtnPressed = true;
		}else if(next.contains(x_dn, y_dn)){
			ApplicationView.isNextBtnPressed = true;
		}


	}


	public void onTouchUp(int x_up, int y_up) {
		home=new Rect((int)(ApplicationView.displayW*.15f),(int)(ApplicationView.displayH*.7+xoffset),(int)(ApplicationView.displayW*.15f+LoadImage.home.getWidth()),(int)(ApplicationView.displayH*.7+LoadImage.home.getHeight()+xoffset));
		next=new Rect((int)(ApplicationView.displayW*.85f-LoadImage.next.getWidth()),(int)(ApplicationView.displayH*.7+xoffset),(int)(ApplicationView.displayW*.85f-LoadImage.next.getWidth()+LoadImage.home.getWidth()),(int)(ApplicationView.displayH*.7+LoadImage.home.getHeight()+xoffset));
	
		ApplicationView.isBackgroundTouch=true;
		AppActivity main=(AppActivity)ApplicationView.contxt;
		main.saveApplicationState();

		if (ApplicationView.isNextBtnPressed == true) {
			ApplicationView.isNextBtnPressed = false;
			startAnimation=false;
		} else if (ApplicationView.isMenuBtnPressed == true) {
			ApplicationView.isMenuBtnPressed = false;
			startAnimation=false;
		}
		
		
		

		if(home.contains(x_up, y_up)){		// home
			
			ApplicationView.islevelCleared = false;
		
			if (ApplicationView.levelno == AppActivity.appLevel) {
				AppActivity.appLevel++;
				
			}
			ApplicationView.islevelCleared = false;
			ApplicationView.isResetAppLevel = true;
			ApplicationView.isTouchEnable = true;
			ApplicationView.isPlayingMode = false;
			ApplicationView.isMianPage = true;
			ApplicationView.isBackgroundTouch=false;
			
		
			
			
		}else if(next.contains(x_up, y_up)){// next
			
			
			
			
			ApplicationView.islevelCleared = false;
			ApplicationView.isGoToNextLevel = true;
			ApplicationView.isResetAppLevel = true;
			ApplicationView.isBackgroundTouch=false;
			
			
			
		}
		}
	
	
	
	
	
	
	
	
	

}
