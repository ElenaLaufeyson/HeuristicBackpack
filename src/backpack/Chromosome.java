package backpack;

import java.util.Random;

//��������� - ��� ������� ������ (���� 101001)
public class Chromosome {
    final int P = 20; //����������� ������� ���� � ��������� 
    Random random = new Random();
    
    //��� - ������� ���������(0 ��� 1)
    private String genome = new String(); //�����(������) �����(���� ���������)
    
    public String getGenome() {
        return genome;
    }
    
    public void setGenome(String genome) {
        this.genome = genome;
    }
        
    //"����������" ������ ���������(�������� �� � �������� ������)
    private int best;
    
    public int getBest() {
        return best;
    }
    
    public void setBest(int best) {
        this.best = best;
    }
    
    @Override
    protected Object clone() {
        Chromosome result = new Chromosome();
        result.setBest(best);
        result.setGenome(genome);
        return result;
    }

    @Override
    public String toString() {
        return "genome: " + genome + "   best:" + best + "\n";
    }

    //���������� ��������� ��������� ������� 0 � 1
    public void fillingChromosome() {
        StringBuilder gen = new StringBuilder();
        int random01;
        for (int i=0; i<Data.lst.size(); i++) {
            random01 = random.nextInt(2);
            if (random01 == 0)
                gen.append('0');
            else
                gen.append('1');            
        }
        genome = gen.toString();
    }

    //��������� "����������" ���������    
    public void calculateBest() {
        Thing fillPack = getFillPack(); //����������� ������ ��� ���� ���������
        if (fillPack.getWeight() <= Data.L) 
            best = fillPack.getPrice();
    }

    //���������� ����������� ������ ��� ���� ��������� ��� ������(� ����� � �����)
    public Thing getFillPack() {
        int weightSum = 0; 
        int priceSum = 0; 
        for(int i=0; i<Data.lst.size(); i++) {
            if(genome.charAt(i) == '1') {
                weightSum += Data.lst.get(i).getWeight();
                priceSum += Data.lst.get(i).getPrice();
            }
        }
        return new Thing(weightSum, priceSum);
    }

    //����������� parent1(this) � parent2
    public Chromosome Crossing(Chromosome parent2) {
        Chromosome[] resChild =  new Chromosome[2];
        resChild[0] = new Chromosome();
        resChild[1] = new Chromosome();
        int cross = random.nextInt(Data.lst.size()-1);  
        StringBuilder resGenome0 = new StringBuilder();
        StringBuilder resGenome1 = new StringBuilder();
        for (int i = 0; i < Data.lst.size(); i++) {            
            if (i <= cross) {
                resGenome0.append(this.getGenome().charAt(i));
                resGenome1.append(parent2.getGenome().charAt(i));
            } else {
                resGenome0.append(parent2.getGenome().charAt(i));
                resGenome1.append(this.getGenome().charAt(i));
            }
        }
        resChild[0].setGenome(resGenome0.toString());
        resChild[1].setGenome(resGenome1.toString());        
        int childNumber = random.nextInt(2);
        return resChild[childNumber];
    }
    
    //�������
    public Chromosome mutation() {
        Chromosome result = (Chromosome) this.clone();
        StringBuilder resGenome = new StringBuilder(genome);
        char oldValue; //0 ��� 1
        char newValue; //1 ��� 0
        int randomPercent;
        for (int i=0; i<Data.lst.size(); i++) {
            randomPercent = random.nextInt(100); //[0;99]
            //���� ������� ��� ����� � �������� ����������� �������
            if (randomPercent < P) {
                //������� (������ 0 �� 1 � 1 �� 0
                oldValue = genome.charAt(i);
                if (oldValue == 0)
                    newValue = 1;
                else
                    newValue = 0;       
                resGenome.setCharAt(i, newValue);
            }
        }
        result.setGenome(resGenome.toString());        
        return result;
    }

}
