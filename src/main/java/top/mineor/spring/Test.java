package top.mineor.spring;

/**
 * Created by mineor on 2016/12/28.
 */
public class Test {
    public static void main(String[] args) {
        print("1","2","3");
    }

    public static void print(String...args){
        for(int i = 0; i < args.length; i++){
            System.out.println(args[i]);
        }
        Integer three = Integer.valueOf(3);
        int i = new Integer(4).intValue();
    }
}
