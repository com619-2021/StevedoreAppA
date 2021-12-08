package uk.ac.solent.devops.model.resource.dto;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import uk.ac.solent.devops.model.party.dto.Party;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
public class AbstractResourceMapperImpl implements AbstractResourceMapper {

    @Override
    public Resource abstractResourceToResource(AbstractResource abstractResource) {
        if ( abstractResource == null ) {
            return null;
        }

        Resource resource = new Resource();

        if ( abstractResource.getId() != null ) {
            resource.setId( abstractResource.getId() );
        }
        if ( abstractResource.getHref() != null ) {
            resource.setHref( abstractResource.getHref() );
        }
        if ( abstractResource.getUuid() != null ) {
            resource.setUuid( abstractResource.getUuid() );
        }
        if ( abstractResource.getName() != null ) {
            resource.setName( abstractResource.getName() );
        }
        List<Characteristic> list = abstractResource.getCharacteristics();
        if ( list != null ) {
            resource.setCharacteristics( new ArrayList<Characteristic>( list ) );
        }
        if ( abstractResource.getResourceOwner() != null ) {
            resource.setResourceOwner( toParty( abstractResource.getResourceOwner() ) );
        }
        if ( abstractResource.getResourceController() != null ) {
            resource.setResourceController( abstractResource.getResourceController() );
        }
        if ( abstractResource.getResourceTypeName() != null ) {
            resource.setResourceTypeName( abstractResource.getResourceTypeName() );
        }
        if ( abstractResource.getDescription() != null ) {
            resource.setDescription( abstractResource.getDescription() );
        }

        return resource;
    }

    @Override
    public ResourceHref abstractResourceToResourceHref(AbstractResource abstractResource) {
        if ( abstractResource == null ) {
            return null;
        }

        ResourceHref resourceHref = new ResourceHref();

        if ( abstractResource.getHref() != null ) {
            resourceHref.setHref( abstractResource.getHref() );
        }
        if ( abstractResource.getUuid() != null ) {
            resourceHref.setUuid( abstractResource.getUuid() );
        }
        if ( abstractResource.getId() != null ) {
            resourceHref.setId( abstractResource.getId() );
        }
        if ( abstractResource.getName() != null ) {
            resourceHref.setName( abstractResource.getName() );
        }

        return resourceHref;
    }

    @Override
    public ResourceCatalog abstractResourceToResourceCatalog(AbstractResource abstractResource) {
        if ( abstractResource == null ) {
            return null;
        }

        ResourceCatalog resourceCatalog = new ResourceCatalog();

        if ( abstractResource.getId() != null ) {
            resourceCatalog.setId( abstractResource.getId() );
        }
        if ( abstractResource.getHref() != null ) {
            resourceCatalog.setHref( abstractResource.getHref() );
        }
        if ( abstractResource.getUuid() != null ) {
            resourceCatalog.setUuid( abstractResource.getUuid() );
        }
        if ( abstractResource.getName() != null ) {
            resourceCatalog.setName( abstractResource.getName() );
        }
        List<Characteristic> list = abstractResource.getCharacteristics();
        if ( list != null ) {
            resourceCatalog.setCharacteristics( new ArrayList<Characteristic>( list ) );
        }
        if ( abstractResource.getResourceOwner() != null ) {
            resourceCatalog.setResourceOwner( toParty( abstractResource.getResourceOwner() ) );
        }
        if ( abstractResource.getResourceController() != null ) {
            resourceCatalog.setResourceController( abstractResource.getResourceController() );
        }
        if ( abstractResource.getResourceTypeName() != null ) {
            resourceCatalog.setResourceTypeName( abstractResource.getResourceTypeName() );
        }
        if ( abstractResource.getDescription() != null ) {
            resourceCatalog.setDescription( abstractResource.getDescription() );
        }

        return resourceCatalog;
    }

    @Override
    public ResourceCatalogHref abstractResourceToResourceCatalogHref(AbstractResource abstractResource) {
        if ( abstractResource == null ) {
            return null;
        }

        ResourceCatalogHref resourceCatalogHref = new ResourceCatalogHref();

        if ( abstractResource.getHref() != null ) {
            resourceCatalogHref.setHref( abstractResource.getHref() );
        }
        if ( abstractResource.getUuid() != null ) {
            resourceCatalogHref.setUuid( abstractResource.getUuid() );
        }
        if ( abstractResource.getId() != null ) {
            resourceCatalogHref.setId( abstractResource.getId() );
        }
        if ( abstractResource.getName() != null ) {
            resourceCatalogHref.setName( abstractResource.getName() );
        }

        return resourceCatalogHref;
    }

    @Override
    public List<ResourceCatalogHref> abstractResourceListToResourceCatalogHrefList(List<AbstractResource> abstractResourceList) {
        if ( abstractResourceList == null ) {
            return null;
        }

        List<ResourceCatalogHref> list = new ArrayList<ResourceCatalogHref>( abstractResourceList.size() );
        for ( AbstractResource abstractResource : abstractResourceList ) {
            list.add( abstractResourceToResourceCatalogHref( abstractResource ) );
        }

        return list;
    }

