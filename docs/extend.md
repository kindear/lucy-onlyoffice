## 基础配置

!> 暂无说明



## 鉴权服务

> 可选

如果需要记录对文件进行编辑修改操作人员信息，对用户编辑权限等进行限制，使用`事件`相关功能，需要拓展实现`OfficeAuthLoader`

```java
public interface OfficeAuthLoader {
    /**
     * 获取当前登录用户ID
     * @return
     */
    default String getUserId(){
        return "0";
    }

    /**
     * 获取当前登录用户名称
     * @return
     */
    default String getUserName(){
        return "guest";
    }
}

```



## 存储服务

> 可选

如果不需要使用编辑功能，则可以不实现该接口`OfficeStoreLoader`

```java
public interface OfficeStoreLoader {
    /**
     * 根据文件 key 获取文件信息
     * @param fileKey
     * @return
     */
    Document readFile(String fileKey);

    /**
     * 修改文件
     * @param fileKey
     * @param stream
     * @return
     */
    boolean writeFile(String fileKey, InputStream stream);

}

```

