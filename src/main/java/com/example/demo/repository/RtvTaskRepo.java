package com.example.demo.repository;

import com.example.demo.entities.RtvTaskEntity;
import com.example.demo.enums.RtvTaskStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RtvTaskRepo extends JpaRepository<RtvTaskEntity, Long>, QuerydslPredicateExecutor<RtvTaskEntity> {

    List<RtvTaskEntity> findAll();

    Page<RtvTaskEntity> findAll(Pageable pageable);

    RtvTaskEntity findAllById(Long rtvTaskId);

    @Query("select u from RtvTaskEntity u where "
            + "(:taskName is null or u.taskName = :taskName ) and "
            + "(:taskStatus is null or u.rtvStatus = :taskStatus) and "
            + "(:businessUnit is null or u.businessUnit = :businessUnit) and "
            + "(:createdFromDate is null or u.createdOn >= :createdFromDate) and "
            + "(:createdToDate is null  or u.createdOn <= :createdToDate) and "
            + "(:modifiedFromDate is null or u.lastModifiedOn >= :modifiedFromDate) and "
            + "(:modifiedToDate is null or u.lastModifiedOn <= :modifiedToDate)"
    )
    Page<RtvTaskEntity> findAllByFilters(
            @Param("taskName") String taskName,
            @Param("taskStatus") RtvTaskStatus taskStatus,
            @Param("businessUnit") String businessUnit,
            @Param("createdFromDate") Date createdFromDate,
            @Param("createdToDate") Date createdToDate,
            @Param("modifiedFromDate") Date modifiedFromDate,
            @Param("modifiedToDate") Date modifiedToDate,
            Pageable pageable);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "update rtv_task set to_rtv=to_rtv-?1,can_rtv=can_rtv-?1,last_modified_by=?3 where id=?2", nativeQuery = true)
    int updateAmountByIdNative(Double amount, Long rtvTaskId, String userName);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "update rtv_task set rtv_status=?2,last_modified_by=?3 where id=?1", nativeQuery = true)
    void updateRtvStatus(Long rtvTaskId, String rtvTaskStatus, String userName);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "update rtv_task set final_rtv=?1, last_modified_by=?3 where id=?2", nativeQuery = true)
    void updateTaskFinalRtv(Double amount, Long rtvPlanId, String userName);
}
