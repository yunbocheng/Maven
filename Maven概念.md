# Maven

[TOC]

## 1.Maven介绍

- Maven是一个项目构建工具（这就是个构建项目的辅助，不使用也可以）
- 软件是一个工程(软件工程) ：为了能够实现软件的流水线生产，在设计模式和构建软件时能够有一种规范和工程化的方法，人们便提出软件工程概念。

## 2. 完成一个Java项目，需要做哪些工作

- 1.分析项目要做什么，知道项目有哪些组成部分。

- 2.设计项目，通过哪些步骤，使用哪些技术。需要多少人， 多长的时间。

- 3.组建团队，招人， 购置设备，服务器， 软件， 笔记本。

- 4.开发人员写代码。 开发人员需要测试自己写代码。 重复多次的工作。

- 5.测试人员，测试项目功能是否符合要求。
  测试开发人员提交代码-如果测试有问题–需要开发人员修改–在提交代码给测试
  测试人员在测试代码-如果还有问题-在交给开发人员-开发人员在提交-在测试
  直到-测试代码通过。

## 3.传统开发项目的问题，没有使用Maven管理的项目

1）很多模块，模块之间有关系， 手工管理关系，比较繁琐。
2）需要很多第三方功能， 需要很多jar文件，需要手工从网络中获取各个jar
3）需要管理jar的版本， 你需要的是mysql.5.1.5.jar 拿你不能给给一个mysql.4.0.jar
4）管理jar文件之间的依赖， 你的项目要使用a.jar 需要使用b.jar里面的类。
      必须首先获取到b.jar才可以， 然后才能使用a.jar.

```java
a.jar需要b.jar这个关系叫做依赖，或者你的项目中要使用mysql的驱动，也可以叫做项目依赖mysql驱动。 a.class使用b.class,a依赖b类
```

## 4.Maven作用（改进项目的开发和管理）

1）maven可以管理jar文件
2）自动下载jar和他的文档，源代码
3）管理jar直接的依赖， a.jar需要b.jar ， maven会自动下载b.jar
4）管理你需要的jar版本
5）帮你编译程序，把java编译为class
6）帮你测试你的代码是否正确。
7）帮你打包文件，形成jar文件，或者war文件
8）帮你部署项目

## 5.项目的构建

- 在以上操作中，测试、编译、打包、部署都是属于构建的过程。

- 构建是面向过程的，就是一些步骤，完成项目代码的<mark>编译</mark>，<mark>测试</mark>，<mark>运行</mark>，<mark>打包</mark>，<mark>部署</mark>等等。

## 5.1 maven支持的构建包括

- <mark>清理</mark> :  把之前项目编译的东西删除掉，我新的编译代码做准备。

- <mark>编译</mark> :  把程序源代码编译为执行代码， java-class文件
  			这个编译是批量的，maven可以同时把成千上百的文件编译为class。（可以一次将项目

  ​			中的所有java文件编译为class）

  ​	       **这个编译和javac 不一样，javac一次编译一个文件。**

- <mark>测试</mark>  : maven可以执行测试程序代码，验证你的功能是否正确。

  ​			这个测试也是批量的，maven同时执行多个测试代码，同时测试很多功能(方法)。

  ​			如果不使用Maven，一次只能测试一个功能(方法)。

- <mark>报告</mark> :  生成测试结果的文件， 测试有没有通过。

- <mark>打包</mark> : （测试成功后叫打包） 把你的项目中所有的class文件，配置文件等所有资源放到一个压

  ​			缩文件中。这个压缩文件就是项目的结果文件， 通常的<mark>java程序</mark>，压缩文件扩展名是<mark>.jar</mark>			扩展的。对于<mark>web应用</mark>，这个压缩文件扩展名是<mark>.war</mark>

- <mark>安装</mark> :  把打包中生成的文件jar，war安装到本机仓库
- <mark>部署</mark> :  把程序安装好可以执行。

**前六步使用Maven进行实现，最后一步部署由开发人员自己完成，使用Maven会复杂.**

## 6.Maven核心概念

- Maven能够实现自动化构建和他的内部原理分不开，这里我们从Maven的九个核心概念入手，

  看看Maven是如何实现自动化构建的。

### 6.1 Maven的九个核心概念

1. POM ：  <mark>一个文件</mark> 名称是pom.xml , pom翻译过来叫做<mark>项目对象模型。</mark>
   				maven把一个项目当做一个模型使用。控制maven构建项目的过程，管理jar依赖。
