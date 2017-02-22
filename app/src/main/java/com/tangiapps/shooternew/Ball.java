package com.tangiapps.shooternew;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;

import static com.tangiapps.shooternew.LoadImage.ballImg;
import static com.tangiapps.shooternew.LoadImage.bubble;

//import static com.tangiapps.tangiappsformate.LoadImage.ballImg;


public class Ball {
    float x,y,x1,y1;
    int index;
    int pos;
    boolean isVisible,isBurst;
    boolean isAvailable;
    boolean isClick;
    RectF rec=new RectF();
    float disH= (float) ApplicationView.displayH;
    float disW= (float) ApplicationView.displayW;

    Ball(double x1, double y1, int index1, boolean a){
        x= (float) x1;
        y= (float) y1;
        index=index1;
        isVisible=a;
        isBurst=false;
        isAvailable=a;

        //For rectangle
        rec=new RectF(x+6,y+6, x+ ballImg[index].getWidth()-6,y+ ballImg[index].getHeight()-6);

    }
    Ball(float x1,float y1, boolean a){
        x=x1;
        y=y1;
        isVisible=a;
        isBurst=false;

        rec=new RectF(x,y, x+ bubble.getWidth(),y+ bubble.getHeight());

    }
    void ballanim(Canvas c ){
      //  x1=b.x;
        //y1=b.y;
        if (x<disW&&y<disH){


              /*  x-=Math.cos(35);
                y-=Math.sin(64);
                c.drawBitmap(LoadImage.ballImg[index], x,y, null);*/



            x-=1;
            y+=disH*0.00875f;

            c.drawBitmap(ballImg[index], x,y, null);
        }



    }


}
