#!/usr/bin/env bash

set -eu

get_branch=`git symbolic-ref --short -q HEAD`
echo 'current branch: ' $get_branch

echo 'start run checkstyle'
./gradlew checkstyleMain

echo 'start run test'
./gradlew clean test

echo 'hook pre-push successfully!'
