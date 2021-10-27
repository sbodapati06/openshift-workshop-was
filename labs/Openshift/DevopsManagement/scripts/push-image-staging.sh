echo "login to OSCP image registry"
docker login -u openshift -p $(oc whoami -t) default-route-openshift-image-registry.apps.demo.ibmdte.net

echo "push cos application image to staging namespace"
docker push default-route-openshift-image-registry.apps.demo.ibmdte.net/staging/cos