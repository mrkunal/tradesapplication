package org.balaji.multiplex.trades;

import java.util.*;

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
/*

        TreeSet<A> treeSet=new TreeSet<>();
        treeSet.add(new A(1,10));
        treeSet.add(new A(2,20));
        treeSet.add(new A(5,15));
        treeSet.add(new A(5,15));
        treeSet.add(new A(5,5));
*/

//        treeSet.forEach(a -> System.out.println(a.age +" "+ a.priority));


        List<A> a=new LinkedList<>();
        a.add(new A(2,20));
        a.add(new A(2,20));
        a.add(new A(1,20));
        a.add(new A(4,15));
        a.add(new A(5,15));
        a.add(new A(5,5));

        Comparator<A> byPriority =
                (A o1, A o2)->{ return o1.priority >o2.priority ? -1: 1;};

        a.sort(byPriority);
        a.stream().forEach(a1 -> {
            System.out.println(a1.age +" "+a1.priority);
        });
    }

    static class A  {
        public int age;
        public int priority;

        public A(int age, int priority) {
            this.age = age;
            this.priority = priority;
        }

      /*  @Override
        public int compareTo(A o) {
            if(this.age == o.age){
                return 0;
            }
            return this.priority>o.priority ? -1: 1;
        }*/
    }
}
