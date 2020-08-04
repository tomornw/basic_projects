package th.in.tomorn.springjpa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import th.in.tomorn.springjpa.entity.CallBack;
import th.in.tomorn.springjpa.entity.Customer;
import th.in.tomorn.springjpa.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{queryString}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public CallBack<Customer> customerSpringExpressions(@PathVariable String queryString, HttpServletRequest request) {
        LOG.info("find by customerSpringExpressions");
        CallBack<Customer> callBack = new CallBack();
        try {
            LOG.debug("debug message");
            LOG.info("This is an info message");
            LOG.warn("Warning for this application");
            LOG.error("Seems error in the application");
            System.out.println("Test Log "+queryString);

            callBack.setData(new ArrayList<>());
            callBack.setData(customerService.findSpringExpressions(queryString));
        } catch (Exception ex) {
            callBack.setCode("500");
            callBack.setMessage("Have Exception: " + ex.getMessage());
        }
        return callBack;
    }
}
