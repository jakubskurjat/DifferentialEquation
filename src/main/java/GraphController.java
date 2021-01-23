import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import org.apache.commons.math3.ode.FirstOrderIntegrator;
import org.apache.commons.math3.ode.nonstiff.EulerIntegrator;

import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GraphController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private LineChart<?, ?> lineChart;

    @FXML
    private CategoryAxis axisX;

    @FXML
    private NumberAxis axisY;

    @FXML
    private SplitMenuButton splitMenuButton;

    @FXML
    private MenuItem smallestValue;

    @FXML
    private MenuItem mediumValue;

    @FXML
    private MenuItem largestValue;

    @FXML
    private Label labelResult;

    @FXML
    private Button plotXt;

    @FXML
    private Button plotVt;

    @FXML
    private Button plotXv;

    @FXML
    private TextField txtMaxTValue;

    @FXML
    private TextField txtInitialFunctionXValue;

    @FXML
    private TextField txtInitialFunctionVValue;

    Grapher grapher;

    ArrayList<Point> points;

    XYChart.Series series;

    @FXML
    void smallestValueAction(ActionEvent event) {
        splitMenuButton.setText(smallestValue.getText());
    }

    @FXML
    void mediumValueAction(ActionEvent event) {
        splitMenuButton.setText(mediumValue.getText());
    }

    @FXML
    void largestValueAction(ActionEvent event) {
        splitMenuButton.setText(largestValue.getText());
    }

    @FXML
    void plotXtAction(ActionEvent event) {
        if(areAllValuesGiven()){
            preparingVariables();

            for (int i = 0; i < points.size(); i++)
                series.getData().add(new XYChart.Data("" + points.get(i).getT(), points.get(i).getX()));

            lineChart.getData().add(series);
            lineChart.setLegendVisible(true);
            grapher = new Grapher(lineChart);

            labelResult.setText("x = " + points.get(points.size() - 1).getX());
        }
    }

    @FXML
    void plotVtAction(ActionEvent event) {
        if(areAllValuesGiven()){
            preparingVariables();

            for (int i = 0; i < points.size(); i++)
                series.getData().add(new XYChart.Data("" + points.get(i).getT(), points.get(i).getV()));

            lineChart.getData().add(series);
            lineChart.setLegendVisible(true);
            grapher = new Grapher(lineChart);

            labelResult.setText("v = " + points.get(points.size() - 1).getV());
        }
    }

    @FXML
    void plotXvAction(ActionEvent event) {
        if(areAllValuesGiven()){
            preparingVariables();

            for (int i = 0; i < points.size(); i++)
                series.getData().add(new XYChart.Data("" + points.get(i).getV(), points.get(i).getX()));

            lineChart.getData().add(series);
            lineChart.setLegendVisible(true);
            grapher = new Grapher(lineChart);

            labelResult.setText("x = " + points.get(points.size()-1).getX() + "\nv = " + points.get(points.size() - 1).getV());
        }
    }

    private void preparingVariables(){
        HarmonicODE harmonicODE = new HarmonicODE(Double.parseDouble(splitMenuButton.getText()));
        FirstOrderIntegrator euler = new EulerIntegrator(0.01);
        ConsoleStepper consoleStepper = new ConsoleStepper();
        points = consoleStepper.getPoints();

        euler.addStepHandler(consoleStepper);

        double[] x0 = {Double.parseDouble(txtInitialFunctionXValue.getText()), Double.parseDouble(txtInitialFunctionVValue.getText())};
        double[] x = new double[2];

        euler.integrate(harmonicODE, -Double.parseDouble(txtMaxTValue.getText()), x0, Double.parseDouble(txtMaxTValue.getText()), x);

        lineChart.setAnimated(false);
        lineChart.getData().clear();

        series = new XYChart.Series();
    }

    private boolean areAllValuesGiven(){
        if(splitMenuButton.getText().length() == 1){
            JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(JOptionPane.getRootFrame()),"Select value!");
            return false;
        }
        else if(txtMaxTValue.getText().equals("") || txtInitialFunctionXValue.getText().equals("") || txtInitialFunctionVValue.getText().equals("")){
            JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(JOptionPane.getRootFrame()),"Max t or initial values are empty!");
            return false;
        }
        else if(!(isNumberAndAtLeastZero(txtMaxTValue) && isNumberAndAtLeastZero(txtInitialFunctionXValue) && isNumberAndAtLeastZero(txtInitialFunctionVValue))){
            JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(JOptionPane.getRootFrame()),"Max t have to be greater than 0 or values are not a number!");
            return false;
        }

        return true;
    }

    private boolean isNumberAndAtLeastZero(TextField value){
        int i = 0;

        if(!value.equals("") && value.getId().equals("txtMaxTValue")) {
            while (i < value.getLength()) {
                if (value.getText().charAt(0) == 46 && value.getLength() == 1) return false;
                else if (value.getLength() == 2 && value.getText().lastIndexOf('.') == 1) return false;
                else if (value.getText().lastIndexOf('.') > 1) return false;
                else if (i==0 && (value.getText().charAt(i) <= 48 || value.getText().charAt(i) > 57)) {
                    return false;
                }

                i++;
            }
            return true;

        } else if(!value.equals("") && !value.getId().equals("txtMaxTValue")){
            while (i < value.getLength()) {
                if (value.getText().charAt(0) == 46 && value.getLength() == 1) return false;
                else if (value.getLength() == 2 && value.getText().lastIndexOf('.') == 1) return false;
                else if (value.getText().lastIndexOf('.') > 1) return false;
                else if (i==0 && (value.getText().charAt(i) < 48 || value.getText().charAt(i) > 57)) {
                    return false;
                }

                i++;
            }

            return true;
        }

        return false;
    }

    @FXML
    void initialize() {
        assert lineChart != null : "fx:id=\"lineChart\" was not injected: check your FXML file 'graph.fxml'.";
        assert axisX != null : "fx:id=\"axisX\" was not injected: check your FXML file 'graph.fxml'.";
        assert axisY != null : "fx:id=\"axisY\" was not injected: check your FXML file 'graph.fxml'.";
        assert splitMenuButton != null : "fx:id=\"splitMenuButton\" was not injected: check your FXML file 'graph.fxml'.";
        assert smallestValue != null : "fx:id=\"smallestValue\" was not injected: check your FXML file 'graph.fxml'.";
        assert mediumValue != null : "fx:id=\"mediumValue\" was not injected: check your FXML file 'graph.fxml'.";
        assert largestValue != null : "fx:id=\"largestValue\" was not injected: check your FXML file 'graph.fxml'.";
        assert labelResult != null : "fx:id=\"labelResult\" was not injected: check your FXML file 'graph.fxml'.";
        assert plotXt != null : "fx:id=\"plotXt\" was not injected: check your FXML file 'graph.fxml'.";
        assert plotXv != null : "fx:id=\"plotVx\" was not injected: check your FXML file 'graph.fxml'.";
        assert plotVt != null : "fx:id=\"plotVt\" was not injected: check your FXML file 'graph.fxml'.";
        assert txtMaxTValue != null : "fx:id=\"txtMaxXValue\" was not injected: check your FXML file 'graph.fxml'.";
        assert txtInitialFunctionXValue != null : "fx:id=\"txtInitialFunctionXValue\" was not injected: check your FXML file 'graph.fxml'.";
        assert txtInitialFunctionVValue != null : "fx:id=\"txtInitialFunctionVValue\" was not injected: check your FXML file 'graph.fxml'.";

    }
}