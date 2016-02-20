package fishing.dao;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cater {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int weight;
	private Date buildingDate;
	private String image;
	@ManyToOne
	private CaterType type;
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
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public Date getBuildingDate() {
		return buildingDate;
	}
	public void setBuildingDate(Date buildingDate) {
		this.buildingDate = buildingDate;
	}
	public CaterType getType() {
		return type;
	}
	public void setType(CaterType type) {
		this.type = type;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}
