package eu.qwsome.svj.model;

import eu.qwsome.svj.features.ownership.OwnershipPrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Lukáš Kvídera
 */
public interface OwnershipRepository extends JpaRepository<Ownership, OwnershipPrimaryKey> {
}
