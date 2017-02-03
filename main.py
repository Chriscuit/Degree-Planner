#This will be the main part of the program
#that actually builds the schedule
class Course(object):

        #Initialize object
	def __init__(self, name, hours,
                 diff_rate, time_consump):
	    self.name = name
	    self.hours = hours
	    self.diff_rate = diff_rate
	    self.time_consump = time_consump

	#Returns string of info for each class so we can print them
	def __repr__(self):
	    return "%s, %s, %s, %s" %(self.name, self.hours,
                                  self.diff_rate,
                                  self.time_consump)

def main():
	#Open file
	in_file = open("./test.txt" , "r")

	#Get rid of headers
	for i in range(4):
	    in_file.readline()

	#Parses through file and creates instances of Course class
	for line in in_file:
	    line = line.strip()
	    line = line.split(", ")
	    name = Course(line[0], int(line[1]),
                      int(line[2]), int(line[3]))
	    print(name)

        #Close file
        in_file.close()
main()

#test
