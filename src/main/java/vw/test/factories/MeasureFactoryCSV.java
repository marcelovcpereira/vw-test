package vw.test.factories;


import ch.qos.logback.classic.Logger;
import vw.test.entities.Measure;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by marcelopereira on 3/8/19.
 */
@Component
public class MeasureFactoryCSV extends MeasureFactory {
    public static final Logger logger = (Logger) LoggerFactory.getLogger(MeasureFactory.class);
    @Autowired
    private Environment env;

    /**
     * Initializes a factory of measures by loading data from CSV.
     *
     * @param csvPath
     * @return
     */
    @Override
    public List<Measure> load(String csvPath) {
        List<Measure> ret = null;

        try (Stream<String> stream = Files.lines(Paths.get(csvPath))) {
            ret = stream
                    .skip(1)
                    .map(e -> fromCSV(e))
                    .filter(measure -> measure != null)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * Parses a CSV line into a Measure object.
     *
     * @param csvLine String
     * @return Measure
     */
    public Measure fromCSV(String csvLine) {
        Measure ret = null;
        if (csvLine != null) {
            try {
                String[] attributes = csvLine.split(env.getProperty("vw.test.csv.separator"));
                if (attributes.length < 1) {
                    return null;
                }
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(env.getProperty("vw.test.csv.date.pattern"));
                DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(env.getProperty("vw.test.csv.time.pattern"));
                ret = new Measure();
                ret.setDate(LocalDate.parse(attributes[0], dateFormatter));
                ret.setTime(LocalTime.parse(attributes[1], timeFormatter));
                ret.setAverageCOConcentration(parseFloat(attributes[2]));
                ret.setAverageSensorResponseCO(parseFloat(attributes[3]));
                ret.setAverageNonMetanicHydroCarbons(parseFloat(attributes[4]));
                ret.setAverageBenzeneConcentration(parseFloat(attributes[5]));
                ret.setAverageSensorResponseNMHC(parseFloat(attributes[6]));
                ret.setAverageNOXConcentration(parseFloat(attributes[7]));
                ret.setAverageSensorResponseNOX(parseFloat(attributes[8]));
                ret.setAverageNO2Concentration(parseFloat(attributes[9]));
                ret.setAverageSensorResponseNO2(parseFloat(attributes[10]));
                ret.setAverageSensorResponseO3(parseFloat(attributes[11]));
                ret.setTemperature(parseFloat(attributes[12]));
                ret.setRelativeHumidity(parseFloat(attributes[13]));
                ret.setAbsoluteHumidity(parseFloat(attributes[14]));
            } catch (DateTimeParseException | NumberFormatException nfe) {
                return null;
            }
        }
        return ret;
    }

    /**
     * Safe method for parsing float as we need aditional logic
     *
     * @param str String
     * @return Float
     */
    public static Float parseFloat(String str) {
        if (str == null) return null;
        str = str.replace(",", ".");
        return Float.parseFloat(str);
    }
}
