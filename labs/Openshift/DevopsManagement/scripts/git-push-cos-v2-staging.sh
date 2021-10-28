
echo "go to roo of gitops repo"
cd ~/cos-gitops-repo

echo "git add"
git add .


echo "git commit"
git commit -m "cos-v2.0"

echo "git set origin with user and pw
git remote set-url origin http://gitlabUser:passw0rd@gitlab.demo.ibmdte.net/gitlabUser/cos-gitops-repo.git

echo "git push to staging branch"
git push -u origin staging 
