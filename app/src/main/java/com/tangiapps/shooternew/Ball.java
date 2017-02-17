package com.tangiapps.shooternew;

import android.graphics.Canvas;
import android.graphics.Rect;

import static com.tangiapps.shooternew.LoadImage.ballImg;
import static com.tangiapps.shooternew.LoadImage.bubble;

//import static com.tangiapps.tangiappsformate.LoadImage.ballImg;


public class Ball {
    int x,y,index,x1,y1;
    boolean isVisible,isBurst;
    boolean isLeaf;
    boolean isClick;
    Rect rec=new Rect();
    int disH= (int) ApplicationView.displayH;
    int disW= (int) ApplicationView.displayW;

    Ball(int x1, int y1, int index1, boolean a){
        x=x1;
        y=y1;
        index=index1;
        isVisible=a;
        isLeaf=false;
        //For rectangle
        rec=new Rect(x,y, x+ ballImg[index].getWidth(),y+ ballImg[index].getHeight());

    }
    Ball(int x1,int y1, boolean a){
        x=x1;
        y=y1;
        isVisible=a;
        isBurst=false;

        rec=new Rect(x,y, x+ bubble.getWidth(),y+ bubble.getHeight());

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
