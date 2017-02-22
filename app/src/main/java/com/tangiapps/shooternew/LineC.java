package com.tangiapps.shooternew;


import android.graphics.Canvas;
import android.graphics.Path;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;


import java.text.DecimalFormat;
import java.util.ArrayList;

import static android.graphics.RectF.intersects;
import static com.tangiapps.shooternew.ApplicationView.cX;
import static com.tangiapps.shooternew.ApplicationView.cY;
import static com.tangiapps.shooternew.ApplicationView.col_count;
import static com.tangiapps.shooternew.ApplicationView.displayH;
import static com.tangiapps.shooternew.ApplicationView.displayW;
import static com.tangiapps.shooternew.ApplicationView.pp;
import static com.tangiapps.shooternew.ApplicationView.balls;
import static com.tangiapps.shooternew.ApplicationView.row_count;
import static com.tangiapps.shooternew.ApplicationView.xbuffer;
import static com.tangiapps.shooternew.ApplicationView.ybuffer;

/**
 * Created by PC-T3 on 2/11/2017.
 */



public class LineC {

    //______________________________Variables________________________________________________________
    Circle circle=new Circle();
   static float dx1, dy1, x, y;
    static double angle, slope;
    boolean flag;
    //Point p[] = new Point[2];
    Path path = new Path();
    float x22, y22;
    double slope1;
    static double slope2, dist;
    static boolean ballflag;
    private float lx, ly;
    //private BallPath ballPath;
    Ball ball;
    //Bitmap ball1 = LoadImage.ballImg[5];
    ArrayList<Double> dire= new ArrayList<>();
    //ArrayList<Double> direction= new ArrayList<>();
    static float xb, yb;
    RectF shotBall;
    static boolean collision,endshoot;
    double speed = 8;
    float xE = (float) (displayW * 0.0375);
    int i=0;

    LineC() {
        speed = displayH*0.009677;
        xb = cX;
        xE = (float) (displayW * 0.04166);
        yb = cY;
    }

    //__________________________________Methods_______________________________________________________
    void angleC(float dwnX, float dwnY) {
        ball = new Ball( 0,  0, 3,true );
        endshoot=false;
        collision=false;
        dire.clear();
        dx1 = cX;
        x22 = cX;
        y22 = cY;
        i=0;
        xbuffer = cX;
        ybuffer = cY;
        double xDiff = cX - dwnX;
        double yDiff = cY - dwnY;

        angle = Math.toDegrees(Math.atan2(yDiff, xDiff));
//        System.out.println("angle = " + angle);
        float xEnd = (int) (cX - (Math.cos(Math.toRadians(angle)) * 1500));
        float yEnd = (int) (cY - (Math.sin(Math.toRadians(angle)) * 1500));
//        System.out.println("xEnd = " + xEnd);
//        System.out.println("yEnd = " + yEnd);
        if (xEnd < displayW / 2) {
            flag = true;
            ballflag = true;
        } else {
            flag = false;
            ballflag = false;

        }
        slope = (cY - yEnd);
        slope /= (cX - xEnd);
        slope1 = slope;
        slope2 = slope;
//        System.out.println("slope = " + slope);
        path.moveTo(cX, cY);

    }

    //__________________________________________________________________________________
    private float formLineL(float xStsart, float yStart, double slope) {
        // flag=false;
        float y11 = (int) ((slope * (xE - xStsart)) + yStart);
        dire.add(Math.atan2((y11-yStart),(xE-xStsart)));
        return y11;
    }

    private float formLineR(float xStsart, float yStart, double slope) {
        // flag=true;
        float y11 = (int) ((slope * ((displayW - xE) - xStsart)) + yStart);
        dire.add(Math.atan2((y11-yStart),((displayW - xE)-xStsart)));
        return y11;
    }

