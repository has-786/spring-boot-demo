package com.example.demo.repository;

import com.example.demo.entities.RtvPlanDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RtvPlanDetailsRepo extends JpaRepository<RtvPlanDetailEntity, Long>, QuerydslPredicateExecutor<RtvPlanDetailEntity> {

    List<RtvPlanDetailEntity> findAll();

    List<RtvPlanDetailEntity> findAllByRtvPlanIdIsIn(List<Long> rtvPlanIds);

    @Query(value = "select * from rtv_plan_detail where rtv_plan_id=?1", nativeQuery = true)
    List<RtvPlanDetailEntity> findAllByRtvPlanId(Long rtvPlanId);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "update rtv_plan_detail set status=?2, last_modified_by=?4 where rtv_plan_id=?1 and brand in ?3", nativeQuery = true)
    void updateRtvPlanDetailStatusTransitionBrand(Long rtvPlanId, String strVendorEvent, List<String> brandsList, String strUserName);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "delete from rtv_plan_detail where rtv_plan_id=?1", nativeQuery = true)
    void deleteByRtvPlanId(Long rtv_plan_id);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "delete from rtv_plan_detail where id IN(?1)", nativeQuery = true)
    void deleteAllByIdNative(List ids);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "update rtv_plan_detail set status=?2, last_modified_by=?4 where rtv_plan_id=?1 and style_id in ?3", nativeQuery = true)
    void updateRtvPlanDetailStatusTransitionStyle(Long rtvPlanId, String strVendorEvent, List<Long> styleIdList, String strUserName);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "update rtv_plan_detail set status=?2, last_modified_by=?6 where rtv_plan_id=?1 and brand= ?3 and article_type=?4 and gender = ?5", nativeQuery = true)
    void updateRtvPlanDetailStatusTransitionBag(Long rtvPlanId, String strVendorEvent, String strBrand, String strArticleType, String strGender, String strUserName);

}
