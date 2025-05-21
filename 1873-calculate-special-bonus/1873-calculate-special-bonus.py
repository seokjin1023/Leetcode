import pandas as pd

def is_odd(id):
    if id % 2 == 0:
        return False
    return True

def notfirstm(name):
    if name.startswith("M"):
        return False
    return True

def calculate_special_bonus(employees: pd.DataFrame) -> pd.DataFrame:
    employees.loc[~(employees['employee_id'].apply(is_odd) & employees['name'].apply(notfirstm)), 'salary'] = 0
    employees.rename(columns={'salary': 'bonus'}, inplace=True)
    return employees[['employee_id', 'bonus']].sort_values(by='employee_id').reset_index(drop=True)