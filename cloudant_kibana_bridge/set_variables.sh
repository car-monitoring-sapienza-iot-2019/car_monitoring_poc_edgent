export CLOUDANT_INSTANCE="/gabriele.cervelli95@gmail.com_ProgettoIOT/Bluemix_CarMonitoringDB_bluemix_s2s_21396fdc-72b4-4697-b3d0-ef9ad271b617_iotfclient"
export CLOUDANT_DATABASE="iotp_1cn1we_car_monitoring_db_2019-04"
#
ibmcloud wsk trigger create data-inserted-trigger \
  --feed Bluemix_${CLOUDANT_INSTANCE}/changes \
  --param dbname "$CLOUDANT_DATABASE"
# Create a function with the specified script
ibmcloud wsk action create process-change process-change.js
# Map action with the trigger
ibmcloud wsk action create process-change-cloudant-sequence \
  --sequence Bluemix_${CLOUDANT_INSTANCE}/read,process-change
#
ibmcloud wsk rule create log-change-rule data-inserted-trigger process-change-cloudant-sequence
# To show logs
ibmcloud wsk activation poll