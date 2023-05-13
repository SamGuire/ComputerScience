from collections import deque
from flask import Flask, request, jsonify
from mysql.connector import Error
import csv

TABLES = {}
TABLES['users'] = {'creation_statement': """
        CREATE TABLE IF NOT EXISTS twitter_db.users (
            id integer primary key
        );
""",
                   'path': './data/users.csv',
                   'insertion_statement': """
                        INSERT INTO twitter_db.users (id) values (%s)
                     """
                   }

TABLES['tweets'] = {'creation_statement': """
        CREATE TABLE IF NOT EXISTS twitter_db.tweets (
            sender_id integer,
            content text,
            tweet_created_date datetime,
            constraint fk_sender_id
            foreign key (sender_id) references twitter_db.users(id)
        );
""",
                    'path': './data/tweets.csv',
                    'insertion_statement': """
                        INSERT INTO twitter_db.tweets (sender_id,content,tweet_created_date) values (%s,%s,%s)
                     """
                    }

TABLES['follows'] = {'creation_statement': """
        CREATE TABLE IF NOT EXISTS twitter_db.follows (
            follower_id integer,
            followee_id integer,
            constraint fk_follower_id
            foreign key (follower_id) references twitter_db.users(id),
            constraint fk_followee_id
            foreign key (followee_id) references twitter_db.users(id)
        );
""",
                     'path': './data/users.csv',
                     'insertion_statement': """
                        INSERT INTO twitter_db.follows (follower_id,followee_id) values (%s,%s)
                     """
                     }


def generate_insert_statement(table, data_dict):
    columns = ", ".join(data_dict.keys())
    values = list(data_dict.values())
    # If there are 5 values -> return "%s, %s, %s, %s, %s"
    placeholders = ", ".join(["%s"]*len(values))
    parameterized_query = "INSERT INTO twitter_db.%s (%s) values (%s)".format(
        table, columns, placeholders)
    return parameterized_query


def create_tables(cnx):
    for table in TABLES:
        try:
            cur = cnx.cursor()
            cur.execute(TABLES[table]['creation_statement'])
            print(f'Successfully created {table} table...')
        except Error as e:
            print(f'Error creating {table} table...\n {e}')
        finally:
            cur.close()


def insert_data_into_tables(cnx, data):
    order_of_insertion = ['users', 'tweets', 'follows']
    for table in order_of_insertion:
        try:
            cur = cnx.cursor()
            cur.executemany(
                TABLES[table]['insertion_statement'], data[table])
            cnx.commit()
            print(f'Successfully inserted data into {table} table...')
        except Error as e:
            print(f'Error inserting into {table} table...\n {e} \n')
        except Exception as e:
            print(f'Something went wrong...\n {e} \n')
        finally:
            cur.close()
