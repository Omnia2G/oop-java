package model.contract.lifeinsurance.travelinsurance;

import model.contract.Contract;
import model.contract.ContractType;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TravelInsurance extends Contract {

    private boolean inEU;
    private PurposeOfTrip purpose;

    public TravelInsurance(Long contractId, LocalDate date, Long userId, LocalDate beginDate, LocalDate endDate, BigDecimal contractPrice, BigDecimal monthlyFee, ContractType contractType,
                           boolean inEU, PurposeOfTrip purpose) {
        super(contractId, date, userId, beginDate, endDate, contractPrice, monthlyFee, contractType);
        this.inEU = inEU;
        this.purpose = purpose;
    }

    public boolean isInEU() {
        return inEU;
    }

    public void setInEU(boolean inEU) {
        this.inEU = inEU;
    }

    public PurposeOfTrip getPurpose() {
        return purpose;
    }

    public void setPurpose(PurposeOfTrip purpose) {
        this.purpose = purpose;
    }
}
