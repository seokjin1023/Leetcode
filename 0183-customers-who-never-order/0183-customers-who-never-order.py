import pandas as pd

def find_customers(customers: pd.DataFrame, orders: pd.DataFrame) -> pd.DataFrame:
    merged = pd.merge(customers, orders, left_on='id', right_on='customerId', how='left')
    no_order = merged[merged['customerId'].isna()]
    return no_order[['name']].rename(columns={'name': 'Customers'})
    