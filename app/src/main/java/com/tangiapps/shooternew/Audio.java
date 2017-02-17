package com.tangiapps.shooternew;

import java.util.HashMap;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

public class Audio {

	static private Audio  sound;
	private static SoundPool soundPool;
	private static AudioManager audioManager;
	private static Context ctx;
	private static HashMap<Integer, Integer> soundPoolMap;
	public Audio() {

	}

	static synchronized public Audio getInstance() {
		if (sound == null)
			sound = new Audio();
		return sound;
	}

	public static void initSounds(Context theContext) {
		ctx = theContext;
		soundPool = new SoundPool(20, AudioManager.STREAM_MUSIC, 0);
		soundPoolMap = new HashMap<Integer, Integer>();
		audioManager = (AudioManager) ctx
				.getSystemService(Context.AUDIO_SERVICE);
	}

	public static void addSound(int Index, int SoundID) {
		soundPoolMap.put(Index, soundPool.load(ctx, SoundID, 1));
	}

	public static void loadAudio() {
		soundPoolMap.put(0, soundPool.load(ctx, R.raw.selection, 1));		
		soundPoolMap.put(1, soundPool.load(ctx, R.raw.levelfailed, 1));
		soundPoolMap.put(2, soundPool.load(ctx, R.raw.levelcomplete, 1));		
		
		
		

		
	}

	public static void playAudio(int index) {

		int strVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
		
			
			if(ApplicationView.isSoundOn){
			soundPool.play(soundPoolMap.get(index), strVolume,
					strVolume, 0, 0, 1f);
			}
	}

	public static void playLoopedAudio(int index) {

		int strVolume = audioManager
				.getStreamVolume(AudioManager.STREAM_MUSIC);
		if(ApplicationView.isSoundOn){
			soundPool.play(soundPoolMap.get(index), strVolume,
					strVolume, 1, -1, 1f);
		}

	}

	public static void stopAudio(int index) {
		soundPool.stop(soundPoolMap.get(index));
	}

	public static void resumeAudio(int index) {
		soundPool.resume(soundPoolMap.get(index));
	}

	public static void releaseAudio(int index) {
		soundPool.release();
	}

	public static void pauseAudio(int index) {
		soundPool.pause(soundPoolMap.get(index));
	}

	public static void cleanup() {
		soundPool.release();
		soundPool = null;
		soundPoolMap.clear();
		audioManager.unloadSoundEffects();
		sound = null;

	}

}
