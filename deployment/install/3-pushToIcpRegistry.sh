#!/usr/bin/env bash

cd ..

cloudctl login -a https://9.121.242.180:8443 --skip-ssl-validation

cloudctl catalog load-chart --archive productpro-liberty-0.1.0.tgz
