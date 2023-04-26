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
	 * @param completionTokensUsed amount of tokens used to respond
	 */
	public void setCompletionTokens(int completionTokensUsed) {
		this.completionTokens = completionTokensUsed;
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
	 * @param promptTokensUsed tokens of prompt
	 */
	public void setPromptTokens(int promptTokensUsed) {
		this.promptTokens = promptTokensUsed;
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
	 * @param totalTokensUsed total tokens used
	 */
	public void setTotalTokens(int totalTokensUsed) {
		this.totalTokens = totalTokensUsed;
	}

	/**
	 * Gets total tokens
	 * @return total tokens
	 */
	public int getTotalTokens(){
		return totalTokens;
	}
}