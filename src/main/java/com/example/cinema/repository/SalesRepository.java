package com.example.cinema.repository;

import com.example.cinema.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// here I finding Sales for a specific roomId
@Repository
public interface SalesRepository extends JpaRepository<Sale, Long> {
    List<Sale> findByRoomId(int roomId);  // this is a record which goes inside of the class
    // findByRoomId is a method name
    //(int roomId) is a paramether that method is accepting
    // List<Sale> is a return type
}


// in brackets I put the type and this parameter itself