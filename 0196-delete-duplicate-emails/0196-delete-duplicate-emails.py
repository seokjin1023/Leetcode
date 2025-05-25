import pandas as pd

def delete_duplicate_emails(person: pd.DataFrame) -> None:
    min_ids = person.groupby('email')['id'].min()
    person.drop(person[~person['id'].isin(min_ids)].index, inplace=True)