    @Override
    public List<ResourceHref> abstractResourceListToResourceHrefList(List<AbstractResource> abstractResourceList) {
        if ( abstractResourceList == null ) {
            return null;
        }

        List<ResourceHref> list = new ArrayList<ResourceHref>( abstractResourceList.size() );
        for ( AbstractResource abstractResource : abstractResourceList ) {
            list.add( abstractResourceToResourceHref( abstractResource ) );
        }

        return list;
    }

    @Override
    public Resource updateResource(AbstractResource resource, Resource resourceEntity) {
        if ( resource == null ) {
            return null;
        }

        if ( resource.getId() != null ) {
            resourceEntity.setId( resource.getId() );
        }
        if ( resource.getHref() != null ) {
            resourceEntity.setHref( resource.getHref() );
        }
        if ( resource.getUuid() != null ) {
            resourceEntity.setUuid( resource.getUuid() );
        }
        if ( resource.getName() != null ) {
            resourceEntity.setName( resource.getName() );
        }
        if ( resourceEntity.getCharacteristics() != null ) {
            List<Characteristic> list = resource.getCharacteristics();
            if ( list != null ) {
                resourceEntity.getCharacteristics().clear();
                resourceEntity.getCharacteristics().addAll( list );
            }
        }
        else {
            List<Characteristic> list = resource.getCharacteristics();
            if ( list != null ) {
                resourceEntity.setCharacteristics( new ArrayList<Characteristic>( list ) );
            }
        }
        if ( resource.getResourceOwner() != null ) {
            resourceEntity.setResourceOwner( toParty( resource.getResourceOwner() ) );
        }
        if ( resource.getResourceController() != null ) {
            resourceEntity.setResourceController( resource.getResourceController() );
        }
        if ( resource.getResourceTypeName() != null ) {
            resourceEntity.setResourceTypeName( resource.getResourceTypeName() );
        }
        if ( resource.getDescription() != null ) {
            resourceEntity.setDescription( resource.getDescription() );
        }

        return resourceEntity;
    }

    @Override
    public ResourceCatalog updateCatalog(AbstractResource resource, ResourceCatalog catalogEntity) {
        if ( resource == null ) {
            return null;
        }

        if ( resource.getId() != null ) {
            catalogEntity.setId( resource.getId() );
        }
        if ( resource.getHref() != null ) {
            catalogEntity.setHref( resource.getHref() );
        }
        if ( resource.getUuid() != null ) {
            catalogEntity.setUuid( resource.getUuid() );
        }
        if ( resource.getName() != null ) {
            catalogEntity.setName( resource.getName() );
        }
        if ( catalogEntity.getCharacteristics() != null ) {
            List<Characteristic> list = resource.getCharacteristics();
            if ( list != null ) {
                catalogEntity.getCharacteristics().clear();
                catalogEntity.getCharacteristics().addAll( list );
            }
        }
        else {
            List<Characteristic> list = resource.getCharacteristics();
            if ( list != null ) {
                catalogEntity.setCharacteristics( new ArrayList<Characteristic>( list ) );
            }
        }
        if ( resource.getResourceOwner() != null ) {
            catalogEntity.setResourceOwner( toParty( resource.getResourceOwner() ) );
        }
        if ( resource.getResourceController() != null ) {
            catalogEntity.setResourceController( resource.getResourceController() );
        }
        if ( resource.getResourceTypeName() != null ) {
            catalogEntity.setResourceTypeName( resource.getResourceTypeName() );
        }
        if ( resource.getDescription() != null ) {
            catalogEntity.setDescription( resource.getDescription() );
        }

        return catalogEntity;
    }

    @Override
    public Party toParty(Party party) {
        if ( party == null ) {
            return null;
        }

        Party party1 = new Party();

        if ( party.getId() != null ) {
            party1.setId( party.getId() );
        }
        if ( party.getFirstName() != null ) {
            party1.setFirstName( party.getFirstName() );
        }
        if ( party.getSecondName() != null ) {
            party1.setSecondName( party.getSecondName() );
        }
        if ( party.getPartyRole() != null ) {
            party1.setPartyRole( party.getPartyRole() );
        }
        if ( party.getAddress() != null ) {
            party1.setAddress( party.getAddress() );
        }
        if ( party.getPartyStatus() != null ) {
            party1.setPartyStatus( party.getPartyStatus() );
        }
        if ( party.getUuid() != null ) {
            party1.setUuid( party.getUuid() );
        }
        if ( party.getEnabled() != null ) {
            party1.setEnabled( party.getEnabled() );
        }
        if ( party.getHref() != null ) {
            party1.setHref( party.getHref() );
        }

        return party1;
    }
}
