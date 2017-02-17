package com.tangiapps.shooternew;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class AppThread extends Thread {
	private SurfaceHolder surfaceHolder;
	ApplicationView gameView;

	// MainCanvas mc;
	private boolean isRunning = false;
	public int FRAME_DELAY = 22;
	public long myLastTime;

	public AppThread(SurfaceHolder surfaceHolder, ApplicationView mainCanvas) {
		this.surfaceHolder = surfaceHolder;
		this.gameView = mainCanvas;
		ApplicationView.surfaceHolder = surfaceHolder;
	}

	public AppThread() {
		// TODO Auto-generated constructor stub
	}

	public void setRunning(boolean running) {
		this.isRunning = running;
	}

	public SurfaceHolder getSurfaceHolder() {
		return surfaceHolder;
	}

	@Override
	public void run() {
		Canvas c;
		while (isRunning) {
			c = null;
			long current = System.currentTimeMillis();
			long delay = FRAME_DELAY + myLastTime - current;

			if (delay > 0) {
				try {
					sleep(delay);
				} catch (InterruptedException e) {
				}
			}
			myLastTime = current;

			try {
				c = surfaceHolder.lockCanvas(null);
				synchronized (surfaceHolder) {
					// call methods to draw and process next fame
					gameView.onDraw(c);
				}
			} finally {
				if (c != null) {
					surfaceHolder.unlockCanvasAndPost(c);
				}
			}
		}
	}

}
