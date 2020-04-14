#!/usr/bin/env bash


function site() {
  ./mvnw -e clean install site site:deploy
}

function run() {
    ./mvnw
}

function main() {
    #run
    site
}

main
