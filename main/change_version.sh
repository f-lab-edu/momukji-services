NEW_VERSION=$1

YAML_CONTENT=`awk '/image:/' momukji-main.yml`
CURRENT_VERSION="${YAML_CONTENT#*momukji-main:}"

sed -i "s/main:${CURRENT_VERSION}/main:${NEW_VERSION}/g" momukji-main.yml