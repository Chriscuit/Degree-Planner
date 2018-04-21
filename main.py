
# This will be the main part of the program
# that actually builds the schedule
class Course:

    # Initialize object
    def __init__(self, name, hours, diff_rate, time_consump, rating, pre_reqs):
        self.name = name
        self.hours = hours
        self.diff_rate = diff_rate
        self.time_consump = time_consump
        self.rating = rating
        if pre_reqs == ['None']:
            self.pre_reqs = []
        else:
            self.pre_reqs = pre_reqs

    # Returns string of info for each class so we can print them
    def __str__(self):
        # return "%s, %s, %s, %s" %(self.name, self.hours, self.diff_rate, self.time_consump)
        return str(self.name)

class Semester:

    def __init__(self, number):
        self.number = number
        self.class_lst = []
        self.total_rating = 0

    def __str__(self):
        # return "%s, %s, %s, %s" %(self.name, self.hours, self.diff_rate, self.time_consump)
        return str(self.number + 1)

def read_courses():
    import csv

    lst = []    # List of list

    # Parses through file and makes list of list
    in_file = open('test.csv', 'r')
    reader = csv.reader(in_file)
    header = next(reader)
    for line in reader:
        course = Course(line[0],          # Name
                      int(line[1]),     # Hours
                      int(line[2]),     # Difficulty rating
                      int(line[3]),     # Time consumption
                      (int(line[2]) + int(line[3])) / 2,    # Overall rating
                      line[4].split(', '))    # list of pre-reqs

        lst.append(course)
    in_file.close()

    # Sorts to prioritize largest ratings so that small ones can be used for evening out
    lst = sorted(lst, key=lambda Course: Course.rating, reverse=True)

    # Prints course and its rating
    for item in lst:
        print(item, item.rating)

    return lst

def sort(lst):

    from copy import deepcopy
    # Inputing number of semesters and initializing plan of Semesters
    num_semesters = int(input("enter # of semesters: "))
    plan = []

    for i in range(num_semesters):
        plan.append(Semester(i))

    # Adding classes to semesters to minimize differences in difficulty
    plan_in_order = deepcopy(plan)
    for i in range(len(lst)):
        plan = sorted(plan, key=lambda Semester: Semester.total_rating)
        plan[0].class_lst.append(lst[i])
        plan[0].total_rating += lst[i].rating

    plan = sorted(plan, key=lambda Semester: Semester.number)

    # Printing Semesters and corresponding classes
    for i in range(len(plan)):
        print(plan[i],':', plan[i].total_rating, end = ' ')
        for x in plan[i].class_lst:
            print(x, end = " ")
        print()

    return plan

# Checks if you have taken pre-reqs, returns bool
# def pre_req_helper(plan_in_order, plan, course):
#
#     current_sem = plan[0].number
#     classes_taken = []
#
#     for i in range(current_sem):
#         classes_taken += plan_in_order[i].class_lst
#
#     return all(x in classes_taken for x in course.pre_reqs)


def main():

    lst = read_courses()
    sort(lst)

main()

'''
1) add algorithm for handling prerequisits
2) algo for handling hardcoded class placements
3) algo for handling semester availabilities
4) conflicting classes
5) change input to excel sheet
'''




