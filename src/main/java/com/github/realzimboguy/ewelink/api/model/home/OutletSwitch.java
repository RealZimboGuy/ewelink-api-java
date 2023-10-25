package com.github.realzimboguy.ewelink.api.model.home;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OutletSwitch {

	@SerializedName("outlet")
	@Expose
	private int outlet;

	@SerializedName("switch")
	@Expose
	private String _switch;

	public int getOutlet() {

		return outlet;
	}

	public void setOutlet(int outlet) {

		this.outlet = outlet;
	}

	public String get_switch() {

		return _switch;
	}

	public void set_switch(String _switch) {

		this._switch = _switch;
	}

	@Override
	public String toString() {

		return "OutletSwitch{" +
				"outlet=" + outlet +
				", _switch='" + _switch + '\'' +
				'}';
	}
}
