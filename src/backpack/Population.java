package backpack;

import java.util.Random;

public class Population {
    //Количество особей в популяции
    private final int populationSize = 100; 

    public int getPopulationSize() {
        return populationSize;
    }
    
    //Количество особей для турнирного отбора
    private final int tournamentNumber = populationSize/2;
        
    //Массив хромосом особей популяции
    private Chromosome population[]; 

    public Population() {
        population = new Chromosome[populationSize];
    }
        
    public Chromosome[] getPopulation() {
        return population;
    }

    public void setPopulation(Chromosome[] population) {
        this.population = population;
    }

    //Создаем популяцию
    public void createPopulation(){
        for (int i=0; i<populationSize; i++) {
            population[i] = new Chromosome();
            //Заполнение хромосомы случайным набором 0 и 1
            population[i].fillingChromosome();
        }			
    }	
        
    //Вычисляем "успешность" всех хромосом
    public void successAllChromosome() {
	for (int i=0; i<populationSize; i++){
            population[i].calculateBest();
	}
    }
    
    //Поиск лучшей хромосомы
    public Chromosome findBestChromosome(){
        int maxBest = 0;
        Chromosome result = population[0];
        for (int i=0; i<populationSize; i++) {
            if (population[i].getBest() > maxBest) {
                result = population[i];
                maxBest = population[i].getBest();
            }
        }
        return result;
    }
    
    public void selestion() {
        //получение пар для скрещивания
        int[][] pairs = getPairsForCrossing(); 
        //новая(следующая) популяция после скрещивания и мутации
        Chromosome nextPopulation[] = new Chromosome[populationSize];
        nextPopulation = getNextPopulation(pairs);
        this.population = nextPopulation;
    } 
    
    //получения пар для скрещивания
    public int[][] getPairsForCrossing() {
        int[][] pairs = new int[populationSize][2];
        int сhromosome1; 
        int сhromosome2; 
        for (int i=0; i<populationSize; i++) {
        //Находим лучшую особь (хромосому1) в турнире
            сhromosome1 = findBestTournament(-1);            			            
        //Находим лучшую особь (хромосому2) в турнире,чтобы не билась сама с собой
            сhromosome2 = findBestTournament(сhromosome1);
            pairs[i][0] = сhromosome1;
            pairs[i][1] = сhromosome2;
        }
        return pairs;
    }
        
    //Находим лучшую хромосому в турнире. В турнире участвуют tournamentNumber особей		
    private int findBestTournament(int index) {
        int bestChromosomeIndex = 0;
        int maxBest = 0;
        int currentIndex;
        Random random = new Random();
        for (int i=0; i<tournamentNumber; i++) {
            currentIndex = random.nextInt(populationSize);
            if (currentIndex == index) {
                i--;
                continue;
            }
            if (population[currentIndex].getBest() > maxBest) {
                maxBest = population[currentIndex].getBest();
                bestChromosomeIndex = currentIndex;
            }
        }
        return bestChromosomeIndex;
    }
        
    //Получим новую(следующую) популяцию после скрещивания и мутации
    private Chromosome[] getNextPopulation(int[][] pairs) {
        Chromosome nextPopulation[] = new Chromosome[populationSize];
        nextPopulation[0] = findBestChromosome();
        Chromosome parent1;     //первый родитель для скрещивания
        Chromosome parent2;     //второй родитель для скрещивания 
        Chromosome resultChild;    //результат скрещивания parent1+parent2
        for (int i = 1; i < populationSize; ++i) {
            parent1 = population[pairs[i][0]];
            parent2 = population[pairs[i][1]];
            resultChild = parent1.Crossing(parent2); //скрещивание
            nextPopulation[i] = resultChild;
            nextPopulation[i] = nextPopulation[i].mutation(); //мутация
        }
        return nextPopulation;
    }
}
