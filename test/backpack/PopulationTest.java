package backpack;

import org.junit.Test;
import static org.junit.Assert.*;

public class PopulationTest {
    
    @Test
    public void testGenetic() {
        System.out.println("Genetic test");
        int[] w1 = {10, 20, 30, 50, 80, 130, 210, 340, 550, 890, 1440, 2330, 3770};
        int[] c1 = {72, 72, 13, 107, 124, 97, 150, 128, 16, 74, 141, 81, 24};
        int L = 150;
        final int iterationNumber = 13;
        Data.input(w1, c1, L);
        GreedyClass greedy1 = new GreedyClass();
        int geneticResult1 = 0;
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
        geneticResult1 = (population.findBestChromosome()).getBest();
        System.out.println(geneticResult1);
        int result1 = greedy1.find();
        boolean resultBoolean = false;
        boolean expectedTrue = true;
        if (geneticResult1 >= result1) 
            resultBoolean = true;
        assertEquals(expectedTrue, resultBoolean);
    }
}
