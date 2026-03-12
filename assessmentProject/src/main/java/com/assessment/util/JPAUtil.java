package com.assessment.util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("assessmentPU");

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }
}
