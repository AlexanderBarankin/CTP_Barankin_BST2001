/ **
        * трёхмерный класс точки.
        **/
public class Point3d {
/ ** координата X **/
    private double xCoord;
/ ** координата Y **/
    private double yCoord;
/ ** координата Z **/
    private double zCoord;
/ ** Конструктор инициализации **/
    public Point3d ( double x, double y, double z) {
        xCoord = x;
        yCoord = y;
        zCoord = z;
    }
/ ** Конструктор по умолчанию. **/
    public Point3d () {
//Вызовите конструктор с тремя параметрами и определите источник.
        this(0.0, 0.0, 0.0);
    }
/ ** Возвращение координаты X **/
    public double getX () {
        return xCoord;
    }
/ ** Возвращение координаты Y **/
    public double getY () {
        return yCoord;
    }
/ ** Возвращение координаты Z **/
    public double getZ () {
        return zCoord;
    }
/ ** Установка значения координаты X. **/
    public void setX ( double val) {
        xCoord = val;
    }
/ ** Установка значения координаты Y. **/
    public void setY ( double val) {
        yCoord = val;
    }
}
/ ** Установка значения координаты Z. **/
public void setZ ( double val) {
        zCoord = val;
        }
        / ** Метод для сравнения значений двух объектов класса Point3d **/
public boolean compareValues(Point3d dot1, Point3d dot2){
        //Возвращяем значения координат первой точки
        double x1 = dot1.getX();
        double y1 = dot1.getY();
        double z1 = dot1.getZ();
        //Возвращаем значения координат второй точки
        double x2 = dot2.getX();
        double y2 = dot2.getY();
        double z2 = dot2.getZ();
        //Сравниваем значения двух точек
        if ((x1 == x2) && (y1 == y2) && (z1 == z2))
        return true;
        else
        return false;
        }
        / ** Метод для нахождения расстояния между двумя точками **/
public double distanceTo(Point3d dot1, Point3d dot2){
        //Возвращяем значения координат первой точки
        double x1 = dot1.getX();
        double y1 = dot1.getY();
        double z1 = dot1.getZ();
        //Возвращаем значения координат второй точки
        double x2 = dot2.getX();
        double y2 = dot2.getY();
        double z2 = dot2.getZ();
        //Находим расстояние между двумя точками
        double distance = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2) + Math.pow((z2 - z1), 2));
        return distance;
        }
        }