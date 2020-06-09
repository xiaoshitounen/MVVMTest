package swu.xl.mvvmtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import android.os.Bundle;

public class VmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        //DataBindingUtil.setContentView()方法返回一个数据绑定对象，其命名规则由系统自动生成
        VmActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //View和Model绑定在一起
        NumViewModel numViewModel = new NumViewModel();
        binding.setNumVM(numViewModel);
    }
}