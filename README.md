# cloudhttp

基于nio实现的http服务器

当前仅支持 /static/** 路径访问静态资源

ps 如 http://localhost:8080/static/home.html
会访问配置文件中配置的静态目录中的 `home.html`文件

配置文件 `server.properties`

* port 配置http服务器监听端口
* static.resource.path 配置静态资源目录
