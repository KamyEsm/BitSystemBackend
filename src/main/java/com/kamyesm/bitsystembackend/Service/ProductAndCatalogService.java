package com.kamyesm.bitsystembackend.Service;

import com.kamyesm.bitsystembackend.DTO.Campaign.CampaignCreateRequest;
import com.kamyesm.bitsystembackend.DTO.Campaign.CampaignPatchRequest;
import com.kamyesm.bitsystembackend.DTO.Campaign.CampaignResponse;
import com.kamyesm.bitsystembackend.DTO.Category.CategoryRequest;
import com.kamyesm.bitsystembackend.DTO.Category.CategoryResponse;
import com.kamyesm.bitsystembackend.DTO.Product.ProductCreateRequest;
import com.kamyesm.bitsystembackend.DTO.Product.ProductResponse;

import java.util.List;

public interface ProductAndCatalogService {

    //category
    CategoryResponse createCategory(CategoryRequest category);
    CategoryResponse getCategoryByName(String name);
    List<CategoryResponse> getAll();
    void deleteByName();
    CategoryResponse updateCategory(CategoryRequest category);
    CategoryResponse findCategoryBySlug(String slug);

    //campaign
    CampaignResponse createCampaign(CampaignCreateRequest campaign);
    CampaignResponse getCampaignByTitle(String title);
    List<CampaignResponse> getAllCampaign();
    void deleteCampaign(String title);
    CampaignResponse patchCampaign(CampaignPatchRequest campaign);

    //product
    ProductResponse createProduct(ProductCreateRequest product);
    List<ProductResponse> getAllProduct();
    ProductResponse getProductByTitle(String title);
    ProductResponse patchProduct(String title);
    void deleteProduct(String title);
    ProductResponse findProductByCategoryName(String category);
    ProductResponse findAllProductByDiscountedPrice();
    ProductResponse findProductBySlug(String slug);

}
