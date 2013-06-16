package vitzli.miscmfrcircuits.circuits;

import vitzli.miscmfrcircuits.circuits.RAMcircuit;

public class RAM_16W extends RAMcircuit {
	
	private final static int memorysize = 16;
	
	public RAM_16W() {
		this.initSize(this.memorysize);
	}

	@Override
	public String getUnlocalizedName() {
		return "miscICs.RAM.16W";
	}

}
