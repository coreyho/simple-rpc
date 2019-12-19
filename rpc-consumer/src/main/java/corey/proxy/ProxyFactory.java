package corey.proxy;

import java.lang.reflect.Proxy;

/**
 * Created by corey on 2019-12-19.
 */
public class ProxyFactory {
    @SuppressWarnings("unchecked")
    public static <T> T getUserService(Class<T> clazz) {
        return (T) Proxy.newProxyInstance(ProxyFactory.class.getClassLoader(), new Class[]{clazz}, new RPCInvocationHandler());
    }
}
