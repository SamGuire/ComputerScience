from collections import deque
from lorem_text import lorem
import random
import time
from datetime import date, timedelta
import csv


def random_datetime(start_datetime: str, end_datetime: str, date_format: str):
    parsed_start_datetime = time.strptime(start_datetime, date_format)
    parsed_end_datetime = time.strptime(end_datetime, date_format)

    start_datetime_in_sec = time.mktime(parsed_start_datetime)
    end_datetime_in_sec = time.mktime(parsed_end_datetime)

    time_diff_in_sec = end_datetime_in_sec-start_datetime_in_sec

    random_time_in_sec = start_datetime_in_sec + random.random() * time_diff_in_sec
    random_datetime = time.strftime(
        date_format, time.localtime(random_time_in_sec))
    return random_datetime


def generete_data(user_size: int, max_follow_count: int, max_number_of_tweets_per_user: int,):
    print(
        f'Generating twitter_db data to simulate:\n\t user_size = {user_size},\n\t max_follow_count = {max_follow_count},\n\t max_number_of_tweets_per_user = {max_number_of_tweets_per_user}\n')

    users_data = [(i,) for i in range(user_size)]
    print(f'Created user data...')

    follows_data = list()
    for follower_id in range(user_size):
        follows_set = set()
        for _ in range(max_follow_count):
            follows_set.add(random.randint(0, user_size-1))
        for followee_id in follows_set:
            follows_data.append((follower_id, followee_id))

    print(f'Created follows data...')

    tweets_data = list()

    date_format = '%Y-%m-%d %H:%M:%S'
    time_diff = timedelta(weeks=2)
    start_datetime = date.today()-time_diff
    end_datetime = date.today()

    start_datetime_str = start_datetime.strftime(date_format)
    end_datetime_str = end_datetime.strftime(date_format)

    for sender_id in range(user_size):
        number_of_tweets = random.randint(0, max_number_of_tweets_per_user)
        for _ in range(number_of_tweets):
            tweet_created_date = random_datetime(
                start_datetime_str, end_datetime_str, date_format)
            tweets_data.append(
                (sender_id, lorem.sentence(), tweet_created_date))

    print(f'Created tweets data...')

    data = {'users': users_data, 'follows': follows_data, 'tweets': tweets_data}

    with open('./data/users.csv', 'w') as f:
        csv_writer = csv.writer(f)
        csv_writer.writerow(['id'])
        csv_writer.writerows(users_data)

    with open('./data/follows.csv', 'w') as f:
        csv_writer = csv.writer(f)
        csv_writer.writerow(['follower_id', 'followee_id'])
        csv_writer.writerows(follows_data)

    with open('./data/tweets.csv', 'w') as f:
        csv_writer = csv.writer(f)
        csv_writer.writerow(['sender_id', 'content', 'tweet_created_date'])
        csv_writer.writerows(tweets_data)

    print('Data inserted into db can be found in /data directory.\n')
    return data
