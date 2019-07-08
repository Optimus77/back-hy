package DesignPattern.Factory;

public class StaticFactory {

    public interface Car {
         public String printCarsName();
    }

    public static class Benz implements  Car {
        @Override
        public String printCarsName() {
            return "我是奔驰";
        }
    }

    public static class BMW implements  Car {
        @Override
        public String printCarsName() {
            return "我是宝马";
        }
    }

    public static class SimpleCarsFactory {
        public static Car createCars(int type) {
            switch (type) {
                case 1:
                    return new Benz();
                default:
                    return new BMW();
            }
        }
    }

    public static void main(String[] args) {
        SimpleCarsFactory.createCars(1).printCarsName();
        SimpleCarsFactory.createCars(2).printCarsName();
    }

}
