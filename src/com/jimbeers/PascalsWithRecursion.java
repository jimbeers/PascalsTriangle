package com.jimbeers;

import java.util.Arrays;

public class PascalsWithRecursion {
	private long[] valueRow;
	private PascalsWithRecursion previousRow;
	
	public PascalsWithRecursion(int row) {
		if (row == 1) {
			valueRow = new long[] {1};
		} else {
			calculateRow(new PascalsWithRecursion(row-1));
		}
		
		System.out.println(this);
	}

	private void calculateRow(PascalsWithRecursion pascalsWithRecursion) {
		long[] previousRowValues = pascalsWithRecursion.getValueRow();
		 // since index starts with 0, our last element will be the lenght of the previous row
		int currentRowLast = previousRowValues.length; 
		valueRow = new long[currentRowLast+1];
		valueRow[0]=1;  // first value alway 1
		valueRow[currentRowLast]=1;  // last value always 1
		for (int x=1; x<currentRowLast;  x++) {
			valueRow[x] = previousRowValues[x-1] + previousRowValues[x];
		}
	}

	public long[] getValueRow() {
		return valueRow;
	}

	public void setValueRow(long[] valueRow) {
		this.valueRow = valueRow;
	}

	@Override
	public String toString() {
		return "PascalsWithRecursion [valueRow=" + Arrays.toString(valueRow) + "";
	}
	
	public String displayString() {
		return "" + Arrays.toString(valueRow) + "";
	}
	
	
	public static void main(String[] args) {
		PascalsWithRecursion p = new PascalsWithRecursion(28);
		long[] values = p.getValueRow();
		
	}

}
