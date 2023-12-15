#!/bin/bash

SCRIPT_DIR=$( cd -- "$( dirname -- "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )

docker exec auth-server /opt/keycloak/bin/kc.sh export --users realm_file  --dir /tmp
docker cp auth-server:/tmp/external-realm.json "$SCRIPT_DIR"


