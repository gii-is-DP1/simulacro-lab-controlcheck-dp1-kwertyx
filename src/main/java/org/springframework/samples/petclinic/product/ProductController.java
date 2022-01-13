package org.springframework.samples.petclinic.product;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    
    @GetMapping(value="/product/create")
    public String create(ModelMap model) {
        model.put("product", new Product());
        return "products/createOrUpdateProductForm";
    }

    @PostMapping(value="/product/create")
    public String createPost(@Valid Product product, BindingResult result, ModelMap model) {
        if(result.hasErrors()) {
            model.put("product", product);
            return "products/createOrUpdateProductForm";
        } else {
            this.productService.save(product);
            return "welcome";
        }
        
    }
}
