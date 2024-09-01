package test.model;

import java.util.Objects;

public class Producer {

	private long id;
	private String name; 
	private String location; 

	public Producer() {
		super();
	}

	public Producer(long id, String name, String location) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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
		Producer other = (Producer) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Producer [id=" + id + ", name=" + name + ", location=" + location + "]";
	}
}
