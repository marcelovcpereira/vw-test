package vw.test.factories;

import vw.test.entities.Measure;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by marcelopereira on 3/8/19.
 */
@Component
public abstract class MeasureFactory {
    public abstract List<Measure> load(String address);
}
