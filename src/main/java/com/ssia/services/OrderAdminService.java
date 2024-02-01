package com.ssia.services;

import com.ssia.entities.TacoOrder;
import com.ssia.repositories.OrderRepository;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;


@Service
public class OrderAdminService {

  private OrderRepository orderRepository;

  public OrderAdminService(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  @PreAuthorize("hasRole('ADMIN')") //метод не вызывается, если наружено условие
  public void deleteAllOrders() {
    orderRepository.deleteAll();
  }
  @PostAuthorize("hasRole('ADMIN') || " +               //сначала вызывается метод, потом исключение в случае несоотв
          "returnObject.user.username == authentication.name")
  public TacoOrder getOrder(long id) {
return new TacoOrder();
  }

}
