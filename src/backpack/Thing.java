package backpack;

//Предмет рюкзака
public class Thing 
        implements Comparable<Thing> { //для жадного алгоритма
    
	private int weight;
	private int price;
        
        float d; //отношение цена/вес (c/w) для жадного
	
	public Thing(int weight, int price){
		this.weight = weight;
		this.price = price;
                
                d = (float)price/price; //для жадного
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
    public int compareTo(Thing o) { //для жадного
        return ((Float)o.d).compareTo((Float)d); //по убыванию d
    }
}
