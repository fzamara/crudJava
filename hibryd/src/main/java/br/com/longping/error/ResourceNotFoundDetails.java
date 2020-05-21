package br.com.longping.error;

import javax.annotation.Generated;

public class ResourceNotFoundDetails {

	private String title;
	private String detail;
	private int status;
	private long timestamp;
	private String developerMessage;

	@Generated("SparkTools")
	private ResourceNotFoundDetails(Builder builder) {
		this.title = builder.title;
		this.detail = builder.detail;
		this.status = builder.status;
		this.timestamp = builder.timestamp;
		this.developerMessage = builder.developerMessage;
	}
	public String getTitle() {
		return title;
	}
	public String getDetail() {
		return detail;
	}
	public int getStatus() {
		return status;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public String getDeveloperMessage() {
		return developerMessage;
	}
	public ResourceNotFoundDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * Creates builder to build {@link ResourceNotFoundDetails}.
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}
	/**
	 * Builder to build {@link ResourceNotFoundDetails}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
		private String title;
		private String detail;
		private int status;
		private long timestamp;
		private String developerMessage;

		private Builder() {
		}
		
		
		public Builder withTitle(String title) {
			this.title = title;
			return this;
		}

		public Builder withDetail(String detail) {
			this.detail = detail;
			return this;
		}

		public Builder withStatus(int status) {
			this.status = status;
			return this;
		}

		public Builder withTimestamp(long timestamp) {
			this.timestamp = timestamp;
			return this;
		}

		public Builder withDeveloperMessage(String developerMessage) {
			this.developerMessage = developerMessage;
			return this;
		}

		public static Builder newBuilder() {
			return new Builder();
		}
	}
	
	
	
}
