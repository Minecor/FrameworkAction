package top.mineor.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by mineor on 2017/1/19.
 */
public class AuthProxy implements MethodInterceptor {
    private String name;
    public AuthProxy(String name){
        this.name = name;
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //仅有tom可以执行增删改查,别的用户都无法通过
        if(!"tom".equals(name)){
            System.out.println("你没有权限!");
            return null;
        }
        return methodProxy.invokeSuper(o, objects);
    }
}
