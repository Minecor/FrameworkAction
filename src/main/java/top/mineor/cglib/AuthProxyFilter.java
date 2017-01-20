package top.mineor.cglib;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * Created by mineor on 2017/1/19.
 */
public class AuthProxyFilter implements CallbackFilter {
    @Override
    public int accept(Method method) {
        //0代表第0个拦截器,1代表第1个拦截器
        if(method.getName().equals("query"))
            return 1;
        return 0;
    }
}
