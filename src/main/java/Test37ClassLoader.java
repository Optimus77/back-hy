public class Test37ClassLoader extends ClassLoader {
    //指定路径
    private String path ;


    public Test37ClassLoader(String classPath){
        path=classPath;
    }


    /**
     * 重写findClass方法
     * @param name 是我们这个类的全路径
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class log = null;
        // 获取该class文件字节码数组
        byte[] classData = getData();

        if (classData != null) {
            // 将class的字节码数组转换成Class类的实例
            log = defineClass(name, classData, 0, classData.length);
        }

        Class.class.getClassLoader().loadClass("a");

        this.getClass().getClassLoader().loadClass("a");
        Class.forName("com.mysql.jdbc.Driver");

        return log;
    }

    private byte[] getData() {
        byte[] b = null;
        return b;

//        File file = new File(path);
//        if (file.exists()){
//            FileInputStream in = null;
//            ByteArrayOutputStream out = null;
//            try {
//                in = new FileInputStream(file);
//                out = new ByteArrayOutputStream();
//
//                byte[] buffer = new byte[1024];
//                int size = 0;
//                while ((size = in.read(buffer)) != -1) {
//                    out.write(buffer, 0, size);
//                }
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                try {
//                    in.close();
//                } catch (IOException e) {
//
//                    e.printStackTrace();
//                }
//            }
//            return out.toByteArray();
//        }else{
//            return null;
//        }
//
//
    }
}
