package com.tangiapps.shooternew;


import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.net.Uri;
import android.view.MotionEvent;

public class MainPage {
	static Rect play, moreapp,  option,shyar;
	static boolean isAboutPage = false, isHomeTouch = true, isHelpPage = false,isOptionPage=false;
	boolean isPlayBtnPressed = false, isMoreBtnPressed = false,isOptionBtnPressesd=false,isShyarBtnPressesd=false;
			
	Paint pp = new Paint();
	Paint wspp = new Paint();
	int ne_x, ne_y;

	Paint pp1 = new Paint();
	int delayCounter=0,framecount,totalframe=8;
	Paint lp = new Paint();
	Paint wslp = new Paint();
	Paint p=new Paint();
	public void drawMainPage(Canvas canv) {
		

			canv.drawBitmap(LoadImage.homebg, 0, 0, null);
	 
	     
			if (isPlayBtnPressed == false) {
				canv.drawBitmap(LoadImage.play,
						(int) (ApplicationView.displayW-LoadImage.play.getWidth())/2,
						(int) (ApplicationView.displayH * .6), null);
				
			} else {
				
				canv.drawBitmap(LoadImage.play1,
						(int) (ApplicationView.displayW-LoadImage.play1.getWidth())/2,
						(int) (ApplicationView.displayH * .6), null);

			}
			

			
				lp.setTypeface(AppActivity.text);
			wslp.setTypeface(AppActivity.text);
			lp.setAntiAlias(true);
			lp.setSubpixelText(true);
			lp.setColor(ApplicationView.contxt.getResources().getColor(
					R.color.white));
			lp.setStyle(Style.STROKE);
			lp.setStrokeWidth(2);

		
			lp.setTextSize(ApplicationView.displayH / 30);
			wslp.setTextSize(ApplicationView.displayH / 30);
			wslp.setAntiAlias(true);
			wslp.setSubpixelText(true);
			wslp.setColor(ApplicationView.contxt.getResources().getColor(R.color.black));
			
			
			
    		delayCounter = delayCounter+1;

    		
    	    if (delayCounter % 10 == 0) {
    	  
    	    	framecount = (framecount+1);
    	    }
    	    if (framecount== totalframe) {
    		      framecount = 0;
    		     // delayCounter=0;
    		     
    		    }
    		    
    	    
			
			if (isMoreBtnPressed == false) {
				canv.drawBitmap(LoadImage.moreapps,
						(int) (ApplicationView.displayW*.05f),
						(int) (ApplicationView.displayH * .8), null);
			} else {
				canv.drawBitmap(LoadImage.moreapps1,
						(int) (ApplicationView.displayW*.05),
						(int) (ApplicationView.displayH * .8), null);

			}

			if (isOptionBtnPressesd == false) {
				canv.drawBitmap(LoadImage.option,
						((int) (ApplicationView.displayW*.95-LoadImage.option1.getWidth())),
						(int) (ApplicationView.displayH * .8), null);
			} else {
				canv.drawBitmap(LoadImage.option1,
						((int) (ApplicationView.displayW*.95-LoadImage.option1.getWidth())),
						(int) (ApplicationView.displayH * .8), null);

			}
			
			if (isShyarBtnPressesd == false) {
				canv.drawBitmap(LoadImage.share,
						((int) (ApplicationView.displayW-LoadImage.share.getWidth())/2),
						(int) (ApplicationView.displayH * .8), null);
			} else {
				canv.drawBitmap(LoadImage.share1,
						((int) (ApplicationView.displayW-LoadImage.share1.getWidth())/2),
						(int) (ApplicationView.displayH * .8), null);

			}

			drawString(canv);	
	
		
	}

	
	public boolean mainPageTouch(MotionEvent e) {

		play = new Rect((int) ((int) (ApplicationView.displayW-LoadImage.play1.getWidth())/2),
				(int) (ApplicationView.displayH * .6),
				(int) ((int) (ApplicationView.displayW-LoadImage.play1.getWidth())/2)
						+ LoadImage.play1.getWidth(),
				(int) (int) (ApplicationView.displayH * .6)
						+ LoadImage.play1.getHeight());

		moreapp = new Rect((int) ((int) (ApplicationView.displayW*.05f)),
				(int) (ApplicationView.displayH * .8),
				((int) (ApplicationView.displayW*.05f))
						+ LoadImage.moreapps.getWidth(),
				(int) (ApplicationView.displayH * .8)
						+ LoadImage.moreapps.getHeight());

		option = new Rect(((int) (ApplicationView.displayW*.95-LoadImage.option1.getWidth())),
				(int) (ApplicationView.displayH * .8),
				((int) (ApplicationView.displayW*.95-LoadImage.option1.getWidth()))
						+ LoadImage.option1.getWidth(),
				(int) (ApplicationView.displayH * .8)
						+ LoadImage.option1.getHeight());
		
		
		shyar = new Rect(((int) (ApplicationView.displayW-LoadImage.share.getWidth())/2),
				(int) (ApplicationView.displayH * .8),
				((int)(ApplicationView.displayW-LoadImage.share.getWidth())/2)
						+ LoadImage.share.getWidth(),
				(int) (ApplicationView.displayH * .8)
						+ LoadImage.share.getHeight());

		if (isHomeTouch) {

			if (e.getAction() == MotionEvent.ACTION_DOWN) {
				ne_x = (int) e.getX();
				ne_y = (int) e.getY();
				if (MainPage.play.contains(ne_x, ne_y)) {
					isPlayBtnPressed = true;
				} else if (MainPage.moreapp.contains(ne_x, ne_y)) {
					isMoreBtnPressed = true;
				} else if (MainPage.option.contains(ne_x, ne_y)) {
					isOptionBtnPressesd = true;
				} else if (MainPage.shyar.contains(ne_x, ne_y)) {
					isShyarBtnPressesd = true;
				} 
			}

			if (e.getAction() == MotionEvent.ACTION_UP) {
				ne_x = (int) e.getX();
				ne_y = (int) e.getY();
				if (isPlayBtnPressed) {
					isPlayBtnPressed = false;
				} else if (isMoreBtnPressed) {
					isMoreBtnPressed = false;
				} else if (isOptionBtnPressesd) {
					isOptionBtnPressesd = false;
				} else if (isShyarBtnPressesd) {
					isShyarBtnPressesd = false;
				} 
				
				
				if (MainPage.play.contains(ne_x, ne_y)) {

					ApplicationView.isMianPage = false;
					ApplicationView.isResetAppLevel = true;
					ApplicationView.isLevelPage = true;
					
					
				} else if (MainPage.moreapp.contains(ne_x, ne_y)) {
					

					Intent in = new Intent("android.intent.action.VIEW",
							Uri.parse(Data.defaultUrl));
					ApplicationView.contxt.startActivity(in);
					
				

				}   else if (MainPage.option.contains(ne_x, ne_y)) {

					ApplicationView.isOptionPage = true;
					Options.isOptionTouch=true;
					isHomeTouch = false;
					
					

					}   else if (MainPage.shyar.contains(ne_x, ne_y)) {
						
						
						shareTextUrl();
						System.out.println("shyar butten is pressed");
						

						} 
			}

		}

		return true;
	}

	
	private void shareTextUrl() {
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
 
       
        share.putExtra(Intent.EXTRA_SUBJECT, "Play more Entertaining Game: ");
        share.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=com.kiss4games.bubbletouchblast&hl=en");
       
       
 
        ApplicationView.contxt.startActivity(Intent.createChooser(share, "Share"));
    }
	public void drawString(Canvas canvas) {

		pp.setAntiAlias(true);
		pp.setSubpixelText(true);
	
		pp.setStyle(Style.STROKE);
		pp.setStrokeWidth(2);
		pp.setColor(ApplicationView.contxt.getResources().getColor(R.color.white));

		wspp.setAntiAlias(true);
		wspp.setSubpixelText(true);
		
		wspp .setColor(ApplicationView.contxt.getResources().getColor(
				R.color.strokeColor));

		pp.setTextSize(ApplicationView.displayH / 14);
		wspp.setTextSize(ApplicationView.displayH / 14);
		pp.setTypeface(AppActivity.text);
		wspp.setTypeface(AppActivity.text);
		

//		canvas.drawText(
//				ApplicationView.contxt.getString(R.string.play),
//				(float) (ApplicationView.displayW* (0.5) - (pp
//						.measureText(ApplicationView.contxt.getString(R.string.play)) * (0.5))),
//				(float) (ApplicationView.displayH * .31), pp);
//		
//		canvas.drawText(ApplicationView.contxt.getString(R.string.play),
//				(float) ((ApplicationView.displayW*.5)- (pp.measureText(ApplicationView.contxt
//						.getString(R.string.play)) * (0.5))),
//				(float) (ApplicationView.displayH * .31), wspp);
//
//		if (ApplicationView.contxt.getString(R.string.moreapps).length() > 15) {
//			pp.setTextSize(ApplicationView.displayH / 22);
//			wspp.setTextSize(ApplicationView.displayH / 22);
//		} else {
//			pp.setTextSize(ApplicationView.displayH / 21);
//			wspp.setTextSize(ApplicationView.displayH / 21);
//		}
//
//		canvas.drawText(
//				ApplicationView.contxt.getString(R.string.moreapps),
//				(float) ((ApplicationView.displayW*.5) - (pp
//						.measureText(ApplicationView.contxt
//								.getString(R.string.moreapps)) * (0.5))),
//				(float) (ApplicationView.displayH * .46), pp);
//		canvas.drawText(ApplicationView.contxt.getString(R.string.moreapps),
//				(float) ((ApplicationView.displayW*.5) - (wspp
//						.measureText(ApplicationView.contxt
//								.getString(R.string.moreapps)) * (0.5))),
//				(float) (ApplicationView.displayH * .46), wspp);
//
//		pp.setTextSize(ApplicationView.displayH / 16);
//		wspp.setTextSize(ApplicationView.displayH / 16);
//		canvas.drawText(
//				ApplicationView.contxt.getString(R.string.option),
//				(float) ((ApplicationView.displayW*.5) - (pp
//						.measureText(ApplicationView.contxt.getString(R.string.option)) * (0.5))),
//				(float) (ApplicationView.displayH * .62), pp);
//		canvas.drawText(ApplicationView.contxt.getString(R.string.option),
//				(float) ((ApplicationView.displayW*.5)-(wspp.measureText(ApplicationView.contxt
//						.getString(R.string.option)) * (0.5))),
//				(float) (ApplicationView.displayH * .62), wspp);

		
		
		
//		canvas.drawText("Line"
//				,
//				(float) (ApplicationView.displayW* (0.5) - (pp
//						.measureText("Line") * (0.5))),
//				(float) (ApplicationView.displayH * .17), pp);
//		canvas.drawText("Line"
//				,
//				(float) (ApplicationView.displayW* (0.5) - (pp
//						.measureText("Line") * (0.5))),
//				(float) (ApplicationView.displayH * .17), wspp);
//		
//		canvas.drawText("Zen Circle"
//				,
//				(float) (ApplicationView.displayW* (0.5) - (pp
//						.measureText("Zen Circle") * (0.5))),
//				(float) (ApplicationView.displayH * .25), pp);
//		canvas.drawText("Zen Circle"
//				,
//				(float) (ApplicationView.displayW* (0.5) - (pp
//						.measureText("Zen Circle") * (0.5))),
//				(float) (ApplicationView.displayH * .25), wspp);
		
//		canvas.drawText("Line"
//				,
//				(float) (ApplicationView.displayW* (0.5) - (pp
//						.measureText("Line") * (0.5))),
//				(float) (ApplicationView.displayH * .15), pp);
//		canvas.drawText("Line"
//				,
//				(float) (ApplicationView.displayW* (0.5) - (pp
//						.measureText("Line") * (0.5))),
//				(float) (ApplicationView.displayH * .15), wspp);
		
		
		

		
	}

}
