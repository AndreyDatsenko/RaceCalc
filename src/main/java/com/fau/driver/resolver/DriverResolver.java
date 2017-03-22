package com.fau.driver.resolver;

import com.fau.driver.domein.Driver;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

public class DriverResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(Driver.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest servletRequest = webRequest.getNativeRequest(HttpServletRequest.class);
        Driver driver = new Driver();
        driver.setName(servletRequest.getParameter("name"));
        driver.setSurname(servletRequest.getParameter("surname"));
        driver.setNumber(Integer.parseInt(servletRequest.getParameter("number")));
        driver.setCarCategory(servletRequest.getParameter("carCategory"));
        driver.setCarMark(servletRequest.getParameter("carMark"));

        return driver;
    }
}
