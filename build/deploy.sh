(cd ../simpledbm-network/code/simpledbm-network-server/ && mvn assembly:assembly)
(cd ../simpledbm-network/code/simpledbm-network-client/ && mvn assembly:assembly)
cp ../simpledbm-network/code/simpledbm-network-server/target/simpledbm-network-server-1.0.18-SNAPSHOT-jar-with-dependencies.jar ../simpledbm-samples/code/forum/simple-forum-db/lib
cp ../simpledbm-network/code/simpledbm-network-client/target/simpledbm-network-client-1.0.18-SNAPSHOT-jar-with-dependencies.jar ../simpledbm-samples/code/forum/simple-forum-createdb/lib
cp ../simpledbm-network/code/simpledbm-network-client/target/simpledbm-network-client-1.0.18-SNAPSHOT-jar-with-dependencies.jar ../simpledbm-samples/code/forum/simple-forum/war/WEB-INF/lib

