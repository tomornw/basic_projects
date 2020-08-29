package th.in.tomorn.spring.util;

import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @author tomornw
 */
@Component
public class SpringJdbc {

    private static final Logger LOG = LoggerFactory.getLogger(SpringJdbc.class);

    public Object findColumnValue(List<Map<String, Object>> resultList, String columnName) {
        Object object = null;
        if (!resultList.isEmpty()) {
            LOG.debug("resultList size: " + resultList.size());
            for (int i = 0; i < resultList.size(); i++) {
                object = resultList.get(i).get(columnName);
                LOG.debug("i: " + (i + 1) + " " + columnName + ": " + object);
                i++;
            }
        } else {
            LOG.warn("resultList: Empty");
        }
        return object;
    }

}
