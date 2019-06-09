package eu.qwsome.svj.features.ownership;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Lukáš Kvídera
 */
@Service
@Transactional
public class OwnershipService {

  private static final Logger LOG = LoggerFactory.getLogger(OwnershipService.class);

  private final OwnershipRepository ownershipRepository;
  private final ObservableList<OwnershipDto> ownerships = FXCollections.observableArrayList();
  private final FlatOwnerRepository flatOwnerRepository;

  public OwnershipService(final OwnershipRepository ownershipRepository, final FlatOwnerRepository flatOwnerRepository) {
    this.ownershipRepository = ownershipRepository;
    this.flatOwnerRepository = flatOwnerRepository;
  }

  private List<OwnershipDto> readOwnerships() {
    final List<Flat> flats = this.ownershipRepository.findAll();
    return flats.stream()
      .map(OwnershipService::map)
      .collect(Collectors.toList())
      ;
  }

  private static OwnershipDto map(final Flat flat) {
    return new OwnershipDto(
      flat.getAddress(),
      FXCollections.observableList(
        flat.getOwners().stream()
          .map(owner -> new OwnerDto(owner.getId(), owner.getFirstName(), owner.getLastName()))
          .collect(Collectors.toList())
      )
    );
  }

  public ObservableList<OwnershipDto> findAll() {
    LOG.trace("findAll()");
    this.ownerships.removeAll(this.ownerships);
    this.ownerships.addAll(readOwnerships());
    return this.ownerships;
  }

  public Optional<OwnershipDto> findByFlatId(final int id) {
    LOG.trace("findAll()");
    return this.ownershipRepository.findById(id)
      .map(OwnershipService::map);
  }

  public ObservableList<OwnerDto> findAllOwners() {
    return readOwnerships().stream()
      .map(OwnershipDto::getOwners)
      .flatMap(List::stream)
      .collect(Collectors.toCollection(FXCollections::observableArrayList))
      ;
  }

  public void addOwnerTo(final int flatId, final int ownerId) {
    LOG.debug("addOwnerTo(flatId={}, ownerID={}", flatId, ownerId);
    final Optional<Flat> flatTOModify = this.ownershipRepository.findById(flatId);
    final Optional<FlatOwner> ownerToAdd = this.flatOwnerRepository.findById(ownerId);

    if (flatTOModify.isPresent() && ownerToAdd.isPresent()) {
      flatTOModify.get().getOwners().add(ownerToAdd.get());
    }
  }
}
