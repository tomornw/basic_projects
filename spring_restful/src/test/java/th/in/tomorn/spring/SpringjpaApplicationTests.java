package th.in.tomorn.spring;

import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import th.in.tomorn.spring.controller.request.CustomerRequest;
import th.in.tomorn.spring.service.CustomerService;

@SpringBootTest
class SpringjpaApplicationTests {

    private static final Logger LOG = LoggerFactory.getLogger(SpringjpaApplicationTests.class);

    @Autowired
    private CustomerService customerService;

    private static final CustomerRequest customerRequest = new CustomerRequest();

    static {
        customerRequest.setCodeKey("005399");
        customerRequest.setCompanyCodeKey("MPK");
    }

    @Test
    @Order(0)
    void feedCustomer() {
        LOG.debug("feedData : Customer");
        boolean hasData = false;
        String msg = "";
        List<Map<String, Object>> resultList = customerService.getCustomer();
        for (int i = 0; i < resultList.size(); i++) {
            if (!resultList.get(i).isEmpty()) {
                hasData = (boolean) resultList.get(i).get("value");
                msg = resultList.get(i).get("msg").toString();
            }
        }
        if (!hasData) {
            LOG.warn(msg);
        }
        assertEquals(true, hasData, msg);
    }

    @Test
    @Order(1)
    void insertCustomer() {
        LOG.debug("insertData : Customer");
        boolean hasData = false;
        String msg = "";
        List<Map<String, Object>> resultList = customerService.insertDataCustomer(customerRequest.getCodeKey(), customerRequest.getCompanyCodeKey(), "ภาษาไทย", "English");
        for (int i = 0; i < resultList.size(); i++) {
            if (!resultList.get(i).isEmpty()) {
                hasData = (boolean) resultList.get(i).get("value");
                msg = resultList.get(i).get("msg").toString();
            }
        }
        if (!hasData) {
            LOG.warn(msg);
        }
        assertEquals(true, hasData, msg);
    }

}
