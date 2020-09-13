#!/bin/bash
docker build -t product:1.0 .
docker run -d -p 8082:8082 --name product product:1.0