2. 约定的目录结构 ： maven项目的目录和文件的位置都是规定的。
3. 坐标 ： 是一个<mark>唯一的字符串</mark>，用来表示资源的。
4. 依赖管理 ： 管理你的项目可以使用jar文件。
5. 仓库管理 (了解) ：你的资源存放的位置。
6. 生命周期 (了解) ： maven工具构建项目的过程，就是生命周期。
7. 插件和目标 (了解) ：执行maven构建的时候用的工具是插件。 
8. 继承　：maven中的继承其实就是继承pom.xml中的依赖，然后在子项目中就可以直接使用父项目中引用的jar和项目，作用和传递依赖一样，只是写法不同。类似于Java中的继承。
9. 聚合：把子项目的构建过程串到一起。一个项目往往由多个模块构成的，在进行构建时，针对每个模块都进行构建命令是一件非常繁琐又容易出错的事情**，**所以Maven的聚合功能能够替我们完成进行一次构建命令完成全部模块的构建。把好几个项目合在一起。

**讲maven的使用，先难后易的。 难是说使用maven的命令，完成maven使用 ， 在idea中直接使用maven，代替命令。**

## 7.Maven的安装与配置

- 需要从maven的官网下载maven的安装包 apache-maven-3.3.9-bin.zip

- 解压安装包，解压到一个目录，非中文目录。

  解压文件介绍：

  - bin目录放置maven的一些工具（里边的mvn.cmd，这是maven的一个命令，这个命令可以执行Maven的构建项目）。
  - conf目录下有一个 settings.xml 文件，这个是Maven这个工具的配置文件。
  - lib目录下存放的是jar包，Maven工具是由Java语言编写的。

- 配置环境变量 ：
  在系统的环境变量中，指定一个M2_HOME的名称， 指定它的值是maven工具安装目录，bin之前的目录

  ```java
  M2_HOME=D:\work\maven_work\apache-maven-3.3.9
  
   再把M2_HOME加入到path之中，在所有路径之前加入 %M2_HOME%\bin;
  ```

- 验证，新的命令行中，执行mvn -v(这个命令代表测试这个Maven的版本号)

## 8.Maven核心----工程约定目录结构

- 所谓约定就是已经规定好的，可以不按照这个约定做，但是一般情况下还是按照这个约定来。
- 约定是大家都遵循的一个规则。
- 每一个Maven项目在磁盘中都是一个文件夹。（这个文件夹就是这个项目）

```
假设其实有一个Hello项目 （#代表注释的意思）
Hello/
—/src
------/main          #放你主程序java代码和配置文件
----------/java      #你的程序包和包中的java文件
----------/resources #你的java程序中要使用的配置文件
------/test          #放测试程序代码和文件的（可以没有）
----------/java      #测试程序包和包中的java文件
----------/resources #测试java程序中要使用的配置文件
—/pom.xml 			 #maven的核心文件（maven项目必须有）
```

- **此时Mavne就会自动的去main目录下找主程序，在test目录下找测试程序。Maven要做的工作都到 pom.xml文件中去找。**

- **在启动项目的时候，Maven首先去 <mark>pom.xml</mark>文件中找Maven要做的工作，然后去main和test文件夹下寻找工作的位置**

- **PowerShell是cmd的超集，cmd能做的PowerShell都能做，但是PowerShell能做的cmd不一定全能做，PowerShell是cmd可以交互使用(在cmd的黑框里可以输入PowerSehll使用PowerShell，也可以在cmd黑框中输入cmd使用cmd)**

- **不论使用PowerShell还是cmd都可以使用 <mark>tree 目录名(文件名)</mark> 来获取到该目录下的目录结构**

- **这个获取到的是该目录下其他的目录结构(文件夹的结构)，不包含其中的文件(比如:pom.xml)**

  ![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210801150206.png)

### 8.1获取Maven中的jar包(在 Mave中这个jar包叫做插件)

- 如何获取，按照以上的目录创建好一个文档，在根目录下使用<mark>mvn compile</mark>编译src/main目录下的所有java文件的。此时会获取到Maven所需的全部插件(也就是jar包)。

- 注意 ： 执行<mark>mvn compile</mark>这个命令必须咋与pom.xml同一级的目录下执行Java文件。 

- 下载这些jar包的位置：在apache中央仓库。

  ```markdown
  Maven在apache中央仓库的地址
  Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/maven-plugin-parameter-documenter-2.0.9.pom
  ```

- 为什么要下载 ：maven工具执行的操作需要很多插件（java类–jar文件）完成的。如果没有这 

  ​							些jar包的支持，Maven是无法完成操作的。

- 下载的东西：jar包（在Maven中叫插件）是Maven完成某些功能必要的文件。
- 下载的jar在哪里 ： 默认仓库(本机仓库) <mark>C:\Users\YunboCheng(用户名)\.m2\repository</mark>

