#!/bin/bash
echo Database:
read database
echo Username:
read username
echo Password:
read password
echo Tar file location:
read file_location
pg_restore -d "postgresql://$username:$password@127.0.0.1/$database" $file_location
