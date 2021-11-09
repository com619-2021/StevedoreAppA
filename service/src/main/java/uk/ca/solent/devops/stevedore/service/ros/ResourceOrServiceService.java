package uk.ca.solent.devops.stevedore.service.ros;

import org.springframework.stereotype.Service;
import uk.ca.solent.devops.stevedore.model.ros.ResourceOrServiceModel;
import uk.ca.solent.devops.stevedore.repository.ros.ResourceOrServiceRepository;
import uk.ca.solent.devops.stevedore.service.base.IStevedoreService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ResourceOrServiceService implements IStevedoreService<ResourceOrServiceModel> {

    private final ResourceOrServiceRepository serviceRepository;

    public ResourceOrServiceService(ResourceOrServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public void Add(ResourceOrServiceModel model) {
        serviceRepository.saveAndFlush(model);
    }

    @Override
    public List<ResourceOrServiceModel> Get() {
        return new ArrayList<>(serviceRepository.findAll());
    }

    @Override
    public ResourceOrServiceModel Get(int id) {
        return serviceRepository.findById((long) id).orElse(null);
    }

    @Override
    public ResourceOrServiceModel Get(UUID uuid) {
        return serviceRepository
                .findAll()
                .stream()
                .filter(orderModel -> orderModel.getUuid().equals(uuid))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void Delete(long id) {
        serviceRepository.findById(id).ifPresent(serviceRepository::delete);
    }

    @Override
    public void Delete(UUID uuid) {
        serviceRepository
                .findAll()
                .stream()
                .filter(orderModel -> orderModel.getUuid().equals(uuid)).findFirst()
                .ifPresent(serviceRepository::delete);
    }

    @Override
    public ResourceOrServiceModel Update(ResourceOrServiceModel updateModel) {
        ResourceOrServiceModel resourceOrServiceModel = serviceRepository.findById(updateModel.getId()).orElse(null);

        if (resourceOrServiceModel == null) return updateModel;

        /*
            Modify orderModel
         */

        serviceRepository.saveAndFlush(resourceOrServiceModel);
        return resourceOrServiceModel;
    }
}
