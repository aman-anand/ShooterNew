package com.tangiapps.shooternew;


import android.graphics.Canvas;
import android.graphics.Path;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

import static android.graphics.RectF.intersects;
import static com.tangiapps.shooternew.ApplicationView.cX;
import static com.tangiapps.shooternew.ApplicationView.cY;
import static com.tangiapps.shooternew.ApplicationView.col_count;
import static com.tangiapps.shooternew.ApplicationView.displayH;
import static com.tangiapps.shooternew.ApplicationView.displayW;
import static com.tangiapps.shooternew.ApplicationView.isLevelFailed;
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

   static float dx1, dy1, x, y;
    static double angle, slope;
    static   ArrayList<Integer> ballarray=new ArrayList<>();
    static double slope2, dist;
    static boolean ballflag;
    //private BallPath ballPath;
    static Ball ball;
    //ArrayList<Double> direction= new ArrayList<>();
    static float xb, yb;
    static int ballindex=0;
    static boolean collision,endshoot,drawLineB,newsetter=true,uuuuuuu=true;
    //Point p[] = new Point[2];
    Path path = new Path();
    float x22, y22;
    double slope1;
    //Bitmap ball1 = LoadImage.ballImg[5];
    ArrayList<Double> dire= new ArrayList<>();
    RectF shotBall;
    double speed = 8;
    float xE = (float) (displayW * 0.0375);
    int i=0;
    boolean aflag=false,flag = false;
    private float lx, ly;


    LineC() {
        speed = displayH*0.01;
        xb = cX;
        xE = (float) (displayW * 0.04166);
        yb = cY;
        setshootingball();

    }

    static float distanceCalc(PointF p1, PointF p2) {

        dist = Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));
        return Float.parseFloat(new DecimalFormat("##.##").format(dist));

    }

static void setshootingball(){
    ballarray.clear();
    for (int j = balls.size()-1; j >= 0; j--) {
        if (balls.get(j).y<0){
            break;
        }
         if (balls.get(j).isVisible){
             if (!ballarray.contains(balls.get(j).index)){
                 ballarray.add(balls.get(j).index);
             }
         }

    }


}

