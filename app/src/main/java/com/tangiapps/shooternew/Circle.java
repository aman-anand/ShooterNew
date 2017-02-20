package com.tangiapps.shooternew;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RoundRectShape;

import java.text.DecimalFormat;

/**
 * Created by aMaN on 2/18/2017.
 */

public class Circle extends ShapeDrawable {
RectF ball1,ball2;
    float radius;
   boolean check_col(RectF r1, RectF r2){
       float centerX,centerY,centerX1,centerY1;
       radius=LoadImage.ballImg[3].getWidth()/2;
       centerX=r1.centerX();
       centerY=r1.centerY();
       centerX1=r2.centerX();
       centerY1=r2.centerY();
       double distance = Math.sqrt(Math.pow((centerX1 - centerX), 2) + Math.pow((centerY1 - centerY), 2));
      // distance= Float.parseFloat(new DecimalFormat("##.##").format(distance));
       if (distance>(radius*2)){
           return false;
       }
       if (distance<=(radius*2)) {
           return true;
       }
       return false;
   }

}
