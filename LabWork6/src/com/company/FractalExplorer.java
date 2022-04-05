package com.company;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import javax.imageio.ImageIO;

public class FractalExplorer {
    private final int displaySize; // Размер экрана
    private final JImageDisplay display;
    private FractalGenerator fractalGenerator;
    private final Rectangle2D.Double range; // Диапазон комплексной плоскости, которая выводится на экран
    private int rowsRemaining;
    JComboBox<String> comboBox = new JComboBox<>();
    Button buttonSave;
    Button buttonReset;
    boolean enabled = true;

    /*
    Конструктор, который принимает значение размера отображения в качестве аргумента,
    затем сохраняет это значение в соответствующем поле, а также инициализирует объекты
    диапазона и фрактального генератора
     */
    public FractalExplorer(int displaySize) {
        this.displaySize = displaySize;
        this.range = new Rectangle2D.Double();
        this.fractalGenerator = new Mandelbrot();
        this.display = new JImageDisplay(displaySize, displaySize);
    }

    /*
    Метод инициализирует графический интерфейс Swing и обрабатывает события его элементов
     */
    public void createAndShowGUI() {
        JFrame frame = new JFrame("Fractal Explorer");

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Fractal: ");
        comboBox = new JComboBox<>();
        comboBox.addItem("Mandelbrot");
        comboBox.addItem("Tricorn");
        comboBox.addItem("Burning Ship");
        panel.add(label);
        panel.add(comboBox);

        // Обработка событий ComboBox
        comboBox.addActionListener(e -> {
            String selectItem = (String) comboBox.getSelectedItem();
            switch (Objects.requireNonNull(selectItem)) {
                case "Tricorn" -> fractalGenerator = new Tricorn();
                case "Burning Ship" -> fractalGenerator = new BurningShip();
                default -> fractalGenerator = new Mandelbrot();
            }
            fractalGenerator.getInitialRange(range);
            drawFractal();

        });
        frame.getContentPane().add(panel, BorderLayout.NORTH);

        // Обработка событий Button "Reset"
        buttonReset = new Button("Reset");
        buttonReset.addActionListener(e -> {
            fractalGenerator.getInitialRange(range);
            drawFractal();
        });

        // Обработка событий Button "Save"
        buttonSave = new Button("Save");
        buttonSave.addActionListener(e -> {
            JFileChooser jFileChooser = new JFileChooser();
            FileFilter filter = new FileNameExtensionFilter("PNG Images", "png");
            jFileChooser.setFileFilter(filter);
            jFileChooser.setAcceptAllFileFilterUsed(false);
            if (jFileChooser.showSaveDialog(display) == JFileChooser.APPROVE_OPTION) {
                File file = jFileChooser.getSelectedFile();
                try {
                    ImageIO.write(display.image, "png", file);
                } catch (IOException exception) {
                    JOptionPane.showMessageDialog(display, exception.getMessage(), "Cannot Save Image", JOptionPane.ERROR_MESSAGE);
                } catch (NullPointerException exception) {
                    JOptionPane.showMessageDialog(display, "Save error", "Cannot Save Image", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        JPanel btnContainer = new JPanel();
        btnContainer.add(buttonReset);
        btnContainer.add(buttonSave);
        frame.getContentPane().add(btnContainer, BorderLayout.SOUTH);

        // Обработка событий мыши
        frame.addMouseListener(new MouseListener() {

            /**
             * Invoked when the mouse button has been clicked (pressed
             * and released) on a component.
             *
             * @param e the event to be processed
             */
            public void mouseClicked(MouseEvent e) {
                if (enabled) {
                    double xCoord = FractalGenerator.getCoord(range.x, range.x + range.width, displaySize, e.getX());
                    double yCoord = FractalGenerator.getCoord(range.y, range.y + range.height, displaySize, e.getY());
                    fractalGenerator.recenterAndZoomRange(range, xCoord, yCoord, 0.5);
                    drawFractal();
                }
            }

            /**
             * Invoked when a mouse button has been pressed on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mousePressed(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been released on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseReleased(MouseEvent e) {

            }

            /**
             * Invoked when the mouse enters a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseEntered(MouseEvent e) {

            }

            /**
             * Invoked when the mouse exits a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        frame.getContentPane().add(display, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    // Метод для вывода на экран фрактала
    private void drawFractal() {
        enableUI(false);
        rowsRemaining = displaySize;
        for (int y = 0; y < displaySize; y++) {
            FractalWorker fractal = new FractalWorker(y);
            fractal.execute();
        }
    }

    /*
    Метод включения или отключения кнопки с выпадающим списком в пользовательском интерфейсе на основе указанного
    параметра
     */
    private void enableUI(boolean val) {
        enabled = val;
        buttonReset.setEnabled(enabled);
        buttonSave.setEnabled(enabled);
        comboBox.setEnabled(enabled);
        display.setEnabled(enabled);
    }


    // Подкласс FractalWorker, предназначенный для вычисления значения цвета для одной строки фрактала
    private class FractalWorker extends SwingWorker<Object, Object> {

        private final int y;
        private int[] rgbColors;

        public FractalWorker(int y) {
            this.y = y;
        }

        // Метод для выполнения фоновых операций
        @Override
        protected Object doInBackground() {
            this.rgbColors = new int[displaySize];
            double xCoord, yCoord;
            for (int x = 0; x < displaySize; x++) {
                xCoord = FractalGenerator.getCoord(range.x, range.x + range.width, displaySize, x);
                yCoord = FractalGenerator.getCoord(range.y, range.y + range.height, displaySize, y);
                int iterations = fractalGenerator.numIterations(xCoord, yCoord);
                int rgbColor;
                if (iterations == -1) {
                    rgbColor = 0;
                } else {
                    float hue = 0.7f + (float) iterations / 200f;
                    rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
                }
                rgbColors[x] = rgbColor;
            }
            return null;
        }


        // Метод, вызываемый после завершения фоновой задачи
        @Override
        protected void done() {
            for (int x = 0; x < displaySize; x++) display.drawPixel(x, y, rgbColors[x]);
            display.repaint(0, 0, y, displaySize, 1);
            rowsRemaining--;
            if (rowsRemaining == 0) {
                enableUI(true);
            }
        }
    }

    public static void main(String[] args) {
        FractalExplorer fractalExplorer = new FractalExplorer(800);
        fractalExplorer.createAndShowGUI();
        fractalExplorer.fractalGenerator.getInitialRange(fractalExplorer.range);
        fractalExplorer.drawFractal();
    }

}

