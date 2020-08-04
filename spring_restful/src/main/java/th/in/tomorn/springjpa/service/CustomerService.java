package th.in.tomorn.springjpa.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import th.in.tomorn.springjpa.entity.Customer;
import th.in.tomorn.springjpa.repository.CustomerRepository;

/**
 *
 * @author tomornw
 */
@Component("customerService")
public class CustomerService {

    private final CustomerRepository repository;

    @Autowired
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public List<Customer> findSpringExpressions(String expressions) throws Exception {
        List<Customer> listObj = new ArrayList<>();
        //http://localhost:8888/customer/findAll
        switch (expressions) {
            case "findAll":
                listObj = (List<Customer>) repository.findAll();
                break;
            default:
                break;
        }
        return listObj;
    }
}
