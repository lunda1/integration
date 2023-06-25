#!/usr/bin/env bash

set -eu

rm -f ./.git/hooks/pre-commit
rm -f ./.git/hooks/pre-push

cp ./scripts/pre-push.sh ./.git/hooks/pre-push

echo 'Add pre-push.sh successfully!'
