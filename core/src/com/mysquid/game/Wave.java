package com.mysquid.game;

import java.util.Arrays;

import squidpony.GwtCompatibility;

public class Wave {
	
	public float[] waveValues;
	
	private int deadzoneStart;
	private int deadzoneEnd;
	
	public Wave () {
		
		int xValueCount = 30;
		
		// flat line
		waveValues = new float[xValueCount];
		Arrays.fill(waveValues, 0f);
		
		deadzoneStart = 30;
		deadzoneEnd = 30;
		
	}
	
	public Wave (float[] waveValues) {
		
		this.waveValues = waveValues;
		this.deadzoneStart = 30;
		this.deadzoneEnd = 30;		
	}
	
	public Wave (float[] waveValues, int deadzoneStart, int deadzoneEnd) {
		
		this.waveValues = waveValues;
		this.deadzoneStart = deadzoneStart;
		this.deadzoneEnd = deadzoneEnd;		
	}
	
	public char[][] getTextRepresentation(int height, int width) {
		
		char [][] out = GwtCompatibility.fill2D(' ', width, height);
		
		for (int x=0; x<width; x++) {
			int yPos = getYPos(waveValues[x], height);
			//out[x][yPos] = '•';			
			out[x][yPos] = '\u2022';			
		}
		return out;					
	}
	
	private static int getYPos(float v, int height) {
		//System.out.println("v="+v);
		int a = Math.round(v * (height/2));
		
		int yIndex;
		if (a < 0) {
			yIndex = ((height/2)) + Math.abs(a) -1;
		}
		else {
			yIndex = ((height/2)) - a;			
		}
		
		//System.out.println("a="+a);

		//System.out.println("index="+yIndex);
		return yIndex;		
	}
		
	public void applyWave(Wave waveToApply, float intensity) {
		
		if (waveToApply.waveValues.length != waveValues.length) {
			return;
		}
		
		for (int i=0; i<waveValues.length;i++) {
			
			if (waveToApply.inDeadZone(i) == false) {
				float diff = waveValues[i] - waveToApply.waveValues[i];
				//waveValues[i] = clamp(waveValues[i] - (diff * intensity), -1f, 1f);
				waveValues[i] = waveValues[i] - (diff * intensity);					
			}
			
		}
		
	}
	
	private boolean inDeadZone(int i) {
		if (i > deadzoneStart && i < deadzoneEnd) {
			
			return true;
		}
		else
			return false;
	}
	
	public float getDifference(Wave other) {
		float diff = 0.f;
		for (int i=0; i<waveValues.length;i++) {
			diff += Math.abs(waveValues[i] - other.waveValues[i]);
		}
		return diff;
		
	}
	
	public static float clamp(float val, float min, float max) {
	    return Math.max(min, Math.min(max, val));
	}

}
