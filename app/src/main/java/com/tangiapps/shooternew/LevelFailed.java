package com.tangiapps.shooternew;




import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;

public class LevelFailed {
	public float blockW, blockH;
	Paint paint = new Paint();
	Paint pp = new Paint();
	Paint wspp = new Paint();
	RectF rectBack = new RectF();
	Paint ppaint = new Paint();
	Paint stpaint = new Paint();
	
RectF home,retry;
Activity activityRef;
public LevelFailed(Activity activityRef){
	this.activityRef=activityRef;
}

public LevelFailed(){
	
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
		
	public void drawLevelFailed(Canvas c) {

		
		
		

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
		
		// AnimatedView.isBackgroundTouch=true;
		blockW = ApplicationView.blockW;
		blockH = ApplicationView.blockH;
		
		
		paint.setColor(Color.BLACK);
		paint.setAlpha(150);
		c.drawRect (new RectF (0,0,(int)(ApplicationView.displayW),(int)(ApplicationView.displayH)), paint);
		paint.setColor(Color.BLACK);
		paint.setAlpha(225);

		stpaint.setStyle(Style.STROKE);
		stpaint.setStrokeWidth(3);
		stpaint.setColor(Color.BLUE);

		
		RectF rect=new RectF ((int)(0),(int)(0),(int)(ApplicationView.displayW),(int)(ApplicationView.displayH));
		

		c.drawRect(rect , paint);
		
		
		pp.setAntiAlias(true);
		pp.setSubpixelText(true);
		pp.setStyle(Style.STROKE);
		
		pp.setStrokeWidth(3);
		//pp.setColor(ApplicationView.contxt.getResources().getColor(R.color.white));
		pp.setColor(Color.BLACK);
		
		wspp.setAntiAlias(true);
		wspp.setSubpixelText(true);

		wspp.setColor(Color.WHITE);
		
		
		
		pp.setTextSize(ApplicationView.displayH / 15);
		wspp.setTextSize(ApplicationView.displayH / 15);
		
		wspp.setTypeface(AppActivity.text);
		pp.setTypeface(AppActivity.text);
		
		
		c.drawText(
				ApplicationView.contxt.getString(R.string.LevelFailed),
				(int) ((ApplicationView.displayW * (.5)) - ((pp
						.measureText(ApplicationView.contxt
								.getString(R.string.LevelFailed))) * (0.50))),
				(float) (ApplicationView.displayH * .25+xoffset), pp);
		c.drawText(
				ApplicationView.contxt.getString(R.string.LevelFailed),
				(int) ((ApplicationView.displayW * (.5)) - ((wspp
						.measureText(ApplicationView.contxt
								.getString(R.string.LevelFailed))) * (0.50))),
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
		
		// home
		if (ApplicationView.isMenuBtnPressed == false) {
			c.drawBitmap(LoadImage.home,( float) (ApplicationView.displayW*.15f),
			(float) (ApplicationView.displayH*.7+xoffset), null);
		} else {
			c.drawBitmap(LoadImage.home1, ( float) (ApplicationView.displayW*.15f),
					(float) (ApplicationView.displayH*.7+xoffset), null);
		}
		
		//next
		
		if (ApplicationView.isRetryBtnPressed == false) {
			c.drawBitmap(LoadImage.retry, (float) ((ApplicationView.displayW*.85)-LoadImage.next.getWidth()),
					(float) (ApplicationView.displayH*.7+xoffset), null);
		
		} else {
		c.drawBitmap(LoadImage.retry1,(float) ((ApplicationView.displayW*.85)-LoadImage.next.getWidth()),
				(float) (ApplicationView.displayH*.7+xoffset), null);

		}
		
	
		


	}
	
	
	public void onTouchDown(float x_dn, float y_dn) {

		blockW = ApplicationView.blockW;
		blockH = ApplicationView.blockH;

	
	home=new RectF ((float)(ApplicationView.displayW*.15f),(float)(ApplicationView.displayH*.7+xoffset),(float)(ApplicationView.displayW*.15f+LoadImage.home.getWidth()),(float)(ApplicationView.displayH*.7+LoadImage.home.getHeight()+xoffset));
	retry=new RectF ((float)(ApplicationView.displayW*.85f-LoadImage.next.getWidth()),(float)(ApplicationView.displayH*.7+xoffset),(float)(ApplicationView.displayW*.85f-LoadImage.next.getWidth()+LoadImage.home.getWidth()),(float)(ApplicationView.displayH*.7+LoadImage.home.getHeight()+xoffset));
	

	if(home.contains(x_dn, y_dn)){
		ApplicationView.isMenuBtnPressed = true;
	}else if(retry.contains(x_dn, y_dn)){
		ApplicationView.isRetryBtnPressed = true;
	}


	}// end of touch down

	public void onTouchUp(float x_dn, float y_dn) {

		
		home=new RectF ((float)(ApplicationView.displayW*.15f),(float)(ApplicationView.displayH*.7+xoffset),(float)(ApplicationView.displayW*.15f+LoadImage.home.getWidth()),(float)(ApplicationView.displayH*.7+LoadImage.home.getHeight()+xoffset));
		retry=new RectF ((float)(ApplicationView.displayW*.85f-LoadImage.next.getWidth()),(float)(ApplicationView.displayH*.7+xoffset),(float)(ApplicationView.displayW*.85f-LoadImage.next.getWidth()+LoadImage.home.getWidth()),(float)(ApplicationView.displayH*.7+LoadImage.home.getHeight()+xoffset));
		

		
		ApplicationView.isBackgroundTouch=true;

		if (ApplicationView.isRetryBtnPressed == true) {
			ApplicationView.isRetryBtnPressed = false;
			startAnimation=false;
		} else

			if (ApplicationView.isMenuBtnPressed == true) {
			ApplicationView.isMenuBtnPressed = false;
		}
		
		
		

		if(home.contains(x_dn, y_dn)){		// home
	
			ApplicationView.isLevelFailed=false;
			ApplicationView.isResetAppLevel = true;
			ApplicationView.isTouchEnable = true;
			ApplicationView.isPlayingMode = false;
			ApplicationView.isMianPage = true;
			ApplicationView.isBackgroundTouch=false;
			
		
			
		
		} else if(retry.contains(x_dn, y_dn)){	// retry
			
			
			ApplicationView.isLevelFailed=false;;
			ApplicationView.isResetAppLevel = true;
			ApplicationView.isBackgroundTouch=false;
			
			ApplicationView.isTouchEnable = true;
		
		
		}
		
		}
		
	
	
	

	
}
