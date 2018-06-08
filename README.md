## 功能说明

用户(配置文件写死)
* 登录
* 登出
* 添加事件
* 删除事件
* 获得事件列表

## 工程运行

运行本工程：

* 打开IDEA 下的terminal；
* 输入sbt回车；（如果报错，请确保你的电脑有正确安装sbt，第一次运行需要更新sbt和下载相关依赖，耐心等待）
   * X:\xxx\xxxx\xxx> sbt
* 此时你已经进入sbt交互式命令行状态：
     * sbt:hellomhtml> project backend
     * sbt:hellomhtml> reStart
* 工程运行在30330端口，浏览器输入http://localhost:30330/todos2018；
* 登录，使用；
* 用户信息在配置文件中(用户名：test;密码：test)，配置文件目录：backend/src/main/resources/application.conf；