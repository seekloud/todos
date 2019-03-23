## demo功能说明

* 添加事件
* 删除事件
* 获得事件列表

## 工程运行

运行本工程：

* 打开IDEA 下的terminal；
* 输入sbt回车；（如果报错，请确保你的电脑有正确安装sbt，第一次运行需要更新sbt和下载相关依赖，耐心等待）
   * X:\xxx\xxxx\xxx> sbt
* 此时你已经进入sbt交互式命令行状态：
     * sbt:todos2018> project backend
     * sbt:todos2018> reStart
* 工程默认运行在30330端口，浏览器输入http://localhost:30330/todos2018；
* 在浏览器上使用；
* 端口等数据写在配置文件里，配置文件目录：backend/src/main/resources/application.conf；

## 待完成功能tip

* 多用户用户登入流程

  用户的登录可以使用session，也可以使用localStorage。
  session可以认为是放在cookie里的一个参数Map，todos2018的session Map定义在backend\src\main\scala\com\neo\sk\todos2018\service\SessionBase.scala。
  可以参考backend\src\main\scala\com\neo\sk\todos2018\utils\SessionSupport.scala里的函数添加删除session。
  使用SessionBase.scala的userAuth函数检验session。
  
* 数据库存储

  配置文件里有postgresql数据库的相关配置。
  数据库操作可以使用slick。
  
  
  
## 参考链接
* [scala-js](http://www.scala-js.org/doc/tutorial/basic/)
* [akka-http](https://doc.akka.io/docs/akka-http/current/introduction.html)
* [monadic-html](https://github.com/OlivierBlanvillain/monadic-html/blob/master/README.md)
