package com.blog.app.service;

import com.blog.app.domain.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing Car.
 */
public interface CarService {

    /**
     * Save a car.
     *
     * @param car the entity to save
     * @return the persisted entity
     */
    Car save(Car car);

    /**
     *  Get all the cars.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<Car> findAll(Pageable pageable);

    /**
     *  Get the "id" car.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    Car findOne(Long id);

    /**
     *  Delete the "id" car.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);

    /**
     * Search for the car corresponding to the query.
     *
     *  @param query the query of the search
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<Car> search(String query, Pageable pageable);
}
