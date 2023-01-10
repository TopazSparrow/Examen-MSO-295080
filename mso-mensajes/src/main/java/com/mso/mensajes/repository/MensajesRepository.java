package com.mso.mensajes.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mso.mensajes.model.MensajeDto;

@Repository
public interface MensajesRepository extends JpaRepository<MensajeDto, String> {

}
