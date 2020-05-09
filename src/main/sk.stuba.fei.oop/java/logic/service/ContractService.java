package logic.service;

import logic.repository.ContractRepository;
import logic.repository.UserRepository;
import model.contract.Contract;
import model.user.User;

import java.util.List;
import java.util.stream.Collectors;

public class ContractService {
    private final ContractRepository contractRepository;
    private final UserRepository userRepository;

    public ContractService(ContractRepository contractRepository, UserRepository userRepository) {
        this.contractRepository = contractRepository;
        this.userRepository = userRepository;
    }

    public List<Contract> getAllContracts() {
        return contractRepository.getAllContracts();
    }

    public List<Contract> getContractsByUserId(Long userId) {
        return contractRepository.getContractByUserId(userId);
    }

    public void addNewContract(Contract contract) {
        try {
            checkIfContractIsValid(contract);
            contractRepository.addContract(contract);
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public Contract editContract(Contract contract) {
        // edit contract by contract id
        User user = userRepository.getUserById(contract.getUserId());
        List<Contract> userContractList = user.getListOfContracts();
        List<Contract> editedUserContractList = userContractList.stream().filter(contract1 -> !contract1.getContractId().equals(contract.getContractId())).collect(Collectors.toList());
        Contract editedContract = contractRepository.editContract(contract);
        editedUserContractList.add(editedContract);
        return editedContract;
    }

    private void checkIfContractIsValid(Contract contract) {

        if (contract == null || contract.getContractId() <= 0 || contract.getUserId() <= 0) {
            throw new IllegalArgumentException("Not valid contract, cant be added.");
        }
    }

}
