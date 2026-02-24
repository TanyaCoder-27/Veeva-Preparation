#!/bin/bash

#Log a normal message
read -p "enter message:" msg
echo "$msg" >> log.txt


#Log errors to separate file
read -p "enter filename to check:" fname
ls "$fname" 2>> error.log

