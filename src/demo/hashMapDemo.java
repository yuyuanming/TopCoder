package demo;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: yuanming
 * Date: 19/3/13
 * Time: PM9:19
 * To change this template use File | Settings | File Templates.
 */
public class hashMapDemo {
    public static void main(String args[]) {
        HashMap<String, Integer> age = new HashMap<String, Integer>();
        age.put("Andy", Integer.valueOf(70));
        age.put("Bob", Integer.valueOf("100000000"));

        System.out.println(age.get("Cidy"));
        System.out.println(age.get("Bob"));
        age.remove("Bob");
        System.out.println(age.size());
    }
}
