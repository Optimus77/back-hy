package com.hy.backhy.repository;


import com.hy.backhy.entity.Phone;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Data
@Repository
public interface PhoneRepository extends JpaRepository<Phone,String> {

    @Query(value="SELECT * FROM phone", nativeQuery = true)
    List<Phone> getPhoneList();




}
