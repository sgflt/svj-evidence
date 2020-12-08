package eu.qwsome.svj.features.ownership;

import java.util.Objects;

enum OwnershipType {
  OWNER('O', "Vlastník"),
  COOPERATIVE_SHARE('S', "Podílník");

  private final Character code;
  private String czechName;

  OwnershipType(final Character code, final String czechName) {
    this.code = Objects.requireNonNull(code);
    this.czechName = czechName;
  }

  Character getCode() {
    return this.code;
  }

  static OwnershipType parse(final Character ownershipTypeToParse) {
    for (final var ownershipType : OwnershipType.values()) {
      if (ownershipType.getCode().equals(ownershipTypeToParse)) {
        return ownershipType;
      }
    }

    throw new IllegalArgumentException("Unknown ownership type: " + ownershipTypeToParse);
  }

  public String czechName() {
    return this.czechName;
  }
}
