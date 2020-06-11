package com.capgemini.online_test.dto;

public class User {

		private Long userId;
		private String userName;
		private Test userTest;
	    private Boolean isAdmin;
		private String userPassword;
		
		
		public User(Long userId, String userName, Test userTest, Boolean isAdmin, String userPassword) {
			super();
			this.userId = userId;
			this.userName = userName;
			this.userTest = userTest;
			this.isAdmin = isAdmin;
			this.userPassword = userPassword;
		}


		public Long getUserId() {
			return userId;
		}


		public void setUserId(Long userId) {
			this.userId = userId;
		}


		public String getUserName() {
			return userName;
		}


		public void setUserName(String userName) {
			this.userName = userName;
		}


		public Test getUserTest() {
			return userTest;
		}


		public void setUserTest(Test userTest) {
			this.userTest = userTest;
		}


		public Boolean isAdmin() {
			return isAdmin;
		}


		public void setAdmin(Boolean isAdmin) {
			this.isAdmin = isAdmin;
		}


		public String getUserPassword() {
			return userPassword;
		}


		public void setUserPassword(String userPassword) {
			this.userPassword = userPassword;
		}


		@Override
		public String toString() {
			return "User [userId=" + userId + ", userName=" + userName + ", userTest=" + userTest + ", isAdmin=" + isAdmin
					+ ", userPassword=" + userPassword + "]";
		}
		
	}
