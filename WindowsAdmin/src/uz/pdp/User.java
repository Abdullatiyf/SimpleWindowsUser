package uz.pdp;

public class User {
    private String adminName;
    private String password;
    private Types userType;

    public User() {
    }

    public User(String adminName) {
        this.adminName = adminName;
    }

    public User(String adminName, Types userType) {
        this.adminName = adminName;
        this.userType = userType;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Types getUserType() {
        return userType;
    }

    public void setUserType(Types userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" +
                "adminName='" + adminName + '\'' +
                ", userType=" + userType +
                '}';
    }
}