- 下载的结果：mvn compile命令执行成功后，会在该项目的<mark>根路径(与src和pom.xml同级)</mark>下生成一个target目录(结果目录).
- 在这个target目录下，存放的是我们书写的<mark>所有Java类</mark>的<mark>.class</mark>文件。

### 8.2 设置本机存放资源文件的目录位置(设置本机仓库)

1. 修改maven的配置文件，maven配置文件的地址：maven安装目录/conf/settings.xml

   <mark>先备份 setting.xml</mark>

2. 修改 localRepository 指定你的要移动的目录**(不要使用中文)**

3. 在这个 setting.xml 中找到这行代码（此时一下的代码在这个xml文件的注释中），这个地址为下载后将这些 jar包存储的默认位置。需要将以下这行代码从注释中取出来，并且改变其中的路径。

   ```xml
   <localRepository>/path/to/local/repo</localRepository>
   <!--将这行从注释中取出来，并将路径改为自己设置的路径-->
   <localRepository>/path/to/local/repo</localRepository>
   <!--例如：想要改变的路径为：C:\development\Maven\Maven-jar-->
   <!--注意将\改为/ 保持一致-->
   <localRepository>C:/development/Maven/Maven-jar</localRepository>
   ```

### 8.3 Maven的使用方式

- 独立使用Maven：使用maven的各种命令，完成代码的编译、测试、打包等。

  比如：我们上边独立使用的Maven命令<mark>mvn compile</mark>独立完成对代码的编译。

- 结合开发工具使用：一般可以在idea中使用Maven : 简单、快捷、不需要记住命令。

  ## 9. Maven核心----仓库的概念

- 仓库是存放东西的，存放maven使用的jar包 和 我们项目使用的jar包
  - maven使用的插件（各种jar）
  - 我项目使用的jar(第三方的工具，比如：myql驱动、jackson)

### 9.1 仓库的分类

- 本地仓库： 就是你的个人计算机上的文件夹，存放各种jar

- 远程仓库： 在互联网上的，使用网络才能使用的仓库（远程仓库包括以下三种）

  ①中央仓库 ：最权威的， 所有的开发人员都共享使用的一个集中的仓库，
  						https://repo.maven.apache.org ：中央仓库的地址。
  ②中央仓库的镜像 ：就是中央仓库的备份， 在各大洲，重要的城市都是镜像。
  ③私服 ：在公司内部，在局域网中使用的， 不是对外使用的。

### 9.2 仓库的使用

- maven仓库的使用不需要人为参与

- 开发人员使用仓库的顺序：

  ```markdown
  开发人员需要使用mysql驱动---->maven首先检查本地仓库---->私服---->镜像----->中央仓库
  ```

- 开发人员使用<mark>远程仓库的顺序</mark>

  <img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210801192529.png" style="zoom:80%;" />

   **从远程仓库下载的仓库一定会保存到本地仓库一份**

## 10.Maven核心----pom文件

- pom即(Project Object Model)项目对象模型。Maven把一个项目的结构和内容抽象成一个模型，在xml文件中进行声明，以便进行构建和描述，<mark>pom.xml是Maven的灵魂</mark>。所有，Maven环境搭建好之后，所有的学习和操作都是关于pom.xml的。

- pom.xml初始：以下这些参数都是pom.xml文件中的<mark>标签属性</mark>

  ![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210801194420.png)

  ![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210801194647.png)

  ![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210801204124.png)

  ![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210801210413.png)

  **以上这些Maven核心参数都要卸载<mark>pom.xml</mark>文件中。**

## 11.Maven核心----坐标

- **每一个Maven项目<mark>必须</mark>有坐标，即项目的唯一标识。**

- groupId + artifactId +  version 三个信息组成的代表一个坐标
- 这个坐标在唯一值，在互联网中唯一的标识一个项目。

<img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210801211242.png" style="zoom:80%;" />

### 11.1 中央仓库

- https://mvnrepository.com/ （mvn中央仓库的地址）

- 在这个中央仓库中你可以下载所需饿一切jar包，需要什么在网页中搜索即可。

  例如 ：所搜mysql会找出有关mysql数据库的信息，连接驱动等.....

  ![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210801201536.png)

- **以上是搜索mysql之后显示的信息，包括了MySQL Connector/J » 8.0.26 所属的公司名称、这个版本的原始下载地址、提供了pom版本文件的下载与jar包形式的下载机制、最重要的是提供了这个版本的数据库的唯一标识（即定位）在下边的那个Maven框框。这个坐标有MySQL的公司（即甲骨文公司提供）**
- **使用这个中央仓库最主要的就是去这个仓库中寻找这个 ==pom.xml文件中的这个Maven依赖代码==，将这个依赖代码复制到我们的pom.xml文件中，Mavne会自动下载这个所需的jar包，并且会在自定义的本地(或者默认的本机仓库存储一份)**

