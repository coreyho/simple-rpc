package corey;

import corey.DTO.UserDTO;
import corey.api.IUserService;
import corey.proxy.ProxyFactory;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        UserDTO userDTO = new UserDTO();
        userDTO.setAge("18");
        userDTO.setName("jack");
        IUserService userService = ProxyFactory.getUserService(IUserService.class);
        userDTO = userService.addUser(userDTO);
        System.out.println(userDTO);
    }
}
