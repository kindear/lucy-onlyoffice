

## 介绍

`lucy-onlyoffice`是依赖于`onlyoffice`的`springboot`集成解决方案，该解决方案简化了`onlyoffice`的使用难度，支持对常见文档类型的预览，编辑和转化。该解决方案提供了功能的拓展实现，用户可以基于拓展接口，实现业务系统和该解决方案的集成。

- [x] 支持 doc、docx、xlsx、pptx 等常见 `office`格式文件的预览和编辑 ，完整支持列表如下:
  - **word** - 文本文档 （*.djvu、.doc、.docm、.docx、.docxf、.dot、.dotm、.dotx、.epub、.fb2、.fodt、.htm、.html、.mht、.mhtml、.odt、.oform、.ott、.oxps、.pdf、.rtf、.stw、.sxw、.txt、.wps、.wpt、.xml、.xps*），
  - **cell** - 电子表格 (*.csv、.et、.ett、.fods、.ods、.ots、.sxc、.xls、.xlsb、.xlsm、.xlsx、.xlt、.xltm、.xltx、.xml*），
  - **slide** - 演示文稿 （*.dps、.dpt、.fodp、.odp、.otp、.pot、.potm、.potx、.pps、.ppsm、.ppsx、.ppt、.pptm、.pptx、.sxi*）。
- [x] 支持 文件转化为 `pdf`
- [x] 支持 生成文件缩略图



## 安装

使用该功能之前，需要完成[【OnlyOffice安装】](https://lucy.apisev.cn/#/lucy-onlyoffice/onlyoffice)

`lucy-onlyoffice`支持`jar`引入集成和独立部署安装(下载源码自行打包部署)

### 1. 配置仓库源

在`pom.xml`中配置`jitpack`

```xml
<repositories>
        <repository>
            <id>jitpack.io</id>
            <url>https://www.jitpack.io</url>
        </repository>
</repositories>复制到剪贴板错误复制成功
```

### 2. 引入依赖

根据[更新日志](https://lucy.apisev.cn/#/lucy-onlyoffice/changelog)决定版本号引入依赖

`version`与更新日志对应

```xml
        <dependency>
            <groupId>com.gitee.lboot</groupId>
            <artifactId>lucy-onlyoffice</artifactId>
            <version>${version}</version>
        </dependency>复制到剪贴板错误复制成功
```

### 3. 修改配置文件

需要在`application.properties`配置`onlyoffice`服务地址 & 服务的部署地址

| 参数     | 介绍                                |      |
| :------- | :---------------------------------- | :--- |
| 服务地址 | `onlyoffice`部署的地址              |      |
| 回调地址 | 业务系统部署地址 + 接收编辑回调路由 |      |

> 测试接口配置可选，配置该值为 `true` 开启默认接口，可以直接使用，参考[快速上手](https://lucy.apisev.cn/#/lucy-onlyoffice/use)

```properties
# 服务地址 -> 将 http://office.example.cn 替换为 onlyoffice部署地址
onlyoffice.document.host=http://office.example.cn

# 回调地址 -> 将 http://onlytest.example.cn 替换为 业务系统部署地址
onlyoffice.document.callback.host=http://onlytest.example.cn/office/callback

# 测试接口
onlyoffice.api.enable=true
```



## 快速上手

`lucy-onlyoffice`提供了`OfficeCtl`功能服务类，可以通过引入该类，实现介绍中的功能。

## [预览](https://lucy.apisev.cn/#/lucy-onlyoffice/use?id=预览)

> 测试文档地址 : `http://150.158.135.236:8888/down/bzQQMYQmVM46.pdf`

<iframe width="100%" height="100px" src="https://lucy.apisev.cn/lucy-onlyoffice/input.html" frameborder="0" allowfullscreen="" style="box-sizing: inherit; font-size: 16px; -webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-size-adjust: none; margin: 1em 0px; color: rgb(77, 77, 77); font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400; letter-spacing: normal; orphans: 2; text-align: start; text-indent: 0px; text-transform: none; widows: 2; word-spacing: 0px; -webkit-text-stroke-width: 0px; white-space: normal; background-color: rgb(255, 255, 255); text-decoration-thickness: initial; text-decoration-style: initial; text-decoration-color: initial;"></iframe>

