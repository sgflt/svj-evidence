package eu.qwsome.svj.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Lukáš Kvídera
 */
@Entity
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer addressId;

  private String municipality;
  private String municipalityPart;
  private String street;
  private String houseNumber;


  public Integer getAddressId() {
    return this.addressId;
  }

  public void setAddressId(final Integer addressId) {
    this.addressId = addressId;
  }

  public String getMunicipality() {
    return this.municipality;
  }

  public void setMunicipality(final String municipality) {
    this.municipality = municipality;
  }

  public String getMunicipalityPart() {
    return this.municipalityPart;
  }

  public void setMunicipalityPart(final String municipalityPart) {
    this.municipalityPart = municipalityPart;
  }

  public String getStreet() {
    return this.street;
  }

  public void setStreet(final String street) {
    this.street = street;
  }

  public String getHouseNumber() {
    return this.houseNumber;
  }

  public void setHouseNumber(final String houseNumber) {
    this.houseNumber = houseNumber;
  }
}
