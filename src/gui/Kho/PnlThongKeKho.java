package gui.Kho;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import utils.SwingHelper;

import java.awt.*;
import java.io.Serial;
import javax.swing.*;

public class PnlThongKeKho extends JPanel{
    @Serial
    private static final long serialVersionUID = 1L;
    public PnlThongKeKho() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel lblTitle = SwingHelper.createProjectJLabel("Thống kê kho", 30);
        lblTitle.setAlignmentX(CENTER_ALIGNMENT);
        add(lblTitle);
    }
}
