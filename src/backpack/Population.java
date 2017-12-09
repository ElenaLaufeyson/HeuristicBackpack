package backpack;

import java.util.Random;

public class Population {
    //���������� ������ � ���������
    private final int populationSize = 100; 

    public int getPopulationSize() {
        return populationSize;
    }
    
    //���������� ������ ��� ���������� ������
    private final int tournamentNumber = populationSize/2;
        
    //������ �������� ������ ���������
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

    //������� ���������
    public void createPopulation(){
        for (int i=0; i<populationSize; i++) {
            population[i] = new Chromosome();
            //���������� ��������� ��������� ������� 0 � 1
            population[i].fillingChromosome();
        }			
    }	
        
    //��������� "����������" ���� ��������
    public void successAllChromosome() {
	for (int i=0; i<populationSize; i++){
            population[i].calculateBest();
	}
    }
    
    //����� ������ ���������
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
        //��������� ��� ��� �����������
        int[][] pairs = getPairsForCrossing(); 
        //�����(���������) ��������� ����� ����������� � �������
        Chromosome nextPopulation[] = new Chromosome[populationSize];
        nextPopulation = getNextPopulation(pairs);
        this.population = nextPopulation;
    } 
    
    //��������� ��� ��� �����������
    public int[][] getPairsForCrossing() {
        int[][] pairs = new int[populationSize][2];
        int �hromosome1; 
        int �hromosome2; 
        for (int i=0; i<populationSize; i++) {
        //������� ������ ����� (���������1) � �������
            �hromosome1 = findBestTournament(-1);            			            
        //������� ������ ����� (���������2) � �������,����� �� ������ ���� � �����
            �hromosome2 = findBestTournament(�hromosome1);
            pairs[i][0] = �hromosome1;
            pairs[i][1] = �hromosome2;
        }
        return pairs;
    }
        
    //������� ������ ��������� � �������. � ������� ��������� tournamentNumber ������		
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
        
    //������� �����(���������) ��������� ����� ����������� � �������
    private Chromosome[] getNextPopulation(int[][] pairs) {
        Chromosome nextPopulation[] = new Chromosome[populationSize];
        nextPopulation[0] = findBestChromosome();
        Chromosome parent1;     //������ �������� ��� �����������
        Chromosome parent2;     //������ �������� ��� ����������� 
        Chromosome resultChild;    //��������� ����������� parent1+parent2
        for (int i = 1; i < populationSize; ++i) {
            parent1 = population[pairs[i][0]];
            parent2 = population[pairs[i][1]];
            resultChild = parent1.Crossing(parent2); //�����������
            nextPopulation[i] = resultChild;
            nextPopulation[i] = nextPopulation[i].mutation(); //�������
        }
        return nextPopulation;
    }
}
