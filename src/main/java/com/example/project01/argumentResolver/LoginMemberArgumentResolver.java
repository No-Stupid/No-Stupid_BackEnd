package com.example.project01.argumentResolver;

import com.example.project01.entity.Member;
import com.example.project01.session.SessionConst;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;


@Slf4j
public class LoginMemberArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        log.info("supportsParameter 실행");

        boolean hasLoginAnnotation = parameter.hasParameterAnnotation(Login.class); //로그인 어노테이션이 붙어있는지 물어보는거
        boolean hasMemberType = Member.class.isAssignableFrom(parameter.getParameterType()); //파라미터 타입이 member가 맞는지

        return hasLoginAnnotation && hasMemberType; //이 두개를 모두 만족하면 true가 되어 밑에 resolverArgument가 실행됨
        //false면 실행 안 됨
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {

        log.info("resolverArgument 실행");

        HttpServletRequest request = (HttpServletRequest) nativeWebRequest.getNativeRequest();
        HttpSession session = request.getSession(false);
        if(session == null) {
            return null;
        }

        Object member = session.getAttribute(SessionConst.LOGIN_MEMBER);

        return member;
    }
}
