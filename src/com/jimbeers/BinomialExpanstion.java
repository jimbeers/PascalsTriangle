package com.jimbeers;
/*
 *  This is the binomial expantion object.
 *
 */

public class BinomialExpanstion {
	long[] multiplyers;
	public BinomialExpanstion(int x, int y, int k) {
		int numTerms = k+1;// there are one more terms then the number of powers.
		PascalsTriangle t = new PascalsTriangle(k+1);
		multiplyers = t.getPascalsTriangle();
		// now calculate multiplyers, and multiply mulitplyers by these new ones
		for (int cnt=0; cnt<numTerms; cnt++) {  // x multi will go from k to 0, y will go from 0 to k
			long xMul = power(x, k-cnt);
			long yMul = power(y, cnt);
			multiplyers[cnt] = multiplyers[cnt]*xMul*yMul;
		}
	}
	
	public String toString() {
		String retString = "";
		for (int cnt=0; cnt<multiplyers.length; cnt++) {
			retString += Long.toString(multiplyers[cnt]) + " ";
		}
		return retString;
	}
	
	long power(long x, long y) {
		if (y==0) {
			return 1;
		}
		
		long retValue = 1;
		for (int cnt=0; cnt<y; cnt++) {
			retValue*=x;
		}
		
		return retValue;
	}

	public static void main(String[] args) {
		BinomialExpanstion e = new BinomialExpanstion(3,4,5);
		
		System.out.print(e);

	}

}
