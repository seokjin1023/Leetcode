import pandas as pd

def article_views(views: pd.DataFrame) -> pd.DataFrame:
    Ids = views[views['author_id'] == views['viewer_id']][['author_id']].sort_values(by=['author_id']).drop_duplicates()
    return Ids.rename(columns={'author_id': 'id'})

    
    