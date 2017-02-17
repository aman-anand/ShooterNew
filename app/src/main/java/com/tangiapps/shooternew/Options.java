package com.tangiapps.shooternew;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.view.MotionEvent;

public class Options {

	static Rect help, about, setting;
	static boolean isAboutPage = false, isSettingPage = true,
			isHelpPage = false, isOptionTouch = true;
	boolean isSettingBtnPressed = false, isAboutBtnPressed = false,
			isHelpBtnPressed = false;
	Paint pp = new Paint();
	Paint wspp = new Paint();
	int ne_x, ne_y;

	public void drawOptionPage(Canvas canv) {

		if (isAboutPage) {
			drawAboutPage(canv);
		} else if (isHelpPage) {
			drawHelpPage(canv);
		} else {

			canv.drawBitmap(LoadImage.levelpage, 0, 0, null);

			Rect rect = new Rect((int) (0), (int) (0),
					(int) (ApplicationView.displayW),
					(int) (ApplicationView.displayH));

			Paint p = new Paint();
			p.setColor(Color.BLACK);
			p.setAlpha(225);

			canv.drawRect(rect, p);

			if (isAboutBtnPressed == false) {
				canv.drawBitmap(LoadImage.button,
						(int) (ApplicationView.displayW - LoadImage.button1
								.getWidth()) / 2,
						(int) (ApplicationView.displayH * .22), null);
			} else {
				canv.drawBitmap(LoadImage.button1,
						(int) (ApplicationView.displayW - LoadImage.button
								.getWidth()) / 2,
						(int) (ApplicationView.displayH * .22), null);

			}

			if (isHelpBtnPressed == false) {
				canv.drawBitmap(LoadImage.button,
						(int) (ApplicationView.displayW - LoadImage.button1
								.getWidth()) / 2,
						(int) (ApplicationView.displayH * .38), null);
			} else {
				canv.drawBitmap(LoadImage.button1,
						(int) (ApplicationView.displayW - LoadImage.button
								.getWidth()) / 2,
						(int) (ApplicationView.displayH * .38), null);

			}

			if (isSettingBtnPressed == false) {
				canv.drawBitmap(LoadImage.button,
						((int) (ApplicationView.displayW - LoadImage.button1
								.getWidth()) / 2),
						(int) (ApplicationView.displayH * .53), null);
			} else {
				canv.drawBitmap(LoadImage.button1,
						(int) (ApplicationView.displayW - LoadImage.button
								.getWidth()) / 2,
						(int) (ApplicationView.displayH * .53), null);

			}

			menudraw(canv);
		}
	}

	private void drawAboutPage(Canvas canv) {
		Paint paint = new Paint();
		paint.setStyle(Style.FILL);
		paint.setTextSize(ApplicationView.displayH / 12);
		paint.setAntiAlias(true);
		paint.setTypeface(AppActivity.text);
		paint.setColor(Color.WHITE);
		canv.drawBitmap(LoadImage.levelpage, 0, 0, null);
		Rect rect = new Rect((int) (0), (int) (0),
				(int) (ApplicationView.displayW),
				(int) (ApplicationView.displayH));

		Paint p = new Paint();
		p.setColor(Color.BLACK);
		p.setAlpha(225);

		canv.drawRect(rect, p);
		canv.drawText(ApplicationView.contxt.getString(R.string.about),
				(int) (((ApplicationView.displayW * (0.5)) - (paint
						.measureText(ApplicationView.contxt
								.getString(R.string.about)) * (0.5)))),
				ApplicationView.displayH *.25f, paint);
		Paint paint1 = new Paint();
		paint1.setStyle(Style.FILL);
		paint1.setTextSize(ApplicationView.displayH / 30);
		paint1.setAntiAlias(true);

		paint1.setTypeface(AppActivity.text);
		paint1.setColor(Color.WHITE);

		String[] lines = ApplicationView.contxt.getString(R.string.abouttext)
				.split("9");

		float yoffset = (float) ((ApplicationView.displayH *.25f) + ((ApplicationView.displayW * (.1))));

		canv.drawText(lines[0],
				(int) ((ApplicationView.displayW * (0.5)) - (paint1
						.measureText(lines[0]) * (0.5))),

				(float) (yoffset * 1.2), paint1);

		for (int i = 1; i < lines.length; i++) {
			yoffset += -paint1.ascent() + paint1.descent();
			canv.drawText(lines[i],
					(int) ((ApplicationView.displayW * (0.5)) - (paint1
							.measureText(lines[i]) * (0.5))),
					(float) (yoffset * 1.2), paint1);
		}

	}

