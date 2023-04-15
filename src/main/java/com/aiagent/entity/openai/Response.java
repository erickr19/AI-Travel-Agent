package com.aiagent.entity.openai;

/**
 * Response POJO used for getting Http Response
 * from OpenAI
 */

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response{

	@JsonProperty("created")
	private int created;

	@JsonProperty("usage")
	private Usage usage;

	@JsonProperty("model")
	private String model;

	@JsonProperty("id")
	private String id;

	@JsonProperty("choices")
	private List<ChoicesItem> choices;

	@JsonProperty("object")
	private String object;

	// constructor

	/**
	 * empty constructor
	 */
	public Response() {
	}

	/**
	 * Sets generation id
	 * @param created id of created response
	 */
	public void setCreated(int created) {
		this.created = created;
	}

	/**
	 * Gets generation id
	 * @return generation id
	 */
	public int getCreated(){
		return created;
	}

	/**
	 * Sets token usage
	 * @param usage tokens used
	 */
	public void setUsage(Usage usage) {
		this.usage = usage;
	}

	/**
	 * Gets token usage
	 * @return tokens used
	 */
	public Usage getUsage(){
		return usage;
	}

	/**
	 * Sets ai model
	 * @param model the ai model used
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * Gets ai model
	 * @return ai model
	 */
	public String getModel(){
		return model;
	}

	/**
	 * Sets response id
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets id of response
	 * @return response id
	 */
	public String getId(){
		return id;
	}

	/**
	 * Sets choices (or body) of response
	 * @param choices response body
	 */
	public void setChoices(List<ChoicesItem> choices) {
		this.choices = choices;
	}

	/**
	 * Gets choices
	 * @return list of choices
	 */
	public List<ChoicesItem> getChoices(){
		return choices;
	}

	/**
	 * Sets object (mode) of AI response
	 * @param object mode of AI response
	 */
	public void setObject(String object) {
		this.object = object;
	}

	/**
	 * Gets object or mode
	 * @return object
	 */
	public String getObject(){
		return object;
	}
}