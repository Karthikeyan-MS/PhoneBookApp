package com.phoner.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.phoner.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact,Serializable> {

	public List<Contact> findByIsActive(boolean flag);
}
