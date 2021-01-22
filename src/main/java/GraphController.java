import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;

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
    private Button plotVx;

    @FXML
    private Button plotVt;

    @FXML
    private TextField txtMaxXValue;

    @FXML
    private TextField txtMaxYValue;

    @FXML
    void smallestValueAction(ActionEvent event) {

    }

    @FXML
    void mediumValueAction(ActionEvent event) {

    }

    @FXML
    void largestValueAction(ActionEvent event) {

    }

    @FXML
    void plotVtAction(ActionEvent event) {

    }

    @FXML
    void plotVxAction(ActionEvent event) {

    }

    @FXML
    void plotXtAction(ActionEvent event) {

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
        assert plotVx != null : "fx:id=\"plotVx\" was not injected: check your FXML file 'graph.fxml'.";
        assert plotVt != null : "fx:id=\"plotVt\" was not injected: check your FXML file 'graph.fxml'.";
        assert txtMaxXValue != null : "fx:id=\"txtMaxXValue\" was not injected: check your FXML file 'graph.fxml'.";
        assert txtMaxYValue != null : "fx:id=\"txtMaxYValue\" was not injected: check your FXML file 'graph.fxml'.";

    }
}