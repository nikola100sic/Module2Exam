package test.dto;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import test.dto.validation.Validation;

public abstract class ComponentDTO {

	private long id;

	@NotBlank(message = "Model cannot be empty", groups = { Validation.Add.class })
	private String model;

	@NotNull(message = "Date is required.", groups = { Validation.Add.class })
	@FutureOrPresent(message = "Date cannot be in the past.", groups = { Validation.Add.class })
	private LocalDate availabilityDate;

	@Positive(message = "Price must be positive.", groups = { Validation.Add.class })
	private double price;

	private String image;
	private boolean availability;

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
		ComponentDTO other = (ComponentDTO) obj;
		return id == other.id;
	}
}
