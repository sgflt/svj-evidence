package eu.qwsome.svj.features.ownership;

import java.util.Objects;

enum OwnershipType {
  OWNER('O'),
  COOPERATIVE_SHARE('S');

  private final Character code;

  OwnershipType(final Character code) {
    this.code = Objects.requireNonNull(code);
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
}
