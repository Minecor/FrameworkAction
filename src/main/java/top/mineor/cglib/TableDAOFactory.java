package top.mineor.cglib;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

/**
 * Created by mineor on 2017/1/19.
 */
public class TableDAOFactory {
    private TableDAO dao = new TableDAO();
    public TableDAO getTableDAO(){
        return dao;
    }

    public TableDAO getAuthTableDAO(AuthProxy authProxy){
        Enhancer en = new Enhancer();
        en.setSuperclass(TableDAO.class);
        //拦截器组,第一个是定义的拦截器,第二个是空拦截器
        //根据过滤器,当调用方法为query时使用空拦截器,否则使用
        //定义的拦截器,即tom可以增删改查,其他人可以查询
        en.setCallbacks(new Callback[]{authProxy, NoOp.INSTANCE});
        en.setCallbackFilter(new AuthProxyFilter());
        return (TableDAO)en.create();
    }
}
