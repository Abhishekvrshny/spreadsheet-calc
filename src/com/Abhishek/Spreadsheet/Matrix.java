package com.Abhishek.Spreadsheet;

class Matrix {
	
	int rows;
	int cols;
	Cell[][] sheet;
	
	Matrix(int rows,int cols){
		this.rows=rows;
		this.cols=cols;
		sheet = new Cell[rows][cols];
	}
	
	void insertInteger(int row,int col,double value){
		Cell cell=new Cell(value);
		this.sheet[row][col] = cell;
	}
	void insertExpr(int row,int col,String expr){
		Cell cell=new Cell(expr);
		this.sheet[row][col] = cell;
	}
	boolean getVisitedFlag(int row,int col){
		return (this.sheet[row][col]).getVisited();
	}
	void setVisitedFlag(int row,int col){
		(this.sheet[row][col]).setVisited();
	}
	double getValue(int row,int col){
		return this.sheet[row][col].getValue();
	}
	String getExpr(int row,int col){
		return this.sheet[row][col].getExpr();
	}

}
