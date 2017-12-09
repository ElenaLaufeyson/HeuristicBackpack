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
        
        //генетический алгоритм
        final int iterationNumber = M;  // оличество проходов цикла программы       
        Population population = new Population();  //попул€ци€       
	population.createPopulation();         //создаем попул€цию                
	int number = 0;                // текущий проход цикла 		
	do {	
            //¬ычисл€ем "успешность" всех хромосом попул€ции
            population.successAllChromosome();
            population.findBestChromosome();
            //селекци€
            population.selestion();
            number++;
        } while (number < iterationNumber);
        System.out.println("Best chromosome: " + population.findBestChromosome());
        
        //жадный алгоритм
        System.out.println("Greedy");
        GreedyClass greed = new GreedyClass();        
        bestPrice = greed.find();
        System.out.println("price = " + bestPrice);   
    }
}
