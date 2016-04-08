package com.fenghui.bases.jpadtos;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: RoomPassWordDTO
 *
 */
@Entity
@Table(name="ROOM_PASSWORD")
public class RoomPassWordDTO implements Serializable
{

	private static final long serialVersionUID = -4514633903492189279L;

	public RoomPassWordDTO()
	{
	}

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;

	@OneToOne(cascade =
	{ CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "ROOM")
	private RoomDTO roomDTO;

	@Column(name = "ROOM_PASSWORD")
	private String roomPassWord;

}
