#!/bin/bash

export ANDROID_SDK_ROOT=~/android/.sdk/sdk
export JAVA_HOME=/opt/jdk1.8.0_102
export PATH=${JAVA_HOME}/bin:${ANDROID_SDK_ROOT}/build-tools/21.1.1:${ANDROID_SDK_ROOT}/platform-tools:${PATH}

# build for 32bit
export ANDROID_ARCH=arm
export ANDROID_ABI=armeabi-v7a
export ANDROID_API_LEVEL=21
export ANDROID_LIBDIR=/system/lib

#pushd test && npm run build && popd
make check
