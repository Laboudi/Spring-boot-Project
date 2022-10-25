package com.architeo.ehiringapp.Repository;

import com.architeo.ehiringapp.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
