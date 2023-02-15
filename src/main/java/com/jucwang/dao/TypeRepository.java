package com.jucwang.dao;

import com.jucwang.entity.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TypeRepository extends JpaRepository<Type,Long> {

    Type findByName(String name);

    //把分页大小查询条数
    @Query("select t from Type t")
    List<Type> findTop(Pageable pageable);
}
