import pandas as pd

courses = pd.read_csv("../courseInfo.csv")
names = courses["Courses"]
for name in names:
	print('\"{}\",'.format(name))
