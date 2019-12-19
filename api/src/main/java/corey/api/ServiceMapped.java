package corey.api;

import java.lang.annotation.*;

/**
 * @author yr
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ServiceMapped {
    String serviceValue();
}