	private void drawHelpPage(Canvas canv) {

		Paint paint = new Paint();
		paint.setStyle(Style.FILL);
		paint.setTextSize(ApplicationView.displayH / 20);
		paint.setAntiAlias(true);

		paint.setTypeface(AppActivity.text);
		paint.setColor(Color.WHITE);
		canv.drawBitmap(LoadImage.levelpage, 0, 0, null);
		Rect rect = new Rect((int) (0), (int) (0),
				(int) (ApplicationView.displayW),
				(int) (ApplicationView.displayH));

		Paint p = new Paint();
		p.setColor(Color.BLACK);
		p.setAlpha(225);

		canv.drawRect(rect, p);
		canv.drawText(ApplicationView.contxt.getString(R.string.Help),
				(int) (((ApplicationView.displayW * (0.5)) - (paint
						.measureText(ApplicationView.contxt
								.getString(R.string.Help)) * (0.5)))),
				ApplicationView.displayH*.2f, paint);

		Paint paint1 = new Paint();
		paint1.setStyle(Style.FILL);
		paint1.setTextSize(ApplicationView.displayH / 30);
		paint1.setAntiAlias(true);

		paint1.setTypeface(AppActivity.text);
		paint1.setColor(Color.WHITE);

		String[] lines = ApplicationView.contxt.getString(R.string.helptext)
				.split("9");

		float yoffset = (float) ((ApplicationView.displayH*.2f) + ((ApplicationView.displayW * (.1))));

		canv.drawText(lines[0],
				(int) ((ApplicationView.displayW * (0.5)) - (paint1
						.measureText(lines[0]) * (0.5))),

				(float) (yoffset * 1.2), paint1);

		for (int i = 1; i < lines.length; i++) {
			yoffset += -paint1.ascent() + paint1.descent();
			
			canv.drawText(lines[i],
					(int) ((ApplicationView.displayW * (0.5)) - (paint1
							.measureText(lines[i]) * (0.5))),
					(float) (yoffset * 1.2), paint1);
		}
	}

	public boolean optionTouch(MotionEvent e) {

		about = new Rect((int) ((int) (ApplicationView.displayW * .15)),
				(int) (ApplicationView.displayH * .22),
				(int) ((int) (ApplicationView.displayW * .15))
						+ LoadImage.button.getWidth(),
				(int) (int) (ApplicationView.displayH * .22)
						+ LoadImage.button.getHeight());

		help = new Rect((int) ((int) (ApplicationView.displayW * .15)),
				(int) (ApplicationView.displayH * .38),
				((int) (ApplicationView.displayW * .15))
						+ LoadImage.button1.getWidth(),
				(int) (ApplicationView.displayH * .38)
						+ LoadImage.button.getHeight());

		setting = new Rect(((int) (ApplicationView.displayW * .15)),
				(int) (ApplicationView.displayH * .53),
				((int) (ApplicationView.displayW * .15))
						+ LoadImage.button.getWidth(),
				(int) (ApplicationView.displayH * .53)
						+ LoadImage.button.getHeight());

		
		if (isOptionTouch) {

			
			if (e.getAction() == MotionEvent.ACTION_DOWN) {
				ne_x = (int) e.getX();
				ne_y = (int) e.getY();
				if (Options.setting.contains(ne_x, ne_y)) {
					isSettingBtnPressed = true;
				} else if (Options.about.contains(ne_x, ne_y)) {
					isAboutBtnPressed = true;
				} else if (Options.help.contains(ne_x, ne_y)) {
					isHelpBtnPressed = true;
				}
			}

			if (e.getAction() == MotionEvent.ACTION_UP) {
				ne_x = (int) e.getX();
				ne_y = (int) e.getY();
				if (isSettingBtnPressed) {
					isSettingBtnPressed = false;
				} else if (isAboutBtnPressed) {
					isAboutBtnPressed = false;
				} else if (isHelpBtnPressed) {
					isHelpBtnPressed = false;
				}

				if (Options.about.contains(ne_x, ne_y)) {

					isAboutPage = true;

					isOptionTouch = false;
					

					

				} else if (Options.help.contains(ne_x, ne_y)) {

					
					// AppActivity activity = (AppActivity) ApplicationView.contxt;
					// activity.menuDailoge();
					isHelpPage = true;
					isOptionTouch = false;

				} else if (Options.setting.contains(ne_x, ne_y)) {
					
					ApplicationView.isSettingPage = true;
					MainPage.isHomeTouch = false;
					Options.isOptionTouch = false;

					
				}
			}

		}

		return true;
	}

