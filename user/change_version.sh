NEW_VERSION=$1

YAML_CONTENT=`awk '/image:/' momukji-user.yml`
CURRENT_VERSION="${YAML_CONTENT#*momukji-user:}"

sed -i "s/user:${CURRENT_VERSION}/user:${NEW_VERSION}/g" momukji-user.yml