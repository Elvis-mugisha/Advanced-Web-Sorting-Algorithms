package com.SortingAlgorithms.SortingAlgorithms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private  ProductService ProductService;



    @GetMapping
    public List<EntityModel<Product>> getAllProducts() {
        return ProductService.getAllProduct().stream().map(Product -> EntityModel.of(Product,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class).getProduct(Product.getId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class).getAllProducts()).withRel("Products")
        )).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public EntityModel<Product> getProduct(@PathVariable int id) {
        Product Product = ProductService.getProduct(id);
        if (Product == null) throw new RuntimeException("Product not found");
        return EntityModel.of(Product,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class).getProduct(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class).getAllProducts()).withRel("Products")
        );
    }

    @PostMapping
    public void addProduct(@RequestBody Product Product) {
        ProductService.addProduct(Product);
    }
    @PutMapping("/{id}")
    public void updateProduct(@PathVariable int id, @RequestBody Product newProduct) {
        ProductService.updateProduct(id, newProduct);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        ProductService.deleteProduct(id);
    }

    @GetMapping("/sort/heap")
    public List<EntityModel<Product>> heapSort() {
        return ProductService.sortProductsByNameHeapSort().stream().map(Product -> EntityModel.of(Product,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class).getProduct(Product.getId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class).getAllProducts()).withRel("Products")
        )).collect(Collectors.toList());
    }

    @GetMapping("/sort/quick")
    public List<EntityModel<Product>> quickSort() {
        return ProductService.sortProductsByNameQuickSort().stream().map(Product -> EntityModel.of(Product,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class).getProduct(Product.getId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class).getAllProducts()).withRel("Products")
        )).collect(Collectors.toList());
    }
    @GetMapping("/sort/merge")
    public List<EntityModel<Product>> mergeSort() {
        return ProductService.sortProductsByNameMergeSort().stream().map(Product -> EntityModel.of(Product,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class).getProduct(Product.getId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class).getAllProducts()).withRel("Products")
        )).collect(Collectors.toList());
    }

    @GetMapping("/sort/radix")
    public List<EntityModel<Product>> radixSort() {
        return ProductService.sortProductsByNameRadixSort().stream().map(Product -> EntityModel.of(Product,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class).getProduct(Product.getId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class).getAllProducts()).withRel("Products")
        )).collect(Collectors.toList());
    }

    @GetMapping("/sort/bucket")
    public List<EntityModel<Product>> bucketSort() {
        return ProductService.sortProductsByNameBucketSort().stream().map(Product -> EntityModel.of(Product,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class).getProduct(Product.getId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class).getAllProducts()).withRel("Products")
        )).collect(Collectors.toList());
    }
}
