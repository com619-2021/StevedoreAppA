/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.solent.devops.impl.dao.order.springdata;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uk.ac.solent.devops.model.order.dto.OrderChangeRequestEntity;

import java.util.List;

/**
 *
 * @author cgallen
 */
@Repository
public interface OrderChangeRequestRepository extends JpaRepository<OrderChangeRequestEntity, Long>, JpaSpecificationExecutor<OrderChangeRequestEntity> {

    @Query("select c from OrderChangeRequestEntity c  where c.uuid = :uuid")
    public List<OrderChangeRequestEntity> findByUuid(@Param("uuid") String uuid);

}
