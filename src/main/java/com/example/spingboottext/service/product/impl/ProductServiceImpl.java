package com.example.spingboottext.service.product.impl;

import com.example.spingboottext.dao.ProductDao;
import com.example.spingboottext.model.Product;
import com.example.spingboottext.model.Result;
import com.example.spingboottext.service.product.ProductService;
import com.example.spingboottext.util.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "ProductService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDao productDao;
    @Override
    public Result addProduct(Product product) {
        productDao.insert(product);
        return ResultUtil.success(product);
    }

    @Override
    public Result findAllProduct(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize) ;
        List<Product> products=productDao.selectProducts();
        PageInfo pageInfo=new PageInfo(products);
        return ResultUtil.success(pageInfo);
    }

    @Override
    public Result byIdGetProduct(long id) {
        Product product=productDao.byIdGetProduct(id);
        return ResultUtil.success(product);
    }
}
