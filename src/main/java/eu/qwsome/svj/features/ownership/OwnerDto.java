package eu.qwsome.svj.features.ownership;

import java.time.LocalDate;

/**
 * @author Lukáš Kvídera
 */
class OwnerDto {

  private final Integer id;
  private final String firstName;
  private final String lastName;
  private final String anotherNames;
  private final LocalDate birthDate;
  private final String email;
  private final String notice;
  private final String phone;

  OwnerDto(
    final int id,
    final String firstName,
    final String lastName,
    final String anotherNames,
    final LocalDate birthDate,
    final String email,
    final String phone,
    final String notice
  ) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.anotherNames = anotherNames;
    this.birthDate = birthDate;
    this.email = email;
    this.phone = phone;
    this.notice = notice;
  }

  int getId() {
    return this.id;
  }

  String getFirstName() {
    return this.firstName;
  }

  String getLastName() {
    return this.lastName;
  }

  String getAnotherNames() {
    return this.anotherNames;
  }

  LocalDate getBirthDate() {
    return this.birthDate;
  }

  String getEmail() {
    return this.email;
  }

  String getPhone() {
    return this.phone;
  }

  String getNotice() {
    return this.notice;
  }

  @Override
  public String toString() {
    return "OwnerDto{" +
      "id=" + this.id +
      ", firstName='" + this.firstName + '\'' +
      ", lastName='" + this.lastName + '\'' +
      ", anotherNames='" + this.anotherNames + '\'' +
      ", birthDate=" + this.birthDate +
      ", email='" + this.email + '\'' +
      ", notice='" + this.notice + '\'' +
      ", phone='" + this.phone + '\'' +
      '}';
  }
}
