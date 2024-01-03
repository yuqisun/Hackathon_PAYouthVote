package org.hackathon.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Voter")
public class Voter implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "phone", nullable = false)
    private String phone;
    @Column(name = "firstName", nullable = false)
    private String firstName;
    @Column(name = "middleName")
    private String middleName;
    @Column(name = "lastName", nullable = false)
    private String lastName;
    @Column(name = "suffix")
    private String suffix;
    @Column(name = "citizenUS", nullable = false)
    private Boolean citizenUS;
    @Column(name = "age18", nullable = false)
    private Boolean age18;
    @Column(name = "reasonToRegister")
    private String reasonToRegister;
    @Column(name = "birthDate", nullable = false)
    private String birthDate;
    @Column(name = "gender", nullable = false)
    private String gender;
    @Column(name = "streetAddress1", nullable = false)
    private String streetAddress1;
    @Column(name = "streetAddress2", nullable = false)
    private String streetAddress2;
    @Column(name = "unitType")
    private String unitType;
    @Column(name = "unitNumber")
    private String unitNumber;
    @Column(name = "city", nullable = false)
    private String city;
    @Column(name = "zipCode")
    private String zipCode;
    @Column(name = "padriver")
    private String padriver;
    @Column(name = "socialSecurity")
    private String socialSecurity;
    @Column(name = "penndotID")
    private String penndotID;
    @Column(name = "politicalParty")
    private String politicalParty;
    @Column(name = "votingAssistance")
    private Boolean votingAssistance;
    @Column(name = "declaration")
    private Boolean declaration;
    @Column(name = "pollWorker")
    private Boolean pollWorker;
    @Column(name = "annualBallot")
    private Boolean annualBallot;
    @Column(name = "mailInBallot")
    private Boolean mailInBallot;

    public Voter() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public Boolean getCitizenUS() {
        return citizenUS;
    }

    public void setCitizenUS(Boolean citizenUS) {
        this.citizenUS = citizenUS;
    }

    public Boolean getAge18() {
        return age18;
    }

    public void setAge18(Boolean age18) {
        this.age18 = age18;
    }

    public String getReasonToRegister() {
        return reasonToRegister;
    }

    public void setReasonToRegister(String reasonToRegister) {
        this.reasonToRegister = reasonToRegister;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStreetAddress1() {
        return streetAddress1;
    }

    public void setStreetAddress1(String streetAddress1) {
        this.streetAddress1 = streetAddress1;
    }

    public String getStreetAddress2() {
        return streetAddress2;
    }

    public void setStreetAddress2(String streetAddress2) {
        this.streetAddress2 = streetAddress2;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPadriver() {
        return padriver;
    }

    public void setPadriver(String padriver) {
        this.padriver = padriver;
    }

    public String getSocialSecurity() {
        return socialSecurity;
    }

    public void setSocialSecurity(String socialSecurity) {
        this.socialSecurity = socialSecurity;
    }

    public String getPenndotID() {
        return penndotID;
    }

    public void setPenndotID(String penndotID) {
        this.penndotID = penndotID;
    }

    public String getPoliticalParty() {
        return politicalParty;
    }

    public void setPoliticalParty(String politicalParty) {
        this.politicalParty = politicalParty;
    }

    public Boolean getVotingAssistance() {
        return votingAssistance;
    }

    public void setVotingAssistance(Boolean votingAssistance) {
        this.votingAssistance = votingAssistance;
    }

    public Boolean getDeclaration() {
        return declaration;
    }

    public void setDeclaration(Boolean declaration) {
        this.declaration = declaration;
    }

    public Boolean getPollWorker() {
        return pollWorker;
    }

    public void setPollWorker(Boolean pollWorker) {
        this.pollWorker = pollWorker;
    }

    public Boolean getAnnualBallot() {
        return annualBallot;
    }

    public void setAnnualBallot(Boolean annualBallot) {
        this.annualBallot = annualBallot;
    }

    public Boolean getMailInBallot() {
        return mailInBallot;
    }

    public void setMailInBallot(Boolean mailInBallot) {
        this.mailInBallot = mailInBallot;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Voter{");
        sb.append("id=").append(id);
        sb.append(", email='").append(email).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", middleName='").append(middleName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", suffix='").append(suffix).append('\'');
        sb.append(", citizenUS=").append(citizenUS);
        sb.append(", age18=").append(age18);
        sb.append(", reasonToRegister='").append(reasonToRegister).append('\'');
        sb.append(", birthDate='").append(birthDate).append('\'');
        sb.append(", gender='").append(gender).append('\'');
        sb.append(", streetAddress1='").append(streetAddress1).append('\'');
        sb.append(", streetAddress2='").append(streetAddress2).append('\'');
        sb.append(", unitType='").append(unitType).append('\'');
        sb.append(", unitNumber='").append(unitNumber).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", zipCode='").append(zipCode).append('\'');
        sb.append(", padriver='").append(padriver).append('\'');
        sb.append(", socialSecurity='").append(socialSecurity).append('\'');
        sb.append(", penndotID='").append(penndotID).append('\'');
        sb.append(", politicalParty='").append(politicalParty).append('\'');
        sb.append(", votingAssistance=").append(votingAssistance);
        sb.append(", declaration=").append(declaration);
        sb.append(", pollWorker=").append(pollWorker);
        sb.append(", annualBallot=").append(annualBallot);
        sb.append(", mailInBallot=").append(mailInBallot);
        sb.append('}');
        return sb.toString();
    }
}
