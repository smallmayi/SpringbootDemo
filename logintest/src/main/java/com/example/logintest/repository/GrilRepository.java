package com.example.logintest.repository;

import com.example.logintest.domain.Gril;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GrilRepository extends JpaRepository<Gril, Long> {

   // void deleteById(Long id);
   @Query(value = "select * from gril where if(?1 !='',id =?1,1=1) and if(?2 !='',gril.name =?2,1=1)",nativeQuery = true)
    List<Gril> find(String id, String name);
    List<Gril> findByIdOrName(Long id, String name);
    List<Gril> findByNameLike(String name);
}