static int getshootingball(){
if (uuuuuuu){
    setshootingball();
    uuuuuuu=false;
}
//    ArrayList<Integer> listc ;
//    listc.clone(ballarray);
    boolean flag = true;
    int n = 0;
    if (newsetter) {
       newsetter=false;
        Random r = new Random();
        while (flag) {
            n = r.nextInt(ballarray.size());
            if (ballarray.contains(n)) {
               ballindex=n;
                break;
            }

        }
    }
        return ballindex;

}

    //__________________________________Methods_______________________________________________________
    void angleC(float dwnX, float dwnY) {
        drawLineB=false;
      ball = new Ball( 0,  0, getshootingball(),true,0,0);
        //        ball = new Ball( 0,  0, getshootingball(),true,0);
        //        ball = new Ball( 0,  0, 3,true,0);
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
        if (angle>25&&angle<160){
            System.out.println("angle = " + angle);
            if (angle>89&&angle<91){
                angle=89;
            }
            drawLineB=true;
        }
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
        c.drawBitmap(LoadImage.ballImg[ball.index], cX-LoadImage.ballImg[3].getWidth()/2, cY, null);
        if (drawLineB) {
            dist = 0;
            while (y22 > -1 && y22 <= displayH) {
                if (flag) {
                    y = formLineL(x22, y22, slope1);
                    dist += reflec(x22, y22, xE, y);
                    path.lineTo(xE, y);
                    if (y<=0){
                        drawLineB=false;
                    }
                    x22 = xE;
                    y22 = y;
                    y = 0;
                    slope1 *= -1;
                    flag = false;
                } else {
                    y = formLineR(x22, y22, slope1);
                    dist += reflec(x22, y22, displayW - xE, y);
                    path.lineTo(displayW - xE, y);
                    if (y<=0){
                        drawLineB=false;
                    }
                    x22 = (int) displayW - xE;
                    y22 = y;
                    y = 0;
                    slope1 *= -1;
                    flag = true;

                }
            }

        }
        c.drawPath(path, pp);
        //c.drawBitmap(ball, cX, cY, null);


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

    void getnewPoints(float x1,float y1){
       dx1= (float) (x1 + (speed *Math.cos(dire.get(i))));
       dy1= (float) (y1 + (speed * Math.sin(dire.get(i))));
    }

    void ballMove(Canvas c) {
        ApplicationView.isTouchEnable=false;
        xb = xbuffer;
        yb = ybuffer;
        //c.drawBitmap(ball,cX-ball.getWidth()/2,cY-ball.getHeight()/2,null);

        if (ballflag) {
            getnewPoints(xb, yb);
            lx = dx1 - LoadImage.ballImg[ball.index].getWidth() / 2;
            ly = dy1 - LoadImage.ballImg[ball.index].getHeight() / 2;
            c.drawBitmap(LoadImage.ballImg[ball.index], lx, ly, null);
            shotBall = new RectF(lx, ly, lx + LoadImage.ballImg[ball.index].getWidth(), ly + LoadImage.ballImg[ball.index].getHeight());
            c.drawRect(shotBall,pp);
            if ((dx1 - LoadImage.ballImg[ball.index].getWidth() / 2) <= 0) {
                ballflag = false;
                i++;

                //System.out.println("slope2 = " + slope2);

            }
            yb = dy1;
            xb = dx1;

        } else {
            getnewPoints(xb, yb);
            lx = dx1 - LoadImage.ballImg[ball.index].getWidth() / 2;
            ly = dy1 - LoadImage.ballImg[ball.index].getHeight() / 2;

            c.drawBitmap(LoadImage.ballImg[ball.index], lx, ly, null);
            shotBall = new RectF(lx, ly, lx + LoadImage.ballImg[ball.index].getWidth(), ly + LoadImage.ballImg[ball.index].getHeight());
            c.drawRect(shotBall,pp);

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



        boolean interse=false;
        int k1=0;
        for (int k=0;k<balls.size();k++) {
            if (balls.get(k).isVisible&&intersects(balls.get(k).rec, shotBall)) {
                interse = check_col(balls.get(k).rec, shotBall);
                k1=k;
            }
        }
        if (interse){
            if (balls.get(k1).index==ball.index){
                identify(ball.index,k1);
                newsetter=true;
                endshoot=true;

            } else if (balls.get(k1).index==10){  //bubble
                balls.get(k1).isVisible=false;
                balls.get(k1).isAvailable=false;
            }
            else if (balls.get(k1).index==62){  //brick

            }
            else if (balls.get(k1).index==32){  //bird

            }
            else{
                if (k1<((row_count-1)*col_count)-1) {
                    for (int i = k1+1; i < balls.size(); i++) {
                        if (intersects(balls.get(i).rec, shotBall)) {
                            balls.get(i).index = ball.index;
                            balls.get(i).isAvailable = true;
                            balls.get(i).isVisible = true;
                            newsetter=true;
                            endshoot=true;
                            break;
                        }

                    }
                } else if (k1>((row_count-1)*col_count)&&balls.get(k1).index!=ball.index) {
                    balls.add(new Ball(lx,ly,ball.index,true,i+col_count,(balls.get(k1).rowNo+1)));
                    newsetter=true;
                    endshoot=true;
                }
            }
            //_______________________________________code for ball falling goes here




        }
        if (endshoot){
             ApplicationView.isTouchEnable=true;
        }

    }

    boolean check_col(RectF r1, RectF r2){
        float radius;
        boolean a =false;
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
        aflag=true;

        while (aflag) {

            for (int i = 0; i < array.length; i++) {
                pos1 = (int) array[i];
                rec1.set(balls.get(pos1).rec);
                // setBoolean(pos1);
                for (int j = 0; j < balls.size(); j++) {
//                    if (j == p) {
//                        continue;
//                    }
                    //intersects(rec, balls.get(j).rec)
                    //if (balls.get(j).isAvailable&&balls.get(j).index==index&&balls.get(j).rec.intersects(rec1.left,rec1.top,rec1.right,rec1.bottom)) {
                    if (balls.get(j).isAvailable&&balls.get(j).index==index&&intersects(balls.get(j).rec,rec1)) {
                        b1.add(j);
                    }
                }

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




}
