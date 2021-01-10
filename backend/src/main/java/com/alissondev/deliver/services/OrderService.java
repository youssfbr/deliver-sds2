package com.alissondev.deliver.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alissondev.deliver.dto.OrderDTO;
import com.alissondev.deliver.dto.ProductDTO;
import com.alissondev.deliver.entities.Order;
import com.alissondev.deliver.entities.OrderStatus;
import com.alissondev.deliver.entities.Product;
import com.alissondev.deliver.repositories.OrderRepository;
import com.alissondev.deliver.repositories.ProductRepository;
import com.alissondev.deliver.services.exceptions.ResourceNotNull;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private ProductRepository productRepository;
			
	@Transactional(readOnly = true)
	public List<OrderDTO> findAll() {
		List<Order> list = repository.findOrdersWithProducts();
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public OrderDTO insert(OrderDTO dto) {
		Order order = new Order(null, dto.getAddress(), dto.getLatitude(), dto.getLongitude(), Instant.now(), OrderStatus.PENDING);		
		for (ProductDTO p : dto.getProducts()) {
			Product product = productRepository.getOne(p.getId());
			order.getProducts().add(product);
		}		
		try {			
			order = repository.save(order);			
		} 
		catch (javax.validation.ConstraintViolationException e) {
			throw new ResourceNotNull("Selecione um ou mais produtos e digite a localização");
		}
		
		return new OrderDTO(order);		
	}
	
	@Transactional
	public OrderDTO setDelivered(Long id) {
		Order order = repository.getOne(id);
		order.setStatus(OrderStatus.DELIVERED);
		order = repository.save(order);
		return new OrderDTO(order);
	}
}
