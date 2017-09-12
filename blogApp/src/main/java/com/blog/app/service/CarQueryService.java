package com.blog.app.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.jhipster.service.QueryService;

import com.blog.app.domain.Car;
import com.blog.app.domain.*; // for static metamodels
import com.blog.app.repository.CarRepository;
import com.blog.app.repository.search.CarSearchRepository;
import com.blog.app.service.dto.CarCriteria;


/**
 * Service for executing complex queries for Car entities in the database.
 * The main input is a {@link CarCriteria} which get's converted to {@link Specifications},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {%link Car} or a {@link Page} of {%link Car} which fullfills the criterias
 */
@Service
@Transactional(readOnly = true)
public class CarQueryService extends QueryService<Car> {

    private final Logger log = LoggerFactory.getLogger(CarQueryService.class);


    private final CarRepository carRepository;

    private final CarSearchRepository carSearchRepository;
    public CarQueryService(CarRepository carRepository, CarSearchRepository carSearchRepository) {
        this.carRepository = carRepository;
        this.carSearchRepository = carSearchRepository;
    }

    /**
     * Return a {@link List} of {%link Car} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<Car> findByCriteria(CarCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specifications<Car> specification = createSpecification(criteria);
        return carRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {%link Car} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<Car> findByCriteria(CarCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specifications<Car> specification = createSpecification(criteria);
        return carRepository.findAll(specification, page);
    }

    /**
     * Function to convert CarCriteria to a {@link Specifications}
     */
    private Specifications<Car> createSpecification(CarCriteria criteria) {
        Specifications<Car> specification = Specifications.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildSpecification(criteria.getId(), Car_.id));
            }
            if (criteria.getMake() != null) {
                specification = specification.and(buildStringSpecification(criteria.getMake(), Car_.make));
            }
            if (criteria.getModel() != null) {
                specification = specification.and(buildStringSpecification(criteria.getModel(), Car_.model));
            }
            if (criteria.getPrice() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getPrice(), Car_.price));
            }
        }
        return specification;
    }

}
