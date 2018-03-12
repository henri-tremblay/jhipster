/*
 * Copyright 2016-2018 the original author or authors from the JHipster project.
 *
 * This file is part of the JHipster project, see http://www.jhipster.tech/
 * for more information.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.jhipster.domain;

import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Base class of all entities generated by JHipster.
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Unique id for an entity of a given type. Will be {@code null} for an entity that hasn't been saved to its data
     * storage.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public BaseEntity() {}

    public BaseEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Equality is based on the id. Two instances of the exact same class and sharing the same id are considered equals.
     * If the ids are {@code null}, two instances will be equals if they actually are the same instance.
     *
     * @param o Object to compare
     * @return if the two instances are equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BaseEntity entity = (BaseEntity) o;
        return !(entity.getId() == null || getId() == null) && Objects.equals(getId(), entity.getId());
    }

    /**
     * Hashcode based on the entity id.
     *
     * @return the id hashcode or 0 if the id is null
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    /**
     * Returns a {@code ToStringHelper} containing the id of the class. Child classes are expected to override this
     * method to add their fields.
     *
     * <pre>{@code
     * @Override
     * protected MoreObjects.ToStringHelper toStringHelper() {
     *     return super.toStringHelper().add("name", name);
     * }
     * }</pre>
     *
     * @return {@code ToStringHelper} used to create the final String
     */
    protected MoreObjects.ToStringHelper toStringHelper() {
        return MoreObjects.toStringHelper(this)
            .add("id", id);
    }

    @Override
    public String toString() {
        return toStringHelper().toString();
    }
}

