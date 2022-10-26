package uz.pdp;

import uz.pdp.array.DynamicArray;

public interface UserServiceInterface {
    DynamicArray<User> users = new DynamicArray<>(3);

    User create(UserDTO newUser);

    User get(String name, Types val);

    Result edit(UserEditDTO userEditDTO);

    Result delete(UserEditDTO userDTO);
}
