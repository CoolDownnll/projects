# 一本糊涂账
------
基于各种JavaSe知识的图形桌面小应用


# 目录
- [功能](#功能)
- [代码目录结构](#代码目录结构)
- [项目开发流程](#项目开发流程)
- [软件设计思想](#软件设计思想)

## 功能
- 消费一览：
- ![image](https://github.com/CoolDownnll/projects/blob/master/ImgsFolderForReadMe/1.BootStrap.PNG)
- 记一笔
- ![image](https://github.com/CoolDownnll/projects/blob/master/ImgsFolderForReadMe/2.jiyibi.PNG)
- 消费分类
- ![image](https://github.com/CoolDownnll/projects/blob/master/ImgsFolderForReadMe/3.xffl.PNG)
- 月消费报表
- ![image](https://github.com/CoolDownnll/projects/blob/master/ImgsFolderForReadMe/4.yxfbb.PNG)
- 设置
- ![image](https://github.com/CoolDownnll/projects/blob/master/ImgsFolderForReadMe/5.set.PNG)
- 备份
- ![image](https://github.com/CoolDownnll/projects/blob/master/ImgsFolderForReadMe/6.backup.PNG)
- 恢复
- ![image](https://github.com/CoolDownnll/projects/blob/master/ImgsFolderForReadMe/7.recover.PNG)

## 代码目录结构
- ![image](https://github.com/CoolDownnll/projects/blob/master/ImgsFolderForReadMe/codeStructure.PNG)

## 项目开发流程
- 表结构设计：
分析应用功能可知，消费一览来自于记一笔以及设置里的预算，记一笔中的分类来自于消费分类，月消费报表来自于记一笔，备份和恢复来自于设置里的Mysql安装目录。所以综合起来本应用设计三张表，分别为：消费记录表Record、设置表Config、消费分类表Category。详情见hutubill\sql\hutubill.sql
- 原型设计：
原型设计包含以下亮点：
  从最初简陋的JFrame开始逐步演化和重构出各种面板类的设计，并且为了方便监听器获取组件，在该应用中将面板类设置为单例的；在原型开发过程中还抽取出了大量工具类
- 实体类与DAO的设计
- 功能开发：
程序启动入口为hutubill\src\startup\Bootstrap.java；由于模块间具有相互依赖，所以按照如下开发顺序进行开发：1、主窗体工具栏事件响应；2、设置；3、消费分类；4、记一笔；5、消费一览；6、月消费报表；7、备份；8、恢复
## 软件设计思想
- 单例模式
- 面板类与监听器类松耦合
- Entity层、DAO层、Service层设计

