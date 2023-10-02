# create namespace
kubectl create namespace user-crud-app-ns

# create secret with password
kubectl create secret generic user-crud-app-secret --from-literal=DB_PASSWORD=mypass --namespace user-crud-app-ns

#install postgres chart
helm install postgresql bitnami/postgresql --version 13.0.0 --namespace user-crud-app-ns -f postgress-install-settings.yaml

# apply configmap - with settings for database and migration script
kubectl apply -f ./manifests/configmap.yaml

# prepare database - fill it with data
kubectl apply -f ./manifests/db-filling-job.yaml

# create pods and containers with main application
kubectl apply -f ./manifests/deployment.yaml

# create service
kubectl apply -f ./manifests/service.yaml

# create ingress
kubectl apply -f ./manifests/ingress.yaml