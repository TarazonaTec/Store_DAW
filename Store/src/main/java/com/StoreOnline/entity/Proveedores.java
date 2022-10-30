package com.StoreOnline.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="tb_proveedores")
public class Proveedores {

	//Datos de la tabla proovedores
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IdProveedor")
	private int codigoProv;
	@Column(name="NombreCia")
	private  String nombre;
	@Column(name="NombreContacto")
	private String nombreContacto ;
	@Column(name="CargoContacto")
	private String Cargo;
	@Column(name="Direccion")
	private String Direccion;
	@Column(name="idpais")
	private String pais;
	@Column(name="Telefono")
	private String telefono;
	@Column(name="Fax")
	private String fax;
	
	//Relacion
	@OneToMany (mappedBy = "tipoPro")
	private List<Productos>listaProductos;
	
}