package com.fau.lap.resolver;

import com.fau.lap.domain.Lap;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LapResolver implements HandlerMethodArgumentResolver {

    private static DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss.SS");

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(Lap.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest servletRequest = webRequest.getNativeRequest(HttpServletRequest.class);

        Lap lap = new Lap();
        lap.setLapNumber(Integer.parseInt(servletRequest.getParameter("lapNumber")));
        lap.setChipBoard(Boolean.parseBoolean(servletRequest.getParameter("chipBoard")));
        lap.setChipFront(Boolean.parseBoolean(servletRequest.getParameter("chipFront")));
        lap.setFalseStart(Boolean.parseBoolean(servletRequest.getParameter("falseStart")));
        lap.setTime(LocalTime.parse(servletRequest.getParameter("time"), TIME_FORMAT));

        return lap;
    }
}
