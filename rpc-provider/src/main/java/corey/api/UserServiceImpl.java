package corey.api;

import corey.DTO.UserDTO;

import java.util.Random;

/**
 *
 * @author corey
 * @date 2019-12-19
 */
public class UserServiceImpl implements IUserService {
    @Override
    public UserDTO addUser(UserDTO userDTO) {
        userDTO.setId(new Random().nextInt() + "");
        return userDTO;
    }
}
