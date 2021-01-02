package org.balaji.multiplex.trades;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TradesApplication {

    public static void main(String[] args) {

//        SpringApplication.run(TradesApplication.class, args);
        Set<String> set = new TreeSet<String>();
        set.add("core java");
        set.add("php");
        set.add("j2ee");
        set.add("struts");
        set.add("hibernate");


        set.contains("php");

        Iterator<String> itr = set.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        set.remove("php");

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
