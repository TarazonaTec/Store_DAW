package com.StoreOnline.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.StoreOnline.entity.Producto;

public interface ProductosRepository  extends JpaRepository<Producto,Integer>{

	@Transactional
	@Modifying
	@Query("update Producto m set m.foto=?1,m.nombreArchivo=?2 where m.idProducto=?3")
	public void actualizarFoto(byte[] img,String nomAr,Integer cod);
}
