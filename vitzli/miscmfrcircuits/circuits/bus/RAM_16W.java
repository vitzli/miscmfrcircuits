package vitzli.miscmfrcircuits.circuits.bus;

import vitzli.miscmfrcircuits.circuits.helpers.RAMcircuit;

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
