#!/bin/bash

dir='/Users/xiangla/testA'
key='6f91e092082ecad1cd4c2dc01e2d891a'
m3u8='https://hls.videocc.net/c7d3982d0d/7/c7d3982d0d4078f039ddcce0847c9c37_2.m3u8?pid=1600049625555X1017426&device=desktop'

mkdir -p ${dir}/tmp

cd ${dir}/tmp

iv='';

for line in `curl $m3u8` ; do
    if [[ $line == http* ]]; then
        echo $line;
        axel --no-clobber -a -o $dir/tmp $line;
    fi;
    if [[ $line == *IV* ]]; then
        iv=${line:0-32};
    fi;
done

echo $iv

mkdir -p ${dir}/tmp/one

for f in *; do g=$(echo $f | sed 's/^.*_2_/00/g') ;tmp=${g%.*}.ts ;cp $f ${dir}/tmp/one/${tmp:0-6} ; done;

cat  ${dir}/tmp/one/*.ts > ${dir}/tmp/one/combine.ts  

openssl aes-128-cbc -d -in ${dir}/tmp/one/combine.ts -out  ${dir}/tmp/one/test.ts  -nosalt -iv $iv -K $key

mv ${dir}/tmp/one/test.ts ${dir}

rm -rf ${dir}/tmp
