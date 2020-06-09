package swu.xl.mvvmtest;

import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class NumViewModel extends BaseObservable {
    private String num;

    private NumModel numModel;

    public NumViewModel() {
        numModel = new NumModel();
    }

    //该注解用于双向绑定，需要与 notifyPropertyChanged()方法结合使用
    //该注解用于标记实体类中的get方法或“is”开头的方法,且实体类必须继承BaseObservable
    //使用@Bindable注解标记的get方法，在编译时，会在BR类中生成对应的字段，然后与notifyPropertyChanged()方法配合使用，当该字段中的数据被修改时，dataBinding会自动刷新对应view的数据
    @Bindable
    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;

        //更新UI
        notifyPropertyChanged(BR.num);
    }

    public void onClickAdd(View view){
        //点击事件处理，直接交给Model层
        numModel.add(new NumModel.ModelCallback() {
            @Override
            public void onSuccess(int num) {
                setNum(num+"");
            }

            @Override
            public void onFailed(int num) {
                setNum("");
            }
        });
    }
}
