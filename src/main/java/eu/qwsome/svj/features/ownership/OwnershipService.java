package eu.qwsome.svj.features.ownership;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
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
  private final FlatRepository flatRepository;

  public OwnershipService(
    final OwnershipRepository ownershipRepository,
    final FlatOwnerRepository flatOwnerRepository,
    final FlatRepository flatRepository
  ) {
    this.ownershipRepository = ownershipRepository;
    this.flatOwnerRepository = flatOwnerRepository;
    this.flatRepository = flatRepository;
  }

  private List<OwnershipDto> readOwnerships() {
    final List<Ownership> flats = this.ownershipRepository.findAll();
    return flats.stream()
      .map(OwnershipService::map)
      .collect(Collectors.toList())
      ;
  }

  private static OwnershipDto map(final Ownership ownership) {
    return new OwnershipDto(
      ownership.getFlat().getAddress(),
      FXCollections.observableList(
        ownership.getFlat().getOwnerships().stream()
          .map(ownerhsip -> new OwnerDto(ownerhsip.getFlatOwner().getId(), ownerhsip.getFlatOwner().getFirstName(), ownerhsip.getFlatOwner().getLastName()))
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
    LOG.trace("findFlatById(id={})", id);
    final Example<Ownership> example = createExampleForFlatId(id);

    final List<Ownership> all = this.ownershipRepository.findAll(example);
    return all
      .stream()
      .findAny()
      .map(OwnershipService::map);
  }

  private static Example<Ownership> createExampleForFlatId(final int id) {
    final Ownership probe = new Ownership();
    final OwnershipPrimaryKey key = new OwnershipPrimaryKey(id, null);
    probe.setKey(key);
    return Example.of(probe);
  }

  public ObservableList<OwnerDto> findAllOwners() {
    return this.flatOwnerRepository.findAll()
      .stream()
      .map(owner -> new OwnerDto(owner.getId(), owner.getFirstName(), owner.getLastName()))
      .collect(Collectors.toCollection(FXCollections::observableArrayList))
      ;
  }

  public void addOwnerTo(final int flatId, final int ownerId) {
    LOG.debug("addOwnerTo(flatId={}, ownerID={}", flatId, ownerId);
    final Optional<FlatOwner> ownerToAdd = this.flatOwnerRepository.findById(ownerId);
    final Optional<Flat> flatToModify = this.flatRepository.findById(flatId);
    if (flatToModify.isPresent() && ownerToAdd.isPresent()) {
      flatToModify.get().addOwner(ownerToAdd.get(), 'O');
    }
  }
}
