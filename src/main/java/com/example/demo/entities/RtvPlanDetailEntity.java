package com.example.demo.entities;

import com.example.demo.enums.BrandType;
import com.example.demo.enums.RtvPlanDetailStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "rtv_plan_detail")
public class RtvPlanDetailEntity extends BaseEntity {

    @Column(name = "rtv_plan_id")
    private Long rtvPlanId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private RtvPlanDetailStatus status;

    @Column(name = "core_item_id")
    private Long coreItemId;

    @Column(name = "style_id")
    private Long styleId;

    @Column(name = "brand")
    private String brand;

    @Column(name = "article_type")
    private String articleType;

    @Column(name = "gender")
    private String gender;

    @Enumerated(EnumType.STRING)
    @Column(name = "brand_type")
    private BrandType brandType;

    @Column(name = "warehouse_id")
    private Integer warehouseId;

    @Column(name = "warehouse_code")
    private String warehouseCode;

    @Column(name = "master_category")
    private String masterCategory;

    @Column(name = "master_brand")
    private String masterBrand;

    @Column(name = "sub_brand_type")
    private String subBrandType;

    @Column(name = "sub_business_unit")
    private String subBusinessUnit;

    @Column(name = "gtin")
    private String gtin;

    @Column(name = "quality")
    private String quality;

    @Column(name = "item_status")
    private String itemStatus;

    @Column(name = "style_live_status")
    private String styleLiveStatus;

    @Column(name = "inv_age_bucket")
    private String invAgeBucket;

    @Column(name = "article_mrp")
    private Double articleMrp;

    @Column(name = "inv_units")
    private Integer invUnits;

    @Column(name = "inv_value")
    private Double invValue;

    @Column(name = "category_manager")
    private String categoryManager;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "last_modified_by")
    private String lastModifiedBy;

}