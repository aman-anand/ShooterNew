package com.tangiapps.shooternew;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.shapes.Shape;

import org.jetbrains.annotations.Contract;

import java.util.ArrayList;

import static com.tangiapps.shooternew.ApplicationView.balls;
import static com.tangiapps.shooternew.ApplicationView.cX;
import static com.tangiapps.shooternew.ApplicationView.cY;
import static com.tangiapps.shooternew.ApplicationView.col_count;
import static com.tangiapps.shooternew.ApplicationView.displayW;
import static com.tangiapps.shooternew.ApplicationView.row_count;

/**
 * Created by PC-T3 on 2/13/2017.
 */

public class BallPath {
//    Bitmap ball=LoadImage.ballImg[3];
//
////    public void setBall(Bitmap ball) {
////        this.ball = ball;
////    }
//
//    boolean flag;
//    double slope1;
//    float y,x=cX;
//float xb=cX,yb=cY;
//    ArrayList<Point> amama=new ArrayList<Point>();
//
//
//    void balldraw(Canvas c,double slope,boolean vv){
//        slope1=slope;
//        flag=vv;
//
//        c.drawBitmap(ball,cX-ball.getWidth()/2,cY-ball.getHeight()/2,null);
//        if (flag){
//          y=  pointL(x,xb+ball.getWidth()/2,yb+ball.getHeight()/2,slope1);
//            c.drawBitmap(ball,xb+ball.getWidth()/2,yb+ball.getHeight()/2,null);
//            xb--;
//            yb=y;
//            if ((xb+ball.getWidth()/2)<0){
//                flag=false;
//                slope1*=-1;
//            }
//        }
//        else{
//            y=  pointR(x,xb,yb,slope1);
//            c.drawBitmap(ball,xb+ball.getWidth()/2,yb+ball.getHeight()/2,null);
//            xb++;
//            yb=y;
//            if ((xb+ball.getWidth()/2)<displayW){
//                flag=true;
//                slope1*=-1;
//            }
//        }
//    }
//
////x1- cord of x at which y is to be found
//    private float pointL(float x1,float xStsart, float yStart, double slope){
//        // flag=false;
//        float y11= (float) ((slope*(x1-xStsart))+yStart);
//        return y11;
//    }
//    @Contract(pure = true)
//    private float pointR(float x1,float xStsart, float yStart, double slope){
//        // flag=true;
//        float y11= (float) ((slope*(x1 - xStsart))+yStart);
//        return y11;
//    }



    //___________________________________________________________________________________________________________________________________________________
//    public Shape s=new Shape() {
//        @Override
//        public void draw(Canvas canvas, Paint paint) {
//
//        }
//    };
//
//    void collision(Rect ball,Rect lvl){
//        PointF c1;PointF c2;
//        float speed=0;
//        c1=new PointF();
//        c2=new PointF();
//        c1.x=ball.exactCenterX();
//        c1.y=ball.exactCenterY();
//        c2.x=lvl.exactCenterX();
//        c2.y=lvl.exactCenterY();
//        LineC.distanceCalc(c1,c2);
//        speed++;
//
//
//    }




