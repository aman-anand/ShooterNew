package com.tangiapps.shooternew;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.RectF;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;


import static android.graphics.Paint.Style.FILL;
import static android.graphics.Paint.Style.FILL_AND_STROKE;
import static android.graphics.Paint.Style.STROKE;
import static com.tangiapps.shooternew.LineC.dx1;
import static com.tangiapps.shooternew.LineC.dy1;
import static com.tangiapps.shooternew.LineC.xb;
import static com.tangiapps.shooternew.LineC.yb;
import static com.tangiapps.shooternew.LoadImage.ballImg;
import static com.tangiapps.shooternew.LoadImage.load;

public class ApplicationView extends SurfaceView implements SurfaceHolder.Callback {

    public static SurfaceHolder surfaceHolder;
    public static float blockW, blockH, displayW, displayH,
            x_cor = 0, y_cor = 0;
    public static boolean isTouchEnable = true,boooooo=true;
    static Context contxt;
    static int levelno = 1, row_count = 11, col_count = 14;
    float downX = 0, downY = 0,
            upX = 0, upY = 0, count = 0, i = 0, j = 0, dX = 0, uX = 0, uY = 0,
            dY = 0;
    static boolean isBackgroundTouch = false, isResetButton = false, isGoToNextLevel = false, isQuitPage = false, isSettingPage = false,
            isBackButtonPress = false, isMianPage = false, isResetAppLevel = false, isPlayingMode = false, isLevelPage = false,
            islevelCleared = false, isLevelFailed = false, isNextBtnPressed = false, isSoundOn = true,
            isMenuBtnPressed = false, isRetryBtnPressed = false, isOptionPage = false, isUpdate = true, isGameOn = false;
    AppThread thread = new AppThread();
    LoadImage loadImage = new LoadImage();
    LevelCleared levelClear = new LevelCleared();
    LevelFailed levelfailed = new LevelFailed();
    AppMatrix appMatrix = new AppMatrix();
    MainPage mainPage = new MainPage();
    AppLevelPage appLevelPage = new AppLevelPage();
    QuitePage quitPage = new QuitePage();
    SettingPage settingPage = new SettingPage();
    Options op = new Options();
    //RectF boardRect;

    BackButtonPress backButtonPress = new BackButtonPress();
    DrawString drawString = new DrawString();
    RectF reset, pause,topBbar;
    ;
    int row = -1, col = -1, delay1 = 0, a = 20;
//    int delayCounter = 0, framecount = 0, framecount1 = 0, framecount2 = 0, birdIndex = 0, totalframe = 6;
//    //__________________________________________________________________My variables_________________________________________________
//    static int anInt;
//    float bux, buy;
    Paint pq = new Paint();
    private int dy;
    static boolean aBoolean, shootball = false, shoot = false;
    ;
    ArrayList<Ball> ballArrayList = new ArrayList<>();
    ArrayList<Ball> bubble = new ArrayList<>();
    Ball [][] abc=new Ball[row_count][col_count];
//    Rotate rotate = new Rotate();
//    Bitmap bitmap;
// double slope;
//    Point p1;
//    Point p2;
    RectF rec_shooter;
    static float cX = 0, x, y;
    static float cY = 0, xbuffer, ybuffer;

    float xEnd, yEnd, xe1, ye1;
    double angle, y22;
    static Paint pp = new Paint();
    float intercept;
    LineC lp2;
    Point[] points = new Point[2];
    static ArrayList<Ball> balls = new ArrayList<>(400);
    ArrayList<Ball> bubbles = new ArrayList<>();
    int[][] gameMatrix = new int[11][14];
    private float xl, yl;
    //BallPath ballPath = new BallPath();


    public ApplicationView(Context context, AttributeSet attr) {
        super(context, attr);
        contxt = context;
        getHolder().addCallback(this);
        setFocusable(true);
        DisplayMetrics DisplayMetrics = new DisplayMetrics();
        DisplayMetrics = context.getResources().getDisplayMetrics();
        displayW = DisplayMetrics.widthPixels;
        displayH = DisplayMetrics.heightPixels;
        lp2 = new LineC();
        isMianPage = true;

        blockW = displayW / col_count;//*0.13541666666666666666666666666667f;
        blockH = blockW;//displayH/row_count;//*0.0875f;


        loadImage.lodingImage(context);
        // appLevel();

        Audio.getInstance();
        Audio.initSounds(context);
        Audio.loadAudio();
        sound_initialization();
        initshooter();
        pp.setColor(getResources().getColor(R.color.colorAccent));
        pp.setTextSize(32);
        pp.setStrokeWidth(5);
        pp.setStyle(STROKE);
        pq.setColor(getResources().getColor(R.color.paincolor));
        pq.setTextSize(32);
        pq.setStrokeWidth(15);
        pq.setStyle(FILL_AND_STROKE);
        topBbar=new RectF(0,0,LoadImage.topbar.getWidth(),LoadImage.topbar.getHeight());
    }

