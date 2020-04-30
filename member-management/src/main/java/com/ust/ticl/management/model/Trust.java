package com.ust.ticl.management.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Table(name="trust")
@Data
@Entity
public class Trust {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="trust_id_sequence")
    @SequenceGenerator(name="trust_id_sequence", sequenceName="trust_id_sequence", allocationSize=1)
	private Integer id;
	
	@Column(name = "trust_name")
	private String trustName;
	
	@Column(name = "member_name")
	private String memberName;
	

}
