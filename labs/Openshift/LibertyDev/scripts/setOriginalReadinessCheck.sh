echo "revert to the original versions of the ReadinessCheck.java health check to the cos web application."

# The preceeding slash means do not prompt for overwriting the file.

\cp ~/openshift-workshop-was/labs/Openshift/LibertyDev/lab-files/Original-ReadinessCheck.java ~/openshift-workshop-was/labs/Openshift/LibertyDev/app/CustomerOrderServicesWeb/src/org/pwte/example/health/ReadinessCheck.java


echo ""
echo "************************************************************************************************"
echo "ReadinessCheck reverted back to its original code"

echo "Script completed"
echo ""
echo "************************************************************************************************"
echo ""