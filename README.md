#  微信答题小程序后端

### 一、代码托管

> [Github](https://github.com/KAIAOS/mp_quiz)

```bash
git clone https://github.com/KAIAOS/mp_quiz
```

### 二、 打包并部署

#### 1. 根据设置配置application.yml文件

#### 2. 生成jar包

```shell script
mvn package      #生成xxx.jar
java -jar xxx.jar
```

#### 3. 部署在服务器后台运行

```bash
nohup java -jar xxx.jar &
```

#### 4. 项目swagger地址

> http://localhost:8084/api/swagger-ui.html

### 三、代码维护
#### 1. GIT参考工作流程 
```git
# dev分支与远程同步
git checkout dev
git pull

# 在dev分支创建新分支 mybranch                
git checkout -b mybranch    
# 本地分支push到远端 
git push origin mybranch
# 本地分支关联远端分支mybranch
git branch --set-upstream-to=origin/mybranch

# 修改代码
git add .
git commit -m "commit something"

# 合并到dev并push
git checkout dev
git merge --no-ff mybranch
git push
```