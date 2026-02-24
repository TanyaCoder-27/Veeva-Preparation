#!/bin/bash

read -p "enter filename: " fname

# search file in current directory
if [ -f "$fname" ]; then
    echo "file exists in current directory"
else
    echo "file not found"
fi

# search file in entire system
result=find /mnt -name "$fname" 2>/dev/null

if [ -n "$result" ]; then
    echo "file found in system at $result"
else
    echo "file not found"
fi

#modified last 3 days

modified =$(find . -type f -mtime -3)

if [ -n "$modified" ]; then
    echo "$modified"
else
    echo "files not modified last 3 days"
fi

#larger than 1kb

l=$(find . -type f -size +1k)

if [ -n "$l" ]; then
    echo "$l"
else
    echo "files not found > 1kb"
fi

#specific extension
read -p "enter extension:" ext


efiles=$(find . -type f -name "*.$ext")

if [ -n "$efiles" ]; then
    echo "$efiles"
else
    echo "no files found with that extension"
fi
