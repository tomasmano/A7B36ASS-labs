package cz.cvut.fel.cs.model;

import java.io.Serializable;

public class Entity implements Serializable{

	protected Long id;

	public Entity() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}