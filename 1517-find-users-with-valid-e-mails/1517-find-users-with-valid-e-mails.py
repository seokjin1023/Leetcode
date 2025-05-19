import pandas as pd

def is_valid(mail):
    domain = "@leetcode.com"
    if not mail[0].isalpha():
        return False
    if not mail.endswith(domain):
        return False
    
    prefix = mail[:-len(domain)]
    if len(prefix) == 0 or not prefix[0].isalpha():
        return False
    
    for char in prefix:
        if not (char.isalpha() or char.isdigit() or char in ['_', '.', '-']):
            return False
    return True

def valid_emails(users: pd.DataFrame) -> pd.DataFrame:
    return users[users['mail'].apply(is_valid)]