    public void lineDraw(Canvas c) {

        dist = 0;
        while (y22 > -1 && y22 <= displayH) {
            if (flag) {
                y = formLineL(x22, y22, slope1);
                dist += reflec(x22, y22, xE, y);
                path.lineTo(xE, y);
                x22 = xE;
                y22 = y;
                y = 0;
                slope1 *= -1;
                flag = false;
            } else {
                y = formLineR(x22, y22, slope1);
                dist += reflec(x22, y22, displayW - xE, y);
                path.lineTo(displayW - xE, y);
                x22 = (int) displayW - xE;
                y22 = y;
                y = 0;
                slope1 *= -1;
                flag = true;

            }
        }
        c.drawPath(path, pp);

        //c.drawBitmap(ball, cX, cY, null);


    }


//___________________________________________________________________ball path


//    public void ballPts(Canvas c) {
//        float recCenter;
//        speed = (float) (dist / 60);
//        c.drawPath(path, pp);
//
//        xb = xbuffer;
//        yb = ybuffer;
//        //c.drawBitmap(ball,cX-ball.getWidth()/2,cY-ball.getHeight()/2,null);
//
//        if (ballflag) {
//            y = point(dx1, xb, yb, slope2);
//            lx = dx1 - ball.getWidth() / 2;
//            ly = y - ball.getHeight() / 2;
//            c.drawBitmap(ball, lx, ly, null);
//            shotBall = new RectF(lx, ly, lx + ball.getWidth(), ly + ball.getHeight());
//            c.drawRect(shotBall, pp);
////                c.drawBitmap(ball,dx1+ball.getWidth()/2,y+ball.getHeight()/2,null);
//
//            dx1 -= 15;
//
//            if ((dx1 - ball.getWidth() / 2) <= 0) {
//                ballflag = false;
//                slope2 *= -1;
//
//                yb = y;
//                xb = dx1;
//                //System.out.println("slope2 = " + slope2);
//
//            }
//        } else {
//            dx1 += 15;
//            y = point(dx1, xb, yb, slope2);
//            // c.drawBitmap(ball,dx1-ball.getWidth()/2,y-ball.getHeight()/2,null);
//            lx = dx1 - ball.getWidth() / 2;
//            ly = y - ball.getHeight() / 2;
//            c.drawBitmap(ball, lx, ly, null);
//            shotBall = new RectF(lx, ly, lx + ball.getWidth(), ly + ball.getHeight());
//            c.drawRect(shotBall, pp);
//
//            if ((dx1 + ball.getWidth() / 2) >= displayW) {
//                ballflag = true;
//                slope2 *= -1;
//                yb = y;
//                xb = dx1;
////                    System.out.println("ball.getWidth()/2 = " + ball.getWidth()/2);
////                    System.out.println("slope2 = " + slope2);
//
//            }
//        }
//        if (y > -1 && y <= displayH) {
//            ApplicationView.shoot = false;
//        }
//    }
//
//    //x1- cord of x at which y is to be found
//    private float point(float x1, float xStsart, float yStart, double slope) {
//        // flag=false;
//        float y11 = (int) ((slope * (x1 - xStsart)) + yStart);
//
//
//        return y11;
//    }


