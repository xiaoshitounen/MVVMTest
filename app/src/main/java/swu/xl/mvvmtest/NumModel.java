package swu.xl.mvvmtest;

public class NumModel {
    private int num = 0;

    public void add(ModelCallback callback){
        callback.onSuccess(++num);
    }

    /**
     * 数据回调接口
     */
    public interface ModelCallback {
        void onSuccess(int num);
        void onFailed(int num);
    }
}
