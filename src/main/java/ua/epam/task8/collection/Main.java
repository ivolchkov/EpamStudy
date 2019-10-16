package ua.epam.task8.collection;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
//        List<Integer> arrList = new MyArrayList<>();
//        List<Integer> linkedList = new MyLinkedList<>();
//
//        System.out.println(arrList);
//        System.out.println(linkedList);
//
//        System.out.println(arrList.isEmpty());
//        System.out.println(linkedList.isEmpty());
//
//        for ( int i = 1; i <= 5; i++ ) {
//            arrList.add(i);
//            linkedList.add(i);
//        }
//
//        System.out.println(arrList);
//        System.out.println(linkedList);
//
//        System.out.println(arrList.size());
//        System.out.println(linkedList.size());
//
//        System.out.println(arrList.isEmpty());
//        System.out.println(linkedList.isEmpty());
//
//        System.out.println(arrList.getByIndex(3));
//        System.out.println(linkedList.getByIndex(3));
//
//        System.out.println(arrList.remove(3));
//        System.out.println(linkedList.remove(3));
//
//        System.out.println(arrList);
//        System.out.println(linkedList);
//
//        arrList.clean();
//        linkedList.clean();
//
//        System.out.println(arrList);
//        System.out.println(linkedList);

        MyHashMap<Integer, Integer> map = new MyHashMap<>();

        System.out.println(map.size());
        System.out.println(map.isEmpty());

        map.put(1,1);
        map.put(2,2);
        System.out.println(map.size());

        HashMap<?,Integer> hMap = new HashMap<>();

    }
}
