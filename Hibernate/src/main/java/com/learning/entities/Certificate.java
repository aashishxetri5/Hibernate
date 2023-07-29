package com.learning.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Certificate {
	private String title;
	private String duration;
	private String certifiedBy;

	public Certificate() {
		super();
	}

	public Certificate(String title, String duration, String certifiedBy) {
		super();
		this.title = title;
		this.duration = duration;
		this.certifiedBy = certifiedBy;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getCertifiedBy() {
		return certifiedBy;
	}

	public void setCertifiedBy(String certifiedBy) {
		this.certifiedBy = certifiedBy;
	}
	
	

}
