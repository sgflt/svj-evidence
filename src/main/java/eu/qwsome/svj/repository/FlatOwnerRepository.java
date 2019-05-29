package eu.qwsome.svj.repository;

import eu.qwsome.svj.entity.FlatOwner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lukáš Kvídera
 */
public class FlatOwnerRepository {

  private static final Logger LOG = LoggerFactory.getLogger(FlatOwnerRepository.class);

  private static final List<FlatOwner> dummyDatabase = new ArrayList<>();

  static {
    dummyDatabase.add(new FlatOwner("xxx", "zzz"));
    dummyDatabase.add(new FlatOwner("aaa", "ddd"));
    dummyDatabase.add(new FlatOwner("xxx", "fff"));
  }

  public List<FlatOwner> findAll() {
    LOG.trace("findAll()");
    return dummyDatabase;
  }

  public void save(final FlatOwner flatOwner) {
    LOG.debug("save(flatOwner={})", flatOwner);
    dummyDatabase.add(flatOwner);
  }
}
