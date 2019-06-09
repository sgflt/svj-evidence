package eu.qwsome.svj.features.ownership;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Lukáš Kvídera
 */
@Repository("ownershipFlatOwnerRepository")
interface FlatOwnerRepository extends JpaRepository<FlatOwner, Integer> {
}
