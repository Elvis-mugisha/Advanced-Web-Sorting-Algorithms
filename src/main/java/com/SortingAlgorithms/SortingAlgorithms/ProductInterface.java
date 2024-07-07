package com.SortingAlgorithms.SortingAlgorithms;
import java.util.List;

public interface ProductInterface {

    List<Product> getAllProduct();
    Product getProduct(int id);
    void addProduct(Product product);
    void updateProduct(int id, Product newProduct);
    void deleteProduct(int id);
    List<Product> sortProductsByNameHeapSort();
    List<Product> sortProductsByNameQuickSort();
    List<Product> sortProductsByNameMergeSort();
    List<Product> sortProductsByNameRadixSort();
    List<Product> sortProductsByNameBucketSort();

}

