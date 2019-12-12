### Git操作命令
```
    
    首先创建用户名，与github用户名一致
    git config --global user.name 'lhzjoker'
    然后绑定邮箱，qq邮箱
    git config --global user.name '2313169248@qq.com'
    
    查看设置
    git config --list
    
    显示当前目录 pwd

    创建文件夹 mkdir + 文件名
    
    初始化仓库 git init
    
    查看状态 git status(看有没有提交)
    
    向仓库中添加文件(本地仓库)
        创建文件 touch + 文件名
        添加到暂存区 git add + 文件名
        提交到仓库 git commit + -m "第一次添加文件"
        
    修改仓库文件
        查看当前目录下的所有文件 ls
        编辑文件vi + 文件名
        进入到修改画面后esc切换模式，需要切换到插入模式
        修改完之后 :+wq 进行保存
        
        查看文件内容 cat + 文件名
        
        然后再重新提交
        
    删除仓库文件
        1.rm -rf + 文件名   删除文件(本地仓库)
        #删除远程仓库(github)
        2.git rm --cached + 文件名 
        3.git commit -m "第一次删除文件"
        
        rm -fr .git是删除所有文件
    
    
    远程仓库
        clone github上的仓库到本地
        git clone + 本地仓库 
        
    
    
    git remote add origin + 仓库地址 (进入远程仓库)
    输入 git push -u origin master（提交修改）
    
    
   #通过Git删除github上文件或者文件夹的完整流程
       1.首先我们要进入仓库
       git remote add origin + 仓库地址 (进入远程仓库)
       2.然后将远程仓库的东西拉下来
       git pull origin master
       3.查看仓库中有哪些东西
       dir
       4.删除文件
       git rm --cached + 文件名
       5.删除文件夹
       git rm -r --cacher + 文件夹名
       6.提交，添加操作说明
       git commit -m"说明内容"
       7.删除完之后，可以删除多个，将本次更改更新到github上去
       git push -u origin master
       
       注:每次增加文件或删除文件，都要commit 然后直接 git push -u origin master，就可以同步到github上了


    #git 出现end无法操作的解决方法 按q
    #git 出现>无法操作的解决方法  ctrl + d
    
    #git修改远程仓库源
         添加远程仓库源git remote add origin +仓库地址
        1.首先要移除以前的远程仓库
        git remote rm origin
        2.然后再添加新的
        git remote add origin +仓库地址
    
    #注（将远程仓库拉下来出错）fatal: refusing to merge unrelated histories
    （拒绝合并不相关的历史）
        $git pull origin master --allow-unrelated-histories
        
    #通过Git上传文件或者文件夹的完整流程
     1.首先我们要添加远程仓库源
       git remote add origin + 仓库地址 (进入远程仓库)
     2.然后将远程仓库的东西拉下来
       git pull origin master
     3.查看仓库中有哪些东西
       dir
     4.添加文件
        git add + 文件名
     5.添加文件夹
        git
     6.提交，添加操作说明
        git commit -m"说明内容"
     7.上传完之后，可以上传多个，将本次更改更新到github上去
       git push -u origin master
```
