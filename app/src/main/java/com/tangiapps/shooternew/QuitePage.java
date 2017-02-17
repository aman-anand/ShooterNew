package com.tangiapps.shooternew;


import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.net.Uri;
import android.view.MotionEvent;

public class QuitePage {
	Paint pp = new Paint();
	Paint wspp = new Paint();
	Paint ppaint = new Paint();
	Paint stpaint = new Paint();
	Rect ok, rateit, cancle;
	int xx = 0, yy = 0;
	
	boolean isOkBtnPressed = false, isRateBtnPressed = false,
			isCancleBtnPressed = false;

	public void drawexitbutton(Canvas can) {

		ppaint.setColor(ApplicationView.contxt.getResources().getColor(
				R.color.white));
	//	ppaint.setAlpha(220);
		stpaint.setStyle(Style.STROKE);
		stpaint.setStrokeWidth(2);
		stpaint.setColor(ApplicationView.contxt.getResources().getColor(
				R.color.paincolor));
		
//		ppaint.setColor(Color.WHITE);
//		ppaint.setAlpha(100);
//		
//		stpaint.setStyle(Style.STROKE);
//		stpaint.setStrokeWidth(3);
		stpaint.setColor(Color.BLUE);
		
		
		
		Rect rectF =new Rect((int)(0),(int)(0),(int)(ApplicationView.displayW),(int)(ApplicationView.displayH));
		
Paint p=new Paint();
p.setColor(Color.BLACK);
p.setAlpha(225);
		can.drawRect(rectF, p);
	

		// draw ok button
		if (isOkBtnPressed == false) {
			can.drawBitmap(LoadImage.button,
					(int) (ApplicationView.displayW -LoadImage.button.getWidth())/2,
					(int) (ApplicationView.displayH * .25), null);
		} else {
			can.drawBitmap(LoadImage.button1,
					(int) (ApplicationView.displayW -LoadImage.button1.getWidth())/2,
					(int) (ApplicationView.displayH * .25), null);

		}

		// draw rate it button
		if (isRateBtnPressed == false) {
			can.drawBitmap(LoadImage.button,
					(int) (ApplicationView.displayW -LoadImage.button.getWidth())/2,
					(int) (ApplicationView.displayH * .45), null);
		} else {
			can.drawBitmap(LoadImage.button1,
					(int) (ApplicationView.displayW -LoadImage.button1.getWidth())/2,
					(int) (ApplicationView.displayH * .45), null);
		}

		// draw cancle button
		if (isCancleBtnPressed == false) {
			can.drawBitmap(LoadImage.button,
					(int) (ApplicationView.displayW -LoadImage.button.getWidth())/2,
					(int) (ApplicationView.displayH * .65), null);
		} else {
			can.drawBitmap(LoadImage.button1,
					(int) (ApplicationView.displayW -LoadImage.button1.getWidth())/2,
					(int) (ApplicationView.displayH * .65), null);
		}
		quiteTextDraw(can);
	}

