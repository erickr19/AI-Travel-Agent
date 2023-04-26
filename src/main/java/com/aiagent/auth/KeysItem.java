package com.aiagent.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class KeysItem{

	@JsonProperty("kty")
	private String kty;

	@JsonProperty("e")
	private String exponent;

	@JsonProperty("use")
	private String use;

	@JsonProperty("kid")
	private String kid;

	@JsonProperty("alg")
	private String alg;

	@JsonProperty("n")
	private String modulus;

	public String getKty(){
		return kty;
	}

	public String getExponent(){
		return exponent;
	}

	public String getUse(){
		return use;
	}

	public String getKid(){
		return kid;
	}

	public String getAlg(){
		return alg;
	}

	public String getModulus(){
		return modulus;
	}
}