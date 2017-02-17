# This will be the main part of the program
# that actually builds the schedule
class Course(object):

    # Initialize object
    def __init__(self, name, hours, diff_rate, time_consump, rating):
        self.name = name
        self.hours = hours
        self.diff_rate = diff_rate
        self.time_consump = time_consump
        self.rating = rating

    # Returns string of info for each class so we can print them
    def __str__(self):
        # return "%s, %s, %s, %s" %(self.name, self.hours, self.diff_rate, self.time_consump)
        return str(self.name)

def main():
    # Open file
    in_file = open("./test.txt" , "r")

    # Get rid of headers
    for i in range(4):
    	in_file.readline()

    lst = [] # List of courses
    plan = {} # Dictionary of semester:course to take

    # Parses through file and creates instances of Course class
    for line in in_file:
        line = line.strip()
        line = line.split(", ")
        name = Course(line[0], int(line[1]), int(line[2]), int(line[3]), (int(line[2]) + int(line[3])) / 2)
        lst.append(name)

    # Close file
    in_file.close()

    # Sorts by rating from largest to smallest
    for i in range(len(lst)):
        for j in range(i):
            if lst[i].rating > lst[j].rating:
                lst[i], lst[j] = lst[j], lst[i]

    # Prints course and its rating
    for item in lst:
        print(item, item.rating)

    num_semesters = int(input("enter # of semesters: "))
    plan = {}

    for i in range(num_semesters):
        plan[i + 1] = []

    i, j = 0, 1
    while i < len(lst):
        plan[j].append(lst[i])
        j += 1
        i += 1
        if j == num_semesters + 1:
            j = 1

    for key in plan:
        print(key,':', end = ' ')
        for x in plan[key]:
            print(x, end = " ")
        print()


main()
