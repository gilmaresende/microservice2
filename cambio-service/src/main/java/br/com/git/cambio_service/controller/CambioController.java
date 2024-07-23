package br.com.git.cambio_service.controller;

import br.com.git.cambio_service.model.Cambio;
import br.com.git.cambio_service.repositories.CambioRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
@Tag(name = "Cambio Service API")
@RestController
@RequestMapping("cambio-service")
public class CambioController {

    @Autowired
    private Environment environment;

    @Autowired
    private CambioRepository repository;

    @Operation(description = "Get cambio from currency")
    @GetMapping(value = "/{amount}/{from}/{to}")
    public Cambio getCambio(@PathVariable("amount") BigDecimal amount, @PathVariable("from") String from, @PathVariable("to") String to) {
        Cambio cambio = repository.findByFromAndTo(from, to);
        if (cambio == null) {
            throw new RuntimeException("Currency Unsupported");
        }
        String port = environment.getProperty("local.server.port");
        cambio.setEnviroment(port);
        BigDecimal conversionfactory = cambio.getConversionFactor();
        BigDecimal convertedValue = conversionfactory.multiply(amount);
        cambio.setConversionValue(convertedValue.setScale(2, RoundingMode.CEILING));
        return cambio;
    }
}
