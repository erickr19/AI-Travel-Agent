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
	 * @param finishReasonToSet the reason for stopping response
	 */
	public void setFinishReason(String finishReasonToSet) {
		this.finishReason = finishReasonToSet;
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
	 * @param indexToSet response index
	 */
	public void setIndex(int indexToSet) {
		this.index = indexToSet;
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
	 * @param texToSet response text
	 */
	public void setText(String textToSet) {
		this.text = textToSet;
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
	 * @param logprobsToSet log of probabilities
	 */
	public void setLogprobs(Object logprobsToSet) {
		this.logprobs = logprobsToSet;
	}

	/**
	 * Gets log of probabilities
	 * @return log of probabilities
	 */
	public Object getLogprobs(){
		return logprobs;
	}
}