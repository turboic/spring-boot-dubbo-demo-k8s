#
# Copyright 2022 Apollo Authors
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
# http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#
# create namespace
kubectl delete namespace sre

# dev-env
kubectl delete -f apollo-env-dev/service-mysql-for-apollo-dev-env.yaml  && \
kubectl delete -f apollo-env-dev/service-apollo-config-server-dev.yaml  && \
kubectl delete -f apollo-env-dev/service-apollo-admin-server-dev.yaml 

# fat-env
kubectl delete -f apollo-env-fat/service-mysql-for-apollo-fat-env.yaml  && \
kubectl delete -f apollo-env-fat/service-apollo-config-server-fat.yaml  && \
kubectl delete -f apollo-env-fat/service-apollo-admin-server-fat.yaml 

# uat-env
kubectl delete -f apollo-env-uat/service-mysql-for-apollo-uat-env.yaml  && \
kubectl delete -f apollo-env-uat/service-apollo-config-server-uat.yaml  && \
kubectl delete -f apollo-env-uat/service-apollo-admin-server-uat.yaml 

# prod-env
kubectl delete -f apollo-env-prod/service-mysql-for-apollo-prod-env.yaml  && \
kubectl delete -f apollo-env-prod/service-apollo-config-server-prod.yaml  && \
kubectl delete -f apollo-env-prod/service-apollo-admin-server-prod.yaml 

# portal
kubectl delete -f apollo-env-dev/service-apollo-portal-server.yaml 