	public void quiteTextDraw(Canvas canvas) {

		
		pp.setAntiAlias(true);
		pp.setSubpixelText(true);
		
		pp.setStyle(Style.STROKE);
		pp.setStrokeWidth(3);
		
		
		
		wspp.setAntiAlias(true);
		wspp.setSubpixelText(true);
		wspp.setTypeface(AppActivity.text);
		pp.setTypeface(AppActivity.text);
		
		if(ApplicationView.contxt.getString(R.string.wanttoquite).length()>18){
			
			pp.setTextSize(ApplicationView.displayH / 32);
			wspp.setTextSize(ApplicationView.displayH / 32);
			
		}
		wspp.setColor(ApplicationView.contxt.getResources().getColor(R.color.white));
		pp.setColor(ApplicationView.contxt.getResources().getColor(
				R.color.strokeColor ));
		
		canvas.drawText(ApplicationView.contxt.getString(R.string.wanttoquite),
				(float) ((ApplicationView.displayW*0.50) - (pp
						.measureText(ApplicationView.contxt
								.getString(R.string.wanttoquite)) * (0.50))),
				(float) ((ApplicationView.displayH * .22)),
				pp);
		canvas.drawText(ApplicationView.contxt.getString(R.string.wanttoquite),
				(float) ((ApplicationView.displayW*0.50) - wspp
						.measureText(ApplicationView.contxt
								.getString(R.string.wanttoquite)) * (0.50)),
				(float) ((ApplicationView.displayH * .22) ),
				wspp);
		
		
		
		wspp.setTextSize(ApplicationView.displayH / 22);
		pp.setTextSize(ApplicationView.displayH / 22);
		
		wspp.setColor(ApplicationView.contxt.getResources().getColor(R.color.strokeColor));
		pp.setColor(ApplicationView.contxt.getResources().getColor(
				R.color.white ));
		
		canvas.drawText(
				ApplicationView.contxt.getString(R.string.ok),
				(float) ((ApplicationView.displayW*0.50f) - (pp
						.measureText(ApplicationView.contxt.getString(R.string.ok)) * (0.50))),
				(float) ((ApplicationView.displayH * .33) ),
				pp);
		canvas.drawText(
				ApplicationView.contxt.getString(R.string.ok),
				(float) ((ApplicationView.displayW*0.50) - wspp
						.measureText(ApplicationView.contxt.getString(R.string.ok)) * (0.50)),
				(float) ((ApplicationView.displayH * .33) ),
				wspp);

		canvas.drawText(ApplicationView.contxt.getString(R.string.RateIt),
				(float) ((ApplicationView.displayW*0.50) - (pp
						.measureText(ApplicationView.contxt
								.getString(R.string.RateIt)) * (0.50))),
				(float) ((ApplicationView.displayH * .53) ),
				pp);
		canvas.drawText(ApplicationView.contxt.getString(R.string.RateIt),
				(float) ((ApplicationView.displayW*0.50) - wspp
						.measureText(ApplicationView.contxt
								.getString(R.string.RateIt)) * (0.50)),
				(float) ((ApplicationView.displayH * .53)),
				wspp);

		canvas.drawText(ApplicationView.contxt.getString(R.string.cancle),
				(float) ((ApplicationView.displayW*0.50) - pp.measureText(ApplicationView.contxt
						.getString(R.string.cancle)) * (0.50)),
				(float) (ApplicationView.displayH * .73), pp);
		canvas.drawText(
				ApplicationView.contxt.getString(R.string.cancle),
				(float) ((ApplicationView.displayW*0.50) - wspp
						.measureText(ApplicationView.contxt.getString(R.string.cancle)) * (0.50)),
				(float) (ApplicationView.displayH * .73), wspp);

	}

	public boolean exitTouch(MotionEvent event) {

		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			xx = (int) event.getX();
			yy = (int) event.getY();

			ok = new Rect((int) ((int) (ApplicationView.displayW -LoadImage.button.getWidth())/2),
					(int) (ApplicationView.displayH * .25),
					(int) ((int) (ApplicationView.displayW -LoadImage.button1.getWidth())/2)
							+ LoadImage.button.getWidth(),
					(int) (ApplicationView.displayH * .25)
							+ LoadImage.button1.getHeight());

			rateit = new Rect((int) ((int) (ApplicationView.displayW -LoadImage.button.getWidth())/2),
					(int) (ApplicationView.displayH * .45),
					(int) ((int) (ApplicationView.displayW -LoadImage.button1.getWidth())/2)
							+ LoadImage.button.getWidth(),
					(int) (ApplicationView.displayH * .45)
							+ LoadImage.button1.getHeight());

			cancle = new Rect((int) ((int) (ApplicationView.displayW -LoadImage.button.getWidth())/2),
					(int) (ApplicationView.displayH * .65),
					(int) ((int) (ApplicationView.displayW -LoadImage.button1.getWidth())/2)
							+ LoadImage.button.getWidth(),
					(int) (ApplicationView.displayH * .65)
							+ LoadImage.button1.getHeight());
			if (ok.contains(xx, yy)) {
				isOkBtnPressed = true;
			} else if (rateit.contains(xx, yy)) {
				isRateBtnPressed = true;
			} else if (cancle.contains(xx, yy)) {
				isCancleBtnPressed = true;
			}
		}
		if (event.getAction() == MotionEvent.ACTION_UP) {
			xx = (int) event.getX();
			yy = (int) event.getY();

			if (isOkBtnPressed) {
				isOkBtnPressed = false;
			} else if (isRateBtnPressed) {
				isRateBtnPressed = false;
			} else if (isCancleBtnPressed) {
				isCancleBtnPressed = false;
			}
			if (ok.contains(xx, yy)) {
				ApplicationView.isQuitPage = false;
				AppActivity rpo = (AppActivity) ApplicationView.contxt;
				rpo.quit();
				rpo = null;
			} else if (rateit.contains(xx, yy)) {
				ApplicationView.isQuitPage = false;
				ApplicationView.isMianPage = true;

				Intent l = new Intent("android.intent.action.VIEW",
						Uri.parse(Data.RateUrl));
				ApplicationView.contxt.startActivity(l);
				AppActivity rpo = (AppActivity) ApplicationView.contxt;
				rpo.quit();
				rpo = null;

			} else if (cancle.contains(xx, yy)) {
				ApplicationView.isQuitPage = false;
				ApplicationView.isMianPage = true;
			}

		}

		return true;
	}

}
