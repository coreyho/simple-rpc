package corey.DTO;

import lombok.Data;

import java.io.Serializable;

/**
 * @author corey
 * @date 2019-12-19
 */
@Data
public class TransformDTO implements Serializable {
    private static final long serialVersionUID = -6973756661873427261L;
    String classPath;
    String methodName;
    Object[] argsValue;
}
