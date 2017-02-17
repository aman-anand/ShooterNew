package com.tangiapps.shooternew;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import android.view.MotionEvent;

public class BackButtonPress {
	Paint pp = new Paint();
	Paint wspp = new Paint();
	Paint ppaint = new Paint();
	Paint stpaint = new Paint();
	RectF rectBack;// =new RectF();
	static Rect resume, home, retry, level;
	boolean isHomeBtnPressed = false, isResumeBtnPressed = false,
			isLevelBtnPressed = false;
	static boolean isBackResume = false;
	int px = 0, py = 0;

	
	
	
	// Gravitational effetcts
	
		private float xoffset,g=4,v,limitX=ApplicationView.displayH * .3f;
		private boolean startAnimation,stopAnimation,bauncy;
		private void claculateOffset(){
			float speed=ApplicationView.displayW*0.02083333333333333333333333333333f;
			limitX=ApplicationView.displayH * .3f;
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
			
		}
		
		
		
		
		
	public void drawingButton(Canvas can) {

		

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

		ppaint.setColor(Color.BLACK);
		ppaint.setAlpha(150);
		can.drawRect(new Rect(0,0,(int)(ApplicationView.displayW),(int)(ApplicationView.displayH)), ppaint);

	
		
		Rect rect = new Rect((int) (0), (int) (0),
				(int) (ApplicationView.displayW),
				(int) (ApplicationView.displayH));

		Paint p = new Paint();
		p.setColor(Color.BLACK);
		p.setAlpha(225);

		can.drawRect(rect, p);
		
		
		
		
		

		if (isResumeBtnPressed == false) {
			can.drawBitmap(LoadImage.button,
					(int) (ApplicationView.displayW*.5f-LoadImage.button.getWidth()/2),
					(int) (ApplicationView.displayH * .25+xoffset), null);
		} else {
			can.drawBitmap(LoadImage.button1,
					(int) (ApplicationView.displayW*.5f-LoadImage.button.getWidth()/2),
					(int) (ApplicationView.displayH * .25+xoffset), null);

		}

		// draw level button
		if (isLevelBtnPressed == false) {
			can.drawBitmap(LoadImage.button,
					(int) (ApplicationView.displayW*.5f-LoadImage.button.getWidth()/2),
					(int) (ApplicationView.displayH * .45+xoffset), null);
		} else {
			can.drawBitmap(LoadImage.button1,
					(int) (ApplicationView.displayW*.5f-LoadImage.button.getWidth()/2),
					(int) (ApplicationView.displayH * .45+xoffset), null);
		}

		// draw home button
		if (isHomeBtnPressed == false) {
			can.drawBitmap(LoadImage.button,
					(int) (ApplicationView.displayW*.5f-LoadImage.button.getWidth()/2),
					(int) (ApplicationView.displayH * .65+xoffset), null);
		} else {
			can.drawBitmap(LoadImage.button1,
					(int) (ApplicationView.displayW*.5f-LoadImage.button.getWidth()/2),
					(int) (ApplicationView.displayH * .65+xoffset), null);
		}

		
		drawString(can);
	}

	private void drawString(Canvas canvas) {
		pp.setTextSize(ApplicationView.displayH / 15);
		pp.setAntiAlias(true);
		pp.setSubpixelText(true);

		pp.setStyle(Style.STROKE);
		pp.setStrokeWidth(3);
		
		wspp.setTextSize(ApplicationView.displayH / 15);
		wspp.setAntiAlias(true);
		wspp.setSubpixelText(true);

		

		wspp.setTypeface(AppActivity.text);
		pp.setTypeface(AppActivity.text);
		
		wspp.setColor(ApplicationView.contxt.getResources()
				.getColor(R.color.white));
		pp.setColor(ApplicationView.contxt.getResources().getColor(
				R.color.strokeColor));
		
		canvas.drawText(ApplicationView.contxt.getString(R.string.pause),
				(float) ((ApplicationView.displayW * .5f) - (pp
						.measureText(ApplicationView.contxt
								.getString(R.string.pause)) * (0.50))),
				(float) ((ApplicationView.displayH * .18+xoffset)), pp);
		
		canvas.drawText(ApplicationView.contxt.getString(R.string.pause),
				(float) ((ApplicationView.displayW * .5f) - (wspp
						.measureText(ApplicationView.contxt
								.getString(R.string.pause)) * (0.50))),
				(float) ((ApplicationView.displayH * .18+xoffset)), wspp);
		
		
		
		wspp.setTextSize(ApplicationView.displayH / 22);
		pp.setTextSize(ApplicationView.displayH / 22);
		
		pp.setColor(ApplicationView.contxt.getResources().getColor(
				R.color.white));
		wspp.setColor(ApplicationView.contxt.getResources()
				.getColor(R.color.strokeColor));

		canvas.drawText(ApplicationView.contxt.getString(R.string.contInue),
				(float) ((ApplicationView.displayW * .5f) - (pp
						.measureText(ApplicationView.contxt
								.getString(R.string.contInue)) * (0.50))),
				(float) ((ApplicationView.displayH * .325+xoffset)), pp);
		canvas.drawText(ApplicationView.contxt.getString(R.string.contInue),
				(float) ((ApplicationView.displayW * .5f) - (wspp
						.measureText(ApplicationView.contxt
								.getString(R.string.contInue)) * (0.50))),
				(float) ((ApplicationView.displayH * .325+xoffset)), wspp);

		canvas.drawText(ApplicationView.contxt.getString(R.string.Level),
				(float) ((ApplicationView.displayW * .5f) - pp
						.measureText(ApplicationView.contxt
								.getString(R.string.Level)) * (0.50)),
				(float) ((ApplicationView.displayH * .525+xoffset)), pp);
		canvas.drawText(ApplicationView.contxt.getString(R.string.Level),
				(float) ((ApplicationView.displayW * .5f) - wspp
						.measureText(ApplicationView.contxt
								.getString(R.string.Level)) * (0.50)),
				(float) ((ApplicationView.displayH * .525+xoffset)), wspp);

		canvas.drawText(ApplicationView.contxt.getString(R.string.home),
				(float) ((ApplicationView.displayW * .5) - pp
						.measureText(ApplicationView.contxt
								.getString(R.string.home)) * (0.50)),
				(float) ((ApplicationView.displayH * .725+xoffset)), pp);
		canvas.drawText(ApplicationView.contxt.getString(R.string.home),
				(float) ((ApplicationView.displayW * .5) - wspp
						.measureText(ApplicationView.contxt
								.getString(R.string.home)) * (0.50)),
				(float) ((ApplicationView.displayH * .725+xoffset)), wspp);

	}
	
	
	
	

