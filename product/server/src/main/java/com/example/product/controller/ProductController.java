package com.example.product.controller;

import com.example.product.dto.CartDTO;
import com.example.product.entity.ProductCategory;
import com.example.product.entity.ProductInfo;
import com.example.product.service.CategoryService;
import com.example.product.service.ProductService;
import com.example.product.utils.ResultVOUtil;
import com.example.product.vo.ProductInfoVO;
import com.example.product.vo.ProductVO;
import com.example.product.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 1. get list of product data from MySQL
     * 2. get category type list
     * 3. get category
     * 4. construct data
     */
    @GetMapping("/list")
    public ResultVO<ProductVO> listOfProduct() {

        // get list of product data from MySQL
        List<ProductInfo> productInfoList = productService.findUpAll();

        // get category type list
        List<Integer> categoryTypeList = productInfoList
                .stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());

        // get category
        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        // construct data
        List<ProductVO> productVOList = new ArrayList<>();

        for (ProductCategory productCategory : categoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }

    /**
     * get product list, for order service
     * @param productIdList
     * @return
     */
    @PostMapping("/listForOrder")
    public List<ProductInfo> listForOrder(@RequestBody List<String> productIdList) {
        return productService.findList(productIdList);
    }

    @PostMapping("/decreaseStock")
    public void decreaseStock(@RequestBody List<CartDTO> cartDTOList) {
        productService.decreaseStock(cartDTOList);
    }
}
