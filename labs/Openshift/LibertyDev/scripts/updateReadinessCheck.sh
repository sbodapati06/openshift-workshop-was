echo "copy the updated ReadinessCheck.java health check to the cos web application."

# The preceeding slash means do not prompt for overwriting the file.

\cp ~/openshift-workshop-was/labs/Openshift/LibertyDev/lab-files/ReadinessCheck.java ~/openshift-workshop-was/labs/Openshift/LibertyDev/app/CustomerOrderServicesWeb/src/org/pwte/example/health/ReadinessCheck.java

echo "ReadinessCheck Update complete"

echo "Script completed"

echo ""
echo "************************************************************************************************"
echo "NOTES:"
echo ""
echo "The new Readiness check performs the following checks to ensure the cos appliction is ready: "

echo "     1. Lookup the ORDERDB via the naming service"
echo "     2. Connect to the ORDERDB database"
echo "     3. Run a query against the database"
echo "     4. Count the number of rows that were returned from the database query"

echo ""
echo "     Readiness Check PASSES: If the resultSet is not NULL, and there is at least 1 row returned from the query"
echo ""
echo "     Readiness check FAILS: If the resultSet is NULL, or if there is ZERO rows returned from the query. You are then requested to start the database and retry the  health check."

echo ""
echo "************************************************************************************************"
