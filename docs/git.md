git remote add origin git@github.com:continuous1024/spring-cloud-learn.git

git add .

git commit

git pull origin master --allow-unrelated-histories

git branch --set-upstream-to=origin/master master
 
git push -u origin master