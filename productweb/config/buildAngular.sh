#!/usr/bin/env bash

echo "build angular Started ...."
pwd
ls -l

### compile angular
cd ../angularUI/product-ui
pwd
ls -l

ng build --prod

pwd
### copy angular scripts to static folder
cp -a ./dist/product-ui/. ../../src/main/resources/static

echo "build angular completed ...."