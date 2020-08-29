package th.in.tomorn.spring.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import th.in.tomorn.spring.repository.CustomerRepository;

/**
 *
 * @author tomornw
 */
@Service
public class CustomerService {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    private CustomerRepository customerRepository;

    public List<Map<String, Object>> getCustomer() {
        List<Map<String, Object>> resultList;
        List<Map<String, Object>> returnList = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        resultList = getCustomerList();
        LOG.info("result size: " + resultList.size());
        if (!resultList.isEmpty()) {
            map.put("msg", "พบข้อมูล");
            map.put("value", true);
            map.put("data", resultList);
        } else {
            map.put("msg", "ไม่พบข้อมูล");
            map.put("value", false);
            map.put("data", "");
        }
        returnList.add(map);
        return returnList;
    }

    public List<Map<String, Object>> insertDataCustomer(String codeKey, String companyCodeKey, String codeNameTh, String codeNameEn) {
        List<Map<String, Object>> resultList;
        List<Map<String, Object>> returnList = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        resultList = insertCustomer(codeKey, companyCodeKey, codeNameTh, codeNameEn);
        LOG.info("result size: " + resultList.size());
        if (!resultList.isEmpty()) {
            map.put("msg", "พบข้อมูล");
            map.put("value", true);
            map.put("data", resultList);
        } else {
            map.put("msg", "ไม่พบข้อมูล");
            map.put("value", false);
            map.put("data", "");
        }
        returnList.add(map);
        return returnList;
    }

    @Transactional
    private List<Map<String, Object>> getCustomerList() {
        List<Map<String, Object>> resultList = customerRepository.findAll();
        return resultList;
    }

    @Transactional
    private List<Map<String, Object>> insertCustomer(String codeKey, String companyCodeKey, String codeNameTh, String codeNameEn) {
        List<Map<String, Object>> resultList = null;
        if (customerRepository.insert(codeKey, companyCodeKey, codeNameTh, codeNameEn) > 0) {
            resultList = customerRepository.findAll();
        }
        return resultList;
    }

}
