package uz.pdp;

public class UserService implements UserServiceInterface {
    @Override
    public User create(UserDTO newUser) {
        if (!isAdmin(newUser)) {
            User user = new User();
            user.setAdminName(newUser.getName());
            user.setPassword(newUser.getPassword());
            switch (newUser.getType()) {
                case ADMIN -> user.setUserType(Types.ADMIN);
                case USER -> user.setUserType(Types.USER);
                case GUEST -> user.setUserType(Types.GUEST);
            }
            users.add(user);
            return user;
        }
        return null;
    }

    @Override
    public User get(String name, Types val) {
        User userI;
        for (int i = 0; i < users.size(); i++) {
            userI = users.get(i);
            if (userI.getAdminName().equals(name) && userI.getUserType().equals(val)) {
                return userI;
            }
        }
        return null;
    }

    @Override
    public Result edit(UserEditDTO userEditDTO) {
        Result result = new Result();
        User user;
        if (!isAdmin(userEditDTO)) {
            for (int i = 0; i < users.size(); i++) {
                user = users.get(i);
                user.setUserType(userEditDTO.getUserType());
                user.setPassword(userEditDTO.getPassword());
                user.setAdminName(userEditDTO.getName());
                result.setSuccess(true);
                result.setMessage("Successfully edited");
            }
        } else {
            result.setMessage("Error");
        }
        return result;
    }


    @Override
    public Result delete(UserEditDTO userDTO) {
        Result result = new Result();
        User userI;
        for (int i = 0; i < users.size(); i++) {
            userI = users.get(i);
            if (userI.getUserType().equals(userDTO.getUserType())) {
                result.setSuccess(users.remove(userI));
                result.setMessage("User removed");
                return result;
            }
        }
        result.setMessage("Error");
        return result;
    }

    private boolean isAdmin(UserDTO user) {
        User user1;
        for (int i = 0; i < users.size(); i++) {
            user1 = users.get(i);
            if (user1.getAdminName().equals(user.getName()) && user1.getUserType().equals(user.getType())) {
                return true;
            }
        }
        return false;
    }

    public void printAll(User user) {
        if (user.getUserType().equals(Types.ADMIN)) {
            for (int i = 0; i < users.size(); i++) {
                System.out.println((i + 1) + "=" + users.get(i));
            }
        } else System.err.println("You do not have enough rights");
    }

    public Result editUserByAdmin(int index, UserEditDTO user) {
        Result result = new Result();
        index -= 1;
        for (int i = 0; i < users.size(); i++) {
            if (index == i) {
                edit(user);
                result.setSuccess(true);
                result.setMessage("Successfully edited by " + user.getUserType());
                return result;
            }
        }
        result.setMessage("Error");
        return result;
    }

    private boolean isAdmin(UserEditDTO user) {
        User user1;
        for (int i = 0; i < users.size(); i++) {
            user1 = users.get(i);
            if (user1.getAdminName().equals(user.getName()) && user1.getUserType().equals(user.getUserType())) {
                return true;
            }
        }
        return false;
    }
}
