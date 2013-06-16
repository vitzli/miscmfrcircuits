package vitzli.miscmfrcircuits.circuits;

import vitzli.miscmfrcircuits.circuits.RAMcircuit;

public class RAM_8W extends RAMcircuit{

	private final static int memorysize = 8;
	
	public RAM_8W() {
		this.initSize(this.memorysize);
	}

	@Override
	public String getUnlocalizedName() {
		return "miscICs.RAM.8W";
	}

}
