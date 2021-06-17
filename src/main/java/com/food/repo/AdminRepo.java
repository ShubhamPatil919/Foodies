package com.food.repo;

import com.food.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdminRepo extends JpaRepository<Admin,Integer> {

    @Query("select a from Admin a where a.email=:email")
    public Admin getUserByEmail(@Param("email") String email);

}
