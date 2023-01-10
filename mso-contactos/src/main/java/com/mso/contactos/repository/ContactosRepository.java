package com.mso.contactos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mso.contactos.model.ContactoDto;

@Repository
public interface ContactosRepository extends JpaRepository<ContactoDto, String> {
	@Query(value="SELECT * FROM contacto a WHERE a.idusuarioorigen=?1", nativeQuery = true)
    List<ContactoDto> findByUser(int idUsuarioOrigen);
}
