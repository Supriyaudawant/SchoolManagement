package school_management.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student 
{
	@Id
     private int id;
     private String name;
	 private String stream;
	 private double fee;
     public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", stream=" + stream + ", fee=" + fee + "]";
	}
	
	
}
