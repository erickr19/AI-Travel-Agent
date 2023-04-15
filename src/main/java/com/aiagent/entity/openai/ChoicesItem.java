package com.aiagent.entity.openai;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Choices POJO from OpenAI response
 */
public class ChoicesItem{

	@JsonProperty("finish_reason")
	private String finishReason;

	@JsonProperty("index")
	private int index;

	@JsonProperty("text")
	private String text;

	@JsonProperty("logprobs")
	private Object logprobs;

	// constructors
	/**
	 * empty constructor
	 */
	public ChoicesItem() {
	}

	/**
	 * Sets finish reason of response generation
	 * @param finishReason the reason for stopping response
	 */
	public void setFinishReason(String finishReason) {
		this.finishReason = finishReason;
	}

	/**
	 * Gets finish reason
	 * @return finish reason
	 */
	public String getFinishReason(){
		return finishReason;
	}

	/**
	 * Sets index of response
	 * note: I'm unsure of what this actually represents as the API docs don't describe it
	 * @param index response index
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * Gets index
	 * @return index
	 */
	public int getIndex(){
		return index;
	}

	/**
	 * Sets text of response
	 * @param text response text
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Gets text of the response
	 * @return response text
	 */
	public String getText(){
		return text;
	}

	/**
	 * Sets the log of probabilities the AI generated (if requested)
	 * @param logprobs
	 */
	public void setLogprobs(Object logprobs) {
		this.logprobs = logprobs;
	}

	/**
	 * Gets log of probabilities
	 * @return log of probabilities
	 */
	public Object getLogprobs(){
		return logprobs;
	}
}