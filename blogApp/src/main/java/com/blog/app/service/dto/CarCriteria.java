package com.blog.app.service.dto;

import java.io.Serializable;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.DoubleFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.FloatFilter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;






/**
 * Criteria class for the Car entity. This class is used in CarResource to
 * receive all the possible filtering options from the Http GET request parameters.
 * For example the following could be a valid requests:
 * <code> /cars?id.greaterThan=5&amp;attr1.contains=something&amp;attr2.specified=false</code>
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class CarCriteria implements Serializable {
    private static final long serialVersionUID = 1L;


    private LongFilter id;

    private StringFilter make;

    private StringFilter model;

    private LongFilter price;

    public CarCriteria() {
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getMake() {
        return make;
    }

    public void setMake(StringFilter make) {
        this.make = make;
    }

    public StringFilter getModel() {
        return model;
    }

    public void setModel(StringFilter model) {
        this.model = model;
    }

    public LongFilter getPrice() {
        return price;
    }

    public void setPrice(LongFilter price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CarCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (make != null ? "make=" + make + ", " : "") +
                (model != null ? "model=" + model + ", " : "") +
                (price != null ? "price=" + price + ", " : "") +
            "}";
    }

}
