import pandas as pd

def check_diab(conditions):
    splitConditions = conditions.split(" ")
    for condition in splitConditions:
        if condition.startswith("DIAB1"):
            return True
    return False

def find_patients(patients: pd.DataFrame) -> pd.DataFrame:
    return patients[patients['conditions'].apply(check_diab)]