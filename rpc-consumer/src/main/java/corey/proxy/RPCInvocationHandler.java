package corey.proxy;

import corey.DTO.TransformDTO;
import corey.api.ServiceMapped;
import corey.net.io.Client;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author corey
 * @date 2019-12-19
 */
public class RPCInvocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("11111");
        TransformDTO transformDTO = new TransformDTO();
        transformDTO.setMethodName(method.getName());
        transformDTO.setArgsValue(args);
        //模拟注册中心
        transformDTO.setClassPath(getClassPath(method));
        return Client.callRemoteService("localhost", 8000, transformDTO);
    }

    private String getClassPath(Method method) {
        return method.getDeclaringClass().getDeclaredAnnotation(ServiceMapped.class).serviceValue();
    }
}
