package com.tangiapps.shooternew;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RoundRectShape;

import java.text.DecimalFormat;
import java.util.ArrayList;

import static android.graphics.RectF.intersects;
import static com.tangiapps.shooternew.ApplicationView.balls;

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




    void identify(int index, int p) {
        ArrayList<Integer> b1 = new ArrayList<>();
        ArrayList<Integer> b2 = new ArrayList<>();
        ArrayList<Integer> finalList = new ArrayList<>();
        // finalList.add(p);
        //int above=0,below=0;
        // boolean aflag=false,bflag=false,flag = false,right,left,aright,aleft,bright,bleft;
        Object[] array = new Object[1];
        array[0] = p;
        int pos1;
        RectF rec1 = new RectF();
        boolean aflag=true;
        int count=0;
        while (aflag) {

            for (int i = 0; i < array.length; i++) {
                pos1 = (int) array[i];
                rec1.set(balls.get(pos1).rec);
                // setBoolean(pos1);
                count=0;
                for (int j = 0; j < balls.size(); j++) {

                    if (balls.get(j).isAvailable&&balls.get(j).index==index&&intersects(balls.get(j).rec,rec1)) {
                        b1.add(j);
                        count++;
                    }
                }
                //if (count==)
                rec1.setEmpty();
            }

            for (int i = 0; i < b1.size(); i++) {
                if (finalList.contains(b1.get(i))) {
                    continue;
                }
                if (balls.get(b1.get(i)).isAvailable) {
                    if (index == balls.get(b1.get(i)).index) {
                        b2.add(b1.get(i));
                        balls.get(b1.get(i)).isAvailable = false;
                    }
                }
            }


            if (!b2.isEmpty()) {
                finalList.addAll(b2);
                array = b2.toArray();
                b1.clear();
                b2.clear();
            } else {
                aflag = false;
            }

        }

        for (int i = 0; i < finalList.size(); i++) {
            balls.get(finalList.get(i)).isVisible=false;
        }

    }

void dest(){

    for (int i1=balls.size()-1;i1>-1;i1--){
        ArrayList<Integer> b1 = new ArrayList<>();
        ArrayList<Integer> b2 = new ArrayList<>();
        ArrayList<Integer> finalList = new ArrayList<>();
        ArrayList<Integer> covered = new ArrayList<>();
        ArrayList<Integer> bared = new ArrayList<>();

        // finalList.add(p);
        //int above=0,below=0;
        // boolean aflag=false,bflag=false,flag = false,right,left,aright,aleft,bright,bleft;
        Object[] array = new Object[1];
        array[0] = i1;
        int pos1;
        RectF rec1 = new RectF();
        boolean aflag=true;
int count=0;

        while (aflag) {

            for (int i = 0; i < array.length; i++) {
                pos1 = (int) array[i];
                rec1.set(balls.get(pos1).rec);
                count=0;
                for (int j = 0; j < balls.size(); j++) {
                    if (balls.get(j).isVisible&&intersects(balls.get(j).rec,rec1)) {
                        b1.add(j);
                        count++;
                    }
                }
                if (count==6){
                    covered.add(pos1);
                }
                rec1.setEmpty();
            }

            for (int i = 0; i < b1.size(); i++) {
                if (finalList.contains(b1.get(i))) {
                    continue;
                }
                //if (balls.get(b1.get(i)).rowNo>) {
                   // if (index == balls.get(b1.get(i)).index) {
                        b2.add(b1.get(i));
                        balls.get(b1.get(i)).isAvailable = false;
                    }
                //}
            }


            if (!b2.isEmpty()) {
                finalList.addAll(b2);
                array = b2.toArray();
                b1.clear();
                b2.clear();
            } else {
                aflag = false;
            }

        }

//        for (int i = 0; i < finalList.size(); i++) {
//            balls.get(finalList.get(i)).isVisible=false;
//        }

    }
} 






