package vitzli.miscmfrcircuits.lib;

import java.util.Arrays;

public class RAMdata {
	
	private int[] memArray;
	private int size;

	public RAMdata(int RAMsize) {
		this.memArray = new int[RAMsize];
		this.size = RAMsize;
	}
	
	public int read(int pos) {
		return this.memArray[pos];
	}
	
	public void write(int value, int pos) {
		this.memArray[pos] = value;
	}

	public void reset() {
		Arrays.fill(this.memArray, 0);
	}
	
	public int[] getArray() {
		return this.memArray;
	}
	
	public void init(int RAMsize, int[] values){
		this.memArray = values;
		this.size = RAMsize;
	}
}