	public void menudraw(Canvas canvas) {

		pp.setAntiAlias(true);
		pp.setSubpixelText(true);

		pp.setStyle(Style.STROKE);
		pp.setStrokeWidth(2);
		wspp.setColor(ApplicationView.contxt.getResources().getColor(
				R.color.white));

		wspp.setAntiAlias(true);
		wspp.setSubpixelText(true);

		pp.setColor(ApplicationView.contxt.getResources().getColor(
				R.color.strokeColor));

		pp.setTextSize(ApplicationView.displayH / 20);
		wspp.setTextSize(ApplicationView.displayH / 20);

		wspp.setTypeface(AppActivity.text);
		pp.setTypeface(AppActivity.text);

		wspp.setColor(ApplicationView.contxt.getResources().getColor(
				R.color.white));
		pp .setColor(ApplicationView.contxt.getResources()
				.getColor(R.color.strokeColor));

		canvas.drawText(ApplicationView.contxt.getString(R.string.option),
				(float) (ApplicationView.displayW * (0.5) - (pp
						.measureText(ApplicationView.contxt
								.getString(R.string.option)) * (0.5))),
				(float) (ApplicationView.displayH * .15), pp);

		canvas.drawText(ApplicationView.contxt.getString(R.string.option),
				(float) ((ApplicationView.displayW * .5) - (pp
						.measureText(ApplicationView.contxt
								.getString(R.string.option)) * (0.5))),
				(float) (ApplicationView.displayH * .15), wspp);

		pp.setTextSize(ApplicationView.displayH / 22);
		wspp.setTextSize(ApplicationView.displayH / 22);
		pp.setColor(ApplicationView.contxt.getResources().getColor(
				R.color.white));
		wspp.setColor(ApplicationView.contxt.getResources()
				.getColor(R.color.strokeColor));


		canvas.drawText(ApplicationView.contxt.getString(R.string.about),
				(float) (ApplicationView.displayW * (0.5) - (pp
						.measureText(ApplicationView.contxt
								.getString(R.string.about)) * (0.5))),
				(float) (ApplicationView.displayH * .29), pp);

		canvas.drawText(ApplicationView.contxt.getString(R.string.about),
				(float) ((ApplicationView.displayW * .5) - (pp
						.measureText(ApplicationView.contxt
								.getString(R.string.about)) * (0.5))),
				(float) (ApplicationView.displayH * .29), wspp);

		canvas.drawText(ApplicationView.contxt.getString(R.string.Help),
				(float) ((ApplicationView.displayW * .5) - (pp
						.measureText(ApplicationView.contxt
								.getString(R.string.Help)) * (0.5))),
				(float) (ApplicationView.displayH * .45), pp);
		canvas.drawText(ApplicationView.contxt.getString(R.string.Help),
				(float) ((ApplicationView.displayW * .5) - (wspp
						.measureText(ApplicationView.contxt
								.getString(R.string.Help)) * (0.5))),
				(float) (ApplicationView.displayH * .45), wspp);

		canvas.drawText(ApplicationView.contxt.getString(R.string.setting),
				(float) ((ApplicationView.displayW * .5) - (pp
						.measureText(ApplicationView.contxt
								.getString(R.string.setting)) * (0.5))),
				(float) (ApplicationView.displayH * .6), pp);
		canvas.drawText(ApplicationView.contxt.getString(R.string.setting),
				(float) ((ApplicationView.displayW * .5) - (wspp
						.measureText(ApplicationView.contxt
								.getString(R.string.setting)) * (0.5))),
				(float) (ApplicationView.displayH * .6), wspp);

	}

}
