from flask import Flask, request, jsonify
from mysql.connector import connect, cursor, Error
from dotenv import load_dotenv
import os
from table import create_tables, insert_data_into_tables
from generate_data import generete_data


load_dotenv()
mysql_connection = {
    "user": os.getenv("MYSQL_USER"),
    "password": os.getenv("MYSQL_PASSWORD"),
    "host": os.getenv("MYSQL_HOST")
}
print(f'MySQL values being used: \n\t {mysql_connection}\n')


def create_db(cnx):
    DROP_DB_STATEMENT = """
        DROP DATABASE IF EXISTS twitter_db;
    """
    INIT_DB_STATEMENT = """
        CREATE DATABASE IF NOT EXISTS twitter_db;
    """

    try:
        cur = cnx.cursor()
        cur.execute(DROP_DB_STATEMENT)
        print('Database dropped for reinitialization...')
        cur.execute(INIT_DB_STATEMENT)
        print("twitter_db initialized...")
    except Error as e:
        print('Error creating twitter_db...\n ', e)
    finally:
        cur.close()


if __name__ == '__main__':
    try:
        cnx = connect(**mysql_connection)
        BAR = "#"*30
        print(f'{BAR} INITIALIZATION {BAR}\n')
        create_db(cnx)
        create_tables(cnx)
        print(f'\n{BAR} MOCK DATA CREATION {BAR}\n')
        data = generete_data(10000, 75, 30)
        print(f'\n{BAR} MOCK DATA INSERTION {BAR}\n')
        insert_data_into_tables(cnx, data)
        print(f'\n{BAR} END {BAR}\n')
        print('DATA READY FOR EXPERIMENTATION !')
    except Error as e:
        print(f'Error in main creation procedure related to db...\n {e}\n')
    except Exception as e:
        print(f'Something went wrong, not related to db...\n {e}\n')
    finally:
        cnx.close()
