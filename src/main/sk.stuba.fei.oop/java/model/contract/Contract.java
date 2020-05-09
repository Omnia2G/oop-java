package model.contract;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Contract {
    private Long contractId;
    private LocalDate date;
    private Long userId;
    private LocalDate beginDate;
    private LocalDate endDate;
    private BigDecimal contractPrice;
    private BigDecimal monthlyFee;
    private ContractType contractType;


    public Contract() {
    }

    public Contract(Long contractId, LocalDate date, Long userId, LocalDate beginDate, LocalDate endDate, BigDecimal contractPrice, BigDecimal monthlyFee, ContractType contractType) {
        setContractId(contractId);
        setDate(date);
        setUserId(userId);
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.contractPrice = contractPrice;
        this.monthlyFee = monthlyFee;
        this.contractType = contractType;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        if (contractId <= 0)
            throw new IllegalArgumentException("You have to specify contract ID.");
        this.contractId = contractId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        if (date.equals(0))
            throw new IllegalArgumentException("You have to specify contracts date.");
        this.date = date;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        if (userId <= 0)
            throw new IllegalArgumentException("You have to specify contracts userID.");
        this.userId = userId;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getContractPrice() {
        return contractPrice;
    }

    public void setContractPrice(BigDecimal contractPrice) {
        this.contractPrice = contractPrice;
    }

    public BigDecimal getMonthlyFee() {
        return monthlyFee;
    }

    public void setMonthlyFee(BigDecimal monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    public ContractType getContractType() {
        return contractType;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contractId=" + contractId +
                ", datum=" + date +
                ", userId=" + userId +
                ", datumZac=" + beginDate +
                ", datumKoniec=" + endDate +
                ", suma=" + contractPrice +
                ", splatka=" + monthlyFee +
                '}';
    }
}
