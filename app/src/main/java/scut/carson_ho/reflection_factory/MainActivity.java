package scut.carson_ho.reflection_factory;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.io.IOException;
import java.util.Properties;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 优化方案：采用属性配置文件

        // 1. 读取属性配置文件
        Properties pro = new Properties() ;

        try {

            pro.load(this.getAssets().open("Product.properties"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2. 获取属性配置文件中的产品类名
        String Classname = pro.getProperty("ProductA");

        // 3. 动态生成产品类实例
        Product concreteProduct = Factory.getInstance(Classname);

        // 4. 调用该产品类对象的方法，从而生产产品
        concreteProduct.show();



        // 方案1

//        // 1. 通过调用工厂类的静态方法（反射原理），从而动态创建产品类实例
//        // 需传入完整的类名 & 包名
//        Product concreteProduct = Factory.getInstance("scut.carson_ho.reflection_factory.ProductA");
//
//        // 2. 调用该产品类对象的方法，从而生产产品
//        concreteProduct.show();





    }
}
