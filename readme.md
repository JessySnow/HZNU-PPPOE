
# 杭州师范大学(仓前校区) 校园网拨号客户端
#### ***只适用于校内联合套餐***
---
## 使用方法
***下载最新的Release，解压后运行 Dial.exe 文件即可，第一次运行如果出现报错——未找到当前拨号连接的号码本入口_623，请尝试使用管理员权限重新启动应用***

---
## 应用内截图
#### V5.0 Beta2主界面
<img width="392" alt="Interface" src="https://user-images.githubusercontent.com/61576653/126256815-f5929f5f-30c7-4f76-b0fd-d5f9ba4a664f.png">

#### V0.51 Pre-Release主界面
<img width="383" alt="V0 51" src="https://user-images.githubusercontent.com/61576653/126868677-67b21163-443f-44e9-ae9f-9fb4fdc8bb17.png">

---
## 存在的问题
1. awt通知存在一定几率会被系统折叠
2. Java调用CMD的拨号线程退出缓慢，导致应用关闭后需要间隔较长时间才能打开
3. jre精简比较粗糙，程序压缩包偏大
4. 拨号等待期间无反馈，会导致误操作

---
## To Do
1. 精简jre
2. 添加拨号等待反馈
3. 精简代码
4. 修复awt通知
