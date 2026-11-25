package guicomponents;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gcc
 */

public class MainMenu extends JFrame {

    public MainMenu() {
        setTitle("PF 102 – GUI Components");
        setSize(760, 560);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Custom Background Panel with Waves, Dividers, and Graphics
        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                int w = getWidth();
                int h = getHeight();

                // 1. Background Base Color
                g2.setColor(new Color(246, 248, 252));
                g2.fillRect(0, 0, w, h);

                // 2. Top-Left Blue Waves
                g2.setColor(new Color(195, 218, 248));
                Path2D topLightWave = new Path2D.Double();
                topLightWave.moveTo(0, 0);
                topLightWave.lineTo(w * 0.65, 0);
                topLightWave.quadTo(w * 0.30, h * 0.04, 0, h * 0.22);
                topLightWave.closePath();
                g2.fill(topLightWave);

                g2.setColor(new Color(102, 163, 232));
                Path2D topDarkWave = new Path2D.Double();
                topDarkWave.moveTo(0, 0);
                topDarkWave.lineTo(w * 0.45, 0);
                topDarkWave.quadTo(w * 0.18, h * 0.03, 0, h * 0.14);
                topDarkWave.closePath();
                g2.fill(topDarkWave);

                // 3. Bottom-Right Blue Waves
                g2.setColor(new Color(195, 218, 248));
                Path2D botLightWave = new Path2D.Double();
                botLightWave.moveTo(w, h);
                botLightWave.lineTo(w * 0.35, h);
                botLightWave.quadTo(w * 0.72, h * 0.96, w, h * 0.76);
                botLightWave.closePath();
                g2.fill(botLightWave);

                g2.setColor(new Color(102, 163, 232));
                Path2D botDarkWave = new Path2D.Double();
                botDarkWave.moveTo(w, h);
                botDarkWave.lineTo(w * 0.55, h);
                botDarkWave.quadTo(w * 0.82, h * 0.96, w, h * 0.84);
                botDarkWave.closePath();
                g2.fill(botDarkWave);

                // 4. Vertical and Horizontal Divider Lines
                g2.setColor(new Color(190, 198, 210));
                g2.setStroke(new BasicStroke(1.5f));
                g2.drawLine(215, 130, 215, 445); // Vertical divider
                g2.drawLine(45, 462, w - 45, 462); // Horizontal footer divider

                // 5. Left-Side Custom Vector Graphics (Java Cup + GUI Window Graphic)
                drawJavaGraphic(g2, 112, 155);
                drawGuiBadgeGraphic(g2, 112, 365);
            }
        };
        mainPanel.setLayout(null);
        setContentPane(mainPanel);

        // --- Header Section ---
        JLabel titleLabel = new JLabel("EVENT-DRIVEN PROGRAMMING", SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 27));
        titleLabel.setForeground(new Color(20, 26, 102));
        titleLabel.setBounds(175, 42, 540, 35);
        mainPanel.add(titleLabel);

        JLabel subTitleLabel = new JLabel("Java Swing Laboratory Activities", SwingConstants.CENTER);
        subTitleLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        subTitleLabel.setForeground(new Color(25, 25, 30));
        subTitleLabel.setBounds(175, 78, 540, 28);
        mainPanel.add(subTitleLabel);

        JLabel promptLabel = new JLabel("Select a laboratory activity to continue.", SwingConstants.CENTER);
        promptLabel.setFont(new Font("SansSerif", Font.ITALIC, 14));
        promptLabel.setForeground(new Color(45, 45, 50));
        promptLabel.setBounds(235, 135, 440, 25);
        mainPanel.add(promptLabel);

        // --- Left Pill Badge ("GUI Components") ---
        JLabel pillLabel = new JLabel("GUI Components", SwingConstants.CENTER) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(20, 26, 102));
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 26, 26);
                super.paintComponent(g);
            }
        };
        pillLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        pillLabel.setForeground(Color.WHITE);
        pillLabel.setBounds(24, 262, 176, 30);
        mainPanel.add(pillLabel);

        // --- Laboratory Buttons ---
        String[] labTitles = {
                "LAB 01 – JCheckBox",
                "LAB 02 – JRadioButton",
                "LAB 03 – JComboBox",
                "LAB 04 – JList",
                "LAB 05 – Multiple-Selection Lists"
        };

        int startY = 172;
        int gapY = 44;

        for (int i = 0; i < labTitles.length; i++) {
            final int index = i;
            LabButton btn = new LabButton(
                    labTitles[i],
                    new Color(216, 226, 243),
                    new Color(198, 213, 238),
                    new Color(148, 168, 204),
                    new Color(25, 28, 36),
                    new LabIcon(i)
            );
            btn.setBounds(265, startY + (i * gapY), 415, 34);
            btn.addActionListener(e -> JOptionPane.showMessageDialog(
                    this,
                    "Opening " + labTitles[index],
                    "Laboratory Activity",
                    JOptionPane.INFORMATION_MESSAGE
            ));
            mainPanel.add(btn);
        }

        // --- Exit Button ---
        LabButton exitBtn = new LabButton(
                "Exit Application",
                new Color(246, 218, 216),
                new Color(238, 198, 195),
                new Color(212, 148, 144),
                new Color(185, 28, 28),
                new LabIcon(5)
        );
        exitBtn.setBounds(265, startY + (5 * gapY) + 8, 415, 36);
        exitBtn.addActionListener(e -> System.exit(0));
        mainPanel.add(exitBtn);

        // --- Footer Section ---
        JLabel devLabel = new JLabel("Developed by: Dela Cruz, John A.", SwingConstants.CENTER);
        devLabel.setFont(new Font("SansSerif", Font.PLAIN, 13));
        devLabel.setForeground(new Color(30, 30, 35));
        devLabel.setBounds(200, 472, 360, 20);
        mainPanel.add(devLabel);

        JLabel blockLabel = new JLabel("BSIT 2 – Block A", SwingConstants.CENTER);
        blockLabel.setFont(new Font("SansSerif", Font.PLAIN, 13));
        blockLabel.setForeground(new Color(30, 30, 35));
        blockLabel.setBounds(200, 492, 360, 20);
        mainPanel.add(blockLabel);
    }

    // Draws the stylized Java coffee cup + "Java" text on the left panel
    private void drawJavaGraphic(Graphics2D g2, int centerX, int topY) {
        // Red Steam Waves
        g2.setColor(new Color(215, 40, 40));
        Path2D steam1 = new Path2D.Double();
        steam1.moveTo(centerX - 4, topY + 28);
        steam1.curveTo(centerX - 18, topY + 14, centerX + 10, topY + 6, centerX - 2, topY - 14);
        steam1.curveTo(centerX + 2, topY + 4, centerX - 10, topY + 14, centerX - 4, topY + 28);
        g2.fill(steam1);

        Path2D steam2 = new Path2D.Double();
        steam2.moveTo(centerX + 10, topY + 24);
        steam2.curveTo(centerX - 2, topY + 12, centerX + 20, topY + 4, centerX + 12, topY - 10);
        steam2.curveTo(centerX + 15, topY + 4, centerX + 4, topY + 12, centerX + 10, topY + 24);
        g2.fill(steam2);

        // Blue Cup Swirls & Saucer
        g2.setColor(new Color(45, 110, 175));
        g2.setStroke(new BasicStroke(3.2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2.drawArc(centerX - 24, topY + 28, 44, 12, 165, 215);
        g2.drawArc(centerX - 20, topY + 38, 36, 10, 165, 215);
        // Cup handle
        g2.drawArc(centerX + 16, topY + 27, 16, 16, -80, 180);
        // Saucer arcs
        g2.drawArc(centerX - 32, topY + 47, 62, 13, 160, 220);
        g2.drawArc(centerX - 24, topY + 54, 48, 10, 165, 210);

        // "Java" Text
        g2.setColor(new Color(215, 40, 40));
        g2.setFont(new Font("Serif", Font.PLAIN, 36));
        FontMetrics fm = g2.getFontMetrics();
        String text = "Java";
        g2.drawString(text, centerX - fm.stringWidth(text) / 2, topY + 95);
    }

    // Draws the circular browser/code badge below "GUI Components"
    private void drawGuiBadgeGraphic(Graphics2D g2, int centerX, int centerY) {
        // Soft light-blue circular backdrop
        g2.setColor(new Color(224, 234, 248));
        g2.fillOval(centerX - 58, centerY - 58, 116, 116);

        // Browser window outline
        int winX = centerX - 36;
        int winY = centerY - 30;
        int winW = 64;
        int winH = 52;
        g2.setColor(new Color(38, 86, 168));
        g2.setStroke(new BasicStroke(2.2f));
        g2.drawRoundRect(winX, winY, winW, winH, 8, 8);
        g2.drawLine(winX, winY + 13, winX + winW, winY + 13);

        // Window top dots
        g2.fillOval(winX + 6, winY + 5, 4, 4);
        g2.fillOval(winX + 13, winY + 5, 4, 4);
        g2.fillOval(winX + 20, winY + 5, 4, 4);

        // Cursor arrow inside browser
        Polygon cursor = new Polygon();
        cursor.addPoint(winX + 22, winY + 22);
        cursor.addPoint(winX + 22, winY + 40);
        cursor.addPoint(winX + 27, winY + 35);
        cursor.addPoint(winX + 34, winY + 35);
        g2.fillPolygon(cursor);

        // Blue "</>" badge at bottom right of window
        g2.setColor(new Color(74, 134, 218));
        g2.fillRoundRect(centerX + 4, centerY + 4, 38, 26, 6, 6);
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Monospaced", Font.BOLD, 13));
        g2.drawString("</>", centerX + 11, centerY + 22);
    }

    // Custom Rounded Button with Left Icon and Centered Label
    static class LabButton extends JButton {
        private final Color normalBg;
        private final Color hoverBg;
        private final Color borderColor;
        private final Icon customIcon;
        private boolean hovered = false;

        public LabButton(String text, Color normalBg, Color hoverBg, Color borderColor, Color fg, Icon icon) {
            super(text);
            this.normalBg = normalBg;
            this.hoverBg = hoverBg;
            this.borderColor = borderColor;
            this.customIcon = icon;

            setForeground(fg);
            setFont(new Font("SansSerif", Font.BOLD, 14));
            setFocusPainted(false);
            setBorderPainted(false);
            setContentAreaFilled(false);
            setCursor(new Cursor(Cursor.HAND_CURSOR));

            addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseEntered(java.awt.event.MouseEvent e) {
                    hovered = true;
                    repaint();
                }

                @Override
                public void mouseExited(java.awt.event.MouseEvent e) {
                    hovered = false;
                    repaint();
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Button fill & border
            g2.setColor(hovered ? hoverBg : normalBg);
            g2.fillRoundRect(1, 1, getWidth() - 2, getHeight() - 2, 8, 8);

            g2.setColor(borderColor);
            g2.setStroke(new BasicStroke(1.2f));
            g2.drawRoundRect(1, 1, getWidth() - 3, getHeight() - 3, 8, 8);

            // Draw Icon at fixed left offset
            if (customIcon != null) {
                int iconY = (getHeight() - customIcon.getIconHeight()) / 2;
                customIcon.paintIcon(this, g2, 42, iconY);
            }

            // Draw Centered Text
            g2.setFont(getFont());
            g2.setColor(getForeground());
            FontMetrics fm = g2.getFontMetrics();
            int textX = (getWidth() - fm.stringWidth(getText())) / 2 + 12;
            int textY = (getHeight() + fm.getAscent() - fm.getDescent()) / 2;
            g2.drawString(getText(), textX, textY);

            g2.dispose();
        }
    }

    // Custom Vector Icons for Each Button
    static class LabIcon implements Icon {
        private final int type;

        public LabIcon(int type) {
            this.type = type;
        }

        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setStroke(new BasicStroke(1.8f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            g2.setColor(type == 5 ? new Color(185, 28, 28) : new Color(36, 82, 165));

            switch (type) {
                case 0: // JCheckBox Icon
                    g2.drawRoundRect(x + 2, y + 2, 16, 16, 4, 4);
                    g2.drawPolyline(new int[]{x + 6, x + 9, x + 15}, new int[]{y + 10, y + 13, y + 7}, 3);
                    break;
                case 1: // JRadioButton Icon
                    g2.drawOval(x + 2, y + 2, 16, 16);
                    g2.fillOval(x + 6, y + 6, 8, 8);
                    break;
                case 2: // JComboBox Icon
                    g2.drawRoundRect(x + 1, y + 4, 18, 12, 3, 3);
                    g2.drawPolyline(new int[]{x + 12, x + 14, x + 16}, new int[]{y + 9, y + 11, y + 9}, 3);
                    break;
                case 3: // JList Icon
                    g2.drawRoundRect(x + 1, y + 3, 18, 14, 3, 3);
                    for (int row = 0; row < 3; row++) {
                        int ry = y + 7 + (row * 3);
                        g2.fillOval(x + 4, ry - 1, 2, 2);
                        g2.drawLine(x + 8, ry, x + 16, ry);
                    }
                    break;
                case 4: // Multiple-Selection Lists Icon
                    g2.drawRoundRect(x + 2, y + 1, 15, 18, 3, 3);
                    g2.drawPolyline(new int[]{x + 6, x + 8, x + 12}, new int[]{y + 6, y + 8, y + 5}, 3);
                    g2.drawPolyline(new int[]{x + 6, x + 8, x + 12}, new int[]{y + 13, y + 15, y + 12}, 3);
                    break;
                case 5: // Power / Exit Icon
                    g2.drawArc(x + 3, y + 3, 14, 14, 125, 290);
                    g2.drawLine(x + 10, y + 1, x + 10, y + 9);
                    break;
            }
            g2.dispose();
        }

        @Override
        public int getIconWidth() {
            return 20;
        }

        @Override
        public int getIconHeight() {
            return 20;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainMenu().setVisible(true);
        });
    }
}