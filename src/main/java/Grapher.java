import javafx.scene.chart.XYChart;

public class Grapher {

    private XYChart graph;

    public Grapher(XYChart graph) {
        this.graph = graph;
    }

    public XYChart getGraph() {
        return graph;
    }

    public void setGraph(XYChart graph) {
        this.graph = graph;
    }
}
