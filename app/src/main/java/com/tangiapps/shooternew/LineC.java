package com.tangiapps.shooternew;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;

import org.jetbrains.annotations.Contract;

import java.text.DecimalFormat;
import java.util.ArrayList;

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
    int dx,dy,x,y;
    static double angle,slope;
    boolean flag;
    Point p[] =new Point[2];
    Path path=new Path();
    int x22,y22;
    double slope1;
    static double slope2,dist;
    static boolean ballflag;
    private int lx,ly;
    private BallPath ballPath;
    private boolean nnnnnnnnnn;
    Bitmap ball=LoadImage.ballImg[5];
    ArrayList<Point> ballCord=new ArrayList<Point>();
    static int xb=cX,yb=cY;
    Rect shotBall;

    LineC(){

    }
    //__________________________________Methods_______________________________________________________
    void angleC(int dwnX, int dwnY){
        ball=LoadImage.ballImg[5];
        dx=cX;
        x22=cX;
        y22=cY;
        xbuffer=cX;
        ybuffer=cY;
        double xDiff = cX-dwnX;
        double yDiff = cY-dwnY;
        angle= Math.toDegrees(Math.atan2(yDiff, xDiff));
//        System.out.println("angle = " + angle);
        int xEnd = (int) (cX - (Math.cos(Math.toRadians(angle)) * 1500));
        int yEnd = (int) (cY - (Math.sin(Math.toRadians(angle)) * 1500));
//        System.out.println("xEnd = " + xEnd);
//        System.out.println("yEnd = " + yEnd);
        if (xEnd< displayW/2){
            flag=true;
            ballflag=true;
        }
        else{
            flag=false;
            ballflag=false;

        }
        slope=(cY - yEnd);
        slope/=(cX - xEnd);
        slope1=slope;
        slope2=slope;
//        System.out.println("slope = " + slope);
        path.moveTo(cX,cY);

    }
   //__________________________________________________________________________________
    private int formLineL(int xStsart, int yStart, double slope){
       // flag=false;
        int y11= (int) ((slope*(30-xStsart))+yStart);
       return y11;
    }

    private int formLineR(int xStsart, int yStart, double slope){
       // flag=true;
        int y11= (int) ((slope*((displayW-30) - xStsart))+yStart);
       return y11;
    }

   public void  lineDraw(Canvas c){


        while (y22>-1&&y22<=displayH) {
            if (flag){
                y=formLineL(x22,y22,slope1);

                path.lineTo(30,y);
                x22=30;
                y22=y;
                y=0;
                slope1*=-1;
                flag=false;
            }
            else{
                y=formLineR(x22,y22,slope1);
                path.lineTo(displayW-30,y);
                x22= (int) displayW-30;
                y22=y;
                y=0;
                slope1*=-1;
                flag=true;

            }
        }
        c.drawPath(path,pp);

        c.drawBitmap(ball,cX,cY,null);


    }


//___________________________________________________________________ball path





   public void ballPts(Canvas c){
       int recCenter;
        c.drawPath(path,pp);

        xb=xbuffer;
        yb=ybuffer;
        //c.drawBitmap(ball,cX-ball.getWidth()/2,cY-ball.getHeight()/2,null);

            if (ballflag){
                y=  point(dx,xb,yb,slope2);
                lx=dx-ball.getWidth()/2;
                ly=y-ball.getHeight()/2;
                c.drawBitmap(ball,lx,ly,null);
                shotBall=new Rect(lx,ly,lx+ball.getWidth(),ly+ball.getHeight());
                c.drawRect(shotBall,pp);
//                c.drawBitmap(ball,dx+ball.getWidth()/2,y+ball.getHeight()/2,null);

                dx-=10;

                if ((dx-ball.getWidth()/2)<=0){
                    ballflag=false;
                    slope2*=-1;

                    yb=y;
                    xb=dx;
                    //System.out.println("slope2 = " + slope2);

                }
            }
            else{
                dx+=10;
                y=  point(dx,xb,yb,slope2);
               // c.drawBitmap(ball,dx-ball.getWidth()/2,y-ball.getHeight()/2,null);
                lx=dx-ball.getWidth()/2;
                ly=y-ball.getHeight()/2;
                c.drawBitmap(ball,lx,ly,null);
                shotBall=new Rect(lx,ly,lx+ball.getWidth(),ly+ball.getHeight());
                c.drawRect(shotBall,pp);

                if ((dx+ball.getWidth()/2)>=displayW){
                    ballflag=true;
                    slope2*=-1; yb=y;
                    xb=dx;
//                    System.out.println("ball.getWidth()/2 = " + ball.getWidth()/2);
//                    System.out.println("slope2 = " + slope2);

                }
            }
        if (y>-1&&y<=displayH){
            ApplicationView.shoot=false;
        }
   }

    //x1- cord of x at which y is to be found
    private int point(int x1,int xStsart, int yStart, double slope){
        // flag=false;
        int y11= (int) ((slope*(x1-xStsart))+yStart);
        return y11;
    }



   static  float distanceCalc(Point p1,Point p2){

    dist=Math.sqrt(Math.pow((p2.x-p1.x),2)+Math.pow((p2.y-p1.y),2));
        return  Float.parseFloat(new DecimalFormat("##.##").format(dist));

    }


   private void identify(int index,int pos){
       ArrayList<Integer> buffer1 = new ArrayList<>();
       ArrayList<Integer> buffer2 = new ArrayList<>();
       ArrayList<Integer> finalList = new ArrayList<>();
       finalList.add(pos);
       int step=col_count;
       int above=pos-step,below=pos+step;
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
               for (int q = col_count-1; q < (row_count * col_count); q += step) {
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
               if (above + 1 < (row_count * col_count) && (above + 1) % col_count != 0) {//checks at aboveition right to the clicked aboveition
                   if (balls.get(above + 1).isVisible && index == balls.get(above + 1).index) {
                       buffer1.add(above + 1);
                       balls.get(above + 1).isVisible = false;
                       //System.out.println("1 at above   " + (above + 1));

                   }
               }

                stepb = false;
               c12 = 0;
               for (int q = col_count-1; q < (row_count * col_count); q += step) {
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
               if (below + 1 < (row_count * col_count) && (below + 1) % col_count != 0) {//checks at belowition right to the clicked belowition
                   if (balls.get(below + 1).isVisible && index == balls.get(below + 1).index) {
                       buffer1.add(below + 1);
                       balls.get(below + 1).isVisible = false;
                       //System.out.println("1 at below   " + (below + 1));

                   }
               }

               stepb = false;
               c12 = 0;
               for (int q = col_count-1; q < (row_count * col_count); q += step) {
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


   }


}
