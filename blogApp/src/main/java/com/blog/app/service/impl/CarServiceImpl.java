package com.blog.app.service.impl;

import com.blog.app.service.CarService;
import com.blog.app.domain.Car;
import com.blog.app.repository.CarRepository;
import com.blog.app.repository.search.CarSearchRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing Car.
 */
@Service
@Transactional
public class CarServiceImpl implements CarService{

    private final Logger log = LoggerFactory.getLogger(CarServiceImpl.class);

    private final CarRepository carRepository;

    private final CarSearchRepository carSearchRepository;
    public CarServiceImpl(CarRepository carRepository, CarSearchRepository carSearchRepository) {
        this.carRepository = carRepository;
        this.carSearchRepository = carSearchRepository;
    }

    /**
     * Save a car.
     *
     * @param car the entity to save
     * @return the persisted entity
     */
    @Override
    public Car save(Car car) {
        log.debug("Request to save Car : {}", car);
        Car result = carRepository.save(car);
        carSearchRepository.save(result);
        return result;
    }

    /**
     *  Get all the cars.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<Car> findAll(Pageable pageable) {
        log.debug("Request to get all Cars");
        return carRepository.findAll(pageable);
    }

    /**
     *  Get one car by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Car findOne(Long id) {
        log.debug("Request to get Car : {}", id);
        return carRepository.findOne(id);
    }

    /**
     *  Delete the  car by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Car : {}", id);
        carRepository.delete(id);
        carSearchRepository.delete(id);
    }

    /**
     * Search for the car corresponding to the query.
     *
     *  @param query the query of the search
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<Car> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of Cars for query {}", query);
        Page<Car> result = carSearchRepository.search(queryStringQuery(query), pageable);
        return result;
    }
}
