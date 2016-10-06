package com.Abhishek.Spreadsheet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Spreadsheet {

	public static void main(String[] args) {
		BufferedReader br = null;
		Matrix mObj= null;
		int rows = 0, cols=0;
		try{
			br = new BufferedReader(new InputStreamReader(System.in));
			String dim = br.readLine();
		    cols = Integer.parseInt(dim.split(" ")[0]);
		    rows = Integer.parseInt(dim.split(" ")[1]);
			mObj = new Matrix(rows,cols);

			for (int i=0;i<rows;i++) {
				for (int j=0;j<cols;j++){
					String input = br.readLine();
					if(Utils.isInteger(input)){
						mObj.insertInteger(i,j,Integer.parseInt(input));
					}
					else{
						mObj.insertExpr(i,j,input);
					}
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
	            if (br != null) {
	                try {
	                    br.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
		evaluate(mObj,rows,cols);
	}
	
	static int evaluate(Matrix mObj,int rows,int cols){
		int isCyclic=0;
		for (int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				if (mObj.getExpr(i, j) == null){
					Utils.printCell(mObj.getValue(i, j));
					continue;
				}
				else{
					if(computeExpr(mObj,i,j)){
						Utils.printCell(mObj.getValue(i, j));
					}
					else{
						isCyclic=1;
						System.out.println("cyclic dependency detected");
					}
				}
			}
		}
		return isCyclic;	
	}
	
	static boolean computeExpr(Matrix mObj,int row,int col){
		if (mObj.getVisitedFlag(row,col) && mObj.getExpr(row,col)!=null){
			return false;
		}
		else if(mObj.getExpr(row,col)==null){
			return true;
		}
		else{
			mObj.setVisitedFlag(row, col);
			Stack<String> exprStack = new Stack<String>();
			String expr = mObj.getExpr(row,col);
			exprStack.addAll(Arrays.asList(expr.trim().split(" ")));
			try{
				double computedValue = RPNCalc(exprStack,mObj);
				mObj.insertInteger(row,col,computedValue);
			}
			catch(CircularDependencyException e){
				return false;
			}
			return true;
		}	

	}
	
	static double RPNCalc(Stack<String> exprStack,Matrix mObj) throws CircularDependencyException{
		String token=exprStack.pop();
		double x,y;
		if (Utils.isInteger(token)){
			return Integer.parseInt(token);
		}
		else if(Character.isAlphabetic(token.charAt(0)) && Utils.isInteger((token.substring(1)))){
			if(computeExpr(mObj,(int)(token.charAt(0))-65,Integer.parseInt(token.substring(1))-1)){
				return mObj.getValue((int)(token.charAt(0))-65, Integer.parseInt(token.substring(1))-1);
			}
			else{
				throw new CircularDependencyException("Circular dependency detected"); 
			}
		}
		else if(token.equals("++")){
			x = RPNCalc(exprStack,mObj);
			x+=1;
			return x;	
		}
		else if(token.equals("--")){
			x = RPNCalc(exprStack,mObj);
			x-=1;
			return x;	
		}
		else{
		    y = RPNCalc(exprStack,mObj);  
		    x = RPNCalc(exprStack,mObj);
		    if      (token.equals("+"))  x += y;
		    else if (token.equals("-"))  x -= y;
		    else if (token.equals("*"))  x *= y;
		    else if (token.equals("/"))  x /= y;
			return x;
		}
	}
	
}
