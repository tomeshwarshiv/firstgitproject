package com.chatserver.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="conversation")
public class Conversation {
	
	@Id
	@GeneratedValue
	private Integer id;
	@Column(name="chat_message")
	private String chastMessage;
	@Column(name="logged_id_userid")
	private  Integer loggedInUserId;
	@Column(name="selected_chat_id")
	private Integer selectedChatId;
	
	
	public Conversation() {
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getChastMessage() {
		return chastMessage;
	}


	public void setChastMessage(String chastMessage) {
		this.chastMessage = chastMessage;
	}


	public Integer getLoggedInUserId() {
		return loggedInUserId;
	}


	public void setLoggedInUserId(Integer loggedInUserId) {
		this.loggedInUserId = loggedInUserId;
	}


	public Integer getSelectedChatId() {
		return selectedChatId;
	}


	public void setSelectedChatId(Integer selectedChatId) {
		this.selectedChatId = selectedChatId;
	}


	@Override
	public String toString() {
		return "Conversation [id=" + id + ", chastMessage=" + chastMessage + ", loggedInUserId=" + loggedInUserId
				+ ", selectedChatId=" + selectedChatId + "]";
	}
	
	
	
	
	
	
	
	
	
}
