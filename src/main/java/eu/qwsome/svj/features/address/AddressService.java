package eu.qwsome.svj.features.address;

import eu.qwsome.svj.model.Address;
import eu.qwsome.svj.model.AddressRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * @author Lukáš Kvídera
 */
@Service
@Transactional
public class AddressService {

  private static final Logger LOG = LoggerFactory.getLogger(AddressService.class);

  private final AddressRepository repository;
  private final ObservableList<Address> addresses;

  public AddressService(final AddressRepository respository) {
    this.repository = respository;
    this.addresses = FXCollections.observableList(this.repository.findAll());
  }

  public ObservableList<Address> findAll() {
    LOG.trace("findAll()");
    this.addresses.removeAll(this.addresses);
    this.addresses.addAll(this.repository.findAll());
    return this.addresses;
  }

  void save(final Address flat) {
    LOG.debug("save(flat={}", flat);
    this.repository.save(flat);
  }

  public Optional<Address> findById(final int id) {
    return this.repository.findById(id);
  }
}
