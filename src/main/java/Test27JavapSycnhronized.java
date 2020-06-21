public class Test27JavapSycnhronized {

        String hy;

        synchronized void hy () {}
        static synchronized void hy5 () {}

        void hy2 () {
            synchronized(hy) {

            }
        }

        void doSomething(){}

        void hy3 () {
            synchronized(this) {

            }
        }

        void hy4 () {
            synchronized(Test27JavapSycnhronized.class) {

            }
        }

        void hy6 (Hy h) {
            synchronized (h) {
                doSomething();

            }

        }








        public static void main(String[] args) {



        }


}
