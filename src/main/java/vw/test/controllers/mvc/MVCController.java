package vw.test.controllers.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vw.test.entities.Measure;
import vw.test.repositories.MeasureRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Plots the HTML page containing table with full required measure data
 */
@Controller
public class MVCController {

    @Autowired
    private MeasureRepository measureRepository;


    @GetMapping("/getMVCDashboard")
    public String dashboard(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        List<Measure> measures = measureRepository.findExceededNO2Measures();
        Integer totalRows = measureRepository.findExceededNO2DaysCount();
        model.addAttribute("measures", measures);
        model.addAttribute("totalRows", totalRows);
        return "dashboard";
    }

    @GetMapping("/getBootstrapDashboard")
    public String bootstrapDashboard(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        List<Measure> measures = measureRepository.findExceededNO2Measures();
        Map<String, List<Measure>> measureMap = new HashMap<>();
        for (Measure m : measures) {
            if (measureMap.get(m.getDate().toString()) == null) {
                measureMap.put(m.getDate().toString(), new ArrayList<>());
            }
            measureMap.get(m.getDate().toString()).add(m);
        }
        Integer totalRows = measureRepository.findExceededNO2DaysCount();
        model.addAttribute("measuresMap", measureMap);
        model.addAttribute("totalRows", totalRows);
        return "bootstrap";
    }

}