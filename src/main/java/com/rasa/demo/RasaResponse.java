package com.rasa.demo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RasaResponse {

	@SerializedName("recipient_id")
	@Expose
	private String recipientId;
	@SerializedName("text")
	@Expose
	private String text;

	public String getRecipientId() {
		return recipientId;
	}

	public void setRecipientId(String recipientId) {
		this.recipientId = recipientId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
