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
    boolean a =false;
   boolean check_col(RectF r1, RectF r2){
       float centerX,centerY,centerX1,centerY1;
       radius=LoadImage.ballImg[3].getWidth()/2;
       radius*=2.5;
       centerX=r1.centerX();
       centerY=r1.centerY();
       centerX1=r2.centerX();
       centerY1=r2.centerY();
       double distance = Math.sqrt(Math.pow((centerX1 - centerX), 2) + Math.pow((centerY1 - centerY), 2));
       distance= Float.parseFloat(new DecimalFormat("##.##").format(distance));
       if (distance>(radius)){
         a= false;
       }
       if (distance<=(radius)) {
         a= true;
       }
       return a;

   }


//        if (interse) {
//            int k1=0;
//            for (int i=0;i<balls.size();i++){
//                if (!balls.get(i).isVisible){
//                    continue;
//                }
//                if(intersects(balls.get(i).rec,shotBall)){
//
//
//                    if (balls.get(i).index==ball.index) {
//
//                        collision=circle.check_col(balls.get(i).rec, shotBall);
//
//                        //System.out.println("intersection");
//                        k1 = i;
//                        break;
//                    }
//                    if (balls.get(i).index!=ball.index){
//                        newsetter=circle.check_col(balls.get(i).rec, shotBall);
//                        if (i>row_count*(col_count-1)){
//
//                            if (newsetter) {
//                                //__________________________________________________________________________________for putting a ball inside the matrix write code??????////
//                                //balladd(i, balls.get(i), ball);
//                                balls.add(new Ball(lx,ly,ball.index,true,i+col_count));
//                                endshoot=true;
//                                // ApplicationView.shoot = false;
//                                newsetter=false;
//                            }
//                        }
//                        else{
//                            for (int j=0;j<balls.size();j++){
//                                if (!balls.get(i).isVisible&&balls.get(i).rec.contains(shotBall)){
//                                    balls.get(i).index=ball.index;
//                                    balls.get(i).isVisible=true;
//                                    balls.get(i).isAvailable=true;
//                                }
//                            }
//
//                        }
//
//
//                    }
//                    // if ()
//                }
//            }
//            if (collision){
//                identify(balls.get(k1).index,balls.get(k1).pos);
//                endshoot=true;
//                // ApplicationView.shoot = false;
//                collision=false;
//
//                //return;
//            }
//            if (y > -1 && y <= displayH) {
//                ApplicationView.shoot = false;
//            }
//    }






}