	public boolean BackTouch(MotionEvent event) {

		resume = new Rect((int) (ApplicationView.displayW*.5f-LoadImage.button.getWidth()/2),
				(int) (ApplicationView.displayH * .25+xoffset),
				(int) (ApplicationView.displayW*.5f-LoadImage.button.getWidth()/2)
						+ LoadImage.button.getWidth(),
				(int) (ApplicationView.displayH * .25+xoffset)
						+ LoadImage.button.getHeight());

		level = new Rect((int) (ApplicationView.displayW*.5f-LoadImage.button.getWidth()/2),
				(int) (ApplicationView.displayH * .45+xoffset),
				(int) (ApplicationView.displayW*.5f-LoadImage.button.getWidth()/2)
						+ LoadImage.button.getWidth(),
				(int) (ApplicationView.displayH * .45+xoffset)
						+ LoadImage.button.getHeight());

		home = new Rect((int) (ApplicationView.displayW*.5f-LoadImage.button.getWidth()/2),
				(int) (ApplicationView.displayH * .65+xoffset),
				(int) (ApplicationView.displayW*.5f-LoadImage.button.getWidth()/2)
						+ LoadImage.button.getWidth(),
				(int) (ApplicationView.displayH * .65+xoffset)
						+ LoadImage.button.getHeight());
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			px = (int) event.getX();
			py = (int) event.getY();
			

			if (resume.contains(px, py)) {
				isResumeBtnPressed = true;
				
			} else if (home.contains(px, py)) {
				isHomeBtnPressed = true;
				
			} else if (level.contains(px, py)) {
				isLevelBtnPressed = true;
				
			}

		}

		if (ApplicationView.isBackgroundTouch == false) {
			if (event.getAction() == MotionEvent.ACTION_UP) {
				px = (int) event.getX();
				py = (int) event.getY();

				if (isHomeBtnPressed) {
					isHomeBtnPressed = false;
					startAnimation=false;
				} else if (isResumeBtnPressed) {
					isResumeBtnPressed = false;
					startAnimation=false;
				} else if (isLevelBtnPressed) {
					isLevelBtnPressed = false;
					startAnimation=false;
				}

				if (resume.contains(px, py)) {
					
					ApplicationView.isBackButtonPress = false;
					ApplicationView.isTouchEnable = true;
					ApplicationView.isBackgroundTouch = false;
					ApplicationView.isUpdate=true;

				} else if (home.contains(px, py)) {

					
					ApplicationView.islevelCleared = false;
					ApplicationView.isLevelFailed = false;
					ApplicationView.isResetAppLevel = true;
					ApplicationView.isBackButtonPress = false;
					ApplicationView.isTouchEnable = true;
					ApplicationView.isPlayingMode = false;
					ApplicationView.isMianPage = true;
					ApplicationView.isBackgroundTouch = false;
					
					ApplicationView.isUpdate=true;
					MainPage.isHomeTouch=true;
					
					
				
					
					
					
				} else if (level.contains(px, py)) {

					
					ApplicationView.islevelCleared = false;
					ApplicationView.isLevelFailed = false;
					ApplicationView.isResetAppLevel = true;
					ApplicationView.isBackButtonPress = false;
					ApplicationView.isTouchEnable = true;
					ApplicationView.isPlayingMode = false;
					ApplicationView.isMianPage = false;
					ApplicationView.isBackgroundTouch = false;
					ApplicationView.isLevelPage = true;
					
					ApplicationView.isUpdate=true;
					
				}

			}
		}

		return true;
	}

}
