package com.st.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "st_documents")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Documents {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	
	public Documents(String name, String type, byte[] st_photo, byte[] st_aadhar_card, byte[] st_SSC_Certificate,
			byte[] st_HSC_Certificate) {
		super();
		this.name = name;
		this.type = type;
		St_photo = st_photo;
		St_aadhar_card = st_aadhar_card;
		St_SSC_Certificate = st_SSC_Certificate;
		St_HSC_Certificate = st_HSC_Certificate;
	}
	private String name;

	private String type;

	@Lob
	private byte[] St_photo;
	@Lob
	private byte[] St_aadhar_card;
	@Lob
	private byte[] St_SSC_Certificate;
	@Lob
	private byte[] St_HSC_Certificate;
	
	
	
	

	/*
	 * // @Column(name = "image", unique = false, nullable = false, length = 100000)
	 * private byte[] image; // @Column(name = "image", unique = false, nullable =
	 * false, length = 100000) private byte[] St_photo; // @Column(name = "image",
	 * unique = false, nullable = false, length = 100000) private byte[]
	 * St_aadhar_card; // @Column(name = "image", unique = false, nullable = false,
	 * length = 100000) private byte[] St_SSC_Certificate; // @Column(name =
	 * "image", unique = false, nullable = false, length = 100000) private byte[]
	 * St_HSC_Certificate; // @Column(name = "image", unique = false, nullable =
	 * false, length = 100000) private byte[] St_TC_Certificate;
	 */
}
