/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.solent.devops.impl.dao.resource.springdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uk.ac.solent.devops.model.resource.dto.ResourceCatalog;

import java.util.List;

/**
 *
 * @author cgallen
 */
@Repository
public interface ResourceCatalogRepository extends JpaRepository<ResourceCatalog, Long>, JpaSpecificationExecutor<ResourceCatalog> {

    @Query("select c from ResourceCatalog c  where c.uuid = :uuid")
    public List<ResourceCatalog> findByUuid(@Param("uuid") String uuid);

}
