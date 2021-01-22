import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.ode.sampling.StepHandler;
import org.apache.commons.math3.ode.sampling.StepInterpolator;

import java.util.ArrayList;

public class ConsoleStepper implements StepHandler {

    ArrayList<Point> points = new ArrayList<>();

    @Override
    public void init(double t0, double[] y0, double t) {
    }

    @Override
    public void handleStep(StepInterpolator interpolator, boolean isLast) throws MaxCountExceededException {
        double t = interpolator.getCurrentTime();
        double[] x = interpolator.getInterpolatedState();

        points.add(new Point(Math.round(t * 1000) / 1000.0, x[0], x[1]));
    }

    public ArrayList<Point> getPoints() {
        return points;
    }
}