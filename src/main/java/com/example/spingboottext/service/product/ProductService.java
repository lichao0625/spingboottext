package com.example.spingboottext.service.product;

import com.example.spingboottext.model.Product;
import com.example.spingboottext.model.Result;

public interface ProductService {
    Result addProduct(Product product);
    Result findAllProduct(int pageNum, int pageSize);
    Result byIdGetProduct(long id);
}
