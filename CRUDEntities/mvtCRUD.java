package com.microservices.elit.model;

public class mvtCRUD {
	
	mvt test;
	
	HTTPTYPE type;
	
	public mvtCRUD() {
		super();
		// TODO Auto-generated constructor stub
	}

	public mvtCRUD(mvt test, HTTPTYPE type) {
		super();
		this.test = test;
		this.type = type;
	}

	public mvt getmvt() {
		return test;
	}

	public void setmvt(mvt test) {
		this.test = test;
	}

	public HTTPTYPE getType() {
		return type;
	}

	public void setType(HTTPTYPE type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "mvtCRUD [this=" + test + ", type=" + type + "]";
	}
	
}