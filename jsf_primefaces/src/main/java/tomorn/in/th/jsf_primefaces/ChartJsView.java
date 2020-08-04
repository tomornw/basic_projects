package tomorn.in.th.jsf_primefaces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.polar.PolarAreaChartDataSet;
import org.primefaces.model.charts.polar.PolarAreaChartModel;

/**
 *
 * @author tomornw
 */
@Named
@RequestScoped
public class ChartJsView implements Serializable {
    private static final Logger LOG = LoggerFactory.getLogger(ChartJsView.class);

    private PolarAreaChartModel polarAreaModel;

    @PostConstruct
    public void init() {
        createPolarAreaModel();
    }

    private void createPolarAreaModel() {

        LOG.debug("debug message");
        LOG.info("This is an info message");
        LOG.warn("Warning for this application");
        LOG.error("Seems error in the application");
        System.out.println("Test Log ");

        polarAreaModel = new PolarAreaChartModel();
        ChartData data = new ChartData();

        PolarAreaChartDataSet dataSet = new PolarAreaChartDataSet();
        List<Number> values = new ArrayList<>();
        values.add(11);
        values.add(16);
        values.add(7);
        values.add(3);
        values.add(14);
        dataSet.setData(values);

        List<String> bgColors = new ArrayList<>();
        bgColors.add("rgb(255, 99, 132)");
        bgColors.add("rgb(75, 192, 192)");
        bgColors.add("rgb(255, 205, 86)");
        bgColors.add("rgb(201, 203, 207)");
        bgColors.add("rgb(54, 162, 235)");
        dataSet.setBackgroundColor(bgColors);

        data.addChartDataSet(dataSet);
        List<String> labels = new ArrayList<>();
        labels.add("Red");
        labels.add("Green");
        labels.add("Yellow");
        labels.add("Grey");
        labels.add("Blue");
        data.setLabels(labels);

        polarAreaModel.setData(data);
    }

    public PolarAreaChartModel getPolarAreaModel() {
        return polarAreaModel;
    }

    public void setPolarAreaModel(PolarAreaChartModel polarAreaModel) {
        this.polarAreaModel = polarAreaModel;
    }
}
