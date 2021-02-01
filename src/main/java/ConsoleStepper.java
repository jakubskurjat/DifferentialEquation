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

        points.add(new Point(roundNumber(t,3), roundNumber(x[0],3), roundNumber(x[1],3)));
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    private static double roundNumber(double number, int numberOfSignificantFigures){
        return ((int) Math.round(number*Math.pow(10,numberOfSignificantFigures)))/Math.pow(10,numberOfSignificantFigures);
    }
}