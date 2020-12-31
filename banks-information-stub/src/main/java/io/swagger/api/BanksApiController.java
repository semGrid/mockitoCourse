package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.model.BankInformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-12-01T14:58:07.832Z")

@Controller
public class BanksApiController implements BanksApi {

    private static final Logger log = LoggerFactory.getLogger(BanksApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public BanksApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<BankInformation>> getAllBanksUsingGET() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<BankInformation>>(objectMapper.readValue("[ {  \"code\" : \"CB\",  \"commissionPercentage\" : 0.0,  \"name\" : \"City Bank\",  \"currency\" : \"USD\"}, {  \"code\" : \"CB\",  \"commissionPercentage\" : 0.0,  \"name\" : \"City Bank\",  \"currency\" : \"USD\"} ]", List.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<BankInformation>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<BankInformation>>(HttpStatus.OK);
    }

    public ResponseEntity<BigDecimal> getBankCommissionUsingGET(@ApiParam(value = "bankCode",required=true) @PathVariable("bankCode") String bankCode) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<BigDecimal>(objectMapper.readValue("0.0", BigDecimal.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<BigDecimal>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<BigDecimal>(HttpStatus.OK);
    }

    public ResponseEntity<String> getBankCurrencyUsingGET(@ApiParam(value = "bankCode",required=true) @PathVariable("bankCode") String bankCode) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<String>(objectMapper.readValue("\"USD\"", String.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<String>(HttpStatus.OK);
    }

    public ResponseEntity<String> getBankInfoUsingGET(@ApiParam(value = "bankCode",required=true) @PathVariable("bankCode") String bankCode) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<String>(objectMapper.readValue("\"\"", String.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<String>(HttpStatus.OK);
    }

}
