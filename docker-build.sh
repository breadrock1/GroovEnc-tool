!#/bin/bash

HELP="false"
PROJECT_HOME=$1
PROJECT_IMAGE_TAG=grooven-$(date +%s)
PROJECT_CONTAINER_NAME=container-$PROJECT_IMAGE_TAG

while [[ $# -gt 0 ]]; do
  key="$1"

  case $key in
    -r|--root)
      PROJECT_HOME="$2"
      shift
      shift
      ;;
    -h|--help)
      HELP="true"
      shift
      ;;
    *)
      shift
      ;;
  esac
done

echo -e "PROJECT_HOME is $PROJECT_HOME"
echo -e "PROJECT_IMAGE_TAG is $PROJECT_IMAGE_TAG"
echo -e "PROJECT_CONTAINER_NAME is $PROJECT_CONTAINER_NAME"

if [[ "$HELP" == "true" ]]; then
	echo Script options:
	echo " " "-r, --root <N>        The path to root project directory."
	echo " " "-h, --help <N>        Print help usage."

	exit 0
fi

docker build --rm --tag $PROJECT_IMAGE_TAG $PROJECT_HOME
docker run -d --name $PROJECT_CONTAINER_NAME $PROJECT_IMAGE_TAG

mkdir -p $PROJECT_HOME/docker-build
docker container cp $PROJECT_CONTAINER_NAME:/home/gradle/grooven $PROJECT_HOME/docker-build/
