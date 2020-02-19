package com.capgemini.online_test.dto;

public class User {
        private String userName,userPassword;
    private long userId;
    private Tests userTest;
    private Boolean isAdmin;
        public String getUserName() {
                return userName;
        }
        public void setUserName(String userName) {
                this.userName = userName;
        }
        public String getUserPassword() {
                return userPassword;
        }
        public void setUserPassword(String userPassword) {
                this.userPassword = userPassword;
        }
        public long getUserId() {
                return userId;
        }
        public void setUserId(long userId) {
                this.userId = userId;
        }
        public Tests getUserTest() {
                return userTest;
        }
        public void setUserTest(Tests userTest) {
                this.userTest = userTest;
        }
        public Boolean getIsAdmin() {
                return isAdmin;
        }
        public void setIsAdmin(Boolean isAdmin) {
                this.isAdmin = isAdmin;
        }
        public User(String userName, String userPassword, long userId, Tests userTest, Boolean isAdmin) {
                super();
                this.userName = userName;
                this.userPassword = userPassword;
                this.userId = userId;
                this.userTest = userTest;
                this.isAdmin = isAdmin;
        }

}
