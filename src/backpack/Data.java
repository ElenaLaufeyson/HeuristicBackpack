package backpack;

import java.util.ArrayList;

public class Data {
    public static ArrayList<Thing> lst; //�������� ����� ��������� ��� �������
    public static int L;               //������������ ��� �������
    
    public static void input(int w[], int c[], int LL) {
        L = LL;
        lst = new ArrayList<>();
        boolean goodPack = false;
        for (int i=0; i<w.length; i++) {
            //���� ���� ���� ������� � ����� <= L
            if (w[i] <= L) {
                goodPack = true;   
            }
            lst.add(new Thing(w[i], c[i]));
        }
        if (!goodPack)
            throw new IllegalArgumentException("� ������ ��� �������� ����������� ����");
    }
}
