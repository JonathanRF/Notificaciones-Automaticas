package com.nb.nanotificacion.views.utils;

import java.awt.Color;

public class Colors {
	
	
	
	public static Color getRandomColor() {
		
		Color colores[] = {
				new Color(255, 87, 51),    
				new Color(234, 41, 0),
				new Color(234, 142, 0),
				new Color(107, 234, 0),
				new Color(4, 176, 214),
				new Color(10, 115, 197),
				new Color(106, 10, 197),
				new Color(201, 23, 174),
				new Color(201, 23, 88),
				new Color(23, 201, 201),
				new Color(0, 0, 0),
				new Color(0, 0, 0),
				new Color(0, 0, 0),
				new Color(0, 0, 0)
		};
		
		int idx = (int) (Math.random() *9);
		//System.out.println(colores[idx]);
		
		return colores[idx];
	}
	
	
	public static Colores getColorMaterial() {
		Colores colores[] = {
				new Colores(new Color(239,154,154), new Color(255,235,238),Color.black,Color.black),
				new Colores(new Color(244,143,177), new Color(252,228,236),Color.black,Color.black),
				new Colores(new Color(206,147,216), new Color(243,229,245),Color.white,Color.black),
				//new Colores(new Color(66, 165, 245), new Color(144, 202, 249),Color.black,Color.black),
				new Colores(new Color(129, 212, 250), new Color(225, 245, 254),Color.black,Color.black),
				new Colores(new Color(128, 222, 234), new Color(224, 247, 250),Color.black,Color.black),
				new Colores(new Color(128, 203, 196), new Color(224, 242, 241),Color.black,Color.black),
				new Colores(new Color(165,214,167), new Color(232,245,233),Color.black,Color.black),
				new Colores(new Color(197,225,165), new Color(241,248,233),Color.black,Color.black),
				new Colores(new Color(230,238,156), new Color(249,251,231),Color.black,Color.black),
				new Colores(new Color(255,245,157), new Color(255,253,231),Color.black,Color.black),
				new Colores(new Color(255,224,130), new Color(255,248,225),Color.black,Color.black),
				new Colores(new Color(255,204,128), new Color(255,243,224),Color.black,Color.black),
				//new Colores(new Color(), new Color(),Color.black,Color.black),
				//new Colores(new Color(), new Color(),Color.black,Color.black),
				//new Colores(new Color(), new Color(),Color.black,Color.black),
		};
		int idx = (int) (Math.random()*12);
		
		return colores[idx];
	}
	
//	public static Color getColorMaterial() {
//		Color colores[] = {
//				new Color(233, 30, 99),    
//				new Color(244, 67, 54),
//				new Color(156, 39, 176),
//				new Color(103,58, 183),
//				new Color(63, 81, 181),
//				new Color(33, 150, 243),
//				new Color(0, 0, 0),
//				new Color(0, 0, 0),
//				new Color(0, 0, 0),
//				new Color(0, 0, 0),
//				new Color(0, 0, 0),
//				new Color(0, 0, 0),
//				new Color(0, 0, 0),
//				new Color(0, 0, 0)
//		};
//		
//		int idx = (int) (Math.random() *6);
//		//System.out.println(colores[idx]);
//		
//		return colores[idx];
//		
//	}
	
	public static class Colores{
		private Color colorPrincipal;
		private Color colorSecundario;
		private Color textoPrimario;
		private Color textoSecundario;
		
		
		

		public Colores(Color colorPrincipal, Color colorSecundario, Color textoPrimario, Color textoSecundario) {
			super();
			this.colorPrincipal = colorPrincipal;
			this.colorSecundario = colorSecundario;
			this.textoPrimario = textoPrimario;
			this.textoSecundario = textoSecundario;
		}

		public Color getColorPrincipal() {
			return colorPrincipal;
		}

		public void setColorPrincipal(Color colorPrincipal) {
			this.colorPrincipal = colorPrincipal;
		}

		public Color getColorSecundario() {
			return colorSecundario;
		}

		public void setColorSecundario(Color colorSecundario) {
			this.colorSecundario = colorSecundario;
		}

		public Color getTextoPrimario() {
			return textoPrimario;
		}

		public void setTextoPrimario(Color textoPrimario) {
			this.textoPrimario = textoPrimario;
		}

		public Color getTextoSecundario() {
			return textoSecundario;
		}

		public void setTextoSecundario(Color textoSecundario) {
			this.textoSecundario = textoSecundario;
		}
		
		
		
	}

}
