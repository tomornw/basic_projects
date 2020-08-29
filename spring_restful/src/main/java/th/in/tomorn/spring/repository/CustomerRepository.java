package th.in.tomorn.spring.repository;

import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerRepository.class);
    @Autowired
    @Qualifier("jdbcConnectionDb2")
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> findAll() {
        String query = " SELECT * FROM customer ";
        LOG.debug("CustomerRepository: findAll");
        LOG.debug("Query: " + query);
        List<Map<String, Object>> object = jdbcTemplate.queryForList(query);
        return object;
    }

    public int insert(String codeKey, String companyCodeKey, String codeNameTh, String codeNameEn) {
        String query = " INSERT INTO customer (code_key, company_code_key, code_name_th, code_name_en) "
                + " VALUES (?, ?, ?, ?); ";
        LOG.debug("CustomerRepository: insert");
        LOG.debug("Query: " + query);
        return jdbcTemplate.update(query, codeKey, companyCodeKey, codeNameTh, codeNameEn);
    }
}
