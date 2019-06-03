package eu.qwsome.svj.service;

import eu.qwsome.svj.entity.FlatOwner;
import eu.qwsome.svj.repository.FlatOwnerRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author Lukáš Kvídera
 */
@Service
public class FlatOwnerService {

  private static final Logger LOG = LoggerFactory.getLogger(FlatOwnerService.class);

  private final FlatOwnerRepository flatOwnerRepository;
  private final ObservableList<FlatOwner> flatOwners;

  public FlatOwnerService(final FlatOwnerRepository flatOwnerRepository) {
    this.flatOwnerRepository = flatOwnerRepository;
    this.flatOwners = FXCollections.observableList(this.flatOwnerRepository.findAll());
  }

  public ObservableList<FlatOwner> findAll() {
    LOG.trace("findAll()");
    return this.flatOwners;
  }

  public void save(final FlatOwner flatOwner) {
    LOG.debug("save(flatOwner={}", flatOwner);
    this.flatOwnerRepository.save(flatOwner);
  }
}
