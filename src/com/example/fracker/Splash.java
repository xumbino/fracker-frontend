package com.example.fracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Splash extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);

		/** set time to splash out */
		// TODO: change this to 5000/6000
		final int welcomeScreenDisplay = 3000;
		/** create a thread to show splash up to splash time */
		Thread welcomeThread = new Thread() {

			int wait = 0;

			@Override
			public void run() {
				try {
					super.run();

					/**
					 * use while to get the splash time. Use sleep() to increase
					 * the wait variable for every 100L.
					 */
					while (wait < welcomeScreenDisplay) {
						sleep(100);
						wait += 100;
					}
				} catch (Exception e) {
					while (wait < welcomeScreenDisplay) {
						try {
							sleep(100);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						wait += 100;
					}
					System.out.println("EXc=" + e);
				} finally {
					/**
					 * Called after splash times up. Do some action after splash
					 * times up. Here we moved to another main activity class
					 */
					startActivity(new Intent(Splash.this, LoginController.class));
					finish();
				}
			}
		};
		welcomeThread.start();

		Intent intent = new Intent(Splash.this, PositionService.class);
		startService(intent);
	}

}
