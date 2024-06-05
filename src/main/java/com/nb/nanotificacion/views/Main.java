package com.nb.nanotificacion.views;

import java.awt.EventQueue;

import com.nb.nanotificacion.views.jframe.SplashScreen;

public class Main {

	public static void main(String[] args) {
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SplashScreen frame = new SplashScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
