import java.text.DecimalFormat;
import java.util.Locale;
public class TableSines {
    public static void main(String[] args) {
        DecimalFormat sineDeci = new DecimalFormat("0.000000");

        float angle = -90;

        System.out.println("Angle\t\tSine");
        System.out.println("-----\t\t--------");
        System.out.printf("%5.1f\t\t%s\n", angle, (Math.sin(Math.toRadians(angle))));
        System.out.printf("%5.1f\t\t%s\n", (angle += 15), sineDeci.format((Math.sin(Math.toRadians(angle)))));
        System.out.printf("%5.1f\t\t%s\n", (angle += 15), sineDeci.format((Math.sin(Math.toRadians(angle)))));
        System.out.printf("%5.1f\t\t%s\n", (angle += 15), sineDeci.format((Math.sin(Math.toRadians(angle)))));
        System.out.printf("%5.1f\t\t%4s\n", (angle += 15), Float.parseFloat(sineDeci.format((Math.sin(Math.toRadians(angle))))));
        System.out.printf("%5.1f\t\t%s\n", (angle += 15), sineDeci.format((Math.sin(Math.toRadians(angle)))));
        System.out.printf("%5.1f\t\t%4s\n", (angle += 15), (Math.sin(Math.toRadians(angle))));
        System.out.printf("%5.1f\t\t%9s\n", (angle += 15), sineDeci.format((Math.sin(Math.toRadians(angle)))));
        System.out.printf("%5.1f\t\t%4s\n", (angle += 15), Float.parseFloat(sineDeci.format((Math.sin(Math.toRadians(angle))))));
        System.out.printf("%5.1f\t\t%9s\n", (angle += 15), Float.parseFloat(sineDeci.format((Math.sin(Math.toRadians(angle))))));
        System.out.printf("%5.1f\t\t%9s\n", (angle += 15), sineDeci.format((Math.sin(Math.toRadians(angle)))));
        System.out.printf("%5.1f\t\t%9s\n", (angle += 15), sineDeci.format((Math.sin(Math.toRadians(angle)))));
        System.out.printf("%5.1f\t\t%4s\n", (angle += 15), (Math.sin(Math.toRadians(angle))));
    }
}