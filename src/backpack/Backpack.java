package backpack;

import java.util.Arrays;
import java.util.Random;

public class Backpack {

   public static void main(String[] args) {       
        Random random = new Random();
        int M = 13;
        int w[] = new int[M];
        int c[] = new int[M];
        int L = 150;
        for (int i=0; i<M; i++) {
            w[i] = 1 + random.nextInt(L);
            c[i] = 1 + random.nextInt(L);            
        }
        System.out.println(Arrays.toString(w));
        System.out.println(Arrays.toString(c));
        System.out.println("L = " + L);
        Data.input(w, c, L);
        int bestPrice = 0;
        
        //������������ ��������
        final int iterationNumber = M;  //���������� �������� ����� ���������       
        Population population = new Population();  //���������       
	population.createPopulation();         //������� ���������                
	int number = 0;                // ������� ������ ����� 		
	do {	
            //��������� "����������" ���� �������� ���������
            population.successAllChromosome();
            population.findBestChromosome();
            //��������
            population.selestion();
            number++;
        } while (number < iterationNumber);
        System.out.println("Best chromosome: " + population.findBestChromosome());
        
        //������ ��������
        System.out.println("Greedy");
        GreedyClass greed = new GreedyClass();        
        bestPrice = greed.find();
        System.out.println("price = " + bestPrice);   
    }
}
