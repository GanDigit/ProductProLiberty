#!/usr/bin/env bash

cd ..

cloudctl login -a https://9.121.242.180:8443 --skip-ssl-validation

cloudctl catalog delete-chart --name productpro-liberty