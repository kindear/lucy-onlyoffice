## 安装

### 1. 拉取镜像

```dockerfile
docker pull onlyoffice/documentserver
```

### 2. 查看镜像

```dockerfile
docker images
```

### 3. 启动容器

命令行 `docker run -i -t -d -p 9004:80 --restart=always onlyoffice/documentserver`

- `-p 80:80` 表示端口映射，前者是宿主机端口，后者是容器内的映射端口。
- `--restart=always` 容器自动重启
- `onlyoffice/documentserver` 镜像名称 

### 4. 访问验证

```
http://ip:port/welcome
```

展示出`welcome`页面代表部署成功



## 反向代理

可以使用`nginx`反向代理，使得域名解析映射到对应服务端口上

> 推荐使用 宝塔面板