    private void identify(int index, int pos) {
        ArrayList<Integer> buffer1 = new ArrayList<>();
        ArrayList<Integer> buffer2 = new ArrayList<>();
        ArrayList<Integer> finalList = new ArrayList<>();
        finalList.add(pos);
        int step = col_count;
        int above = pos - step, below = pos + step;
        Object[] array = new Object[1];
        int pointsBuffer;
        //System.out.println("index  " + index + "   position  " + position);
        //balls.get(position).isVisible = false;
        // int pos = position;
        boolean flag = true;
        array[0] = pos;


        while (flag) {
            for (int i = 0; i < array.length; i++) {
                pos = (int) array[i];
                if (pos + 1 < (row_count * col_count) && (pos + 1) % col_count != 0) {//checks at position right to the clicked position
                    if (balls.get(pos + 1).isVisible && index == balls.get(pos + 1).index) {
                        buffer1.add(pos + 1);
                        balls.get(pos + 1).isVisible = false;
                        //System.out.println("1 at pos   " + (pos + 1));

                    }
                }
                if (pos + step < (row_count * col_count)) {//checks at position below the clicked position
                    if (balls.get(pos + step).isVisible && index == balls.get(pos + step).index) {
                        buffer1.add(pos + step);
                        balls.get(pos + step).isVisible = false;
                        //System.out.println("3 at pos   " + (pos + step));
                    }
                }
                boolean stepb = false;
                int c12 = 0;
                for (int q = col_count - 1; q < (row_count * col_count); q += step) {
                    if (pos - 1 == q) {
                        c12++;
                    }
                }
                if (c12 > 0) {
                    stepb = false;
                } else {
                    stepb = true;
                }
                if (pos - 1 >= 0 && stepb) {//checks at position left to the clicked position


                    if (balls.get(pos - 1).isVisible && index == balls.get(pos - 1).index) {
                        buffer1.add(pos - 1);
                        balls.get(pos - 1).isVisible = false;
                        //System.out.println("2 at pos   " + (pos - 1));
                    }
                }


                if (pos - step >= 0) {//checks at position above the clicked position
                    if (balls.get(pos - step).isVisible && index == balls.get(pos - step).index) {
                        buffer1.add(pos - step);
                        balls.get(pos - step).isVisible = false;
                        //System.out.println("4 at pos   " + (pos - 8));
                    }
                }

                //______________________________for checking right and left of above position_________________________________________________________________________
                if (above + 1 < (row_count * col_count) && (above + 1) % col_count != 0&&(above+1)>0) {//checks at aboveition right to the clicked aboveition
                    if (balls.get(above + 1).isVisible && index == balls.get(above + 1).index) {
                        buffer1.add(above + 1);
                        balls.get(above + 1).isVisible = false;
                        //System.out.println("1 at above   " + (above + 1));

                    }
                }

                stepb = false;
                c12 = 0;
                for (int q = col_count - 1; q < (row_count * col_count); q += step) {
                    if (above - 1 == q) {
                        c12++;
                    }
                }
                if (c12 > 0) {
                    stepb = false;
                } else {
                    stepb = true;
                }
                if (above - 1 >= 0 && stepb) {//checks at aboveition left to the clicked aboveition


                    if (balls.get(above - 1).isVisible && index == balls.get(above - 1).index) {
                        buffer1.add(above - 1);
                        balls.get(above - 1).isVisible = false;
                        //System.out.println("2 at above   " + (above - 1));
                    }
                }
                //_________________________________for checking right and left of below position___________________________________________________________________________________________
                if (below + 1 < (row_count * col_count) && (below + 1) % col_count != 0) {//checks at position right to the clicked position
                    if (balls.get(below + 1).isVisible && index == balls.get(below + 1).index) {
                        buffer1.add(below + 1);
                        balls.get(below + 1).isVisible = false;
                        //System.out.println("1 at below   " + (below + 1));

                    }
                }

                stepb = false;
                c12 = 0;
                for (int q = col_count - 1; q < (row_count * col_count); q += step) {
                    if (below - 1 == q) {
                        c12++;
                    }
                }
                if (c12 > 0) {
                    stepb = false;
                } else {
                    stepb = true;
                }
                if (below - 1 >= 0 && stepb) {//checks at belowition left to the clicked belowition


                    if (balls.get(below - 1).isVisible && index == balls.get(below - 1).index) {
                        buffer1.add(below - 1);
                        balls.get(below - 1).isVisible = false;
                        //System.out.println("2 at below   " + (below - 1));
                    }
                }


            }

//           if (buffer1.isEmpty()) {
//               var++;
//               if (var == 2) {
//                   flag = false;
//               }
//           }
            //for adding the unique members of buffer1 to finalList
            for (int j = 0; j < buffer1.size(); j++) {
                ////System.out.println("Search path:: for loop 2nd");
                if (finalList.contains(buffer1.get(j))) {
                    continue;
                } else {
                    buffer2.add(buffer1.get(j));
                    //System.out.println("added to bfr 2     "+(buffer2.get(j)));
                }
            }


            if (!buffer2.isEmpty()) {
                finalList.addAll(buffer2);
                array = buffer2.toArray();
                buffer1.clear();
                buffer2.clear();
            } else
                flag = false;



        }
        for (int i=0;i<finalList.size();i++){
            balls.get(finalList.get(i)).isBurst=true;
        }
        //collision=false;

    }


    void ident(int index,int p){


    }



}
