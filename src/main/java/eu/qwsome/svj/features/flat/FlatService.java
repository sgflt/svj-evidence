package eu.qwsome.svj.features.flat;

import eu.qwsome.svj.model.Flat;
import eu.qwsome.svj.model.FlatRepository;
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
class FlatService {

  private static final Logger LOG = LoggerFactory.getLogger(FlatService.class);

  private final FlatRepository flatRepository;
  private final ObservableList<Flat> flats;

  public FlatService(final FlatRepository flatRepository) {
    this.flatRepository = flatRepository;
    this.flats = FXCollections.observableList(this.flatRepository.findAll());
  }

  ObservableList<Flat> findAll() {
    LOG.trace("findAll()");
    this.flats.removeAll(this.flats);
    this.flats.addAll(this.flatRepository.findAll());
    return this.flats;
  }

  void save(final Flat flat) {
    LOG.debug("save(flat={}", flat);
    this.flatRepository.save(flat);
  }

  Optional<Flat> findById(final int id) {
    return this.flatRepository.findById(id);
  }
}