## 12.Maven核心----依赖管理

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210801204124.png)

<img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210801211510.png" style="zoom:80%;" />

<img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210801211624.png" style="zoom:80%;" />

- **packaging : 打包后压缩文件的扩展名，默认是jar，web应用是war。**

- **packaging可以不写，因为默认就是jar**

  pom.xml加入依赖的方式：：

<img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210801205513.png" style="zoom:80%;" />

- **经过以上代码Maven会去本地仓库查有没有5.1.9这个版本的mysql-conncetor的jar包，如果在本地仓库中存在5.1.9这个版本的mysql-conncetor， 此时就会把这个版本的数据库绑定到这个Maven项目上。以上的mysql、mysql-conncetor、5.1.9对应的都是在本地仓库中存在的文件夹**

- **以上的依赖文件如果在本地仓库中没有，那么Maven会自动去远程仓库中进行寻找。**

```markdown
开发人员需要使用mysql驱动---->maven首先检查本地仓库---->私服---->镜像----->中央仓库
```

## 13.Maven核心----配置属性

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210801210819.png)

## 14.Maven核心----构建

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210801210926.png)

-  Maven在进行项目的构建时， 配置信息，例如指定编译java代码使用的jdk的版本等

## 15. Maven核心----生命周期、常用命令、插件

- maven生命周期：就是maven构建项目的过程，清理，编译，测试，报告，打包，安装，部署

- maven的命令：maven独立使用，通过命令，完成maven的生命周期的执行。

   						   maven可以使用命令，完成项目的清理，编译，测试等等.

-  maven的插件：maven命令执行时，真正完成功能的是插件，插件就是一些<mark>jar文件， 一些类</mark>

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210801212054.png)

<img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210801212420.png" style="zoom: 67%;" />

**<mark>以下是一个标准的工程约定目录结构</mark>**

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210801215810.png)

**以下是Maven的常用命令**

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210801215340.png)

### 15.1 mvn clean （清理）命令

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210802084050.png)

- **以上就是一个插件，在生命周期中的清理阶段，使用Maven命令中的<mark>mvn clean</mark>清理命令，mvn clean之后会使用以上这个插件(jar包)完成清理工作。**

- **注意：清理工作是插件完成的，不是命令完成的，命令只是负责调用这些插件(jar包)，插件来完成清理，编译，测试，报告，打包，安装，部署这些工作。**

- **<mark>mvn clean</mark>**：只编译主程序下的Java文件（即mian目录下的所有Java文件，不编译test文件夹下

  ​					  的测试程序）

### 15.2 mvn compile （编译主程序）命令

- **以下这个是使用 <mark>mvn compile 命令编译主程序</mark>，所使用的插件**

- 使用 <mark>mvn compile命令</mark>，会使用两个插件，完成两个操作

  编译==main/java/目录下==的所有java 为class文件，将这些class文件存储到==target/classes文件夹下==。

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210802085026.png)

- 编译==main/java/目录下==的所有java文件，将这些class文件存储到==target/classes文件夹下==。

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210802085702.png)

- **这个插件会将<mark>src/main/resources文件夹中的文件</mark>拷贝到 <mark>target/classes的文件夹下</mark>**

### 15.3 mvn test-compile （编译测试程序）命令

- **==mvn test-compile== ：这个命令编译==test文件夹下所有的测试程序==，编译好的这些测试程序会存储到==target/test-classes文件夹下==。**

### 15.4 mvn test （测试程序）命令

- **重点 ： 测试程序的包路径一定要和主程序的包路径一致，这样才不会报错，也就是保证这两			      个文件在同一个包路径下。**

  ![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210802103351.png) 

- 此时可以看出 ==test中的测试程序== 与==main中的主程序==的路径是一样的。

- **这个是执行的==test/java文件夹下的测试程序==，会将测试结果全部存储到==target/surefire-resports文件夹中==。**

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210802102105.png)

- 注意 ：在执行==mvn test== 命令时，会把测试以前的步骤重新进行一次（清理、编译主程序、编译测试程序），这是因为有 Maven生命周期的存在。所以此时需要的插件比较多。第一个编译的是main主程序，第二个编译的是test测试程序。

![image-20210802102757082](https://gitee.com/YunboCheng/imageBad/raw/master/image/image-20210802102757082.png)

- **以上的这个插件是用来测试程序的。以下输出格式代表测试成功。**

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210802102907.png)

