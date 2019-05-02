package be.pxl.ja2.beers.data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "brewers")
public class Brewer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String address;
	private String zipCode;
	private String city;
	private int turnover;

	private Brewer() {
	    //JPA
    }

	public Brewer(String name) {
	    this.name = name;
    }

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getTurnover() {
		return turnover;
	}

	public void setTurnover(int turnover) {
		this.turnover = turnover;
	}

    @Override
	public String toString() {
		return "Brewer [id=" + id + ", name=" + name + ", address=" + address + ", zipCode=" + zipCode + ", city="
				+ city + ", turnover=" + turnover + "]";
	}
}
