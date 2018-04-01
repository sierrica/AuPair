package com.sierrica.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @RequiredArgsConstructor @AllArgsConstructor
@Getter @Setter
public class Credentials {
	
	@NonNull
	@JsonProperty(value="tokenProvider", index=0, required=true)
	private String tokenProvider;
	
	@JsonProperty(value="clientId", index=1, required=false)
	private String clientId;
	
	@JsonProperty(value="issuer", index=2, required=false)
	private String issuer;
	
	@JsonProperty(value="url", index=3, required=false)
	private String url;
	
	@JsonProperty(value="redirectUri", index=4, required=false)
	private String redirectUri;


//	@Override
//	public String toString() {
//		return "{" + 
//				"\"tokenProvider\":\"" + tokenProvider + "\"," +
//				"\"clientId\":\"" + clientId + "\"," +
//				"\"issuer\":\"" + issuer + "\"," + 
//				"\"url\":\"" + url + "\"," + 
//				"\"redirectUri\":\"" + redirectUri + "\"" + 
//			  "}";
//	}
}