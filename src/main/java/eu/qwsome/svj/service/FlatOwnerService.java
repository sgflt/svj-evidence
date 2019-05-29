package eu.qwsome.svj.service;

import eu.qwsome.svj.entity.FlatOwner;
import eu.qwsome.svj.repository.FlatOwnerRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Lukáš Kvídera
 */
public class FlatOwnerService {

  private static final Logger LOG = LoggerFactory.getLogger(FlatOwnerService.class);
  private static final FlatOwnerService INSTANCE = new FlatOwnerService(new FlatOwnerRepository());

  private final FlatOwnerRepository flatOwnerRepository;
  private final ObservableList<FlatOwner> flatOwners;

  private FlatOwnerService(final FlatOwnerRepository flatOwnerRepository) {
    this.flatOwnerRepository = flatOwnerRepository;
    this.flatOwners = FXCollections.observableList(this.flatOwnerRepository.findAll());
  }

  public static FlatOwnerService getInstance() {
    return INSTANCE;
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