- 从 TESETS 以下代表的是测试结果 ：
  - Runing代表的是执行的测试程序的路径以及测试程序的名称。
  - == = Maven junit testAdd === 代表的是该测试结果输出的信息。
  - Test run : 代表的是测试程序运行时的信息。（测试数量、失败、错误、跳过、测试时间）
  - Results : 代表的是这个测试程序输出的结果。（测试数量、失败、错误、跳过）
- **以下代码测试失败。此时会抛出异常，并显示测试两个，失败一个。**

![image-20210802111629783](https://gitee.com/YunboCheng/imageBad/raw/master/image/image-20210802111629783.png)

**以下代码是测试结果：测试两个，失败了一个，会告诉你==错误信息==**。

```
Failed tests:testAdd2(com.yunbocheng.TestHelloMaven): expected:<5> but was:<3>
```

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210802111717.png)

**重点 ：以上的错误信息会生成一个报告，这个报告在 ==target/surefire-reports==文件夹下。测试的==所有结果==都在这个文件夹下。**

**讲以上的代码错修改完成，此时会显示以下运行结果。测试两个方法，且都成功。**

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210802125210.png)

### 15.5 mvn package命令（打包主程序）

- ==mvn package== 命令，按照pom.xml配置文件把主程序打包为jar包或者war包。
- **以下是打包使用的插件，在执行这插件之前，也会使用编译、测试的插件将这个项目在执行一遍，最后由==mvn package==这个命令将主程序进行打包。**

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210802125817.png)

- jar包以及war包就相当于一个压缩文件。

- 打包传成功之后会在==target目录下生成一个ch01-maven-1.0-SNAPSHOT.jar包==。

- **这个jar包中信息的解释：**（jar包中包含主成程序的类文件以及配置文件(pom.xml)）

  - Hello这个项目主程序(HelloMaven)的路径以及字节码文件。

  - 里边存在一个==META-INF=文件夹，在文件夹下包含这个项目的pom.xml配置文件。

  - 里边还有原Maven项目==src/mian/resources文件夹里边的文件==(config.txt配置文件)

    这个配置文件是开发人员自己在mian目录下创建并书写的。

- **针对这个jar包名称的解释：**

  - ch01-maven : 就是该项目==pom.xml配置文件==中==artifactId(项目模块名称)==参数的信息。

  - 1.0-SNAPSHOT ： 就是该项目==pom.xml配置文件==中==version(版本号)==参数的信息。

**重点 ：这个jar包含所有的东西就是原Maven项目中main目录下的所有主程序的class文件    以及开发人员自己编写的配置文件。**

### 15.6 mvn install命令（安装主程序）

- **会把本工程打包，并且按照本工程的坐标保存到本地仓库。即使把这个项目生成的jar包保存到你自定义的本机仓库或者默认仓库(.m2)中，这样其他的项目就可以使用你这个项目中的主程序方法了**
- **以下是执行==mvn install==命令所使用的插件，在执行这个插件之前，也会使用编译、测试、打包的插件将这个项目在执行一遍，最后由==mvn package==这个命令将这个Maven项目生成的jar包保存到本机仓库**
- 这个本机仓库的地址就是自己在Maven中自己配置的地址或者是默认地址(.m2)。

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210802133719.png)

- **保存到本机仓库里的地址就是这个Maven项目中==pom.xml配置文件中的坐标信息。==**

```xml
<groupId>com.yunbocheng</groupId>
<artifactId>ch01-maven</artifactId>
<version>1.0-SNAPSHOT</version>
```

**以上是该Maven项目中pom.xml配置文件中的==坐标信息==。以下是保存到本机仓库中的==路径信息==**

```markdown
C:\development\Maven\Maven-jar\com\yunbocheng\ch01-maven\1.0-SNAPSHOT\ch01-maven-1.0-SNAPSHOT.jar  
```

**可以看出坐标信息就是保存到本机仓库的路径信息**

注意 ： 在groupId这个参数中的信息，每一个小数点就代表一级文件夹

​			  ==com.yunbocheng==代表==com/yunbocheng==。

## 16.单元测试 junit

- 单元测试（测试方法）：用的是junit， junit是一个专门测试的框架（工具）。

- junit测试的内容： 测试的是类中的方法， 每一个方法都是独立测试的。

  <mark>方法是测试的基本单位（单元）。</mark>

-   maven借助单元测试，批量的测试你类中的大量方法是否符合预期的。 

<img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210801215131.png" style="zoom:80%;" />

<img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210801215225.png" style="zoom:80%;" />

**测试程序格式**

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210802083537.png)

## 17.关于 Maven项目中 pom.xml配置文件的解释

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xsi:schemaLocation="http://maven.apche.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://maven.apache.org/POM/4.0.0">

<modelVersion>4.0.0</modelVersion>

