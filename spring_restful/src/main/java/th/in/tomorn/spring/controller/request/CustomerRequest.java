package th.in.tomorn.spring.controller.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import org.springframework.stereotype.Component;

@Component
public class CustomerRequest {

    @NotEmpty(message = "is Empty")
    @Size(min = 2, max = 10)
    private String codeKey;
    @NotEmpty(message = "is Empty")
    @Size(min = 2, max = 10)
    private String companyCodeKey;

    public String getCompanyCodeKey() {
        return companyCodeKey;
    }

    public void setCompanyCodeKey(String companyCodeKey) {
        this.companyCodeKey = companyCodeKey;
    }

    public String getCodeKey() {
        return codeKey;
    }

    public void setCodeKey(String codeKey) {
        this.codeKey = codeKey;
    }

}
