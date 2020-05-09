
import logic.repository.ContractRepository;
import logic.repository.UserRepository;
import logic.service.ContractService;
import logic.service.UserService;
import logic.view.ContractView;
import logic.view.UserView;
import model.contract.Contract;
import model.contract.ContractType;
import model.contract.lifeinsurance.accidentinsurance.AccidentInsurance;
import model.contract.lifeinsurance.accidentinsurance.TerritorialValidity;
import model.contract.lifeinsurance.travelinsurance.PurposeOfTrip;
import model.contract.lifeinsurance.travelinsurance.TravelInsurance;
import model.contract.nonlifeinsurance.EstateType;
import model.contract.nonlifeinsurance.estateinsurance.EstateInsurance;
import model.contract.nonlifeinsurance.householdinsurance.HouseholdInsurance;
import model.user.User;
import model.user.UserAddress;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    //contract
    // ctractId , date, userId, beginDate, endDate, contractPrice, monthlyFee, contractType
    //estateInsurance
    //estateType, estateAddress, estatePrice, garage
    public static void main(String[] args) {

        UserAddress userAddress1 = new UserAddress(82106, "Bratislava", "Baltska", 21);
        UserAddress userAddress2 = new UserAddress(81102, "Bratislava", "Hviezdoslavovo namestie", 15);
        Contract contract1 = new EstateInsurance(1L, LocalDate.now(), 1L, LocalDate.now(), LocalDate.now(), BigDecimal.valueOf(250000.01D), BigDecimal.valueOf(675.88D), ContractType.ESTATE, EstateType.FAMILYBRICKHOUSE, userAddress1, BigDecimal.valueOf(154156.2), true);
        Contract contract2 = new AccidentInsurance(2L, LocalDate.now(), 1L, LocalDate.now(), LocalDate.now(), BigDecimal.valueOf(123654.55D), BigDecimal.valueOf(233.23D), ContractType.ACCIDENT, 600, 25000, 65, TerritorialValidity.WORLDPLUSSLOVAKIA);
        Contract contract3 = new TravelInsurance(3L, LocalDate.now(), 2L, LocalDate.now(), LocalDate.now(), BigDecimal.valueOf(250.00D), BigDecimal.valueOf(13.34D), ContractType.TRAVEL, true, PurposeOfTrip.WORK);
        Contract contract4 = new HouseholdInsurance(4L, LocalDate.now(), 2L, LocalDate.now(), LocalDate.now(), BigDecimal.valueOf(65000.86D), BigDecimal.valueOf(485.39D), ContractType.HOUSEHOLD, EstateType.FLAT, userAddress2, BigDecimal.valueOf(235000.75D), BigDecimal.valueOf(45389.70D));
        List<Contract> contractsUser1 = new ArrayList<>(Collections.singleton(contract1));
        contractsUser1.add(contract2);
        List<Contract> contractsUser2 = new ArrayList<>(Collections.singleton(contract3));
        contractsUser2.add(contract4);
        User user1 = new User(1L, "Zsombor", "Orosz", 123456, "xorosz@stuba.sk", userAddress1, null, contractsUser1);
        User user2 = new User(2L, "Marek", "Novotny", 654321, "xnovotny@stuba.sk", userAddress2, null, contractsUser2);
        UserRepository userRepository = new UserRepository();
        ContractRepository contractRepository = new ContractRepository();
        UserService userService = new UserService(userRepository);
        ContractService contractService = new ContractService(contractRepository, userRepository);
        UserView userView = new UserView();
        ContractView contractView = new ContractView();
        contractService.addNewContract(contract1);
        contractService.addNewContract(contract2);
        contractService.addNewContract(contract3);
        contractService.addNewContract(contract4);
        userService.addNewUser(user1);
        userService.addNewUser(user2);

        System.out.println("1. and 2. user: ");
        userView.printUserDetails(userService.getUserById(1L));
        userView.printUserDetails(userService.getUserById(2L));

        System.out.println("Edited firstName of user1: ");
        user1.setFirstName("Kalman");
        userService.editUser(user1);
        userView.printUserDetails(userService.getUserById(1L));

        System.out.println("Edited contract1 monthlyFee: ");
        System.out.println(contract1.getMonthlyFee());
        contract1.setMonthlyFee(BigDecimal.valueOf(750.50D));
        System.out.println(contractService.editContract(contract1));
        System.out.println();
        System.out.println();

        System.out.println("\nUser1's contracts (contractId, contractType, userId): ");
        contractView.printAllContractsByUserId(user1.getListOfContracts());

        System.out.println("All contracts in the database (contractID / contractType): ");
        contractView.printAllContracts(contractService.getAllContracts());

        System.out.println("contract1 details: ");
        contractView.printContractDetails(contract1);


    }
}

