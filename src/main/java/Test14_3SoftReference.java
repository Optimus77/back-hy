import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class Test14_3SoftReference {

    public static void main(String[] args) {
        WeakReference<Hy> weakRef = new WeakReference(new Hy());
        System.out.println("GC前："+weakRef.get());
        System.gc();
        System.out.println("GC后："+weakRef.get());

        //定义一个软引用列表
        List<SoftReference<Integer>> softList = new ArrayList<>();

        //软引用列表添加5000个软引用
        for(int i=0;i<5000;i++){
            softList.add(new SoftReference<Integer>(128));
        }
        System.gc();
        //存活的引用数
        int activeRefNum = 0;
        for(SoftReference softRef:softList){
            if(softRef.get()!=null){
                activeRefNum++;
            }
        }
        System.gc();
        System.out.println("当前存活的引用数："+activeRefNum);

        List list = new ArrayList();
        for(int i=0;i<160050;i++){
            list.add(i);
        }

        System.gc();
        int activeRefNum2 = 0;
        for(SoftReference softRef:softList){
            if(softRef.get()!=null){
                activeRefNum2++;
            }
        }
        System.gc();
        System.out.println("当前存活的引用数："+activeRefNum2);
    }
}
