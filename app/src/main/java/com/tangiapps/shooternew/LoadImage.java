package com.tangiapps.shooternew;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class LoadImage {

	public float displayW, displayH, screenHeight;
	public static float blockHeight,blockWidth;

	public static Bitmap level_completed,box,  level, right,  reset,pause,
			 homebg, button,
			retry, retry1,button1,
			levellock,  levelpage,moreapps,moreapps1,soundon1,
			
			 home,home1, next,next1,bombsprit,load,soundon,play,play1,option,option1,share,share1,shooter;
	//__________________________________________________________________My variables_________________________________________________
	public static Bitmap  ballImg[]=new Bitmap[11];
	static  Bitmap bubble;
 static Bitmap topbar;


	public void lodingImage(Context ctx) {
		
		
		 blockHeight=ApplicationView.blockH;
		 blockWidth=ApplicationView.blockW;
		 
	
		displayW = (ApplicationView.displayW + 1);
		displayH = (ApplicationView.displayH + 1);

		
		
		right = BitmapFactory.decodeResource(ctx.getResources(),
				R.drawable.right);
		right = Bitmap.createScaledBitmap(right, (int) (displayW * .15),
				(int) (displayW*.1), true);

		
	

		levelpage = BitmapFactory.decodeResource(ctx.getResources(),
				R.drawable.background);
		levelpage = Bitmap.createScaledBitmap(levelpage, (int) displayW,
				(int) displayH, true);

		homebg = BitmapFactory.decodeResource(ctx.getResources(),
				R.drawable.homebg);
		homebg = Bitmap.createScaledBitmap(homebg, (int) displayW,
				(int) displayH, true);

		level = BitmapFactory.decodeResource(ctx.getResources(),
				R.drawable.unlock_level);
		level = Bitmap.createScaledBitmap(level, (int) (displayH / 8.5),
				(int) (displayH / 8.5), true);
		
		
		
		

		levellock = BitmapFactory.decodeResource(ctx.getResources(),
				R.drawable.levellock);
		levellock = Bitmap.createScaledBitmap(levellock, (int) (displayH / 8.5),
				(int) (displayH / 8.5), true);

		right = BitmapFactory.decodeResource(ctx.getResources(),
				R.drawable.right);
		right = Bitmap.createScaledBitmap(right, (int) (displayW * .15),
				(int) (displayW*.1), true);


		button = BitmapFactory.decodeResource(ctx.getResources(),
				R.drawable.btn);
		button = Bitmap.createScaledBitmap(button, (int) (displayW*.7),
				(int) (displayH*.12), true);

		button1 = BitmapFactory.decodeResource(ctx.getResources(),
				R.drawable.btn1);
		button1 = Bitmap.createScaledBitmap(button1, (int) (displayW*.7),
				(int) (displayH*.12), true);
		
		

		reset = BitmapFactory.decodeResource(ctx.getResources(),
				R.drawable.reset);
		reset = Bitmap.createScaledBitmap(reset, (int) (displayW*.1),
				(int) ((int) (displayW*.1)), true);

		home = BitmapFactory
				.decodeResource(ctx.getResources(), R.drawable.home);
		home = Bitmap.createScaledBitmap(home, (int) (displayW*.2), (int) (displayW*.2),
				true);
		home1 = BitmapFactory
				.decodeResource(ctx.getResources(), R.drawable.home1);
		home1 = Bitmap.createScaledBitmap(home1, (int) (displayW*.2), (int) (displayW*.2),
				true);

		next = BitmapFactory.decodeResource(ctx.getResources(),
				R.drawable.next);
		next = Bitmap.createScaledBitmap(next, (int) (displayW*.2), (int) (displayW*.2),
				true);
		
		next1 = BitmapFactory.decodeResource(ctx.getResources(),
				R.drawable.next1);
		next1= Bitmap.createScaledBitmap(next1, (int) (displayW*.2), (int) (displayW*.2),
				true);
		

		retry = BitmapFactory.decodeResource(ctx.getResources(),
				R.drawable.retry);
		retry = Bitmap.createScaledBitmap(retry, (int) (displayW*.2), (int) (displayW*.2),
				true);
		
		retry1 = BitmapFactory.decodeResource(ctx.getResources(),
				R.drawable.retry1);
		retry1 = Bitmap.createScaledBitmap(retry1, (int) (displayW*.2), (int) (displayW*.2),
				true);

	
		play = BitmapFactory.decodeResource(ctx.getResources(),
				R.drawable.play);
		play = Bitmap.createScaledBitmap(play, (int) (displayW*.25), (int) (displayW*.25),
				true);
		
		play1 = BitmapFactory.decodeResource(ctx.getResources(),
				R.drawable.play1);
		play1 = Bitmap.createScaledBitmap(play1, (int) (displayW*.25), (int) (displayW*.25),
				true);
		
		
		option = BitmapFactory.decodeResource(ctx.getResources(),
				R.drawable.options);
		option = Bitmap.createScaledBitmap(option, (int) (displayW*.2), (int) (displayW*.2),
				true);
		option1 = BitmapFactory.decodeResource(ctx.getResources(),
				R.drawable.option1);
		option1 = Bitmap.createScaledBitmap(option1, (int) (displayW*.2), (int) (displayW*.2),
				true);
		
		
		moreapps = BitmapFactory.decodeResource(ctx.getResources(),
				R.drawable.moreapp);
		moreapps = Bitmap.createScaledBitmap(moreapps, (int) (displayW*.2), (int) (displayW*.2),
				true);
		moreapps1 = BitmapFactory.decodeResource(ctx.getResources(),
				R.drawable.moreapps);
		moreapps1 = Bitmap.createScaledBitmap(moreapps1, (int) (displayW*.2), (int) (displayW*.2),
				true);
		
		
		share = BitmapFactory.decodeResource(ctx.getResources(),
				R.drawable.sear);
		share = Bitmap.createScaledBitmap(share, (int) (displayW*.2), (int) (displayW*.2),
				true);
		share1 = BitmapFactory.decodeResource(ctx.getResources(),
				R.drawable.sear1);
		share1 = Bitmap.createScaledBitmap(share1, (int) (displayW*.2), (int) (displayW*.2),
				true);
		
		
		
		soundon = BitmapFactory.decodeResource(ctx.getResources(),
				R.drawable.soundon);
		soundon = Bitmap.createScaledBitmap(soundon, (int) (displayW*.2), (int) (displayW*.2),
				true);
		
		soundon1 = BitmapFactory.decodeResource(ctx.getResources(),
				R.drawable.soundon1);
		soundon1 = Bitmap.createScaledBitmap(soundon1, (int) (displayW*.2), (int) (displayW*.2),
				true);
		
		pause = BitmapFactory.decodeResource(ctx.getResources(),
				R.drawable.pause);
		pause = Bitmap.createScaledBitmap(pause, (int) (displayW*.1), (int) (displayW*.1),
				true);


		ballImg[0]= BitmapFactory.decodeResource(ctx.getResources(),
				R.drawable.a1);
		ballImg[0] = Bitmap.createScaledBitmap(ballImg[0], (int) (displayW/15),
				(int) (displayW/15), true);

		ballImg[1]= BitmapFactory.decodeResource(ctx.getResources(),
				R.drawable.a2);
		ballImg[1] = Bitmap.createScaledBitmap(ballImg[1], (int) (displayW/15),
				(int) (displayW/15), true);

		ballImg[2]= BitmapFactory.decodeResource(ctx.getResources(),
				R.drawable.a3);
		ballImg[2] = Bitmap.createScaledBitmap(ballImg[2], (int) (displayW/15),
				(int) (displayW/15), true);

		ballImg[3]= BitmapFactory.decodeResource(ctx.getResources(),
				R.drawable.a4);
		ballImg[3] = Bitmap.createScaledBitmap(ballImg[3], (int) (displayW/15),
				(int) (displayW/15), true);

		ballImg[4]= BitmapFactory.decodeResource(ctx.getResources(),
				R.drawable.a5);
		ballImg[4] = Bitmap.createScaledBitmap(ballImg[4],(int) (displayW/15),
				(int) (displayW/15), true);
		ballImg[5]= BitmapFactory.decodeResource(ctx.getResources(),
				R.drawable.a6);
		ballImg[5] = Bitmap.createScaledBitmap(ballImg[5],(int) (displayW/15),
				(int) (displayW/15), true);
		ballImg[6]= BitmapFactory.decodeResource(ctx.getResources(),
				R.drawable.a7);
		ballImg[6] = Bitmap.createScaledBitmap(ballImg[6],(int) (displayW/15),
				(int) (displayW/15), true);
		ballImg[7]= BitmapFactory.decodeResource(ctx.getResources(),
				R.drawable.a8);
		ballImg[7] = Bitmap.createScaledBitmap(ballImg[7],(int) (displayW/15),
				(int) (displayW/15), true);
		ballImg[8]= BitmapFactory.decodeResource(ctx.getResources(),
				R.drawable.a9);
		ballImg[8] = Bitmap.createScaledBitmap(ballImg[8],(int) (displayW/15),
				(int) (displayW/15), true);
		ballImg[9]= BitmapFactory.decodeResource(ctx.getResources(),
				R.drawable.a10);
		ballImg[9] = Bitmap.createScaledBitmap(ballImg[9],(int) (displayW/15),
				(int) (displayW/15), true);
		ballImg[10]= BitmapFactory.decodeResource(ctx.getResources(),
				R.drawable.bubble);
		ballImg[10]= Bitmap.createScaledBitmap(ballImg[10],(int) (displayW/15),
				(int) (displayW/15), true);

		shooter = BitmapFactory.decodeResource(ctx.getResources(),
				R.drawable.shooter);
		shooter = Bitmap.createScaledBitmap(shooter, (int) (displayW*.05), (int) (displayW*.3),
				true);
		box=BitmapFactory.decodeResource(ctx.getResources(),R.drawable.box);
		box=Bitmap.createScaledBitmap(box,(int) (displayW*.2f),(int) (displayW*.2f),true);
		topbar=BitmapFactory.decodeResource(ctx.getResources(),R.drawable.topbar);
		topbar=Bitmap.createScaledBitmap(topbar,(int) (displayW),(int) (displayW*.2f),true);



	}

}
