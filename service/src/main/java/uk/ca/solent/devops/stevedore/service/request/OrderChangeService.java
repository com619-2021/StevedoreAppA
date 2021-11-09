package uk.ca.solent.devops.stevedore.service.request;

import org.springframework.stereotype.Service;
import uk.ca.solent.devops.stevedore.model.request.OrderChangeRequestModel;
import uk.ca.solent.devops.stevedore.repository.request.OrderChangeRepository;
import uk.ca.solent.devops.stevedore.service.base.IStevedoreService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderChangeService implements IStevedoreService<OrderChangeRequestModel> {

    private final OrderChangeRepository changeRepository;

    public OrderChangeService(OrderChangeRepository changeRepository) {
        this.changeRepository = changeRepository;
    }

    @Override
    public void Add(OrderChangeRequestModel model) {
        changeRepository.saveAndFlush(model);
    }

    @Override
    public List<OrderChangeRequestModel> Get() {
        return new ArrayList<>(changeRepository.findAll());
    }

    @Override
    public OrderChangeRequestModel Get(int id) {
        return changeRepository.findById((long) id).orElse(null);
    }

    @Override
    public OrderChangeRequestModel Get(UUID uuid) {
        return changeRepository.findAll().stream().filter(orderModel -> orderModel.getUuid().equals(uuid)).findFirst().orElse(null);
    }

    @Override
    public void Delete(long id) {
        Optional<OrderChangeRequestModel> byId = changeRepository.findById(id);
        byId.ifPresent(changeRepository::delete);
    }

    @Override
    public void Delete(UUID uuid) {
        Optional<OrderChangeRequestModel> first = changeRepository.findAll().stream().filter(orderModel -> orderModel.getUuid().equals(uuid)).findFirst();
        first.ifPresent(changeRepository::delete);
    }

    @Override
    public OrderChangeRequestModel Update(OrderChangeRequestModel updateModel) {
        OrderChangeRequestModel orderChangeRequestModel = changeRepository.findById(updateModel.getId()).orElse(null);

        if (orderChangeRequestModel == null) return updateModel;

        /*
            Modify orderModel
         */


        changeRepository.saveAndFlush(orderChangeRequestModel);
        return orderChangeRequestModel;
    }
}
