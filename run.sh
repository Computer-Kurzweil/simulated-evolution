#!/usr/bin/env bash



function site() {
  ./mvnw clean dependency:list install site site:deploy
}

function run() {
    ./mvnw
}

function main() {
    #run
    site
}

main
