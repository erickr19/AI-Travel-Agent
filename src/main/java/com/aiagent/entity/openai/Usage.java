package com.aiagent.entity.openai;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Usage POJO for OpenAI API response
 */
public class Usage{

	@JsonProperty("completion_tokens")
	private int completionTokens;

	@JsonProperty("prompt_tokens")
	private int promptTokens;

	@JsonProperty("total_tokens")
	private int totalTokens;

	// constructor

	/**
	 * empty constructor
	 */
	public Usage() {
	}

	/**
	 * Sets tokens used to complete response
	 * @param completionTokens amount of tokens used to respond
	 */
	public void setCompletionTokens(int completionTokens) {
		this.completionTokens = completionTokens;
	}

	/**
	 * Gets completion tokens
	 * @return completion tokens
	 */
	public int getCompletionTokens(){
		return completionTokens;
	}

	/**
	 * Sets tokens used for the prompt
	 * @param promptTokens tokens of prompt
	 */
	public void setPromptTokens(int promptTokens) {
		this.promptTokens = promptTokens;
	}

	/**
	 * Gets prompt tokens
	 * @return prompt tokens
	 */
	public int getPromptTokens(){
		return promptTokens;
	}

	/**
	 * Sets total tokens used (prompt and completion tokens)
	 * @param totalTokens total tokens used
	 */
	public void setTotalTokens(int totalTokens) {
		this.totalTokens = totalTokens;
	}

	/**
	 * Gets total tokens
	 * @return total tokens
	 */
	public int getTotalTokens(){
		return totalTokens;
	}
}