    private void sound_initialization() {

        if (AppActivity.audio.getRingerMode() == 0) {

            isSoundOn = false;
        }
        if (AppActivity.audio.getRingerMode() == 1) {

            isSoundOn = false;
        }
        if (AppActivity.audio.getRingerMode() == 2) {

            isSoundOn = true;
        }

    }

    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {
        // TODO Auto-generated method stub

    }

    public void surfaceCreated(SurfaceHolder holder) {
        // TODO Auto-generated method stub
        thread = new AppThread(getHolder(), this);
        thread.setRunning(true);
        thread.start();

    }

    @Override
    protected void onDraw(Canvas c) {

        // TODO Auto-generated method stub
        super.onDraw(c);
        try {


            if (isMianPage) {

                mainPage.drawMainPage(c);


            } else if (isLevelPage == true) {

                appLevelPage.Level_Canvas(c);

            } else if (isPlayingMode == true) {

                if (isResetAppLevel == true) {
                    isResetAppLevel = false;
                    resetAppLevel();

                }

                gamePlay(c);
                isGameOn = true;
                if (isLevelFailed || islevelCleared || isMianPage || isQuitPage || isBackButtonPress || isLevelPage || isSettingPage || isOptionPage) {
                    isGameOn = false;
                }
            }
            if (isQuitPage) {
                quitPage.drawexitbutton(c);
            }

            if (isOptionPage) {
                op.drawOptionPage(c);
            }


            if (isSettingPage) {
                settingPage.drawSettingPage(c);
            }


        } catch (Exception e) {

        }

    }

    public void gamePlay(Canvas c) {
        if (balls.get(balls.size()-1).y>displayH*.6f){
            levelanim();
        }
        if (balls.get(balls.size()-1).y<displayH*.6f){
            levelanim1();
        }

        c.drawBitmap(LoadImage.levelpage, 0, 0, null);
        c.drawBitmap(LoadImage.topbar,0,0,null);

        //c.drawBitmap(LoadImage.pause, ApplicationView.displayW * .97f - LoadImage.pause.getWidth(), ApplicationView.displayH * .1f, AppActivity.cls);


//        bitmap=getO(LoadImage.shooter, (float) angle);
//        c.drawBitmap(bitmap,ApplicationView.displayW*.5f-LoadImage.shooter.getWidth(),ApplicationView.displayH*.8f,AppActivity.cls);


        for (int i = 0; i < balls.size(); i++) {

            if (balls.get(i).isAvailable) {
                if (balls.get(i).isVisible ) {
                    //c.drawRect(balls.get(i).rec, paint);
                    //c.drawBitmap(LoadImage.ballImg[balls.get(i).index], balls.get(i).x, balls.get(i).y, null);
                   // c.drawRect(balls.get(i).rec,pq);
                    c.drawBitmap(LoadImage.ballImg[balls.get(i).index], balls.get(i).x, balls.get(i).y, null);


                }
            }

        }
        c.drawBitmap(LoadImage.shooter, ApplicationView.displayW * .5f - LoadImage.shooter.getWidth(), ApplicationView.displayH * .8f, pp);
        c.drawBitmap(LoadImage.box, ApplicationView.displayW * .3f - LoadImage.box.getWidth(), ApplicationView.displayH * .85f, null);
        c.drawBitmap(LoadImage.ballImg[3], cX-LoadImage.ballImg[3].getWidth()/2, cY, null);
        if (aBoolean) {

            lp2.lineDraw(c);
            //shootball=true;

        }
        if (shootball) {
            shoot=true;
            if (LineC.endshoot)
            shoot = false;

        }
        if (shoot) {
            lp2.ballMove(c);
            xbuffer = dx1;
            ybuffer = dy1;

        }

        if (islevelCleared == false) {

            //islevelCleared=true;
//					if(ApplicationView.isSoundOn){
//						Audio.stopAudio(2);
//						Audio.playAudio(2);
//					}

        } else if (isLevelFailed == false) {


            //isLevelFailed=true;
//	if(ApplicationView.isSoundOn){
//		Audio.stopAudio(1);
//		Audio.playAudio(1);
//
//	}


        }


        drawString.drawString(c);


        if (isLevelFailed) {
            isBackgroundTouch = true;

            levelfailed.drawLevelFailed(c);

        } else
            //islevelCompleted=true;
            if (islevelCleared) {

                isBackgroundTouch = true;

                levelClear.drawLevelComplete(c);

            }


        if (ApplicationView.isBackButtonPress) {
            ApplicationView.isTouchEnable = false;
            backButtonPress.drawingButton(c);

        }


        /// Score bonus

    }

