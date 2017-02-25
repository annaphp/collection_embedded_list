package anna.model;

import javax.persistence.Embeddable;

@Embeddable
public class Insole {
	
	private int size;
	private String category;
	
	
	public Insole() {
	}

	public Insole(int size, String category) {
		this.size = size;
		this.category = category;
	}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Insole [size=" + size + ", category=" + category + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + size;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Insole other = (Insole) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (size != other.size)
			return false;
		return true;
	}
	
	
	
	
}
