package com.yatish.serialization;

import java.io.Serializable;

public class Dog implements Serializable{
	private String name="Tommy";
	private String breed="Pomerian";
	private String sound="Bhaw bhaw";
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public String getSound() {
		return sound;
	}
	public void setSound(String sound) {
		this.sound = sound;
	}
	@Override
	public String toString() {
		return "Dog [name=" + name + ", breed=" + breed + ", sound=" + sound + "]";
	}
	
	
}
