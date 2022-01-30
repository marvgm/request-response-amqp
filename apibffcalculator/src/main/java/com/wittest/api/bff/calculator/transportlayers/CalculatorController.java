package com.wittest.api.bff.calculator.transportlayers;

import com.wittest.api.bff.calculator.entities.ResultDto;
import com.wittest.api.bff.calculator.entities.enumerators.OperationalEnum;
import com.wittest.api.bff.calculator.interactors.ServiceCalculatorUseCase;
import com.wittest.api.bff.calculator.interactors.ServiceGenUuidUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class CalculatorController {

    @Autowired
    private ServiceCalculatorUseCase serviceCalculatorUseCase;

    @Autowired
    private ServiceGenUuidUseCase serviceGenUuidUseCase;

    @GetMapping(value = "/sum")
    public ResponseEntity<ResultDto> calculateSum(@RequestParam(name = "a") BigDecimal a,
                                          @RequestParam(name = "b") BigDecimal b) {

     var id = serviceGenUuidUseCase.getUuid();

     var result =  this.serviceCalculatorUseCase.calculate(a, b, OperationalEnum.SUM.name(), id);

     return ResponseEntity.ok()
             .headers(getHeaders(id))
             .body(result);
    }

    @GetMapping(value = "/minus")
    public ResponseEntity<ResultDto> calculateMinus(@RequestParam(name = "a") BigDecimal a,
                                               @RequestParam(name = "b") BigDecimal b) {

        var id = serviceGenUuidUseCase.getUuid();

        var result =  this.serviceCalculatorUseCase.calculate(a, b, OperationalEnum.MINUS.name(), id);

        return ResponseEntity.ok()
                .headers(getHeaders(id))
                .body(result);
    }

    @GetMapping(value = "/division")
    public ResponseEntity<ResultDto> calculateDivision(@RequestParam(name = "a") BigDecimal a,
                                                    @RequestParam(name = "b") BigDecimal b) {

        var id = serviceGenUuidUseCase.getUuid();

        var result =  this.serviceCalculatorUseCase.calculate(a, b, OperationalEnum.DIVISION.name(), id);

        return ResponseEntity.ok()
                .headers(getHeaders(id))
                .body(result);
    }

    @GetMapping(value = "/multiplication")
    public ResponseEntity<ResultDto> calculateMultiplication(@RequestParam(name = "a") BigDecimal a,
                                                       @RequestParam(name = "b") BigDecimal b) {

        var id = serviceGenUuidUseCase.getUuid();

        var result =  this.serviceCalculatorUseCase.calculate(a, b, OperationalEnum.MULTIPLICATION.name(), id);

        return ResponseEntity.ok()
                .headers(getHeaders(id))
                .body(result);
    }

    private HttpHeaders getHeaders(UUID id){
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("id", id.toString());
        return responseHeaders;
    }


}
