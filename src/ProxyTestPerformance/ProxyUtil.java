package ProxyTestPerformance;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

public class ProxyUtil {

    public static <T> T getProxy(T obj) {
        return (T) Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

//                Long startTime = System.currentTimeMillis();
                // 条用原对象方法
                Object rs = method.invoke(obj, args);
//                Long endTime = System.currentTimeMillis();
//                System.out.println(method.getName() + "运行时间：" + (endTime - startTime) / 1000.0 + "s");

                return rs;
            }
        });
    }


}