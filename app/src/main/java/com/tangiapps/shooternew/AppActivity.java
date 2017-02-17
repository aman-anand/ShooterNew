package com.tangiapps.shooternew;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.WindowManager;


public class AppActivity extends Activity {

	ApplicationView animView;
	AppThread gameThread;
	
	String defaultUrl = Data.defaultUrl;
	public static Context ctx;


	 
	  
	static Typeface text;
	public static boolean isPauseButtonPress = false, isPowerButtonPress = false;
	public static Paint cls=new Paint();
	static int appLevel;
	
	public static AudioManager audio;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getApplicationState();
		audio = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
		setContentView(R.layout.activity_app);


		
		animView = new ApplicationView(this, null);
		gameThread = new AppThread();

		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
				WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		
		cls.setAntiAlias(true);
		cls.setFilterBitmap(true);

		text=Typeface.createFromAsset(getAssets(), "BAUHS93.TTF");
		ctx=AppActivity.this;
		
		
		
	}
	

	
	public void getApplicationState() {

		SharedPreferences preferences = getPreferences(MODE_PRIVATE);
		if (preferences.contains("currentLevel")) {
			appLevel = Integer.parseInt(preferences.getString("currentLevel",
					null));

		}

	}

	public void saveApplicationState() {
		if (appLevel > ApplicationView.levelno) {
			SharedPreferences preferences = getPreferences(MODE_PRIVATE);
			SharedPreferences.Editor editor = preferences.edit();
			editor.putString("currentLevel", String.valueOf(appLevel));

			editor.commit();

		} else {
			SharedPreferences preferences = getPreferences(MODE_PRIVATE);
			SharedPreferences.Editor editor = preferences.edit();
			editor.putString("currentLevel",
					String.valueOf(ApplicationView.levelno));

			editor.commit();
		}
	}

	protected void onDestroy() {

		super.onDestroy();
		saveApplicationState();
		if (animView != null) {
			animView.clear();
		}
		animView = null;
		gameThread = null;
	}

	@Override
	protected void onPause() {
	
		super.onPause();
	
		
		isPauseButtonPress = true;
		ApplicationView.isUpdate=false;
	
		if(ApplicationView.islevelCleared==false && ApplicationView.isLevelFailed==false){
		ApplicationView.isBackButtonPress = true;
		}

	}

	@Override
	protected void onResume() {
		

		super.onResume();
		
		
		isPauseButtonPress = false;
		

	}

	public void quit() {
		
		saveApplicationState();
		try {
			System.exit(0);
			this.finalize();
		} catch (Throwable e) {

		}
		this.finish();
	}



	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {

			if (Options.isAboutPage) {
				Options.isAboutPage = false;
				Options.isOptionTouch = true;
			} else if (Options.isHelpPage) {
				Options.isHelpPage = false;
				Options.isOptionTouch = true;
			} else if(ApplicationView.isSettingPage){
				ApplicationView.isSettingPage=false;
				MainPage.isOptionPage=true;
				Options.isOptionTouch=true;
			}else if(ApplicationView.isOptionPage){
					ApplicationView.isOptionPage=false;
					MainPage.isHomeTouch=true;
			}else if (ApplicationView.isMianPage ) {

				ApplicationView.isQuitPage = true;

			}else if (ApplicationView.isLevelPage) {
				ApplicationView.isLevelPage = false;
				ApplicationView.isMianPage = true;
				MainPage.isHomeTouch=true;
			} else if (ApplicationView.islevelCleared == false && ApplicationView.isLevelFailed==false) {
				ApplicationView.isBackButtonPress = true;
				ApplicationView.isUpdate=false;

			}
			return true;
		}
		
		
		if (keyCode == KeyEvent.KEYCODE_POWER) {
			onPause();
			return true;
		}  else if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
			audio.adjustStreamVolume(AudioManager.STREAM_MUSIC,
					AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);
			return true;

		} else if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
			audio.adjustStreamVolume(AudioManager.STREAM_MUSIC,
					AudioManager.ADJUST_LOWER, AudioManager.FLAG_SHOW_UI);
			return true;
		} 
		return super.onKeyDown(keyCode, event);
	}

//	public void menuDailoge() {
//		final Dialog dialog = new Dialog(this);
//		dialog.getWindow().setBackgroundDrawableResource(
//				android.R.color.transparent);
//		dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//				WindowManager.LayoutParams.FLAG_FULLSCREEN);
//		dialog.getWindow().setFlags(
//				WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
//				WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
//		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//
//		dialog.setContentView(R.layout.help);
//
//		dialog.show();
//	}

}
