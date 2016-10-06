package com.Abhishek.Spreadsheet;

class Cell {
	
	double value;
	String expr;
	boolean visited;
	
	Cell(double value){
		this.value=value;
		this.expr=null;
		this.visited=false;
		
	}
	Cell(String expr){
		this.value=0;
		this.expr=expr;
		this.visited=false;
		
	}
	double getValue(){
		return this.value;
	}
	boolean getVisited(){
		return this.visited;
	}
	void setVisited(){
		this.visited=true;
	}
	String getExpr(){
		return this.expr;
	}

}
