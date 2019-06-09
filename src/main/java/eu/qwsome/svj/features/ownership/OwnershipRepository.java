package eu.qwsome.svj.features.ownership;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Lukáš Kvídera
 */
interface OwnershipRepository extends JpaRepository<Flat, Integer> {
}
