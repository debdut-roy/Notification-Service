package com.practice.Notification_Service.DTO;

public class CandidateCreatedDetailsDto {

	private String candidateName;
	private String candidateEmail;
	private String candidateTemporaryPassword;
	public CandidateCreatedDetailsDto() {
		super();
	}
	public CandidateCreatedDetailsDto(String candidateName, String candidateEmail, String candidateTemporaryPassword) {
		super();
		this.candidateName = candidateName;
		this.candidateEmail = candidateEmail;
		this.candidateTemporaryPassword = candidateTemporaryPassword;
	}
	public String getCandidateName() {
		return candidateName;
	}
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	public String getCandidateEmail() {
		return candidateEmail;
	}
	public void setCandidateEmail(String candidateEmail) {
		this.candidateEmail = candidateEmail;
	}
	public String getCandidateTemporaryPassword() {
		return candidateTemporaryPassword;
	}
	public void setCandidateTemporaryPassword(String candidateTemporaryPassword) {
		this.candidateTemporaryPassword = candidateTemporaryPassword;
	}
	@Override
	public String toString() {
		return "CandidateCreatedDetailsDto [candidateName=" + candidateName + ", candidateEmail=" + candidateEmail
				+ ", candidateTemporaryPassword=" + candidateTemporaryPassword + "]";
	}
	
	
}
