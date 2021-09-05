#!/bin/bash

# The root directory for the project
ROOT_DIR="$(dirname $0)/.."
echo "Project root directory detected as $ROOT_DIR"

# This can be adjusted to the wanted repository, branch and gradle property
GRADLE_PROPERTY="purpurRef"
REPOSITORY="pl3xgaming/Purpur"
BRANCH="ver/1.17.1"

# Print out the information which will be used for updating to the runner.
echo "Will be updating property $GRADLE_PROPERTY from repository $REPOSITORY in branch $BRANCH."

# Curl the branch information and parse the commit hash using python
LATEST_COMMIT=$(curl -s "https://api.github.com/repos/$REPOSITORY/branches/$BRANCH" | python -c 'import sys, json; print(json.load(sys.stdin)["commit"]["sha"])')
echo "Curled latest commit hash of $REPOSITORY in $BRANCH: $LATEST_COMMIT."

# Replace in the gradle.properties file the old commit hash with the new one
perl -pi -e "s/$GRADLE_PROPERTY = [0-9a-z]{40}/$GRADLE_PROPERTY = $LATEST_COMMIT/g" "$ROOT_DIR/gradle.properties"
echo "Replaced old commit hash in gradle.properties with $LATEST_COMMIT."
