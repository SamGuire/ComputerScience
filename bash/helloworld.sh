#!/bin/bash
echo 'Hello world'
total=0
values=(1 2 3)
for v  in  ${values[@]}
do 
	echo $v
	total=$(($total+v))
done
 echo $total
