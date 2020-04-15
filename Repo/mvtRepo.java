package com.microservices.elit.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.microservices.elit.model.mvt;
@RepositoryRestResource(collectionResourceRel = "mvt", path = "mvt")
public interface mvtRepo  extends JpaRepository<mvt, Integer> {

}