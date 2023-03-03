package com.example.demo.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Entity.ProjectEntity;
@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity,Integer>{

@Query(value="select * from the_royal_route where sid=:b or sname=:c",nativeQuery=true) 
public List<ProjectEntity> BookingDetails(@Param("b") int bookingId,@Param("c") String city);

@Modifying @Transactional @Query(value = "DELETE FROM the_royal_route where bookingId = :i", nativeQuery = true)
Integer deteteByBookingId(@Param("i") int sid); 


}






