package com.Abhishek.Spreadsheet;

class CircularDependencyException extends Exception {

	private static final long serialVersionUID = 1L;

	public CircularDependencyException(String message) {
        super(message);
    }
}
