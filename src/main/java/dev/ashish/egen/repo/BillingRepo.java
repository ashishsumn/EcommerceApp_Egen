package dev.ashish.egen.repo;

import dev.ashish.egen.model.Billing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingRepo extends JpaRepository<Billing, Long> {
}
