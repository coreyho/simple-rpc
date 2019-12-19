package corey.api;


import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import corey.DTO.UserDTO;

/**
 * @author corey
 * @date 2019-12-19
 */
@ServiceMapped(serviceValue = "corey.api.UserServiceImpl")
public interface IUserService {
    UserDTO addUser(UserDTO userDTO);
}
