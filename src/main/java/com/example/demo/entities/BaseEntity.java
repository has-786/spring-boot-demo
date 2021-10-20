package com.example.demo.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@MappedSuperclass
public abstract class BaseEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false)
  private Long id;

  @Column(name = "created_on", nullable = false, updatable = false)
  private Date createdOn;

  @Column(name = "last_modified_on", nullable = false)
  private Date lastModifiedOn;

  @Column(name = "created_by")
  private String createdBy;

  @Column(name = "last_modified_by")
  private String lastModifiedBy;


  @PrePersist
  private void beforePersist() {
    lastModifiedOn = createdOn = (createdOn == null) ? new Date() : createdOn;
  }

  @PreUpdate
  protected void beforeUpdate() {
    lastModifiedOn = new Date();
  }

}


