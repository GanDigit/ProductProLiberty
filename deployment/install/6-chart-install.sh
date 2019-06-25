#!/usr/bin/env bash
echo 'installation started '

helm install --name productpro-liberty-helm ../productpro-liberty --tls

echo 'installation completed'
