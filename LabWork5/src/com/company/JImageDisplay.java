package com.company;

import java.awt.*;
import java.awt.image.*;

// Класс JImageDisplay представляет собой графический виджет для отображения фракталов
public class JImageDisplay extends javax.swing.JComponent{

    public BufferedImage image;

    // Инициализация нового изображения
    JImageDisplay(int width, int height){
        image = new BufferedImage(width, height, image.TYPE_INT_RGB);
        setPreferredSize(new Dimension(width, height));
    }

    // Отрисовка изображения в компоненте
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0,0, image.getWidth(), image.getHeight(), null);
    }

    // Запись данных в изображение
    public void clearImage(){
        for (int i = 0; i < image.getWidth(); i++){
            for (int j = 0; j < image.getHeight(); j++){
                image.setRGB(i,j,new Color(0, 0, 0).getRGB());
            }
        }
    }

    public void drawPixel(int x, int y, int rgbColor){
        image.setRGB(x, y, rgbColor);
    }
}

