package top.mineor.cglib;

/**
 * Created by mineor on 2017/1/19.
 */
public class Client {
    public static void main(String[] args) {
        TableDAOFactory factory = new TableDAOFactory();
        TableDAO dao1 = factory.getAuthTableDAO(new AuthProxy("tom"));
        TableDAO dao2 = factory.getAuthTableDAO(new AuthProxy("nam"));
        crud(dao1);
        crud(dao2);
    }

    public static void crud(TableDAO dao){
        dao.insert();
        dao.update();
        dao.query();
        dao.delete();
    }
}
