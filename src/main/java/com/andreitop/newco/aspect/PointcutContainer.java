package com.andreitop.newco.aspect;

import com.andreitop.newco.service.TripService;
import org.aspectj.lang.annotation.Pointcut;

public class PointcutContainer {

    @Pointcut("execution( * com.andreitop.newco.repository.*Repo*.find*())")
    public void repositoryFind() {
    }

    @Pointcut("execution( * com.andreitop.newco.repository.*Repo*.save())")
    public void repositorySave() {
    }

    @Pointcut("within( * com.andreitop.newco.service.*) && target (service)")
    public void serviceMethods() {
    }

    @Pointcut("execution( * com.andreitop.newco.service.*Service+.delete*(..)) && args(id) && target (service)")
    public void serviceDelete(TripService service, Long id) {
    }




}
