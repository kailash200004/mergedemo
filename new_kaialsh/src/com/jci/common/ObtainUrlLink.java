package com.jci.common;

import java.net.URL;

import javax.servlet.http.HttpServletRequest;

public class ObtainUrlLink {

	public static String obtainURL(HttpServletRequest request, String project_type) {
		String url = "";
		try {
			URL urll2 = new URL(request.getRequestURL().toString());
			url = urll2.getAuthority();
			if(url.toLowerCase().contains("") || url.toLowerCase().contains(".com") || url.toLowerCase().contains(".com")) {
				url = "https://"+url;
				if(project_type.toLowerCase().trim().contains("wet")) {
					url += "/";
				}else if(project_type.toLowerCase().trim().contains("wat")) {
					url += "/-3";
				}else if(project_type.toLowerCase().trim().contains("login")) {
					url += "/-2";
				}
			}else {
				//uncomment me for local requests

				url = "http://" + url;
				if (project_type.toLowerCase().trim().contains("wet")) {
					url += "/";
				} else if (project_type.toLowerCase().trim().contains("wat")) {
					url += "/-2";
				}

			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
			url = "http://cyfuture.com/";
		}
		System.out.println("URL Created is: "+url);
		return url;
	}
	public static String extractPageNameFromURLString(String urlString){
        if (urlString==null) return null;
        int lastSlash = urlString.lastIndexOf("/");
        //if (lastSlash==-1) lastSlash = 0;
        String pageAndExtensions = urlString.substring(lastSlash+1);
        int lastQuestion = pageAndExtensions.lastIndexOf("?");
        if (lastQuestion==-1) lastQuestion = pageAndExtensions.length();
        String result = pageAndExtensions.substring(0,lastQuestion);
        return result;
    }

}