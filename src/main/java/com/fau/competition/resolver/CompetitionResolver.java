package com.fau.competition.resolver;

import com.fau.competition.domein.Competition;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CompetitionResolver implements HandlerMethodArgumentResolver {

    private static DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss.SS");

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(Competition.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest servletRequest = webRequest.getNativeRequest(HttpServletRequest.class);

        Competition competition = new Competition();
        competition.setDate(LocalDate.parse(servletRequest.getParameter("date")));
        competition.setCompetitionName(servletRequest.getParameter("competitionName"));
        competition.setCompetitionCity(servletRequest.getParameter("competitionCity"));
        competition.setChipBoard(LocalTime.parse(servletRequest.getParameter("chipBoard"), TIME_FORMAT));
        competition.setChipFront(LocalTime.parse(servletRequest.getParameter("chipFront"), TIME_FORMAT));
        competition.setFalseStart(LocalTime.parse(servletRequest.getParameter("falseStart"), TIME_FORMAT));

        return competition;
    }
}