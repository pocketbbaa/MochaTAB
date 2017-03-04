package com.tab.controllers;

import net.paoding.rose.web.ControllerInterceptorAdapter;
import net.paoding.rose.web.Invocation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.annotation.Annotation;

/**
 * Created by Administrator on 2017/3/4 0004.
 */
public class AccountInterceptor extends ControllerInterceptorAdapter {

    @Override
    public Class<? extends Annotation> getRequiredAnnotationClass() {
        return ValidateLogin.class;
    }

    @Override
    public Object before(Invocation inv) throws Exception {

        HttpServletRequest request = inv.getRequest();
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("user");
        if (obj != null) {
            return super.before(inv);
        }
        return "r:/index.jsp";
    }

    @Override
    public void afterCompletion(final Invocation inv, Throwable ex) throws Exception {
        // TODO ....
    }

}
