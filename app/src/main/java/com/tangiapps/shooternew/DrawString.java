package com.tangiapps.shooternew;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;

public class DrawString {
	public float blockW, blockH;
	Paint lp = new Paint();
	Paint wslp = new Paint();



	

	

	public void drawString(Canvas c) {
		blockW = ApplicationView.blockW;
		blockH = ApplicationView.blockH;
		

		lp.setTypeface(AppActivity.text);
		wslp.setTypeface(AppActivity.text);
		lp.setAntiAlias(true);
		lp.setSubpixelText(true);
		lp.setColor(ApplicationView.contxt.getResources().getColor(
				R.color.white ));
		lp.setStyle(Style.STROKE);
		lp.setStrokeWidth(2);

	
		lp.setTextSize(ApplicationView.displayH / 24);
		wslp.setTextSize(ApplicationView.displayH / 24);
		wslp.setAntiAlias(true);
		wslp.setSubpixelText(true);
		wslp.setColor(ApplicationView.contxt.getResources().getColor(R.color.strokeColor));

		c.drawText(ApplicationView.contxt.getString(R.string.Level) + ": "
				+ ApplicationView.levelno,
				(int) ((ApplicationView.displayW * (.2)) - ((lp
						.measureText(ApplicationView.contxt.getString(R.string.Level)
								+ ": " + ApplicationView.levelno)) * (0.50))),
				(float) (ApplicationView.displayH * .14), lp);

		c.drawText(ApplicationView.contxt.getString(R.string.Level) + ": "
				+ ApplicationView.levelno,
				(int) ((ApplicationView.displayW * (.2)) - ((wslp
						.measureText(ApplicationView.contxt.getString(R.string.Level)
								+ ": " + ApplicationView.levelno)) * (0.50))),
				(float) (ApplicationView.displayH * .14), wslp);

		
//		c.drawText(ApplicationView.contxt.getString(R.string.moves) + ": "
//				+ ApplicationView.moves,
//				(int) ((ApplicationView.displayW * (.55)) - ((lp
//						.measureText(ApplicationView.contxt.getString(R.string.moves)
//								+ ": " + ApplicationView.moves)) * (0.50))),
//				(float) (ApplicationView.displayH * .14), lp);
//
//		
//		c.drawText(ApplicationView.contxt.getString(R.string.moves) + ": "
//				+ ApplicationView.moves,
//				(int) ((ApplicationView.displayW * (.55)) - ((lp
//						.measureText(ApplicationView.contxt.getString(R.string.moves)
//								+ ": " + ApplicationView.moves)) * (0.50))),
//				(float) (ApplicationView.displayH * .14), wslp);
//		
//		
//		c.drawText(ApplicationView.contxt.getString(R.string.score) + ": "
//				+ ApplicationView.total_score,
//				(int) ((ApplicationView.displayW * (.5)) - ((lp
//						.measureText(ApplicationView.contxt.getString(R.string.score) + ": "
//								+ ApplicationView.total_score
//								)) * (0.50))),
//				(float) (ApplicationView.displayH * .88), lp);
//
//		
//		c.drawText(ApplicationView.contxt.getString(R.string.score) + ": "
//				+ ApplicationView.total_score,
//				(int) ((ApplicationView.displayW * (.5)) - ((lp
//						.measureText(ApplicationView.contxt.getString(R.string.score) + ": "
//								+ ApplicationView.total_score
//								)) * (0.50))),
//				(float) (ApplicationView.displayH * .88), wslp);

		
		

	}
}
