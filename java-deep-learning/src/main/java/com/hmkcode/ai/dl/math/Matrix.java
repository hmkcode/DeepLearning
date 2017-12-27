package com.hmkcode.ai.dl.math;	
	
	public class Matrix {
	
	public static int ROW = 0;
	public static int COLUMN = 1;

	private double[][] values;
	private int rows;
	private int columns;
	
	public Matrix(int rows, int columns){
		this.rows = rows;
		this.columns = columns;
		
		this.values = new double[this.rows][this.columns];
	}
	
	public Matrix(double[][] values){
		this.values = values;
		
		if(values != null){
			this.rows = values.length;
			
			if(values.length > 0)
			this.columns = values[0].length;
		}
	
	}
	public Matrix getRow(int index){
		double[][] results = new double[1][columns];
		results[0] = this.values[index];
		
		return new Matrix(results);
	}
	
	public Matrix getColumn(int index){
		
		double[][] results = new double[rows][1];
		
		for(int r = 0 ; r < rows; r++)
			results[r][0] = this.values[r][index];

		return new Matrix(results);
	}
	
	public Vector getVector(int index, int direction){
	
		
		if (direction == ROW)
			return new Vector(this.values[index]);		
		else if(direction == COLUMN){
			double[] column = new double[getRows()];
			
			for(int r = 0 ; r < rows; r++)
			column[r] = this.values[r][index];
			
			return new Vector(column);
		}
		else
			return null;
	}
	
	
	public Matrix T(){
	
		double[][] tMatrix = new double[getColumns()][getRows()];
	
		
		for(int r = 0 ; r < rows; r++)
		for(int c = 0 ; c < columns ; c++)
		tMatrix[c][r] = this.values[r][c];
		
		return new Matrix(tMatrix);
	
	}
	
	public static Matrix M(Vector vector){
		double[][] results = new double[1][vector.getValues().length];
		results[0] = vector.getValues();
		
		return new Matrix(results);
	}
	
	public Matrix dot(Matrix matrix){
	
		double[][] results = new double[this.getRows()][matrix.getColumns()];
		
		for(int r = 0; r < this.getRows(); r++)
		for(int c = 0 ; c < matrix.columns; c++)
		results[r][c] = this.getVector(r, ROW).dot(matrix.getVector(c, COLUMN));
		
		return new Matrix(results);
	}
	// =============================
	
	public double[][] getValues() {
		return values;
	}
	
	public void setValues(double[][] values) {
		this.values = values;
	}
	
	public int getRows() {
		return rows;
	}
	
	public void setRows(int rows) {
		this.rows = rows;
	}
	
	public int getColumns() {
		return columns;
	}
	
	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	@Override
	public String toString() {
	
		String output = "";
		
		for(int r = 0 ; r < this.rows; r++){
		for(int c = 0 ; c < this.columns; c++)
		output += this.values[r][c]+", ";
		
		output += "\n";
		}
		
		return output;
	}
}