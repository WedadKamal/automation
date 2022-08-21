package com.fawry.API.angularAutomation.dataModels;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class MainDataModel {

	private String expectedMessage;

	@JsonIgnore
	public int getExpectedstatusMessage() {
		return expectedstatusMessage;
	}

	public void setExpectedstatusMessage(int expectedstatusMessage) {
		this.expectedstatusMessage = expectedstatusMessage;
	}



	private int expectedstatusMessage;
	private String testCaseId;
	private String testCaseTitle;
	private String errType;

	private String idInDB;
	private String dbCriteria;

	@JsonIgnore
	public String getTestCaseId() {
		return testCaseId;
	}
	public void setTestCaseId(String testCaseId) {
		this.testCaseId = testCaseId;
	}

	@JsonIgnore
	public String getTestCaseTitle() {
		return testCaseTitle;
	}

	public void setTestCaseTitle(String testCaseTitle) {
		this.testCaseTitle = testCaseTitle;
	}

	@JsonIgnore
	public String getExpectedMessage() {
		return expectedMessage;
	}
	public void setExpectedMessage(String expectedMessage) {
			this.expectedMessage = expectedMessage;
		}

	@JsonIgnore
	public String getErrType() {
		return errType;
	}

	public void setErrType(String errType) {
		this.errType = errType;
	}


	@JsonIgnore
	public String getIdInDB() {
		return idInDB;
	}

	public void setIdInDB(String idInDB) {
		this.idInDB = idInDB;
	}

	@JsonIgnore
	public String getDbCriteria() {
		return dbCriteria;
	}

	public void setDbCriteria(String dbCriteria) {
		this.dbCriteria = dbCriteria;
	}
}