<groupId>com.yunbocheng</groupId>
<artifactId>ch01-maven</artifactId>
<version>1.0-SNAPSHOT</version>

<dependencies>
	<dependency>
		<groupId>junit</groupId>
		<artifactId>junit</artifactId>
		<version>4.12</version>
		<scope>test</scope>
	</dependency>
</dependencies>
</project>
```

- modelVersion : 是这个Maven的版本号，现在统一使用4.0.0这个版本

- ```xml
  <!--这段代码表示的是该项目生成后的jar包在本机仓库中的保存路径-->
  <groupId>com.yunbocheng</groupId>
  <artifactId>ch01-maven</artifactId>
  <version>1.0-SNAPSHOT</version>
  ```

- ```xml
  <!--这段代码代表的是从外部引入进来的依赖jar包，Maven会自动寻找这个jar包，如果这个jar包在本机中存在直接拿来使用，如果不存在会自动去远程仓库中获取，并且获取到的远成jar包会在本机仓库保存一份，方便下次使用。-->
  <dependencies>
  	<dependency>
  		<groupId>junit</groupId>
  		<artifactId>junit</artifactId>
  		<version>4.12</version>
  		<scope>test</scope>
  	</dependency>
  </dependencies>
  <!--<dependencies>代表的是里边有多个插件(jar包)，相当于多个插件的一个大括号，所有的插件都写在这个dependencies标签中-->
  <!--<dependency>这个标签里包含的是这个项目中的一个插件，他写在<dependencies>这个标签的里边，会有多个<dependency>标签，每一个标签就是一个插件-->
  ```

## 18.编译插件配置

- 插件可以在自己的项目中设置，最常用的是 maven 编译插件。设置项目使用的jdk版本时通过编译插件来指定。使用pom.xml配置文件中的< build >标签中设置。
- build是用来==构建配置项目==的。
- 控制配置 Maven构建项目的==参数设置==，如 ：设置JDK的版本。

![image-20210802144721974](https://gitee.com/YunboCheng/imageBad/raw/master/image/image-20210802144721974.png)

- 参数信息解释：
  - build ：构建项目==参数信息==。
  - plugins :  ==配置插件==，这个相当于所有插件的一个大括号，所有的插件都写在这个里面。
  - plugin : ==配置具体的插件==，这个代表该Maven项目中的一个插件信息，还有其他的插件。
  - groupId ：该插件的==组织名称==。
  - artifactId ： ==插件的名称==。
  - version :  ==插件的版本==。
  - confiruration : 配置插件的信息。
  - source : 告诉Maven，我们写的代码是在==jdk1.8上编译==的。
  - target : 我们的程序应该==运行在1.8的jdk上==。

### 18.1 配置 jdk版本的两种方式

- **第一种：使用 properties标签配置**

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210802161950.png)

- **第二种：使用 configuration 标签配置**

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210802162031.png)

## 19. idea中设置Maven

- 在idea中设置maven ，让idea和maven结合使用。
- idea中内置了maven ，一般==不使用内置的==， 因为用内置修改maven的设置不方便。
- 使用自己安装的maven， 需要==覆盖==idea中的默认的设置。让idea指定maven安装位置等信息

- **在idea的文件中 ==Setting==是设置当前项目的，==Other Settings==是为以后新建工程起作用**
- 在配置Maven的时候，这两个位置都要配置。

### 19.1配置Setting中的Maven

- 第一步：配置Maven

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210802171834.png)

**需要配置的三个地方**

- Maven Home directory  :  maven的==安装目录==。				

- User Settings File  :  就是maven安装目录==conf/setting.xml配置文件== 。				

- Local Repository :    ==本机仓库==的目录位置。

- 第二步：配置运行程序

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210802192424.png)

- **配置JDK的版本**
- **设置一个参数信息，==-DarchetypeCatalog=internal==，这个参数信息的目的是为了使构建Maven项目时速度变快。**
- Maven在创建项目的时候会默认连网下载一个==模板文件==，这个模板文件大小有7M，为了==避免== 不下载这个模板文件，加上这个参数信息，表示我们用的是内部的内容，不用下载。
-  ==-DarchetypeCatalog=internal== , maven项目创建时，会联网下载模版文件，比较大，使用    ==-DarchetypeCatalog=internal==，不用下载， 创建maven项目速度快。（2019版本以后，新的就不用添加这个）

### 19.2 配置Other Settings

- 第一步 ：找到文件下拉菜单中的 ==新项目管理==
- 第二步 ：找到新项目设置

<img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210802173539.png" style="zoom:80%;" />

- 第三步 ： 找到Maven 和上边的配置方式一样

<img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210802173745.png" style="zoom: 50%;" />

- 第四步 ：添加jdk与参数信息

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210802192424.png)

## 20.idea创建JavaSE项目

**使用模版创建项目**

- **maven-archetype-quickstart : 普通的java项目**
- **maven-archetype-webapp : web工程**

<img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210802193707.png" style="zoom:67%;" />

**以下是使用==maven-archetype-quickstart== 模块构建成功后的==结构目录==**

<img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210802194016.png" style="zoom: 67%;" />

**注意：其中 ==resources文件== 是我们自己==手动创建==的，==maven-archetype-quickstart模块==没有提供这两个文件夹。其中APP类是模块自动生成的，如果想用别的类文件，直接把这份删除即可。**

**在idea中，不同的文件夹展示的形式不一样**

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210802194305.png)

- 源根 ： 代表Java主程序的根文件夹。
- 测试源根 ： 代表Java测试程序的根文件夹。
- 资源根 ：代表main文件夹下的配置文件。
- 测试资源根 ：代表test文件夹下的配置文件。

**以下目录结构中包含了项目执行之后生成的==target文件夹==。**

<img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210802200719.png" style="zoom:80%;" />

**以下是一个Maven构建的Java项目执行完程序之后结构，Java项目生成的是==jar包==**

<img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210802214625.png" style="zoom:80%;" />

## 21.idea创建Web项目

**使用模版创建项目**

- **maven-archetype-quickstart : 普通的java项目**
- **maven-archetype-webapp : web工程**

**以下就是使用==maven-archetype-webapp模块==设置的web工程目录**

![image-20210802202832880](https://gitee.com/YunboCheng/imageBad/raw/master/image/image-20210802202832880.png)

**此时需手动在main文件夹下创建一个Java目录(源根)，还需一个存放主程序配置文件夹(资源根)**

**还需要在src下创建一个与main文件夹同级的测试文件夹(test)，在test文件夹下创建一个测试文件夹(测试源根)，还有一个测试文件夹下的配置文件夹(测试资源根)**

**以下就是一个完整的Web Maven项目结构**

<img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210802204913.png" style="zoom:67%;" />

**在Maven中不用从==导入外部servlet (jar包)与 jsp(jar包)==，只需要在==pom.xml==中加入==servlet与jsp依赖==即可**

**注意：以下这些依赖项不需要手动编写，直接去==中央仓库==中下载这个==pom.xml源代码==。**

**中央仓库地址 ：==[中央仓库](https://mvnrepository.com/)==**

```xml
<dependencies> 
  <!--这些依赖项全部写在dependencies标签内部-->  
	<!--添加servlet依赖项(servlet的jar包)-->
    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>javax.servlet-api</artifactId>
      <version>3.1.0</version>
      <scope>provided</scope>
    </dependency>

    <!--添加jsp依赖项(jsp的jar包)-->
    <dependency>
      <groupId>javax.servlet.jsp</groupId>
      <artifactId>jsp-api</artifactId>
      <version>2.1</version>
      <scope>provided</scope>
    </dependency>
