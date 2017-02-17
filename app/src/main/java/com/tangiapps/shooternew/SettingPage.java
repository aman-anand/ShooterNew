package com.tangiapps.shooternew;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.view.MotionEvent;

public class SettingPage {
	Paint pp = new Paint();
	Paint wp = new Paint();
	Paint wspp = new Paint();

	static Rect resetgame, sound, home;
	int px = 0, py = 0;
	boolean isResetGameBtnPressed = false, isSoundBtnPressed = false,
			isHomePageBtnPressed = false;

	public void drawSettingPage(Canvas can) {
		pp.setColor(Color.BLUE);
		pp.setStyle(Style.STROKE);
		pp.setStrokeWidth(3);

		wp.setColor(Color.WHITE);
		wp.setAlpha(100);

		int left = (int) ((ApplicationView.displayW * 0.5) - (LoadImage.retry
				.getWidth() * 0.5));
		int top = (int) (0.35 * ApplicationView.displayH);
		int buttonh = LoadImage.retry.getHeight();
		int gap = (int) (ApplicationView.displayH / 15);

		can.drawBitmap(LoadImage.levelpage, 0, 0, null);

		Paint p = new Paint();
		p.setColor(Color.BLACK);
		p.setAlpha(225);
		Rect rect = new Rect((int) (0), (int) (0),
				(int) (ApplicationView.displayW),
				(int) (ApplicationView.displayH));
		can.drawRect(rect, p);

		if (isResetGameBtnPressed == false) {
			can.drawBitmap(LoadImage.retry, left, top, AppActivity.cls);
		} else {
			can.drawBitmap(LoadImage.retry1, left, top, AppActivity.cls);

		}

		if (ApplicationView.isSoundOn == true ) {
			can.drawBitmap(LoadImage.soundon, left, top + buttonh + gap,
					AppActivity.cls);
		} else {
			can.drawBitmap(LoadImage.soundon1, left, top + buttonh + gap,
					AppActivity.cls);
		}
		
		if (isHomePageBtnPressed) {
		can.drawBitmap(LoadImage.home1 , left, top + buttonh*2 + gap*2, AppActivity.cls);
		
		} else {
		can.drawBitmap(LoadImage.home , left, top + buttonh*2 + gap*2, AppActivity.cls);
		
	//	wp.setColor(Color.RED);
	//	wp.setStrokeWidth(3);
		//can.drawLine(left+LoadImage.soundon.getWidth()*.25f, top + buttonh + gap+LoadImage.soundon.getHeight()*.25f,left+LoadImage.soundon.getWidth()*.75f, top + buttonh + gap+LoadImage.soundon.getHeight()*.75f, wp);
		
		}	
		
		

		pp.setAntiAlias(true);
		pp.setSubpixelText(true);

		pp.setStyle(Style.STROKE);
		pp.setStrokeWidth(2);
		pp.setColor(ApplicationView.contxt.getResources().getColor(
				R.color.strokeColor ));

		wspp.setAntiAlias(true);
		wspp.setSubpixelText(true);

		wspp.setColor(ApplicationView.contxt.getResources().getColor(
				R.color.white));

		pp.setTextSize(ApplicationView.displayH / 15);
		wspp.setTextSize(ApplicationView.displayH / 15);

		wspp.setTypeface(AppActivity.text);
		pp.setTypeface(AppActivity.text);

		can.drawText(ApplicationView.contxt.getString(R.string.setting),
				(float) (ApplicationView.displayW * (0.5) - (pp
						.measureText(ApplicationView.contxt
								.getString(R.string.setting)) * (0.5))),
				(float) (ApplicationView.displayH * .3), pp);

		can.drawText(ApplicationView.contxt.getString(R.string.setting),
				(float) ((ApplicationView.displayW * .5) - (pp
						.measureText(ApplicationView.contxt
								.getString(R.string.setting)) * (0.5))),
				(float) (ApplicationView.displayH * .3), wspp);

	}

	public boolean settingTouch(MotionEvent event) {

		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			px = (int) event.getX();
			py = (int) event.getY();
			int left = (int) ((ApplicationView.displayW * 0.5) - (LoadImage.retry
					.getWidth() * 0.5));
			int top = (int) (0.35 * ApplicationView.displayH);
			int buttonw = LoadImage.retry.getWidth();
			int buttonh = LoadImage.retry.getHeight();
			int gap = (int) (ApplicationView.displayH / 15);

			resetgame = new Rect(left, top, left + buttonw, top + buttonh);

			sound = new Rect(left, top + buttonh + gap, left + buttonw, top + 2
					* buttonh + gap);
			home = new Rect(left, top + buttonh*2 + gap*2, left + buttonw, top + 3
					* buttonh + 2*gap);

			if (resetgame.contains(px, py)) {
			} else if (home.contains(px, py)) {
				isHomePageBtnPressed = true;
			}
			else if (sound.contains(px, py)) {
				isSoundBtnPressed = true;
			}
		}
		if (event.getAction() == MotionEvent.ACTION_UP) {
			px = (int) event.getX();
			py = (int) event.getY();

			if (isResetGameBtnPressed) {

				isResetGameBtnPressed = false;
			} else if (isHomePageBtnPressed) {

				isHomePageBtnPressed = false;
			}
			else if (isSoundBtnPressed) {
			
			isSoundBtnPressed = false;
		}
			if (resetgame.contains(px, py)) {

				AppActivity.appLevel = 1;
				ApplicationView.levelno = 1;

				AppActivity rpo = (AppActivity) ApplicationView.contxt;
				rpo.saveApplicationState();

				ApplicationView.isSettingPage = false;
				ApplicationView.isOptionPage = false;

				ApplicationView.isMianPage = false;
				ApplicationView.isResetAppLevel = true;
				ApplicationView.isLevelPage = true;
			

			} else if (home.contains(px, py)) {
				MainPage.isHomeTouch = true;
				ApplicationView.isOptionPage = false;
				ApplicationView.isSettingPage = false;

			}
			else if (sound.contains(px, py)) {
			
			if (ApplicationView.isSoundOn == true) {
				ApplicationView.isSoundOn = false;
			} else {
				ApplicationView.isSoundOn = true;
			}
		}

		}

		return true;
	}

}
