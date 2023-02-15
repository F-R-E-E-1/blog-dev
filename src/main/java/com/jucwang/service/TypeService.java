package com.jucwang.service;

import com.jucwang.entity.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TypeService {

    //保存分类
    Type saveType(Type type);

    //查询分类
    Type getType(Long id);

    //分页查询
    Page<Type> listType(Pageable pageable);

    //修改分类
    Type updateType(Long id,Type type);

    //删除分类
    void deleteType(Long id);

    Type getTypeByName(String name);

    List<Type> listType();

    List<Type> listTypeTop(Integer size);
}
