package logic.view;

import model.contract.Contract;

import java.util.List;

public class ContractView {

    public void printAllContractsByUserId(List<Contract> contractList) {

        for (Contract contract : contractList) {
            System.out.println(contract.getContractId());
            System.out.println(contract.getContractType());
            System.out.println(contract.getUserId());
            System.out.println();
        }
        System.out.println();
    }

    public void printContractDetails(Contract contract) {
        System.out.println(contract);
    }

    public void printAllContracts(List<Contract> contractList) {
        for (Contract contract : contractList) {
            System.out.println(contract.getContractId());
            System.out.println(contract.getContractType());
            System.out.println();
        }
        System.out.println();
    }
}
