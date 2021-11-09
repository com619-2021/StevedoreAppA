package uk.ca.solent.devops.stevedore.service.order;

import org.springframework.stereotype.Service;
import uk.ca.solent.devops.stevedore.model.order.OrderModel;
import uk.ca.solent.devops.stevedore.repository.order.OrderRequestRepository;
import uk.ca.solent.devops.stevedore.service.base.IStevedoreService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService implements IStevedoreService<OrderModel> {

    private final OrderRequestRepository requestRepository;

    public OrderService(OrderRequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    public void Add(OrderModel model) {
        requestRepository.saveAndFlush(model);
    }

    @Override
    public List<OrderModel> Get() {
        return new ArrayList<>(requestRepository.findAll());
    }

    @Override
    public OrderModel Get(int id) {
        return requestRepository.findById((long) id).orElse(null);
    }

    @Override
    public OrderModel Get(UUID uuid) {
        return requestRepository.findAll().stream().filter(orderModel -> orderModel.getUuid().equals(uuid)).findFirst().orElse(null);
    }

    @Override
    public void Delete(long id) {
        Optional<OrderModel> byId = requestRepository.findById(id);
        byId.ifPresent(requestRepository::delete);
    }

    @Override
    public void Delete(UUID uuid) {
        Optional<OrderModel> first = requestRepository.findAll().stream().filter(orderModel -> orderModel.getUuid().equals(uuid)).findFirst();
        first.ifPresent(requestRepository::delete);
    }

    @Override
    public OrderModel Update(OrderModel updateModel) {

        OrderModel orderModel = requestRepository.findById(updateModel.getId()).orElse(null);

        if (orderModel == null) return updateModel;

        /*
            Modify orderModel
         */


        requestRepository.saveAndFlush(orderModel);
        return orderModel;
    }
}