</dependencies>
```

**以下是一个Maven构建的Web项目执行完程序之后结构，Java项目生成的是==war包==**

**这个war包就是最终交付给客服的web文件，这个war包解压后可以直接使用**

- 此时将这个==war包==放到 ==Tomcat/webapps==下，之后==启动Tomcat/bin/startup.bat==，启动之后在网页上就可以直接运行这个==war包==中的文件。

<img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210802214904.png" style="zoom:80%;" />

## 22. idae中导入Maven工程(模块)

### 22.1 解决依赖不能识别的问题：

- 第一种 ：将鼠标停留在==pom.xml文件==上，右键选中==Maven==，之后点击==重新加载项目==。
- 注意 ：此时刷新的==只是这一个项目==的依赖文件。

<img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210803100346.png" style="zoom:67%;" />

- 第二种：在Maven栏中点击刷新按钮

- 注意 ： 此时刷新的是整个在Maven栏中存在的项目

  <img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210803100837.png" style="zoom: 80%;" />

### 22.2 idea导入Maven模块

- 第一步 ：找到项目结构，找到模块，然后点击加号，导入模块。

<img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210803101718.png" style="zoom:67%;" />

- 第二步 ： 在你的资源管理器中找到你要导入的Maven模块。

<img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210803101856.png" style="zoom: 50%;" />

- 第三步 ： 选中从外部模型导入模块，选择Maven，点击确定。

<img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210803101953.png" style="zoom:50%;" />

- 第四步 ：将缺少的依赖进行勾选。idea会自定为我们选择的。

<img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210803102103.png" style="zoom:50%;" />

## 23.依赖管理

- **==依赖范围==， 在pom.xml配置文件中使用scope标签表示的。**
- **scope:表示依赖使用的范围，也就是在maven构建项目的那些阶段中起作用。**
- maven构建项目 编译， 测试 ，打包， 安装 ，部署 过程（阶段）
- **scope的值有 :  compile, test, provided ,默认是==compile==**
- ==compile== : 在编译， 测试 ，打包， 安装 ，部署 这些阶段都要用到这个依赖的jar包。
- ==test== ：只在测试程序阶段使用这个依赖jar包，
- ==provided(提供者)== ： 在编写主程序和运行程序阶段使用这个依赖jar包。

<img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/image-20210803103509974.png" alt="image-20210803103509974" style="zoom: 80%;" />

- **重点 ： 使用==compile== ，该项目打包之后，会在生成的war包或者jar包中==存在==被compile声明的依赖项(即jar包)，**

  **使用==provided==，该项目打包之后，生成的jar包或者war包中==不存在==被peovided声明的依赖项(jar包)。**

- **在pom.xm文件中添加依赖jar包的时候，如果本机仓库没有，Maven会==自动==到中央仓库进行下载，不用开发人员自己解决，并且加入依赖项的代码==(坐标)==可以去中央仓库进行==复制粘贴。==**

## 24.Maven常用操作

### 24.1 Maven属性设置

- **这个属性设置是Maven提供的。**

```xml
<!--在 properties标签中声明的就是Maven属性的设置 -->
<!--maven.compiler.source 这是属性名，1.8这是属性值-->
<properties>
    <!--maven构建项目使用的编码方式，避免中文乱码-->
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <!--编译代码使用饿jdk版本-->
    <maven.compiler.source>1.8</maven.compiler.source>
    <!--运行程序时使用的jdk版本-->
    <maven.compiler.target>1.8</maven.compiler.target>
