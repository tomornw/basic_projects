package th.in.tomorn.spring.controller.api;

import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import th.in.tomorn.spring.controller.request.CustomerRequest;
import th.in.tomorn.spring.controller.response.ResponseAPI;
import th.in.tomorn.spring.service.CustomerService;
import th.in.tomorn.spring.util.DatetimeFormat;
import th.in.tomorn.spring.util.Validation;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private DatetimeFormat datetimeFormat;
    @Autowired
    private Validation validation;
    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/all", consumes = "application/x-www-form-urlencoded", produces = "application/json")
    public ResponseAPI feedCustomer(@Valid CustomerRequest request, BindingResult bindingResult, ResponseAPI response) {
//        curl  -X POST -d "{\"codeKey\":\"test\", \"companyCodeKey\":\"MPK\"}" http://localhost:8888/customer/all
        LOG.debug("debug message");
        LOG.info("This is an info message");
        LOG.warn("Warning for this application");
        LOG.error("Seems error in the application");
        if (validation.checkRequest(bindingResult, response, datetimeFormat)) {
            LOG.info(" Checking request passed : " + request.toString());
            List<Map<String, Object>> reults = customerService.getCustomer();
            response.success(null, reults, datetimeFormat);
            LOG.info(" Response : " + reults);
        }
        return response;
    }

    @PostMapping(path = "/add", consumes = "application/x-www-form-urlencoded", produces = "application/json")
    public ResponseAPI addCustomer(@Valid CustomerRequest request, BindingResult bindingResult, ResponseAPI response) {
//        curl  -X POST -d "{\"codeKey\":\"test\", \"companyCodeKey\":\"MPK\"}" http://localhost:8888/customer/add
        if (validation.checkRequest(bindingResult, response, datetimeFormat)) {
            LOG.info(" Checking request passed : " + request.toString());
            List<Map<String, Object>> reults = customerService.insertDataCustomer(request.getCodeKey(), request.getCompanyCodeKey(), "เย้", "en");
            response.success(null, reults, datetimeFormat);
            LOG.info(" Response : " + reults);
        }
        return response;
    }
}
