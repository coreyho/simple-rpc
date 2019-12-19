package corey.DTO;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author corey
 * @date 2019-12-19
 */
@Data
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 6626033950120315566L;
    private String name;
    private String id;
    private String age;
}
