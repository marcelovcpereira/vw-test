package vw.test.controllers.rest;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import vw.test.entities.Measure;
import vw.test.factories.MeasureFactory;
import vw.test.repositories.MeasureRepository;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Returns RESTful endpoints for decoupled visualization
 */
@RestController
public class RESTController {
    public static final Logger logger = (Logger) LoggerFactory.getLogger(RESTController.class);

    @Autowired
    private MeasureRepository measureRepository;

    @Autowired
    private MeasureFactory factory;

    @Autowired
    private Environment env;


    @GetMapping(path = "/{id}")
    public
    @ResponseBody
    Optional<Measure> get(@PathVariable Integer id) {
        return measureRepository.findById(id);
    }

    @GetMapping(path = "/getNO2Measures")
    public
    @ResponseBody
    List<Measure> getExceededMeasuresInNO2() {
        return measureRepository.findExceededNO2Measures();
    }

    @GetMapping(path = "/getNO2Days")
    public
    @ResponseBody
    List<Date> getExceededDaysInNO2() {
        return measureRepository.findExceededNO2Days();
    }

    @GetMapping(path = "/getNO2DaysCount")
    public
    @ResponseBody
    Integer getExceededDaysCountInNO2() {
        return measureRepository.findExceededNO2DaysCount();
    }

    @PostConstruct
    public void load() {
        logger.info("Loading measures...");
        String filePath = env.getProperty("vw.test.csv.path");
        logger.info("From file: " + filePath);
        List<Measure> measures = factory.load(filePath);
        logger.info("Done. " + measures.size() + " valid measures found. Persisting...");
        measureRepository.saveAll(measures);
        logger.info("Done.");
    }
}