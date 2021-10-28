
echo "go to directory where the Dockerfie1 exists"
cd ~/cos-gitops-repo/labs/Openshift/DevopsManagement

echo "Build cos:v2.0 image"
docker build --tag default-route-openshift-image-registry.apps.demo.ibmdte.net/staging/cos:v2.0 -f Dockerfile1 .


echo "login to OSCP image registry"
docker login -u openshift -p $(oc whoami -t) default-route-openshift-image-registry.apps.demo.ibmdte.net

echo "push cos application image to staging namespace"
docker push default-route-openshift-image-registry.apps.demo.ibmdte.net/staging/cos:v2.0
