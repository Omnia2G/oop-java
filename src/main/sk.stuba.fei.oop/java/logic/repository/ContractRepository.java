package logic.repository;

import model.contract.Contract;
import model.contract.lifeinsurance.accidentinsurance.AccidentInsurance;
import model.contract.lifeinsurance.travelinsurance.TravelInsurance;
import model.contract.nonlifeinsurance.estateinsurance.EstateInsurance;
import model.contract.nonlifeinsurance.householdinsurance.HouseholdInsurance;

import java.util.ArrayList;
import java.util.List;

public class ContractRepository {
    private List<Contract> allContracts;

    public ContractRepository() {
        this.allContracts = new ArrayList<>();
    }

    public List<Contract> getContractByUserId(Long id) {
        List<Contract> userContractList = new ArrayList<>();
        for (Contract contract : allContracts) {
            if (contract.getUserId().equals(id)) {
                userContractList.add(contract);
            }
        }
        return userContractList;
    }

    public boolean checkIfContractIdExists(Long contractId) {
        for (Contract contract : allContracts) {
            if (contract.getContractId().equals(contractId)) {
                return true;
            }
        }
        return false;
    }

    public void addContract(Contract newContract) {
        allContracts.add(newContract);
    }

    public Contract editContract(Contract editedContract) {
        Contract tempContract = getContractId(editedContract.getContractId());
        allContracts.remove(editedContract);
        editContract(editedContract, tempContract);
        System.out.println(tempContract.getContractType());
        switch (tempContract.getContractType()) {
            case ACCIDENT:
                editAccidentInsurance(editedContract, tempContract);
                break;
            case ESTATE:
                editEstateInsurance(editedContract, tempContract);
                break;
            case TRAVEL:
                editTravelInsurance(editedContract, tempContract);
                break;
            case HOUSEHOLD:
                editHouseholdInsurance(editedContract, tempContract);
                break;
        }
        allContracts.add(tempContract);
        return tempContract;
    }

    public List<Contract> getAllContracts() {
        // for safety
        return new ArrayList<>(allContracts);
    }

    public void setAllContracts(List<Contract> allContracts) {
        this.allContracts = allContracts;
    }

    private void editEstateInsurance(Contract editedContract, Contract tempContract) {
        EstateInsurance editedEstateInsurance = (EstateInsurance) editedContract;
        EstateInsurance tempEstateInsurance = (EstateInsurance) tempContract;
        editedEstateInsurance.setEstateAddress(tempEstateInsurance.getEstateAddress());
        editedEstateInsurance.setEstatePrice(tempEstateInsurance.getEstatePrice());
        editedEstateInsurance.setEstateType(tempEstateInsurance.getEstateType());
        editedEstateInsurance.setGarage(tempEstateInsurance.isGarage());
    }

    private void editAccidentInsurance(Contract editedContract, Contract tempContract) {
        AccidentInsurance editedAccidentInsurance = (AccidentInsurance) editedContract;
        AccidentInsurance tempAccidentInsurance = (AccidentInsurance) tempContract;
        editedAccidentInsurance.setAccidentConseq(tempAccidentInsurance.getAccidentConseq());
        editedAccidentInsurance.setDailycompens(tempAccidentInsurance.getDailycompens());
        editedAccidentInsurance.setDeath(tempAccidentInsurance.getDeath());
        editedAccidentInsurance.setTerritorialValidity(tempAccidentInsurance.getTerritorialValidity());
    }

    private void editTravelInsurance(Contract editedContract, Contract tempContract) {
        TravelInsurance editedTravelInsurance = (TravelInsurance) editedContract;
        TravelInsurance tempTravelInsurance = (TravelInsurance) tempContract;
        editedTravelInsurance.setInEU(tempTravelInsurance.isInEU());
        editedTravelInsurance.setPurpose(tempTravelInsurance.getPurpose());
    }

    private void editHouseholdInsurance(Contract editedContract, Contract tempContract) {
        HouseholdInsurance editedHouseholdInsurance = (HouseholdInsurance) editedContract;
        HouseholdInsurance tempHouseholdInsurance = (HouseholdInsurance) tempContract;
        editedHouseholdInsurance.setEstateType(tempHouseholdInsurance.getEstateType());
        editedHouseholdInsurance.setEstateAddress(tempHouseholdInsurance.getEstateAddress());
        editedHouseholdInsurance.setEstatePrice(tempHouseholdInsurance.getEstatePrice());
        editedHouseholdInsurance.setEquipmentPrice(tempHouseholdInsurance.getEquipmentPrice());
    }


    private void editContract(Contract editedContract, Contract tempContract) {
        tempContract.setBeginDate(editedContract.getBeginDate());
        tempContract.setEndDate(editedContract.getEndDate());
        tempContract.setContractPrice(editedContract.getContractPrice());
        tempContract.setMonthlyFee(editedContract.getMonthlyFee());
    }

    private Contract getContractId(Long contractId) {
        Contract tempContract = null;
        for (Contract contract : allContracts) {
            if (contract.getContractId().equals(contractId)) {
                tempContract = contract;
            }
        }
        return tempContract;
    }
}
