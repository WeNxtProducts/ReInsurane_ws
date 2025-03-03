package com.vi.corelib.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.vi.corelib.api.RequestPatterns;
import org.apache.catalina.util.URLEncoder;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriBuilderFactory;

import jakarta.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.StringJoiner;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

public abstract class UrlUtility {

	public static HashMap getQueryParamsFromUrl(String url) throws URISyntaxException {
		URI uri = new URI(url);
		String query = uri.getRawQuery();
		HashMap<String, String> queryParams = new HashMap<String, String>();
		try {
			StringJoiner joiner = new StringJoiner("&");
			for (String param : query.split("&")) {
				queryParams.put(param.split("=")[0], decode(param.split("=")[1]));
			}
			return queryParams;
		} catch (Exception e) {
			return null;
		}
	}
	public static String queryStringify(String baseUrl, JsonNode queryString) {
		List<String> params = JsonHelper.getKeys(queryString);
		StringBuilder strBuilder = new StringBuilder();

		for(String str : params) {
			strBuilder.append("&").append(str).append("=").append(queryString.get(str).asText());
		}
		return baseUrl+"?"+(strBuilder.toString().substring(1));

	}
	public static String getFullURL(HttpServletRequest request) {
		StringBuilder requestURL = new StringBuilder(request.getRequestURL().toString());
		String queryString = request.getQueryString();

		if (queryString == null) {
			return requestURL.toString();
		} else {
			return requestURL.append('?').append(queryString).toString();
		}
	}

	private static String decode(String value) throws UnsupportedEncodingException {
		return URLDecoder.decode(value, StandardCharsets.UTF_8.toString());
	}

	public static void setPolicy(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable();
		http.sessionManagement().sessionCreationPolicy(STATELESS);
		http.authorizeRequests().anyRequest().permitAll();
	}

	public static String allowedOrigins() {
		return "*";
	}

	public static String allowedMethods() {
		return "*";
	}

	public static String allowedHeaders() {
		return "*";
	}
}
