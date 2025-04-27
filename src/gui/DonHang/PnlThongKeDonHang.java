package gui.DonHang;

import utils.SwingHelper;
import dao.ThongKe_Dao;
import entity.ThongKeSanPham;
import entity.ThongKeNhanVien;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.plot.CategoryPlot;
import java.awt.BorderLayout;
import java.io.Serial;

public class PnlThongKeDonHang extends JPanel implements ActionListener {
    @Serial
    private static final long serialVersionUID = 1L;

    private ThongKe_Dao thongKeDao;
    private JPanel pnlChartContainer;
    private JComboBox<String> cboThoiGian;
    private JPanel pnlProducts;
    private JPanel pnlEmployees;
    private JButton btnRefresh;

    public PnlThongKeDonHang() {
        thongKeDao = new ThongKe_Dao();
        setLayout(new BorderLayout());

        JPanel pnlNorth = new JPanel();
        pnlNorth.setLayout(new BoxLayout(pnlNorth, BoxLayout.Y_AXIS));

        JLabel lblTitle = SwingHelper.createProjectJLabel("Thống Kê Doanh Thu", 30);
        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlNorth.add(lblTitle);
        pnlNorth.add(Box.createVerticalStrut(15));

        JPanel pnlFilter = new JPanel();
        pnlFilter.setBorder(BorderFactory.createTitledBorder("Tùy chọn thống kê"));
        pnlFilter.add(SwingHelper.createProjectJLabel("Thời gian:"));

        cboThoiGian = new JComboBox<>(new String[]{"Tất cả", "Hôm nay", "Tuần này", "Tháng này", "Năm nay"});
        pnlFilter.add(cboThoiGian);

        btnRefresh = SwingHelper.createProjectJButton("Làm mới");
        btnRefresh.addActionListener(this);
        pnlFilter.add(btnRefresh);

        pnlNorth.add(pnlFilter);
        add(pnlNorth, BorderLayout.NORTH);


        pnlChartContainer = new JPanel(new GridLayout(1, 2, 10, 10));
        pnlChartContainer.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));


        pnlProducts = new JPanel(new BorderLayout());
        pnlProducts.setBorder(BorderFactory.createTitledBorder("Doanh Thu Theo Sản Phẩm"));

        pnlEmployees = new JPanel(new BorderLayout());
        pnlEmployees.setBorder(BorderFactory.createTitledBorder("Doanh Thu Theo Nhân Viên"));

        pnlChartContainer.add(pnlProducts);
        pnlChartContainer.add(pnlEmployees);

        add(pnlChartContainer, BorderLayout.CENTER);


        loadCharts();
    }

    private void loadCharts() {
        loadProductRevenueChart();
        loadEmployeeRevenueChart();
    }

    private void loadProductRevenueChart() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try {
            List<ThongKeSanPham> productRevenueList = thongKeDao.getProductRevenue(getSelectedTimeFilter());
            // Add data to dataset
            for (ThongKeSanPham item : productRevenueList) {
                dataset.addValue(item.getDoanhThu(), "Doanh Thu", item.getTenSanPham());
            }

            JFreeChart chart = ChartFactory.createBarChart(
                    "Top 10 Sản Phẩm Theo Doanh Thu",
                    "Sản Phẩm",
                    "Doanh Thu (VNĐ)",
                    dataset,
                    PlotOrientation.VERTICAL,
                    true,
                    true,
                    false
            );

            CategoryPlot plot = chart.getCategoryPlot();
            BarRenderer renderer = (BarRenderer) plot.getRenderer();
            renderer.setSeriesPaint(0, new Color(79, 129, 189));

            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(400, 300));


            pnlProducts.removeAll();
            pnlProducts.add(chartPanel, BorderLayout.CENTER);
            pnlProducts.revalidate();
            pnlProducts.repaint();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi tải dữ liệu thống kê sản phẩm", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadEmployeeRevenueChart() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try {
            List<ThongKeNhanVien> employeeRevenueList = thongKeDao.getEmployeeRevenue(getSelectedTimeFilter());
            // Add data to dataset
            for (ThongKeNhanVien item : employeeRevenueList) {
                dataset.addValue(item.getDoanhThu(), "Doanh Thu", item.getTenNhanVien());
            }

            JFreeChart chart = ChartFactory.createBarChart(
                    "Doanh Thu Theo Nhân Viên",
                    "Nhân Viên",
                    "Doanh Thu (VNĐ)",
                    dataset,
                    PlotOrientation.VERTICAL,
                    true,
                    true,
                    false
            );
            CategoryPlot plot = chart.getCategoryPlot();
            BarRenderer renderer = (BarRenderer) plot.getRenderer();
            renderer.setSeriesPaint(0, new Color(192, 80, 77));

            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(400, 300));

            pnlEmployees.removeAll();
            pnlEmployees.add(chartPanel, BorderLayout.CENTER);
            pnlEmployees.revalidate();
            pnlEmployees.repaint();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi tải dữ liệu thống kê nhân viên", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String getSelectedTimeFilter() {
        String selected = (String) cboThoiGian.getSelectedItem();
        switch (selected) {
            case "Hôm nay":
                return "today";
            case "Tuần này":
                return "week";
            case "Tháng này":
                return "month";
            case "Năm nay":
                return "year";
            default:
                return "all";
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRefresh) {
            loadCharts();
        }
    }
}