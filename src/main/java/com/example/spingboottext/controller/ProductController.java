package com.example.spingboottext.controller;


import com.example.spingboottext.model.Product;
import com.example.spingboottext.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("add")
    @ResponseBody
    @CrossOrigin
    public Object addProduct(String name,int type,int power,long createBy){
        Product product=new Product();
        product.setName(name);
        product.setPower(power);
        product.setType(type);
        product.setCreateBy(createBy);
        return productService.addProduct(product);
    }

    @PostMapping("getProducts")
    @ResponseBody
    @CrossOrigin
    public Object getProducts(int pageNum,int pageSize){
        return productService.findAllProduct(pageNum, pageSize);
    }

    @PostMapping("getProduct")
    @ResponseBody
    @CrossOrigin
    public Object getProduct(long id){
        return productService.byIdGetProduct(id);
    }
}
