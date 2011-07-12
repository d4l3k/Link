cp ./src/plugin.yml ./bin/
cd bin
zip -r ../Link.jar *
cd ../../
cp -f ./Link/Link.jar ./BukkitServer/plugins/
cd BukkitServer
java -jar craftbukkit-0.0.1-SNAPSHOT.jar
