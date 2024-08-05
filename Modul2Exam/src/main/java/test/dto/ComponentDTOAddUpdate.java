package test.dto;

import jakarta.validation.constraints.Positive;
import test.dto.validation.Validation;

public class ComponentDTOAddUpdate extends ComponentDTO {

	@Positive(message = "Producer ID must be specified.", groups = { Validation.Add.class })
	private long producerId;

	public long getProducerId() {
		return producerId;
	}

	public void setProducerId(long producerId) {
		this.producerId = producerId;
	}
}
