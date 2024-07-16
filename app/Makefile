.DEFAULT_GOAL := build-run

setup:
	./gradlew wrapper --gradle-version 8.5

clean:
	./gradlew clean

build:
	./gradlew clean build

install:
	./gradlew clean install

run-dist:
	./build/install/app/bin/app 

run-dist-files:
	./build/install/app/bin/app -f=stylish file1.json file2.json

run-stylish:
	./build/install/app/bin/app -f stylish file1_.json file2_.json

run-plain:
	./build/install/app/bin/app -f plain file1_.json file2_.json

run-json:
	./build/install/app/bin/app -f json file1_.json file2_.json

run:
	./gradlew run

test:
	./gradlew test

report:
	./gradlew jacocoTestReport

lint:
	./gradlew checkstyleMain

build-run: build run

.PHONY: build