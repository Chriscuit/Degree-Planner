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

class Semester(object):

    def __init__(self, number):
        self.number = number
        self.class_lst = []
        self.total_rating = 0

    def __str__(self):
        # return "%s, %s, %s, %s" %(self.name, self.hours, self.diff_rate, self.time_consump)
        return str(self.number + 1)


def main():
    # Open file
    in_file = open("./test.txt" , "r")

    # Get rid of headers
    for i in range(4):
        in_file.readline()

    lst = [] # List of courses

    # Parses through file and creates instances of Course class
    for line in in_file:
        line = line.strip()
        line = line.split(", ")
        name = Course(line[0], int(line[1]), int(line[2]), int(line[3]), (int(line[2]) + int(line[3])) / 2)
        lst.append(name)

    # Close file
    in_file.close()

    # Sorts to prioritize largest ratings so that small ones can be used for evening out
    lst = sorted(lst, key=lambda Course: Course.rating, reverse=True)

    # Prints course and its rating
    for item in lst:
        print(item, item.rating)

    # Inputing number of semesters and initializing plan of Semesters
    num_semesters = int(input("enter # of semesters: "))
    plan = []

    i = 0
    while i < num_semesters:
        plan.append(Semester(i))
        i += 1

    # Adding classes to semesters to minimize differences in difficulty
    i = 0
    while i < len(lst):
        plan = sorted(plan, key=lambda Semester: Semester.total_rating)
        plan[0].class_lst.append(lst[i])
        plan[0].total_rating += lst[i].rating
        i += 1
    plan = sorted(plan, key=lambda Semester: Semester.number)

    # Printing Semesters and corresponding classes
    i = 0
    while i < len(plan):
        print(plan[i],':', plan[i].total_rating, end = ' ')
        for x in plan[i].class_lst:
            print(x, end = " ")
        print()
        i += 1

    '''
    1) add algorithm for handling prerequisits
    2) algo for handling hardcoded class placements
    3) algo for handling semester availabilities
    4) conflicting classes
    5) change input to excel sheet
    '''



main()
