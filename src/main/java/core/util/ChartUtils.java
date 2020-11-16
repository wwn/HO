package core.util;

import core.gui.model.StatistikModel;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.internal.chartpart.Chart;
import org.knowm.xchart.style.Styler;

import javax.swing.*;

public class ChartUtils extends XYChart{

    StatistikModel[] m_Models = null;

    public ChartUtils(StatistikModel[] models, boolean hasLabels, boolean hasHelpLines) {
        super(10, 10);
        this.getStyler().setHasAnnotations(hasLabels);
        this.getStyler().setPlotGridHorizontalLinesVisible(hasHelpLines);
        this.m_Models = models;
    }


    public void setData() {
        double[] xData = new double[] { 0.0, 1.0, 2.0 };
        double[] yData = new double[] { 2.0, 1.0, 0.0 };

        // Create Chart
//        chart = new XYChartBuilder().width(600).height(400).title("Area Chart").xAxisTitle("X").yAxisTitle("Y").build();
        this.setXAxisTitle("X");

        // Customize Chart
        this.getStyler().setLegendPosition(Styler.LegendPosition.InsideNE);
        this.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Area);

        // Series
        this.addSeries("a", new double[] { 0, 3, 5, 7, 9 }, new double[] { -3, 5, 9, 6, 5 });
        this.addSeries("b", new double[] { 0, 2, 4, 6, 9 }, new double[] { -1, 6, 4, 0, 4 });
        this.addSeries("c", new double[] { 0, 1, 3, 8, 9 }, new double[] { -2, -1, 1, 0, 1 });

    }

    public void updateData(String serieName, boolean isVisible) {
        //TODO:
        if (isVisible) this.addSeries(serieName, new double[] { -3, 5, 9, 6, 5 });
        else this.removeSeries(serieName);
    }



}