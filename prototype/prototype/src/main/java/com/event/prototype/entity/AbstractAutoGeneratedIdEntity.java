package com.event.prototype.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Superclass for entities with auto generated id.
 */
@MappedSuperclass
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public abstract class AbstractAutoGeneratedIdEntity extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    public AbstractAutoGeneratedIdEntity(Long id) {
        this.id = id;
    }

    public AbstractAutoGeneratedIdEntity() {
    }
}
