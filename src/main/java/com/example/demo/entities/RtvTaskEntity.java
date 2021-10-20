  package com.example.demo.entities;

  import com.example.demo.enums.RtvTaskStatus;
  import org.hibernate.annotations.LazyCollection;
  import org.hibernate.annotations.LazyCollectionOption;

  import javax.persistence.*;
  import java.time.Month;
  import java.util.List;


  import lombok.Getter;
  import lombok.Setter;

  @Getter
  @Setter
  @Entity
  @Table(name = "rtv_task")
  public class RtvTaskEntity extends BaseEntity {

    @Column(name = "job_id")
    private Long jobId;

    @Column(name = "task_name")
    private String taskName;

    @Column(name = "business_unit")
    private String businessUnit;

    @Column(name = "commercial_type")
    private String commercialType;

    @Column(name = "month")
    private Month month;

    @Column(name = "uploaded_file_link")
    private String uploadedFileLink;

    @Column(name = "to_rtv")
    private Double toRtv;

    @Column(name = "can_rtv")
    private Double canRtv;

    @Column(name = "final_rtv")
    private Double finalRtv;

    @Enumerated(EnumType.STRING)
    @Column(name = "rtv_status")
    private RtvTaskStatus rtvStatus;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "rtv_task_id", referencedColumnName = "id")
    private List<RtvPlanEntity> rtvPlanEntities;

  }