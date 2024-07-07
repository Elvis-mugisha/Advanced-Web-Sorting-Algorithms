package com.SortingAlgorithms.SortingAlgorithms;

import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class ProductService implements ProductInterface {
    private final LinkedList<Product> Products = new LinkedList<>();


    @Override
    public List<Product> getAllProduct() {
        return Products;
    }

    @Override
    public Product getProduct(int id) {

        return Products.stream()
                .filter(Product -> Product.getId() == id)
                .findFirst().orElse(null);
    }

    @Override
    public void addProduct(Product Product) {
        Products.add(Product);
    }

    @Override
    public void updateProduct(int id, Product newProduct) {
        Product Product = getProduct(id);
        if (Product != null) {
            Product.setName(newProduct.getName());
            Product.setPrice(newProduct.getPrice());
        }
    }
    @Override
    public void deleteProduct(int id) {
        Products.removeIf(Product -> Product.getId() == id);
    }

    @Override
    public List<Product> sortProductsByNameHeapSort() {
        List<Product> sortedProducts = new LinkedList<>(Products);
        SortingAlgorithms.heapSort(sortedProducts);
        return sortedProducts;
    }

    @Override
    public List<Product> sortProductsByNameQuickSort() {
        List<Product> sortedProducts = new LinkedList<>(Products);
        SortingAlgorithms.quickSort(sortedProducts, 0, sortedProducts.size() - 1);
        return sortedProducts;
    }

    @Override
    public List<Product> sortProductsByNameMergeSort() {
        List<Product> sortedProducts = new LinkedList<>(Products);
        SortingAlgorithms.mergeSort(sortedProducts, 0, sortedProducts.size() - 1);
        return sortedProducts;
    }
    @Override
    public List<Product> sortProductsByNameRadixSort() {
        List<Product> sortedProducts = new LinkedList<>(Products);
        SortingAlgorithms.radixSort(sortedProducts);
        return sortedProducts;
    }

    @Override
    public List<Product> sortProductsByNameBucketSort() {
        List<Product> sortedProducts = new LinkedList<>(Products);
        int maxVal = Products.stream().mapToInt(Product -> Product.getName().length()).max().orElse(0);
        SortingAlgorithms.bucketSort(sortedProducts, maxVal);
        return sortedProducts;
    }
}
