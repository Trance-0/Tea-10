import os
from pathlib import Path
import pandas as pd

df = pd.read_csv(
            os.path.join(Path(__file__).resolve().parent, "profile.csv"),
            sep=",",
        )

def law(row):
    return row['over']-abs(abs(row['over']-row['frag'])-abs(row['over']-row['step']))

df['prog']=df.apply(law, axis=1)
df['prog_standardized']=df.apply(lambda row:row['prog']/50, axis=1)

print(df.sort_values('prog',ascending = False).head(5))