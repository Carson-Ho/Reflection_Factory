package scut.carson_ho.reflection_factory;

/**
 * Created by Carson_Ho on 17/7/28.
 */

public class Factory {

    // 定义方法：通过反射动态创建产品类实例
    public static Product getInstance(String ClassName) {

        Product concreteProduct = null;

        try {

            // 1. 根据 传入的产品类名 获取 产品类类型的Class对象
            Class product_Class = Class.forName(ClassName);

            // 2. 通过Class对象动态创建该产品类的实例
            concreteProduct = (Product) product_Class.newInstance();

        } catch (Exception e) {
            e.printStackTrace();
        }

        // 3. 返回该产品类实例
        return concreteProduct;
    }

}
