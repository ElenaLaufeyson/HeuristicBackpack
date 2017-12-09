package backpack;

//������� �������
public class Thing 
        implements Comparable<Thing> { //��� ������� ���������
    
	private int weight;
	private int price;
        
        float d; //��������� ����/��� (c/w) ��� �������
	
	public Thing(int weight, int price){
		this.weight = weight;
		this.price = price;
                
                d = (float)price/price; //��� �������
	}
		
	public int getPrice() {
		return price;
	}
        
	public void setPrice(int price) {
		this.price = price;
	}
        
	public int getWeight() {
		return weight;
	}
        
	public void setWeight(int weight) {
		this.weight = weight;
	}

    @Override
    public int compareTo(Thing o) { //��� �������
        return ((Float)o.d).compareTo((Float)d); //�� �������� d
    }
}
