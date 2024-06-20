package org.marcoantdev.app.repository;

import org.marcoantdev.app.entity.InterestPoint;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class InterestPointRepository implements PanacheRepositoryBase<InterestPoint, Integer> {
    
}
