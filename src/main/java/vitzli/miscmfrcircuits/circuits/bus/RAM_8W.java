package vitzli.miscmfrcircuits.circuits.bus;

import vitzli.miscmfrcircuits.circuits.base.RAMcircuit;

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