</properties>
```

 ### 24.2 Maven全局变量

- **这个属性是开发人员自定义的。**

- **自定义的属性 ：**
  - 在 ==properties标签中== 通过自定义标签声明变量（标签名就是变量名）。
  - 在pom.xml文件中的其它位置，使用 ==${标签名}== 使用变量的值。
- **自定义全局变量一般是定义==依赖的版本号==， 当你的项目中要使用多个相同的版本号， 先使用全局变量定义， 在使用==${变量名}==**

```xml
<!--在 properties 标签中声明自定义的全局变量-->
<properties>
    <!--maven构建项目使用的编码方式，避免中文乱码-->
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <!--编译代码使用饿jdk版本-->
    <maven.compiler.source>1.8</maven.compiler.source>
    <!--运行程序时使用的jdk版本-->
    <maven.compiler.target>1.8</maven.compiler.target>
    <!--自定义变量(这个变量名就是标签名)，表示版本号-->
    <!--这个标签名可以自己定义，因为在XML文件中标签名随意定义，没有要求。-->
    <spring.version>5.2.0</spring.version>
</properties>

```

- **之后在其他地方使用这个版本号的时候就不用挨个的书写版本号，直接使用这个变量。**
- **这样的话只要在==properties== 中修改这个版本号，修改一次，在其他的依赖中这个版本号都会更改。**

<img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210803112043.png" style="zoom:80%;" />

<img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210803112434.png" style="zoom:67%;" />

### 24.3 资源插件

- **在pom.xml的 ==build标签==中加入==resources标签==**

```xml
<build>
    <!--只要将这个resources标签中放到buil标签中就可以，可以是任意的位置-->
	<resources>
		<resource>
		<directory>src/main/java</directory><!--所在的目录-->
		<includes><!--包括目录下的.properties,.xml 文件都会扫描到-->
		<include>**/*.properties</include>
		<include>**/*.xml</include>
		</includes>
		<!--filtering 选项 false 不启用过滤器， *.property 已经起到过滤的作用了-->
		<filtering>false</filtering>
		</resource>
	</resources>
</build>
<!--以上代码代表的含义：将src/main/java目录下得所有.properties和.xml文件-->
```

例如 ：mybatis课程中会用到这个作用。

- 默认没有使用resources的时候， maven执行编译代码时， 会把==src/main/resource目录中==的文件==拷贝==到==target/classes目录中==。对于==src/main/java== 目录下的==非Java文件不处理==，不会拷贝到==target/classes目录中==。

- 我们程序有时需要把一些文件放在==src/main/java== 目录中，当我们在执行Java程序时，需要用到 ==src/main/java== 目录中的文件，需要告诉Maven在 使用命令==mvn compile== 编译==src/main/java目录下的程序==的时候，需要把Java文件夹中的==非Java文件一同拷贝==到==target/classes目录中==

