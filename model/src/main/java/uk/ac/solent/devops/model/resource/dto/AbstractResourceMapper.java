/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.solent.devops.model.resource.dto;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import uk.ac.solent.devops.model.party.dto.Party;

import java.util.List;

/**
 * maps one abstract resource into another abstract resource can be used to map values of resource entity to dto objects
 *
 * @author cgallen
 */
@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AbstractResourceMapper {

    AbstractResourceMapper INSTANCE = Mappers.getMapper(AbstractResourceMapper.class);

    Resource abstractResourceToResource(AbstractResource abstractResource);

    ResourceHref abstractResourceToResourceHref(AbstractResource abstractResource);

    ResourceCatalog abstractResourceToResourceCatalog(AbstractResource abstractResource);

    ResourceCatalogHref abstractResourceToResourceCatalogHref(AbstractResource abstractResource);
    
    List<ResourceCatalogHref> abstractResourceListToResourceCatalogHrefList(List<AbstractResource> abstractResourceList);
    
    List<ResourceHref> abstractResourceListToResourceHrefList(List<AbstractResource> abstractResourceList);

    Resource updateResource(AbstractResource resource, @MappingTarget Resource resourceEntity);

    ResourceCatalog updateCatalog(AbstractResource resource, @MappingTarget ResourceCatalog catalogEntity);

    // prevents attempted database disconnected lazy loading updates of users 
    @Mapping(ignore = true, target = "users")
    Party toParty(Party party);

}
