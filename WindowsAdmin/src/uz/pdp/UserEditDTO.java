package uz.pdp;

public class UserEditDTO {
    private String name;
    private String password;
    private Types userType;

    public UserEditDTO() {
    }

    public UserEditDTO(String name, String password, Types userType) {
        this.name = name;
        this.password = password;
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
