package be.pxl.ja2.beers.data;

import java.time.LocalDate;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class BrewingDeclaration {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Basic
	private LocalDate brewingdate;
	@Enumerated(EnumType.STRING)
	private BrewingDeclarationState state;

	@OneToOne
	private Brewer brewer;

	public LocalDate getBrewingdate() {
		return brewingdate;
	}

	public void setBrewingdate(LocalDate brewingdate) {
		this.brewingdate = brewingdate;
	}

	public BrewingDeclarationState getState() {
		return state;
	}

	public void setState(BrewingDeclarationState state) {
		this.state = state;
	}

	public Brewer getBrewer() {
		return brewer;
	}

	public void setBrewer(Brewer brewer) {
		this.brewer = brewer;
	}

	public Long getId() {
		return id;
	}

}
