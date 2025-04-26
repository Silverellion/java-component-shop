package gui.DonHang;

import utils.SwingHelper;
import dao.ThongKeDao;
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

    private ThongKeDao thongKeDao;
    private JPanel pnlChartContainer;
    private JComboBox<String> cboThoiGian;
    private JPanel pnlProducts;
    private JPanel pnlEmployees;
    private JButton btnRefresh;

    public PnlThongKeDonHang() {
        // Initialize DAO
        thongKeDao = new ThongKeDao();

        // Set up panel
        setLayout(new BorderLayout());

        // North panel with title and filter options
        JPanel pnlNorth = new JPanel();
        pnlNorth.setLayout(new BoxLayout(pnlNorth, BoxLayout.Y_AXIS));

        // Title
        JLabel lblTitle = SwingHelper.createProjectJLabel("Thống Kê Doanh Thu", 30);
        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlNorth.add(lblTitle);
        pnlNorth.add(Box.createVerticalStrut(15));

        // Filter options
        JPanel pnlFilter = new JPanel();
        pnlFilter.setBorder(BorderFactory.createTitledBorder("Tùy chọn thống kê"));
        pnlFilter.add(SwingHelper.createProjectJLabel("Thời gian:"));

        cboThoiGian = new JComboBox<>(new String[]{"Tất cả", "Hôm nay", "Tuần này", "Tháng này", "Năm nay"});
        pnlFilter.add(cboThoiGian);

        btnRefresh = new JButton("Làm mới");
        btnRefresh.addActionListener(this);
        pnlFilter.add(btnRefresh);

        pnlNorth.add(pnlFilter);
        add(pnlNorth, BorderLayout.NORTH);

        // Chart container for center area
        pnlChartContainer = new JPanel(new GridLayout(1, 2, 10, 10));
        pnlChartContainer.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Init chart panels
        pnlProducts = new JPanel(new BorderLayout());
        pnlProducts.setBorder(BorderFactory.createTitledBorder("Doanh Thu Theo Sản Phẩm"));

        pnlEmployees = new JPanel(new BorderLayout());
        pnlEmployees.setBorder(BorderFactory.createTitledBorder("Doanh Thu Theo Nhân Viên"));

        pnlChartContainer.add(pnlProducts);
        pnlChartContainer.add(pnlEmployees);

        add(pnlChartContainer, BorderLayout.CENTER);

        // Initialize charts
        loadCharts();
    }

    private void loadCharts() {
        loadProductRevenueChart();
        loadEmployeeRevenueChart();
    }

    private void loadProductRevenueChart() {
        // Create dataset for product revenue
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        try {
            // Get product revenue data from DAO
            List<ThongKeSanPham> productRevenueList = thongKeDao.getProductRevenue(getSelectedTimeFilter());

            // Add data to dataset
            for (ThongKeSanPham item : productRevenueList) {
                dataset.addValue(item.getDoanhThu(), "Doanh Thu", item.getTenSanPham());
            }

            // Create chart
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

            // Customize the chart
            CategoryPlot plot = chart.getCategoryPlot();
            BarRenderer renderer = (BarRenderer) plot.getRenderer();
            renderer.setSeriesPaint(0, new Color(79, 129, 189));

            // Create panel
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(400, 300));

            // Update UI
            pnlProducts.removeAll();
            pnlProducts.add(chartPanel, BorderLayout.CENTER);
            pnlProducts.revalidate();
            pnlProducts.repaint();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi tải dữ liệu thống kê sản phẩm", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadEmployeeRevenueChart() {
        // Create dataset for employee revenue
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        try {
            // Get employee revenue data from DAO
            List<ThongKeNhanVien> employeeRevenueList = thongKeDao.getEmployeeRevenue(getSelectedTimeFilter());

            // Add data to dataset
            for (ThongKeNhanVien item : employeeRevenueList) {
                dataset.addValue(item.getDoanhThu(), "Doanh Thu", item.getTenNhanVien());
            }

            // Create chart
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

            // Customize the chart
            CategoryPlot plot = chart.getCategoryPlot();
            BarRenderer renderer = (BarRenderer) plot.getRenderer();
            renderer.setSeriesPaint(0, new Color(192, 80, 77));

            // Create panel
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(400, 300));

            // Update UI
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