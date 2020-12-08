package eu.qwsome.svj.features.owner.event;

/**
 * @author Lukáš Kvídera
 */
public class FlatOwnerUpdated {
    private Integer id;

    public FlatOwnerUpdated(final Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
