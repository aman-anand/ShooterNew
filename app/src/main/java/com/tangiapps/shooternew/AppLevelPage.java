package com.tangiapps.shooternew;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.MotionEvent;

public class AppLevelPage {

	public static int flag = 0;

	boolean leftclick = false, rightclick = false,isLevelButton=false;

	Rect left;
	Rect right;
	Paint withoutStroke = new Paint();
	Rotate rr=new Rotate();
	int lcounter = 0;
	float width;
	float height;
	int cfn = 0;
	int cfb = 0;
	float lx, ly;
	
	public void getLevelNo() {

		
		
			if (ApplicationView.levelno >= AppActivity.appLevel) {
				AppActivity.appLevel = ApplicationView.levelno;
			}
		
		
		
		

		withoutStroke.setTextSize(ApplicationView.displayH / 22);
		withoutStroke.setAntiAlias(true);
		withoutStroke.setSubpixelText(true);
		withoutStroke.setTypeface(Typeface.DEFAULT_BOLD);
		withoutStroke.setColor(Color.BLACK);
	}

	public void Level_Canvas(Canvas canvas) {
		getLevelNo();
		
	
		lcounter = flag * 15;
		canvas.drawBitmap(LoadImage.levelpage, 0, 0, null);
		width = LoadImage.level.getWidth();
		height = LoadImage.level.getHeight();
		float leftgap=(ApplicationView.displayW-width*4)/2;//ApplicationView.displayH*.15f;
		float topgap=(ApplicationView.displayH-((width*5)+((width*.3f)*4)))*.4f;//ApplicationView.displayH*.125f;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				
				
				float left=leftgap+ (j * width)+(width*.5f*j);
				float top=(int) topgap+(i * height)+(width*.3f*i);
				
					if (lcounter <AppActivity.appLevel) {
						
							canvas.drawBitmap(LoadImage.level,left, top,
									null);
						
							withoutStroke.setColor(Color.BLACK);
						canvas.drawText(
								String.valueOf(lcounter + 1),
								left+width*.5f
										- withoutStroke.measureText(String
												.valueOf(lcounter + 1)) / 2,
								top+height*.6f,
								withoutStroke);

						lcounter++;
					} else {
						canvas.drawBitmap(LoadImage.levellock,left, top,
								null);
					}

				
			}
		}

		canvas.drawText(String.valueOf(flag + 1), ApplicationView.displayW / 2
				- withoutStroke.measureText(String.valueOf(flag + 1)) / 2,
				(float) (ApplicationView.displayH * 0.95), withoutStroke);

		if (leftclick == true) {
			canvas.drawBitmap(rr.getRotedImage(LoadImage.right,180),
					(int) (.0063 * ApplicationView.blockW),
					(int) (.87 * ApplicationView.displayH), null);

		} else {

			canvas.drawBitmap(rr.getRotedImage(LoadImage.right,180),
					(int) (.0063 * ApplicationView.blockW),
					(int) (.87 * ApplicationView.displayH), null);
		}
		if (rightclick == true) {
			canvas.drawBitmap(LoadImage.right,
					(int) (.84 * ApplicationView.displayW),
					(int) (.87 * ApplicationView.displayH), null);
		} else {
			canvas.drawBitmap(LoadImage.right,
					(float) (.84 * ApplicationView.displayW),
					(int) (.87 * ApplicationView.displayH), null);
		}

	}

	public boolean onTouchEvent(MotionEvent event) {

		switch (event.getAction()) {
		
		
			
		case MotionEvent.ACTION_UP:
			lx = (int) event.getX();
			ly = (int) event.getY();

			if (isLevelButton == true) {
				isLevelButton = false;
			}
			
			rectangle();
			Get_Level();
			if (left.contains((int) lx, (int) ly)) {
				leftclick = true;
				if (flag == 0) {
					flag = 4;
					
				} else {
					flag--;
					
				}
				
//				if(ApplicationView.isSoundOn){
//					
//					Sound.stopSound(0);
//					Sound.playSound(0);
//					
//				}
			} else if (right.contains((int) lx, (int) ly)) {

				rightclick = true;
				if (flag == 4) {
					flag = 0;
				

				} else {
					flag++;
					

				}
			
//				if(ApplicationView.isSoundOn){
//					
//					Sound.stopSound(0);
//					Sound.playSound(0);
//					
//				}
			}

			break;

		}

		return true;
	}

	public void rectangle() {

		// left right button clicked

		left = new Rect((int) (.0063 * ApplicationView.blockW),
				(int) (.87 * ApplicationView.displayH),
				(int) (.0063 * ApplicationView.blockW)
						+ LoadImage.right.getWidth(),
				(int) (.87 * ApplicationView.displayH)
						+ LoadImage.right.getHeight());
		right = new Rect((int) (.85 * ApplicationView.displayW),
				(int) (.87 * ApplicationView.displayH),
				(int) (.84 * ApplicationView.displayW)
						+ LoadImage.right.getWidth(),
				(int) (.87 * ApplicationView.displayH)
						+ LoadImage.right.getHeight());
	}

	private void Get_Level() {
		int levelcount = 15 * flag + 1;
		
		float leftgap=(ApplicationView.displayW-width*4)/2;//ApplicationView.displayH*.15f;
		float topgap=(ApplicationView.displayH-((width*5)+((width*.3f)*4)))*.4f;//ApplicationView.displayH*.125f;
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				
				float left=leftgap+ (j * width)+(width*.4f*j);
				float top=(int) topgap+(i * height)+(width*.3f*i);
				
					if (lx >=left
							&& lx <= left+width
							&& ly >= top
							&& ly <= top+width
							&& levelcount <= AppActivity.appLevel) {
						ApplicationView.levelno = levelcount;
						
						ApplicationView.isLevelPage = false;
						ApplicationView.isPlayingMode = true;

						if (isLevelButton == false) {
							isLevelButton = true;
						}

						lx = 0;
						ly = 0;

						levelcount = 0;
						lcounter = 0;
						break;

					} else {
						levelcount++;

					}
				}
			
		}
	}
}
