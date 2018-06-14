# 1. 可靠性信息管理和分析系统

## 1. 服务端口配置

```shell
# 集群模式
gzepro-eureka-server			9001

gzepro-monitor-service			9101
gzepro-predict-service			9111
gzepro-evaluate-service			9121
gzepro-diagnose-service			9131
gzepro-decision-service  		9141
gzepro-manage-service			9151
gzepro-history-service			9161

gzepro-zuul-server				9201
gzepro-config-server			9211
gzepro-hystrix-dashboard		9221
gzepro-turbine-server			9222
```

## 2. 未完成

```shell
gzepro-zuul-server
gzepro-config-server
gzepro-turbine-server
```

## 3. 启动顺序

1. gzepro-eureka-server
2. 服务提供者（调用者）

## 4. 监控界面

- erreka
	- http://localhost:9001/
	
- hystrix-dashboard
	- http://127.0.0.1:9221/hystrix
	
## 5. 相关文档

### 5.1. 插件与设置
#### 5.1.1. eclipse中使用Lombok

##### 5.1.1.1. Lombok安装

1. 下载lombok.jar包 https://projectlombok.org/download.html

2. 运行Lombok.jar: 
     `java -jar E:\maven\repository\org\projectlombok\lombok\1.16.20\lombok-1.16.20.jar`lombok.jar所在路径

  数秒后将弹出一框，以确认eclipse的安装路径

3. 确认完eclipse的安装路径后，点击install/update按钮，即可安装完成

4. 安装完成之后，请确认eclipse安装路径下是否多了一个`lombok.jar`包，并且其

  配置文件eclipse.ini中是否 添加了如下内容: 

   `-javaagent:D:\Spring Tool Suite\spring-tool-suite-3.7.3.RELEASE\lombok.jar`

  如果上面的答案均为true，那么恭喜你已经安装成功，否则将缺少的部分添加到相应的位置即可

5. 重启eclipse或spring-tool-suite

##### 5.1.1.2.Lombok 基本用法

- entity

  ![](http://ww1.sinaimg.cn/large/005PjuVtgy1fqs7fgrptvj30fh0asmx7.jpg)

- log

```
@CommonsLog  
Creates private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(LogExample.class);  
@Log  
Creates private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(LogExample.class.getName());  
@Log4j  
Creates private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(LogExample.class);  
@Log4j2  
Creates private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(LogExample.class);  
@Slf4j  
Creates private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LogExample.class);  
@XSlf4j  
Creates private static final org.slf4j.ext.XLogger log = org.slf4j.ext.XLoggerFactory.getXLogger(LogExample.class);  
```
#### 5.1.2. 静态导入
![](http://ww1.sinaimg.cn/large/005PjuVtgy1fs9od0j5i9j30xe0immxi.jpg)

### 5.2. 代码生成

- 数据源
	- /gzepro-generator/src/main/resources/generator.xml
	
- 代码生成
	- /gzepro-generator/src/test/java/com/gzepro/plugin/ColgPluginTest.java
	
- 修改生成的实体

```java
// 删除get/set方法
// 创建时间，修改时间，由数据库维护，修改注解
@Column(name = "create_time", insertable = false, updatable = false)
@Column(name = "update_time", insertable = false, updatable = false)
```

- 构造方法

```java
// 如果需要自定义构造方法，需要在类上添加注解，用于生成无参构造
@NoArgsConstructor
```

### 5.1 业务层

- 推荐使用静态导入的方法导入ValidUtil与CheckUtil工具类，校验数据
- 增删改操作必须打印日志
- 条件分支必须打印条件之，重要参数必须打印
- 数据量大的时候需要打印数据量
- 不要依赖debug，多依赖日志。
- ResultVo是Controller专用的，不要往后传递。

### 5.2 持久层

- 通用mapper的使用
  - 插入： 使用insertSelective，不允许使用insert()
  - 修改： 使用updateByPrimaryKeySelective，不允许使用updateByPrimaryKey()

### 5.3 maven使用

- 引入依赖时，判断该依赖范围，以及是否需要传递给子项目，如果不需要，必须禁止传递依赖，防止依赖冲突