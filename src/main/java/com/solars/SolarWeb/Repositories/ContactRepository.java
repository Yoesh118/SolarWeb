package com.solars.SolarWeb.Repositories;

import com.solars.SolarWeb.Domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
