package com.guitar.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import com.guitar.model.Manufacturer;

@Repository
@RepositoryRestResource(path="mfgs", collectionResourceRel="mfgs")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public interface ManufacturerJpaRepository extends JpaRepository<Manufacturer, Long> {
	List<Manufacturer> findByFoundedDateBefore(Date date);
	
	List<Manufacturer> findByActiveTrue();
	List<Manufacturer> findByActiveFalse();
	
	List<Manufacturer> getAllThatSellAcoustics(String name);
	
	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	List<Manufacturer> findAll();

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	Page<Manufacturer> findAll(Pageable pageable);

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	List<Manufacturer> findAll(Sort sort);

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	List<Manufacturer> findAll(Iterable<Long> ids);
	
}
