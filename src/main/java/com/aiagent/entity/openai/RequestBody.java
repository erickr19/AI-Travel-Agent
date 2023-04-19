package com.aiagent.entity.openai;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * RequestBody
 * Used as a POJO for HttpRequest
 */
public class RequestBody{
	// constructors

	/**
	 * Instantiates an empty RequestBody
	 */
	public RequestBody() {}

	/**
	 * Constructs a default RequestBody for the project
	 * @param prompt the prompt for the AI to use
	 */
	public RequestBody(String prompt) {
		this.topP = 1;
		this.frequencyPenalty = 0;
		this.maxTokens = 512;
		this.presencePenalty = 0;
		this.temperature = 0.7;
		this.model = "text-davinci-003";
		this.prompt = prompt;
	}


	@JsonProperty("top_p")
	private int topP;

	@JsonProperty("frequency_penalty")
	private int frequencyPenalty;

	@JsonProperty("max_tokens")
	private int maxTokens;

	@JsonProperty("presence_penalty")
	private int presencePenalty;

	@JsonProperty("temperature")
	private Object temperature;

	@JsonProperty("model")
	private String model;

	@JsonProperty("prompt")
	private String prompt;

	/**
	 * Sets diversity value
	 * @param topP diversity value max:1
	 */
	public void setTopP(int topP){
		this.topP = topP;
	}

	/**
	 * Gets diversity value
	 * @return diversity value
	 */
	public int getTopP(){
		return topP;
	}

	/**
	 * Sets penalty value for frequency of generated tokens max:2
	 * Controls how often the AI is likely to repeat itself
	 * @param frequencyPenalty penalty value
	 */
	public void setFrequencyPenalty(int frequencyPenalty){
		this.frequencyPenalty = frequencyPenalty;
	}

	/**
	 * Gets penalty value for frequency of generated tokens
	 * @return penalty value
	 */
	public int getFrequencyPenalty(){
		return frequencyPenalty;
	}

	/**
	 * Sets max tokens that AI can use to generate text max:2048
	 * @param maxTokens max token value
	 */
	public void setMaxTokens(int maxTokens){
		this.maxTokens = maxTokens;
	}

	/**
	 * Gets max tokens
	 * @return maximum tokens
	 */
	public int getMaxTokens(){
		return maxTokens;
	}

	/**
	 * Sets penalty value for frequency of generated tokens max:2
	 * Controls how often the AI will talk about new topics
	 * @param presencePenalty
	 */
	public void setPresencePenalty(int presencePenalty){
		this.presencePenalty = presencePenalty;
	}

	/**
	 * Gets presence penalty value
	 * @return presence penalty value
	 */
	public int getPresencePenalty(){
		return presencePenalty;
	}

	/**
	 * Sets the value of randomness the AI should use to generate response max:1
	 * @param temperature
	 */
	public void setTemperature(Object temperature){
		this.temperature = temperature;
	}

	/**
	 * Gets randomness value
	 * @return randomness value
	 */
	public Object getTemperature(){
		return temperature;
	}

	/**
	 * Sets the model the AI should use to generate response
	 * text-davinci-003 - most capable for creative generation
	 * text-curie-001 - as capable as davinci but slower and cheaper
	 * text-babbage-001 - capable for staightforward tasks, fast, cheap
	 * text-ada-001 - capable of simple tasks, cheapest and fastest of the GPT-3 series
	 * @param model
	 */
	public void setModel(String model){
		this.model = model;
	}

	/**
	 * Gets AI model
	 * @return ai model
	 */
	public String getModel(){
		return model;
	}

	/**
	 * Sets prompt the AI should base its response off
	 * @param prompt
	 */
	public void setPrompt(String prompt){
		this.prompt = prompt;
	}

	/**
	 * Gets prompt
	 * @return prompt
	 */
	public String getPrompt(){
		return prompt;
	}

	/**
	 * Displays properties in a string
	 * @return string of all properties
	 */
	@Override
 	public String toString(){
		return 
			"RequestBody{" + 
			"top_p = '" + topP + '\'' + 
			",frequency_penalty = '" + frequencyPenalty + '\'' + 
			",max_tokens = '" + maxTokens + '\'' + 
			",presence_penalty = '" + presencePenalty + '\'' + 
			",temperature = '" + temperature + '\'' + 
			",model = '" + model + '\'' + 
			",prompt = '" + prompt + '\'' + 
			"}";
		}
}