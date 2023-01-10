package com.mso.mensajes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mso.mensajes.model.ConversacionDto;

import java.util.List;

@Repository
public interface MensajesRepositoryImpl extends JpaRepository<ConversacionDto, String> {

    @Query(value="SELECT * FROM conversacion c WHERE c.idusuarioorigen=?1 and c.idusuariodestino=?2", nativeQuery = true)
    List<ConversacionDto> findByConversacion(int idUsuarioOrigen,int idUsuarioDestino);
    
    @Query(value="SELECT * FROM conversacion c WHERE c.idconversacion=?1", nativeQuery = true)
    List<ConversacionDto> findByIdConver(int idUsuarioOrigen);
    
    @Transactional
    @Modifying
    @Query(value="DELETE from conversacion c WHERE c.idusuarioorigen=?1", nativeQuery = true)
    void deleteConversacionUser(int idUsuarioOrigen);

}
