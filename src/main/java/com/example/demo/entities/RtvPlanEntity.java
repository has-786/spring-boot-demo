package com.example.demo.entities;


import com.example.demo.enums.RtvPlanStatus;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "rtv_plan")
public class RtvPlanEntity extends BaseEntity {

    @Column(name = "rtv_task_id")
    private Long rtvTaskId;

    @Enumerated(EnumType.STRING)
    @Column(name = "plan_status")
    private RtvPlanStatus planStatus;

    @Column(name = "vendor_id")
    private Long vendorId;

    @Column(name = "vendor_name")
    private String vendorName;

    @Column(name = "business_unit")
    private String businessUnit;

    @Column(name = "to_rtv")
    private Double toRtv;

    @Column(name = "can_rtv")
    private Double canRtv;

    @Column(name = "final_rtv")
    private Double finalRtv;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "last_modified_by")
    private String lastModifiedBy;

    @Column(name = "published_on")
    private Date publishedOn;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "rtv_plan_id", referencedColumnName = "id")
    private List<RtvPlanDetailEntity> rtvPlanDetailEntities;

}