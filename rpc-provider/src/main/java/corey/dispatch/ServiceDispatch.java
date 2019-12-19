package corey.dispatch;

import corey.DTO.TransformDTO;

import java.lang.reflect.Method;

/**
 * @author corey
 * @date 2019-12-19
 */
public class ServiceDispatch {
    public static Object dispatch(Object requestObj) throws Exception {
        if (!(requestObj instanceof TransformDTO)) {
            return null;
        }
        TransformDTO transformDTO = (TransformDTO) requestObj;
        if (transformDTO.getMethodName() == null || transformDTO.getClassPath() == null) {
            return null;
        }
        String methodName = transformDTO.getMethodName();
        Class<?> clazz = Class.forName(transformDTO.getClassPath());
        //参数列表为空
        if (transformDTO.getArgsValue() == null || transformDTO.getArgsValue().length <= 0) {
            Method method = clazz.getDeclaredMethod(methodName);
            return method.invoke(clazz.newInstance());
        }
        //参数列表不为空
        Object[] params = transformDTO.getArgsValue();
        Class[] types = new Class[params.length];
        for (int i = 0; i < params.length; i++) {
            types[i] = params[i].getClass();
        }
        Method method = clazz.getDeclaredMethod(methodName, types);
        return method.invoke(clazz.newInstance(), params);

    }

}
