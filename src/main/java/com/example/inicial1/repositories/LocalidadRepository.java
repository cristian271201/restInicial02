package com.example.inicial1.repositories;

import com.example.inicial1.entities.Localidad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LocalidadRepository extends BaseRepository<Localidad, Long> {

    List<Localidad> findByDenominacionContaining(String denominacion);

    //con paginacion
    Page<Localidad> findByDenominacionContaining(String denominacion, Pageable pageable);

    //en JPQL
    @Query(value = "SELECT l FROM Localidad l WHERE l.denominacion LIKE %:filtro%")
    List<Localidad> search(@Param("filtro") String filtro);

    //con paginacion
    @Query(value = "SELECT l FROM Localidad l WHERE l.denominacion LIKE %:filtro%")
    List<Localidad> search(@Param("filtro") String filtro, Pageable pageable);

    //EN SQL NATIVO
    @Query(
            value = "SELECT * FROM localidad WHERE localidad.denominacion LIKE %:filtro% ",
            nativeQuery = true
    )
    List<Localidad> searchNativo(@Param("filtro") String filtro);

    //sql nativo con paginacion
    @Query(
            value = "SELECT * FROM localidad WHERE localidad.denominacion LIKE %:filtro% ",
            countQuery = "SELECT count(*) FROM localida",
            nativeQuery = true
    )
    Page<Localidad> searchNativo(@Param("filtro") String filtro, Pageable pageable);
}