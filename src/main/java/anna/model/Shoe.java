package anna.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table

public class Shoe {
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
    
    @Column
	private String color;
    
    @Column(name="shoe_size")
	private int size;
		
	@ElementCollection
	private List<Insole> insole = new ArrayList<>() ;
	
	public Shoe() {}

	public Shoe( String color, int size) {
		this.color = color;
		this.size = size;
	}

	public void setInsole(List<Insole> insole){
		this.insole = insole;
	}
	
	public List<Insole> getInsole(){
		return insole;
	}

	public long getId() {
		return id;
	}

	public void setId(long id){
		this.id = id;
		
	}
	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Shoe [id=" + id + ", color=" + color + ", size=" + size + " , insole " + insole+"]";
	}	
	
	
	
}
