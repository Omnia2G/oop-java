package model.contract.nonlifeinsurance.estateinsurance;

import model.contract.Contract;
import model.contract.ContractType;
import model.contract.nonlifeinsurance.EstateType;
import model.user.UserAddress;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EstateInsurance extends Contract {

    private EstateType estateType;
    private UserAddress estateAddress;  // not string ..... its a fucking Address class
    private BigDecimal estatePrice; // nehnutelnosti
    private boolean garage;  // pripoistenie garaze

    public EstateInsurance(Long contractId, LocalDate date, Long userId, LocalDate beginDate, LocalDate endDate, BigDecimal contractPrice, BigDecimal monthlyFee, ContractType contractType,
                           EstateType estateType, UserAddress estateAddress, BigDecimal estatePrice, boolean garage) {
        super(contractId, date, userId, beginDate, endDate, contractPrice, monthlyFee, contractType);
        this.estateType = estateType;
        this.estateAddress = estateAddress;
        this.estatePrice = estatePrice;
        this.garage = garage;
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

    public boolean isGarage() {
        return garage;
    }

    public void setGarage(boolean garage) {
        this.garage = garage;
    }

    @Override
    public String toString() {
        return super.toString() +
                " estateType=" + estateType +
                ", estateAddress='" + estateAddress + '\'' +
                ", estatePrice=" + estatePrice +
                ", garage=" + garage +
                '}';
    }
}
