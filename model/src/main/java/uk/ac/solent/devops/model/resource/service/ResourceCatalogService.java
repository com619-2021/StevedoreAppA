package uk.ac.solent.devops.model.resource.service;

import uk.ac.solent.devops.model.dto.ReplyMessage;
import uk.ac.solent.devops.model.resource.dto.ResourceCatalog;

public interface ResourceCatalogService {

    public ReplyMessage getResourceCatalogByuuid(String uuid);

    public ReplyMessage deleteResourceCatalogByUuid(String uuid);

    public ReplyMessage postCreateResourceCatalog(ResourceCatalog resourceCatalog);

    public ReplyMessage putUpdateResourceCatalog(ResourceCatalog resourceCatalog);

    public ReplyMessage getResourceCatalogByTemplate(ResourceCatalog resourceCatalogSearchTemplate,Integer offset, Integer limit);

    public ReplyMessage postRemoveCharacteristic(String resourceUuid, String characteristicName);
    
    public ReplyMessage postAddModifyCharacteristic(String resourceUuid, String characteristicName, String value, String description);
}
