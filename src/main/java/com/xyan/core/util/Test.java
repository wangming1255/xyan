package com.xyan.core.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Test {
	/**
	 * 获取外网地址
	 * 
	 * @engineer wangrun 
	 * @Description  time 2013-1-29 下午01:34:03
	 * @return void
	 * @throws Exception
	 */
	public static void getPublicIP() throws Exception {
		String inputLine = "";
		String read = "";
		String ip = "";
		URL url = new URL("http://checkip.dyndns.org/");
		HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		while ((read = in.readLine()) != null) {
			inputLine += read;
		}
		String[] strs = inputLine.split(":");
		ip = strs[1].split("<")[0];

	}
	
	public static void main(String[] args) throws Exception {
		int one_million = 1_000_000;
		System.out.println(one_million);
	}
}
