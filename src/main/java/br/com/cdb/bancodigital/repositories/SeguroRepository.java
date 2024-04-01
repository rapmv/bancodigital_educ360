package br.com.cdb.bancodigital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cdb.bancodigital.entities.Seguro;

@Repository
public interface SeguroRepository extends JpaRepository<Seguro, Long> {

}
