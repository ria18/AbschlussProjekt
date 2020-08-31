package com.tqg.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "lizenz")

public class Lizenz implements Serializable {

	private static final long serialVersionUID = -3465813074586302847L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotBlank(message = "Bitte LizenzName eingeben")
	@Column
	private String lizenzName;
	@NotBlank(message = "Bitte LizenzKey eingeben")
	@Column
	private String lizenzKey;
	
	
	 @Column
	@ElementCollection(targetClass=Integer.class)
	private List<String> selectedCheckBox;

	public Lizenz() {
		// TODO Auto-generated constructor stub
	}
	
	public Lizenz(int id, String name, String key) {
		this.id = id;
		this.lizenzKey = key;
		this.lizenzName =name;
	
	}

	public boolean isNew() {
		return (this.id == 0);
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLizenzName() {
		return lizenzName;
	}

	public void setLizenzName(String lizenzName) {
		this.lizenzName = lizenzName;
	}

	public String getLizenzKey() {
		return lizenzKey;
	}

	public void setLizenzKey(String lizenzKey) {
		this.lizenzKey = lizenzKey;
	}

	public List<String> getSelectedCheckBox() {
		return selectedCheckBox;
	}

	public void setSelectedCheckBox(List<String> selectedCheckBox) {
		this.selectedCheckBox = selectedCheckBox;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Lizenz [id=" + id + ", lizenzName=" + lizenzName + ", lizenzKey=" + lizenzKey + ", selectedCheckBox="
				+ selectedCheckBox + "]";
	}


	

	

	

	

	
	

	
	
}