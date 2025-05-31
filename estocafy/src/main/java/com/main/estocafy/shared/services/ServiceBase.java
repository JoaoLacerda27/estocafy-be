package com.main.estocafy.shared.services;

import jakarta.servlet.http.HttpServletRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Locale;

public abstract class ServiceBase {
    protected ModelMapper mapper;
    @Autowired
    protected MessageSource messageSource;
    @Autowired
    protected LocaleResolver localeResolver;

    public final void setMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public final String getMessage(String key, Object... args) {
        Locale locale = resolveCurrentLocale();
        return messageSource.getMessage(key, args, locale);
    }

    private Locale resolveCurrentLocale() {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attrs == null) {
            return Locale.getDefault();
        }
        HttpServletRequest request = attrs.getRequest();
        return localeResolver.resolveLocale(request);
    }
}
