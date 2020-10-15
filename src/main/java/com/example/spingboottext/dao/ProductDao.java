package com.example.spingboottext.dao;

import com.example.spingboottext.model.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductDao {
    int insert(Product product);
    List<Product> selectProducts();
    Product byIdGetProduct(@Param("id") long id);
}
