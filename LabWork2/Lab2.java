package com.company;
import java.util.Scanner;
public class Lab2{
    //Данный метод принимает введённые пользователем координаты точек, затем создаёт 3 объекта типа Point3d
    public static void main(String[] args){
        Point3d dot1 = null;
        Point3d dot2 = null;
        Point3d dot3 = null;
        char axes[] = {'x', 'y', 'z'};
        int numbers[] = new int[3];
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите координаты (x, y, z) трёх точек:");
        for(int i = 1; i < 4; i++){
            for (int j = 0; j < 3; j++) {
                System.out.println(i + ":" + axes[j]);
                numbers[j] = sc.nextInt();
            }
            switch(i){
                case 1: dot1 = new Point3d(numbers[0],numbers[1],numbers[2]);
                    break;
                case 2: dot2 = new Point3d(numbers[0],numbers[1],numbers[2]);
                    break;
                case 3: dot3 = new Point3d(numbers[0],numbers[1],numbers[2]);
                    break;
            }
        }
        if (Point3d.compareValues(dot1, dot2) || Point3d.compareValues(dot2, dot3) || Point3d.compareValues(dot1, dot3)){
            System.out.println("Были введены одинаковые точки");
        }
        else
            System.out.println("Площадь треугольника = " + computeArea(dot1, dot2, dot3));
    }
    //Данный метод находит площадь треугольника через формулу Герона
    public static double computeArea(Point3d dot1, Point3d dot2, Point3d dot3){
        //Найдём длины сторон треугольника
        double a = dot1.distanceTo(dot2);
        double b = dot2.distanceTo(dot3);
        double c = dot3.distanceTo(dot1);
        //Найдём периметр треугольника
        double perimeter = (a + b + c) / 2;
        //Найдём площадь треугольника
        double area = Math.sqrt((per * (per - a) * (per - b) * (per - c)));
        return area;
    }
}