    private void levelanim1() {
        for (int i = 0; i < balls.size(); i++) {

            // c.drawBitmap(LoadImage.ballImg[balls.get(i).index], balls.get(i).x, balls.get(i).y, null);
//            if (balls.get(i).y==displayH*.75f){
//                for ()
//            }
//
            balls.get(i).y+=10;
            balls.get(i).rec=new RectF(balls.get(i).x,balls.get(i).y,balls.get(i).x+LoadImage.ballImg[0].getWidth(),LoadImage.ballImg[0].getHeight()+balls.get(i).y);

        }
    }

    private void levelanim() {
        for (int i = 0; i < balls.size(); i++) {

           // c.drawBitmap(LoadImage.ballImg[balls.get(i).index], balls.get(i).x, balls.get(i).y, null);
//            if (balls.get(i).y==displayH*.75f){
//                for ()
//            }
//
            balls.get(i).y-=10;
            balls.get(i).rec=new RectF(balls.get(i).x,balls.get(i).y,balls.get(i).x+LoadImage.ballImg[0].getWidth(),LoadImage.ballImg[0].getHeight()+balls.get(i).y);

        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        pause = new RectF((float) (ApplicationView.displayW * .97f - LoadImage.pause.getWidth()), (float) (ApplicationView.displayH * .1f), (float) (ApplicationView.displayW * .97f), (float) (ApplicationView.displayH * .1f + LoadImage.pause.getHeight()));


        if (isQuitPage) {
            quitPage.exitTouch(event);

        } else if (isSettingPage) {
            settingPage.settingTouch(event);

        } else if (isOptionPage) {

            op.optionTouch(event);
        } else if (isMianPage) {

            mainPage.mainPageTouch(event);
        } else if (isLevelPage) {

            appLevelPage.onTouchEvent(event);

        } else if (isBackButtonPress == true) {

            backButtonPress.BackTouch(event);

        }
//        else if (isGameOn){
//            lp2.gametouch(event);
//            System.out.println("game on");
//        }


        if (isTouchEnable) {

            switch (event.getAction()) {

                case MotionEvent.ACTION_DOWN:

                    downX = (float) event.getX();
                    downY = (float) event.getY();
                    dX = (float) event.getX();
                    dY = (float) event.getY();
                    if (isPlayingMode) {
                        aBoolean = true;
                        lp2.angleC(downX, downY);
                    }
                    shootball = false;
//                    drawLineByLength(cX,cY,angle,800);

                    if (isBackgroundTouch == false) {


                        //System.out.println("  within back move ******************");
//                        int down_X = (int) event.getX();
//                        int down_Y = (int) event.getY();


//					if (rset.contains(downX, downY)) {
//
//						 ApplicationView.isResetAppLevel = true;
//						 ApplicationView.isTouchEnable = true;
//						 }
//					
                        if (pause.contains(downX, downY)) {

                            isBackButtonPress = true;
                            isUpdate = false;


                        }


                    }

                    if (islevelCleared == true) {

                        levelClear.onTouchDown(downX, downY);

                    }

                    if (isLevelFailed == true) {
                        levelfailed.onTouchDown(downX, downY);
                    }

                    break;
                case MotionEvent.ACTION_UP:
                    upX = (float) event.getX();
                    uX = (float) event.getX();
                    upY = (float) event.getY();
                    uY = (float) event.getY();

                    if (isGameOn && aBoolean) {
                        shootball = true;
//                        System.out.println("event = " + event);
//                        System.out.println("shootball = " + shootball);
                    }
                    aBoolean = false;
                    if (isPlayingMode && !aBoolean) {
                        // ballPath.setBall(LoadImage.ballImg[3]);
                        //shootball=true;
                    }
                    // lp2.path.reset();
                    if (isBackgroundTouch == false) {

                    }


                    if (isLevelFailed == true) {

                        levelfailed.onTouchUp(upX, upY);
                    }

                    if (islevelCleared == true) {

                        levelClear.onTouchUp(upX, upY);
                        if (isGoToNextLevel) {
                            isGoToNextLevel = false;
                            goToNextLevel();
                            // isBackgroundTouch=false;
                        }
                    }


                    break;
                case MotionEvent.ACTION_MOVE:
                    downX = (float) event.getX();
                    downY = (float) event.getY();
                    dX = (float) event.getX();
                    dY = (float) event.getY();
                    lp2.path.reset();

                    if (isPlayingMode) {
                        lp2.angleC(downX, downY);
                    }
                    //   System.out.println(downX+"    "+downY);
//                    drawLineByLength(cX,cY,angle,800);


                  /*  if (isLevelFailed == true) {

                        lf.onTouchUp(upX, upY);
                    }

                    if (islevelCleared == true) {

                        lc.onTouchUp(upX, upY);
                        if (goToNextLevel) {
                            goToNextLevel = false;
                            nextLevel();
                            // backmove=false;
                        }
                    }*/

                    break;


            }

        }

        // isTouch = true;
        return true;
    }


    public void surfaceDestroyed(SurfaceHolder holder) {
        // TODO Auto-generated method stub
        boolean retry = true;
        thread.setRunning(false);
        while (retry) {
            try {
                thread.join();
                retry = false;
            } catch (InterruptedException e) {

            }
        }

    }


    public void appLevel() {


        if (levelno == 76) {
            levelno = 1;
        }


        gameMatrix = appMatrix.levelMatrix(levelno);
        Create();

    }

    // next leve
    public void goToNextLevel() {
        levelno++;

        if (levelno > AppActivity.appLevel) {
            AppActivity.appLevel++;

        }
        appLevel();

    }

    //_reset game level
    private void resetAppLevel() {
        appLevel();


        isBackButtonPress = false;

        isLevelFailed = false;
        islevelCleared = false;
        isUpdate = true;

        ApplicationView.isTouchEnable = true;
        ApplicationView.isBackgroundTouch = false;


        row = -1;
        col = -1;


    }


    public void clear() {
        synchronized (surfaceHolder) {
            isPlayingMode = false;
            isMianPage = true;


        }
    }

    //__________________________________________________________________My methods_________________________________________________
    void initshooter() {
        float x = (float) (ApplicationView.displayW * .5f - LoadImage.shooter.getWidth()/2);
        float y = (float) (ApplicationView.displayH * .9f);
        //System.out.println(x+"  "+y);
        rec_shooter = new RectF(x, y, x + LoadImage.shooter.getWidth(), y + LoadImage.shooter.getHeight());

        cX = x ;
        //cX -= 36;
        cY = y ;
       // cY -= 18;
        xe1 = cX;
        ye1 = cY;
        xbuffer = cX;
        ybuffer = cY;
        //System.out.println(cX+"  "+cY);


    }


    public Bitmap getO(Bitmap bitmap, float orientation) {

        int w = bitmap.getWidth();
        int h = bitmap.getHeight();
        Matrix mtx = new Matrix();
        mtx.setRotate(orientation, cX, cY);

        return Bitmap.createBitmap(bitmap, 0, 0, w, h, mtx, true);
    }

    void lineEq(int slope, int y, int x) {
        intercept = y - (slope * x);
    }

    void initballs() {

    }

    void  Create() {
        //if (balls.size() < (row_count * col_count)) {

//        if (isUpdate || islevelCleared) {
//           balls.clear();
//        }
//        row_count=;
//        col_count=;
        y=LoadImage.topbar.getHeight();
        //y=displayH*.75f;
        x= (float) (displayW - (col_count * ballImg[0].getWidth()))/10 ;
        //y+= (float) (displayH - (row_count * ballImg[0].getHeight()))/12 ;
        xl = ballImg[0].getWidth();
        yl = ballImg[0].getHeight()*.9f;
        //y=y+yl;
        x=x+xl;
        int p=0;
        for (int i = 0; i < row_count; i++) {
            if (i%2!=0&&i>0){
                x = (float) (displayW - (col_count * ballImg[0].getWidth())) / 1.5f;

            }
            else{
                x = (float) (displayW - (col_count * ballImg[0].getWidth())) / 10;
            }
            for (int j = 0; j < col_count; j++) {

                balls.add(new Ball(x, y, gameMatrix[i][j], true,p));


                x = (float) (x + xl);
                p++;
            }


            y = (float) (y + yl);

        }
        System.out.println("balls.size  " + balls.size());

       // balls.add(new Ball(158,572+yl,2,true,p));
        System.out.println("balls.size  " + balls.size());


    }

    void shootingLogic() {

    }


}
