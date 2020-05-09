package model.contract.nonlifeinsurance.householdinsurance;

import model.contract.Contract;
import model.contract.ContractType;
import model.contract.nonlifeinsurance.EstateType;
import model.user.UserAddress;

import java.math.BigDecimal;
import java.time.LocalDate;

public class HouseholdInsurance extends Contract {

    private EstateType estateType;
    private UserAddress estateAddress;
    private BigDecimal estatePrice; // nehnutelnosti
    private BigDecimal equipmentPrice; //zariadenia

    public HouseholdInsurance(Long contractId, LocalDate date, Long userId, LocalDate beginDate, LocalDate endDate, BigDecimal contractPrice, BigDecimal monthlyFee, ContractType contractType,
                              EstateType estateType, UserAddress estateAddress, BigDecimal estatePrice, BigDecimal equipmentPrice) {
        super(contractId, date, userId, beginDate, endDate, contractPrice, monthlyFee, contractType);
        this.estateType = estateType;
        this.estateAddress = estateAddress;
        this.estatePrice = estatePrice;
        this.equipmentPrice = equipmentPrice;
    }

    public EstateType getEstateType() {
        return estateType;
    }

    public void setEstateType(EstateType estateType) {
        this.estateType = estateType;
    }

    public UserAddress getEstateAddress() {
        return estateAddress;
    }

    public void setEstateAddress(UserAddress estateAddress) {
        this.estateAddress = estateAddress;
    }

    public BigDecimal getEstatePrice() {
        return estatePrice;
    }

    public void setEstatePrice(BigDecimal estatePrice) {
        this.estatePrice = estatePrice;
    }

    public BigDecimal getEquipmentPrice() {
        return equipmentPrice;
    }

    public void setEquipmentPrice(BigDecimal equipmentPrice) {
        this.equipmentPrice = equipmentPrice;
    }
}
