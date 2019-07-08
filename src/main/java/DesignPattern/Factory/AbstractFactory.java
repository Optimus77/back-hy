package DesignPattern.Factory;

import org.springframework.context.ApplicationContext;

public abstract class AbstractFactory {
    abstract Car createCar(String carBand) ;
    abstract SUV createSUV(String carBand) ;

    public interface Car {
        public void printCarsName();
    }
    public static class Benz implements Car {
        @Override
        public void printCarsName() {
            System.out.println("我是奔驰");
        }
    }
    public static class BMW implements Car {
        @Override
        public void printCarsName() {
            System.out.println("我是宝马");
        }
    }

    public interface SUV {
        public void printSUVsName();
    }
    public static class Jeep implements SUV {
        @Override
        public void printSUVsName() {
            System.out.println("我是吉普");
        }
    }
    public static class RangeRover implements SUV {
        @Override
        public void printSUVsName() {
            System.out.println("我是路虎");
        }
    }

    public static class DefaultFactory extends  AbstractFactory{
        @Override
        Car  createCar (String carBand) {
            if ("Benz".equals(carBand)) {
                return new BenzFactory().createCar();
            } else  {
                return new BMWFactory().createCar();
            }
        }
        @Override
        SUV createSUV(String carBand) {
            if ("Jeep".equals(carBand)) {
                return new JeepFactory().createSUV();
            } else {
                return new RangeRoverFactory().createSUV();
            }
        }
    }

    public static class BenzFactory {
       Car  createCar () {
            return new Benz();
       }
    }
    public static class BMWFactory {
        Car  createCar () {
            return new BMW();
        }
    }
    public static class JeepFactory {
        SUV  createSUV () {
            return new Jeep();
        }
    }
    public static class RangeRoverFactory {
        SUV  createSUV () {
            return new RangeRover();
        }
    }

    public static void main(String[] args) {
        new DefaultFactory().createCar("Benz").printCarsName();
        new DefaultFactory().createSUV("Jeep").printSUVsName();

    }

}
