package com.tangiapps.shooternew;

import java.util.ArrayList;
import java.util.Random;

public class AppMatrix {

	

	
	
	
	
	//  1------>  RED
	//  2------>  Green
	//  3------>  Blue
	//  3------>  Yellow
	
	

	public static final int level_1[][] = {				///////done

			{0, 0, 1, 1, 2, 3, 3, 2, 3, 2, 0,0,0},
			{3, 3, 3, 3, 3, 1, 3, 1,3,2,1,1,1},
			{1, 3, 3, 2, 3, 0, 0, 0,0,2,3,2,2},
			{0, 3, 2, 0, 3, 3, 3, 3,0,3,2,3,3},
			{1, 3, 3, 2, 3, 1, 1, 1,2,3,0,4,4},
			{2, 3, 0, 2, 3, 2, 3, 1,3,3,3,3,3},
			{3, 0, 3, 3, 2, 1, 3, 1,3,2,0,2,2},
			{2, 3, 0, 2, 3, 1, 3, 3,3,1,0,1,1},
			{2, 3, 0, 2, 3, 1, 3, 3,3,2,1,0,0},
			{2, 3, 0, 2, 3, 1, 3, 3,3,1,2,2,2},
			{2, 3, 0, 2, 3, 1, 3, 3,3,1,2,2,2},

	};
	
	
	
	public int[][] levelMatrix(int levelno) {

		switch (levelno) {

		case 1:
			
			
			return level_1;
			//break;
		
		
		}
		return level_1;
	}

	private void setLevelMatrix(byte h[][]) {

		//System.out.println("  copying main matrix");
		for (int k = 0; k < ApplicationView.row_count; k++)
			for (int l = 0; l < ApplicationView.col_count; l++) {
				
				
			}
		

	}
	int  getBalls(){
		ArrayList<Integer> listc = new ArrayList<Integer>();
		for (int i=0;i<4;i++ ){
			listc.add(i);
		}
		boolean flag=true;
		int n,count=0,i=1;
		Random r = new Random();
		n=r.nextInt(listc.size());
//		int [] a=new int[4];
//		a[0]=0;
//		while(flag){
//			count=0;
//			n=r.nextInt(listc.size());
//			for (int j=0;j<a.length;j++){
//				if (a[j]==n)
//					count++;
//			}
//			if (count!=0)
//			{
//				continue;
//			}
//			if (count==0){
//				a[i]=n;
//				i++;
//			}
//			if (i==4){
//				flag=false;
//			}
//
//		}
		return n;
	}




}
