package com.solars.SolarWeb.Repositories;

import com.solars.SolarWeb.Domain.Contact;
import com.solars.SolarWeb.Domain.PromoForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PromoFormRepository extends JpaRepository<PromoForm, Long> {

    @Modifying
    @Query("delete from PromoForm c where c.id=:id")
    void deleteC(@Param("id") Long id);
}
