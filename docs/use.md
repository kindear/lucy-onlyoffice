`lucy-onlyoffice`提供了`OfficeCtl`功能服务类，可以通过引入该类，实现介绍中的功能。



## 预览


 <html>
<head>
  <title>地址跳转</title>
<body>
  <button onclick="window.open('http://onlytest.apisev.cn/office/preview/remote?url=http://150.158.135.236:8888/down/bzQQMYQmVM46.pdf','_blank')">PC预览</button>
  <button onclick="window.open('http://onlytest.apisev.cn/office/preview/embedded/remote?url=http://150.158.135.236:8888/down/bzQQMYQmVM46.pdf','_blank')">嵌入式预览</button>
  <button onclick="window.open('http://onlytest.apisev.cn/office/preview/mobile/remote?url=http://150.158.135.236:8888/down/bzQQMYQmVM46.pdf','_blank')">移动端预览</button>
</body>
</html>


| 方法                                          | 参数                               | 备注                                            |
| --------------------------------------------- | ---------------------------------- | ----------------------------------------------- |
| previewRemoteFile(String remoteUrl)           | remoteUrl:文件访问地址             | PC端预览                                        |
| previewRemoteFileOnMobile(String remoteUrl)   | remoteUrl:文件访问地址             | 移动端预览                                      |
| previewRemoteFileOnEmbedded(String remoteUrl) | remoteUrl:文件访问地址             | 嵌入预览                                        |
| previewFile(String fileKey)                   | fileKey:文件唯一标识符             | 预览存储系统中文件，需要实现`OfficeStoreLoader` |
| previewFile(DocEditor editor)                 | DocEditor: 预览参数                | 预览文件，根据指定配置项                        |
| previewFile(DocEditor editor, String title)   | DocEditor: 预览参数 title:预览标题 | 预览文件，根据指定配置项，并指定标题            |





`OfficeCtl` 使用方法如下

```java
@Slf4j
@Controller
@RequestMapping("office")
@AllArgsConstructor
public class OnlyOfficeController {
    OfficeCtl officeCtl;

    @SneakyThrows
    @RequestMapping("preview/remote")
    @ApiOperation(value = "网络文档预览",notes = "支持各种类型文档")
    public ModelAndView previewRemote(@RequestParam("url") String url) {
        return officeCtl.previewRemoteFile(url);
    }

    @SneakyThrows
    @RequestMapping("preview/mobile/remote")
    @ApiOperation(value = "网络文档预览(移动端)",notes = "支持各种类型文档")
    public ModelAndView previewRemoteOnMobile(@RequestParam("url") String url) {
        return officeCtl.previewRemoteFileOnMobile(url);
    }

    @SneakyThrows
    @RequestMapping("preview/embedded/remote")
    @ApiOperation(value = "网络文档预览(嵌入)",notes = "支持各种类型文档")
    public ModelAndView previewRemoteOnEmbedded(@RequestParam("url") String url) {
        return officeCtl.previewRemoteFileOnEmbedded(url);
    }

}

```

## 编辑

 <html>
<head>
  <title>地址跳转</title>
<body>
  <button onclick="window.open('http://onlytest.apisev.cn/office/edit/remote?url=http://150.158.135.236:8888/down/sSvtjfBd4W4J.docx','_blank')">PC编辑</button>
</body>
</html>

| 方法                                    | 参数                   | 备注                                                         |
| --------------------------------------- | ---------------------- | ------------------------------------------------------------ |
| editRemoteFile(String remoteUrl)        | remoteUrl:文件访问地址 | PC端编辑                                                     |
| editFile(String fileKey)                | fileKey:文件唯一标识符 | 编辑存储系统中文件，需要实现`OfficeStoreLoader`              |
| editFile(Document document)             | Document:文件参数      | 编辑文件，初步定制化                                         |
| editFile(DocEditor editor)              | DocEditor: 编辑参数    | 编辑文件，根据指定配置项，高度定制化                         |
| editCallback(Map<String,Object> params) | params:回调参数        | 接收修改后信息，实现业务系统中文件修改或者新增，需要实现`OfficeStoreLoader` |

`OfficeCtl`实现文档编辑

```java
@Slf4j
@Controller
@RequestMapping("office")
@AllArgsConstructor
public class OnlyOfficeController {
    OfficeCtl officeCtl;

    @SneakyThrows
    @RequestMapping("edit/remote")
    @ApiOperation(value = "网络文档编辑",notes = "支持各种类型文档")
    public ModelAndView editRemote(@RequestParam("url") String url){
        return officeCtl.editRemoteFile(url);
    }
}

```

接收回调参数

```java
@Slf4j
@RestController
@RequestMapping("office")
@AllArgsConstructor
public class OfficeCallbackController {
    OfficeCtl officeCtl;

    @PostMapping("callback")
    public Object officeCallBack(@RequestBody Map<String,Object> params){
        return officeCtl.editCallback(params);
    }
}

```

## PDF转化

| 方法                           | 参数                   | 备注                  |
| ------------------------------ | ---------------------- | --------------------- |
| covertToPdf(String remoteUrl)  | remoteUrl:文件访问地址 | 转化为PDF             |
| covertToPdf(Document document) | Document:文件参数      | 转化为PDF，初步定制化 |



## 生成缩略图

| 方法                                 | 参数                   | 备注                   |
| ------------------------------------ | ---------------------- | ---------------------- |
| generateThumbnail(String remoteUrl)  | remoteUrl:文件访问地址 | 生成缩略图             |
| generateThumbnail(Document document) | Document:文件参数      | 生成缩略图，初步定制化 |



`OfficeCtl`实现上述功能

```java
@Slf4j
@RestController
@RequestMapping("office")
@Api(tags = "OnlyOffice相关服务")
@AllArgsConstructor
public class OnlyOfficeRestController {

    OfficeCtl officeCtl;

    @SneakyThrows
    @GetMapping("covert/pdf")
    @ApiOperation(value = "网络文档转pdf")
    public String covertPdf(@RequestParam("url") String url){
        return officeCtl.covertToPdf(url);
    }
    
    @SneakyThrows
    @GetMapping("covert/png")
    @ApiOperation(value = "网络文档生成png")
    public String covertPng(@RequestParam("url") String url){
        return officeCtl.generateThumbnail(url);
    }
}

```

