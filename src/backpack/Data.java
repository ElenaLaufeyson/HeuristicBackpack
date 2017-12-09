package backpack;

import java.util.ArrayList;

public class Data {
    public static ArrayList<Thing> lst; //Исходный набор предметов для рюкзака
    public static int L;               //максимальный вес рюкзака
    
    public static void input(int w[], int c[], int LL) {
        L = LL;
        lst = new ArrayList<>();
        boolean goodPack = false;
        for (int i=0; i<w.length; i++) {
            //есть хоть один предмет с весом <= L
            if (w[i] <= L) {
                goodPack = true;   
            }
            lst.add(new Thing(w[i], c[i]));
        }
        if (!goodPack)
            throw new IllegalArgumentException("В наборе нет предмета подходящего веса");
    }
}
