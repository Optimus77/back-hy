package DesignPattern.Factory;

public class Factory {

    public interface Car {
        public String printCarsName();
    }

    public static class Benz implements Car {
        @Override
        public String printCarsName() {
            return "我是奔驰";
        }
    }

    public static class BMW implements Car {
        @Override
        public String printCarsName() {
            return "我是宝马";
        }
    }

    public interface factory {
        public Car createCar ();
    }

    public static class BenzFactory implements factory {

        @Override
        public Car createCar() {
                return new Benz();
        }
    }

    public static class BMWFactory implements factory {
        @Override
        public Car createCar() {
            return new BMW();
        }
    }

    public static void main(String[] args) {
        new BenzFactory().createCar().printCarsName();
        new BMWFactory().createCar().printCarsName();
    }

}
