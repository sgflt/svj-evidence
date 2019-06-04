package eu.qwsome.svj.features.owner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author Lukáš Kvídera
 */
@Service
class FlatOwnerService {

  private static final Logger LOG = LoggerFactory.getLogger(FlatOwnerService.class);

  private final FlatOwnerRepository flatOwnerRepository;
  private final ObservableList<FlatOwner> flatOwners;

  public FlatOwnerService(final FlatOwnerRepository flatOwnerRepository) {
    this.flatOwnerRepository = flatOwnerRepository;
    this.flatOwners = FXCollections.observableList(this.flatOwnerRepository.findAll());
  }

  ObservableList<FlatOwner> findAll() {
    LOG.trace("findAll()");
    this.flatOwners.removeAll(this.flatOwners);
    this.flatOwners.addAll(this.flatOwnerRepository.findAll());
    return this.flatOwners;
  }

  void save(final FlatOwner flatOwner) {
    LOG.debug("save(flatOwner={}", flatOwner);
    this.flatOwnerRepository.save(flatOwner);
  }
}
