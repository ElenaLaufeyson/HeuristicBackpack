package backpack;

import java.util.ArrayList;
import java.util.Collections;

public class GreedyClass {

    int find() {             
        //��������� �� �������� Thing.d
        Collections.sort(Data.lst);
        System.out.println("");
        //����� ��������
        int sumPrice1 = 0; 
        int sumW1 = 0;
        int currentL = Data.L;
        ArrayList result = new ArrayList();
        int wi; //��� �������� ��������
        for (int i=0; i<Data.lst.size(); i++) {
            wi = Data.lst.get(i).getWeight();
            if (currentL < wi) {
                continue;
            }    
            result.add(wi);
            sumW1 += wi;
            currentL -= wi; //������� ����
            sumPrice1 += Data.lst.get(i).getPrice();                        
        }
        System.out.println(" res = " + result + " = "+ sumW1);
        return sumPrice1;
    }
}
