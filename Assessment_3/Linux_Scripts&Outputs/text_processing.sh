#!/bin/bash

#Text Processing & Pattern Search

read -p "enter text filename:" file

if [ ! -f "$file" ]; then
    echo "file not found."
else
    read -p "enter string to search: " str
    grep -n "$str" "$file"
fi


read -p "enter html filename: " html
if [ ! -f "$html" ]; then
    echo "file not found."
else
    read -p "enter tag name: " tag
    
    sed -n "s:.*<$tag>\(.*\)</$tag>.*:\1:p" "$html"
fi
