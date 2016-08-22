package com.shdev.oukongli.demo.activeMQDemo.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import org.fusesource.hawtbuf.ByteArrayInputStream;

public class TestString {
	public static void main(String[] args) throws IOException {
		String str = "奥运会奥运会奥运会奥运会奥运会奥运会奥运会奥";
		InputStream inputStream = new ByteArrayInputStream(str.getBytes());
		System.out.println(str.getBytes().length);
		byte[] buffer = new byte[64];
		int bytesRead = -1;
		StringBuffer stringBuffer = new StringBuffer();
		while ((bytesRead = inputStream.read(buffer)) != -1) {
			stringBuffer.append(new String(buffer).trim());
		}
		System.out.println(stringBuffer.toString());
		if (inputStream != null) {
			inputStream.close();
		}
	}

}
