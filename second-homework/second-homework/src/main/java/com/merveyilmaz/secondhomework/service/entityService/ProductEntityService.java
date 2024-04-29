package com.merveyilmaz.secondhomework.service.entityService;

import com.merveyilmaz.secondhomework.dao.CategoryRepository;
import com.merveyilmaz.secondhomework.dao.ProductRepository;
import com.merveyilmaz.secondhomework.entitiy.Category;
import com.merveyilmaz.secondhomework.entitiy.Product;
import com.merveyilmaz.secondhomework.enums.EnumStatus;
import com.merveyilmaz.secondhomework.exceptions.ItemNotFoundException;
import com.merveyilmaz.secondhomework.general.BaseEntityService;
import com.merveyilmaz.secondhomework.general.GeneralErrorMessage;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductEntityService extends BaseEntityService<Product, ProductRepository> {

    public final CategoryRepository categoryRepository;

    protected ProductEntityService(ProductRepository repository, CategoryRepository categoryRepository) {
        super(repository);
        this.categoryRepository = categoryRepository;
    }
    public List<Product> findAllActiveProducts() {
        List<Product> products = getRepository().findAll();

        List<Product> activeProducts = products.stream()
                .filter(product -> product.getStatus() == EnumStatus.ACTIVE)
                .collect(Collectors.toList());

        return activeProducts;
    }

    public List<Product> findAllActiveProductsByExpirationDateLE() {
        List<Product> products = getRepository().findAll();

        LocalDateTime currentDateTime = LocalDateTime.now();

        List<Product> validProducts = products.stream()
                .filter(product -> product.getStatus() == EnumStatus.ACTIVE)
                .filter(product -> product.getExpirationDate().isBefore(currentDateTime))
                .collect(Collectors.toList());

        return validProducts;
    }

    public Product findActiveProductById(Long id) {
        Optional<Product> productOptional = getRepository().findById(id);

        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            if (product.getStatus() == EnumStatus.ACTIVE) {
                return product;
            } else {
                throw new ItemNotFoundException(GeneralErrorMessage.ACTIVE_ITEM_NOT_FOUND);
            }
        } else {
            throw new ItemNotFoundException(GeneralErrorMessage.ITEM_NOT_FOUND);
        }

    }

    public Product findActiveProductByCategoryId(Long categoryId) {
        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);

        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();

            Product product = getRepository().findByCategoryId(category);

            if (product != null) {
                if (product.getStatus() == EnumStatus.ACTIVE) {
                    return product;
                } else {
                    throw new ItemNotFoundException(GeneralErrorMessage.ACTIVE_ITEM_NOT_FOUND);
                }
            } else {
                throw new ItemNotFoundException(GeneralErrorMessage.ITEM_NOT_FOUND);
            }

        } else {
            throw new ItemNotFoundException(GeneralErrorMessage.ITEM_NOT_FOUND);
        }

    }


}
