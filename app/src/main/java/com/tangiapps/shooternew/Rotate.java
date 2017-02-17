package com.tangiapps.shooternew;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;

public class Rotate {

	public Bitmap getRotedImage(Bitmap bitmap, int orientation) {
		int rotation = orientation;
//		switch (orientation) {
//		case 270:
//			rotation = 270;
//			break;
//		case 180:
//			rotation = 180;
//			break;
//		case 90:
//			rotation = 90;
//			break;
//		case -270:
//			rotation = -270;
//			break;
//		case -180:
//			rotation = -180;
//			break;
//		case -90:
//			rotation = -90;
//			break;
//		default:
//			rotation = 0;
//			break;
//		}
		int w = bitmap.getWidth();
		int h = bitmap.getHeight();
		Matrix mtx = new Matrix();
		//mtx.postRotate(rotation-90,ApplicationView.cX,ApplicationView.cY);
		mtx.postRotate(rotation,ApplicationView.cX,ApplicationView.cY);

		//return Bitmap.createBitmap(bitmap, 0, 0, w, h, mtx, true);
		return Bitmap.createBitmap(bitmap,0,0,w,h,mtx,true);

	}

	public Rect getRect(Rect rect, int orientation) {
		int rotation = orientation;
		Rect r;
//		switch (orientation) {
//		case 270:
//			rotation = 270;
//			break;
//		case 180:
//			rotation = 180;
//			break;
//		case 90:
//			rotation = 90;
//			break;
//		case -270:
//			rotation = -270;
//			break;
//		case -180:
//			rotation = -180;
//			break;
//		case -90:
//			rotation = -90;
//			break;
//		default:
//			rotation = 0;
//			break;
//		}
		int w = rect.width();
		int h = rect.height();
		Matrix mtx = new Matrix();
		//mtx.postRotate(rotation-90,ApplicationView.cX,ApplicationView.cY);
		mtx.postRotate(rotation,ApplicationView.cX,ApplicationView.cY);
		r=new Rect();
		//return Bitmap.createBitmap(bitmap, 0, 0, w, h, mtx, true);
		return r ;

	}

}
