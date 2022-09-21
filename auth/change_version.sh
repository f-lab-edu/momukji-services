NEW_VERSION=$1

YAML_CONTENT=`awk '/image:/' momukji-auth.yml`
CURRENT_VERSION="${YAML_CONTENT#*momukji-auth:}"

sed -i "s/auth:${CURRENT_VERSION}/auth:${NEW_VERSION}/g" momukji-auth.yml