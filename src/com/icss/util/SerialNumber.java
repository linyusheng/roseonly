package com.icss.util;

public abstract class SerialNumber {
	
	public synchronized String getSerialNumber() {
		return process();
	}

	protected abstract String process();
}
