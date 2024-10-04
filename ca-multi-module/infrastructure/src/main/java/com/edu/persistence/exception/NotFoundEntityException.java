package com.edu.persistence.exception;

public class NotFoundEntityException extends RuntimeException{
    public NotFoundEntityException(Class entityClass, Long id) {
        super(entityClass.getSimpleName() + " not found by id " + id);
    }
}
