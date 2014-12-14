#S3 Material Poller Plugin for Go-CD
====================================

Plugin that allows S3 storage to be used as dependency materials in pipelines in Go-CD.


##Build
=======

You need the go-plugin-api*jar in your local m2 cache. It's not published at maven central. You should ideally be using the same jar that your Go server uses to ensure compatibility. After you catch hold of the jar, please run the following command to setup the jar in your local m2 repo cache.
```
mvn install:install-file -Dfile=<JAR_FILE_LOCATION> -DgroupId=com.thoughtworks.go -DartifactId=go-plugin-api -Dversion=<JAR_VERSION> -Dpackaging=jar
```
