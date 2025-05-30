package com.main.estocafy.shared.services;

import org.modelmapper.ModelMapper;

public abstract class ServiceBase {
    protected ModelMapper mapper;

    public final void setMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }
}
