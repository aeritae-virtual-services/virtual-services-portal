package com.vsportal.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URIHelper {
	
	public String decodeURIComponent(String encodedURI) {
		String decodedURI = null;
		try {
			decodedURI = URLDecoder.decode(encodedURI.replaceAll("+", "%2B"), "UTF-8").replaceAll("%2B", "+");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return decodedURI;
	}
	
	public String encodeURIComponent(String decodedURI) {
		String encodedURI = null;
		try {
			encodedURI = URLEncoder.encode(decodedURI.replaceAll("%2B", "+"), "UTF-8").replaceAll("+", "%2B");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return encodedURI;
	}
}
