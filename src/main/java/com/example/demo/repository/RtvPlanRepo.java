package com.example.demo.repository;

import com.example.demo.entities.RtvPlanDetailEntity;
import com.example.demo.entities.RtvPlanEntity;
import com.example.demo.enums.RtvPlanStatus;
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
public interface RtvPlanRepo extends JpaRepository<RtvPlanEntity, Long>, QuerydslPredicateExecutor<RtvPlanEntity> {

    List<RtvPlanEntity> findAll();

    @Query("select r from RtvPlanDetailEntity r where r.rtvPlanId = ?1")
    List<RtvPlanDetailEntity> findAllByRtvPlanId(Long rtvPlanId);

    List<RtvPlanEntity> findByIdIsIn(List<Long> rtvPlanIdsList);

    @Query("select u from RtvPlanEntity u where"
            + "(:rtvTaskId is null or u.rtvTaskId = :rtvTaskId) and"
            + "( u.planStatus IN :rtvPlanStatusList)"
    )
    Page<RtvPlanEntity> findAllByPlanStatus(@Param("rtvTaskId") Long rtvTaskId,
                                            @Param("rtvPlanStatusList") List<RtvPlanStatus> rtvPlanStatusList, Pageable pageable);

    @Query("select u from RtvPlanEntity u where"
            + "(:receivedDateFrom is null or u.publishedOn >= :receivedDateFrom) and"
            + "(:receivedDateTo is null or u.publishedOn <= :receivedDateTo) and"
            + "(:status is null or u.planStatus = :status)")
    Page<RtvPlanEntity> findAllByFilters(
            @Param("receivedDateFrom") Date receivedDateFrom,
            @Param("receivedDateTo") Date receivedDateTo,
            @Param("status") RtvPlanStatus status,
            Pageable pageable);

    RtvPlanEntity findAllById(Long id);

    @Query(value = "select * from rtv_plan where rtv_task_id=?1 and vendor_id=?2 and plan_status=?3", nativeQuery = true)
    RtvPlanEntity findAllByRtvTaskIdAndVendorIdAndStatus(Long rtvTaskId, Long VendorId, String plan_status);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "update rtv_plan set to_rtv=to_rtv-?1,can_rtv=can_rtv-?1,last_modified_by=?3 where id=?2", nativeQuery = true)
    void updateAmountByIdNative(Double amount, Long rtvPlanId, String userName);

    void deleteById(Long id);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "update rtv_plan set plan_status=?2, final_rtv=?3, last_modified_by=?4 where id=?1", nativeQuery = true)
    void updateRtvPlanStatusTransition(Long rtvPlanId, String rtvPlanStatus, Double amount, String userName);

}
