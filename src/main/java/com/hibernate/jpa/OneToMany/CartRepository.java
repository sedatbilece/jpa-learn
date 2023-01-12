package com.hibernate.jpa.OneToMany;

import com.hibernate.jpa.OneToOne.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<Cart,Long> {
}