    static float distanceCalc(PointF p1, PointF p2) {

        dist = Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));
        return Float.parseFloat(new DecimalFormat("##.##").format(dist));

    }

    float reflec(float xS, float yS, float xEdge, float yEdge) {
        PointF c1;
        PointF c2;
        float dist;

        c1 = new PointF();
        c2 = new PointF();
        c1.x = xS;
        c1.y = yS;
        c2.x = xEdge;
        c2.y = yEdge;
        return distanceCalc(c1, c2);
        //ballspeed.add(dist/20);


    }


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
        //balls.get(position).isBurst = false;
        // int pos = position;
        boolean flag = true;
        array[0] = pos;


        while (flag) {
            for (int i = 0; i < array.length; i++) {
                pos = (int) array[i];
                if (pos + 1 < (row_count * col_count) && (pos + 1) % col_count != 0) {//checks at position right to the clicked position
                    if (balls.get(pos + 1).isBurst && index == balls.get(pos + 1).index) {
                        buffer1.add(pos + 1);
                        balls.get(pos + 1).isBurst = true;
                        //System.out.println("1 at pos   " + (pos + 1));

                    }
                }
                if (pos + step < (row_count * col_count)) {//checks at position below the clicked position
                    if (balls.get(pos + step).isBurst && index == balls.get(pos + step).index) {
                        buffer1.add(pos + step);
                        balls.get(pos + step).isBurst = true;
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


                    if (balls.get(pos - 1).isBurst && index == balls.get(pos - 1).index) {
                        buffer1.add(pos - 1);
                        balls.get(pos - 1).isBurst = true;
                        //System.out.println("2 at pos   " + (pos - 1));
                    }
                }


                if (pos - step >= 0) {//checks at position above the clicked position
                    if (balls.get(pos - step).isBurst && index == balls.get(pos - step).index) {
                        buffer1.add(pos - step);
                        balls.get(pos - step).isBurst = true;
                        //System.out.println("4 at pos   " + (pos - 8));
                    }
                }

                //______________________________for checking right and left of above position_________________________________________________________________________
                if (above + 1 < (row_count * col_count) && (above + 1) % col_count != 0&&(above+1)>0) {//checks at aboveition right to the clicked aboveition
                    if (balls.get(above + 1).isBurst && index == balls.get(above + 1).index) {
                        buffer1.add(above + 1);
                        balls.get(above + 1).isBurst = true;
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


                    if (balls.get(above - 1).isBurst && index == balls.get(above - 1).index) {
                        buffer1.add(above - 1);
                        balls.get(above - 1).isBurst = true;
                        //System.out.println("2 at above   " + (above - 1));
                    }
                }
                //_________________________________for checking right and left of below position___________________________________________________________________________________________
                if (below + 1 < (row_count * col_count) && (below + 1) % col_count != 0) {//checks at position right to the clicked position
                    if (balls.get(below + 1).isBurst && index == balls.get(below + 1).index) {
                        buffer1.add(below + 1);
                        balls.get(below + 1).isBurst = true;
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


                    if (balls.get(below - 1).isBurst && index == balls.get(below - 1).index) {
                        buffer1.add(below - 1);
                        balls.get(below - 1).isBurst = true;
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
        collision=false;

    }





    void getnewPoints(float x1,float y1){
       dx1= (float) (x1 + (speed *Math.cos(dire.get(i))));
       dy1= (float) (y1 + (speed * Math.sin(dire.get(i))));
    }

    void ballMove(Canvas c){
        xb = xbuffer;
        yb = ybuffer;
        //c.drawBitmap(ball,cX-ball.getWidth()/2,cY-ball.getHeight()/2,null);

        if (ballflag) {
            getnewPoints(xb,yb);
            lx =dx1 - LoadImage.ballImg[ball.index].getWidth() / 2;
            ly = dy1 - LoadImage.ballImg[ball.index].getHeight() / 2;
            c.drawBitmap(LoadImage.ballImg[ball.index], lx, ly, null);
            shotBall = new RectF(lx, ly, lx +LoadImage.ballImg[ball.index].getWidth(), ly + LoadImage.ballImg[ball.index].getHeight());

            if ((dx1 -LoadImage.ballImg[ball.index].getWidth() / 2) <= 0) {
                ballflag = false;
                i++;

                //System.out.println("slope2 = " + slope2);

            }
            yb = dy1;
            xb = dx1;

        }
        else{
            getnewPoints(xb,yb);
            lx =dx1 - LoadImage.ballImg[ball.index].getWidth() / 2;
            ly = dy1 - LoadImage.ballImg[ball.index].getHeight() / 2;
            c.drawBitmap(LoadImage.ballImg[ball.index], lx, ly, null);
            shotBall = new RectF(lx, ly, lx + LoadImage.ballImg[ball.index].getWidth(), ly + LoadImage.ballImg[ball.index].getHeight());


            if ((dx1 + LoadImage.ballImg[ball.index].getWidth() / 2) >= displayW) {
                ballflag = true;
                i++;
            }
            yb = dy1;
            xb = dx1;
//            for (int i=0;i<balls.size();i++){
//                if(intersects(balls.get(i).rec,shotBall)){
//                    if (ball.index==balls.get(i).index) {
//                        circle.check_col(balls.get(i).rec, shotBall);
//
//                        System.out.println("intersection");
//                        break;
//                    }
//                }
//            }
//            if (collision){
//                //identify(balls.get(i).index,i);
//                endshoot=true;
//                // ApplicationView.shoot = false;
//                collision=false;
//                //return;
//            }
        }
        for (int i=0;i<balls.size();i++){
            if(intersects(balls.get(i).rec,shotBall)){
                if (balls.get(i).index==ball.index)
                    circle.check_col(balls.get(i).rec,shotBall);
                //System.out.println("intersection");

                break;
            }
        }
        if (collision){
            identify(balls.get(i).index,i);
            endshoot=true;
            // ApplicationView.shoot = false;
            collision=false;

            //return;
        }
        if (y > -1 && y <= displayH) {
            ApplicationView.shoot = false;
        }
    }
    void check_colisiion(RectF r1, RectF r2){
        for (int i=0;i<balls.size()-1;i++){

        }
    }

}
