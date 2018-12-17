package com.hy.backhy.repository;


import com.hy.backhy.entity.PC;
import com.hy.backhy.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PcRepository extends JpaRepository<PC,String> {

    @Query(value="SELECT * FROM pc", nativeQuery = true)
    List<PC> getPCList();

}
