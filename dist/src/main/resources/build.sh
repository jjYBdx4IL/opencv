#!/bin/bash

set -o pipefail
set -Eex

basedir=$1
version=$2
shift 2

cd $basedir/target/winlibs
rm -rf $basedir/target/winlibs/opencv
7z x -bb1 opencv.exe opencv/build/java

destdir=$basedir/target/classes/win32-x86-32
install -d $destdir
cp -f opencv/build/java/x86/opencv_java${version//\./}.dll $destdir/opencv.dll

destdir=$basedir/target/classes/win32-x86-64
install -d $destdir
cp -f opencv/build/java/x64/opencv_java${version//\./}.dll $destdir/opencv.dll

#install -d $basedir/target/src
#cd $basedir/target/src
#jar xf $basedir/target/winlibs/opencv/build/java/opencv-${version//\./}.jar
#find . -type f -name '*.class' -exec rm '{}' \;

destdir=$basedir/target/classes/linux-x86-64
cd $basedir/target/linuxlibs/opencv-${version}
rm -rf build
mkdir build
cd build
# we need ant for JNI build
which ant
cmake .. -DCMAKE_TOOLCHAIN_FILE=../platforms/linux/gnu.toolchain.cmake -DBUILD_SHARED_LIBS=OFF
make -j$(grep ^proc /proc/cpuinfo | wc -l)
install -d $destdir
cp -f lib/libopencv_java${version//\./}.so $destdir/libopencv.so

install -d $basedir/target/src
cd $basedir/target/src
jar xf $basedir/target/linuxlibs/opencv-${version}/build/bin/opencv-${version//\./}.jar
find . -type f -name '*.class' -exec rm '{}' \;
