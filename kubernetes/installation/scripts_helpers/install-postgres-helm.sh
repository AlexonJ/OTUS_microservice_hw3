#helm install [release-name] [repo-name] --set persistence.existingClaim=[pvc-name] --set volumePermissions.enabled=true
#kubectl create namespace test-ns
helm install postgresql bitnami/postgresql --version 13.0.0 --namespace user-crud-app-ns --create-namespace -f postgress-install-settings.yaml
