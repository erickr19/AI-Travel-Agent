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
	 * @param createdIdToSet id of created response
	 */
	public void setCreated(int createdIdToSet) {
		this.created = createdIdToSet;
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
	 * @param usageToSet tokens used
	 */
	public void setUsage(Usage usageToSet) {
		this.usage = usageToSet;
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
	 * @param modelUsed the ai model used
	 */
	public void setModel(String modelUsed) {
		this.model = modelUsed;
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
	 * @param idToSet
	 */
	public void setId(String idToSet) {
		this.id = idToSet;
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
	 * @param choicesToSet response body
	 */
	public void setChoices(List<ChoicesItem> choicesToSet) {
		this.choices = choicesToSet;
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
	 * @param objectToSet mode of AI response
	 */
	public void setObject(String objectToSet) {
		this.object = objectToSet;
	}

	/**
	 * Gets object or mode
	 * @return object
	 */
	public String getObject(){
		return object;
	}
}