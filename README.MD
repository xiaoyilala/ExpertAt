# kotlin 学习
GoodExecutor

# ExpertAt AOP 注解库 公用库 

## 引入

###  项目根目录 build.gradle


```
buildscript{
    ...
    dependencies{
        ...
        classpath 'com.hujiang.aspectjx:gradle-android-plugin-aspectjx:2.0.10'
    }
}

```

###  模块build.gradle 

```
apply plugin: 'android-aspectjx'

```

```
aspectjx {
    include 'com.ice'
    exclude 'androidx','kotlin','com.google','com.squareup','com.alipay','org.apache'
    //关闭AspectJX功能
    enabled false
}
```











