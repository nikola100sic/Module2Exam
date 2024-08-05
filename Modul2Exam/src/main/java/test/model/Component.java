package test.model;

import java.time.LocalDate;
import java.util.Objects;

public class Component {

	private long id;
	private String model;
	private LocalDate availabilityDate;
	private double price;
	private String image;
	private boolean availability;

	private Producer producer;

	public Component() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Component(long id, String model, LocalDate availabilityDate, double price, String image,
			boolean availability, Producer producer) {
		super();
		this.id = id;
		this.model = model;
		this.availabilityDate = availabilityDate;
		this.price = price;
		this.image = image;
		this.availability = availability;
		this.producer = producer;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public LocalDate getAvailabilityDate() {
		return availabilityDate;
	}

	public void setAvailabilityDate(LocalDate availabilityDate) {
		this.availabilityDate = availabilityDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public Producer getProducer() {
		return producer;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Component other = (Component) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Component [id=" + id + ", model=" + model + ", availabilityDate=" + availabilityDate + ", price="
				+ price + ", image=" + image + ", availability=" + availability + "]";
	}
}
