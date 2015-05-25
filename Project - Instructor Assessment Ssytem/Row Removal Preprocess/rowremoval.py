## Pratik Jaiswal
## CSC 869: Data Mining, Dr. Hui Yang
## Term Project

# Python program to remove rows that contain incomplete information

# usage: python rowremoval.py

infileName = "instructor.data"
outfileName = "trim.data"
Error = ["Other","Rejected","Unknown"]  # Terms that I don't want in our dataset.


# Open input and output files
infile = open(infileName, 'r')
outfile = open(outfileName, 'w')

# Run through the rows
for line in infile:
    if line != "\n" and line != "\r\n":       # skip blank lines
        if Error[0] not in line and Error[1] not in line and Error[2] not in line:
            outfile.write(line)
            
# Close the files
infile.close()
outfile.close()

# Printing the name of file that is created
print outfileName ,' is created!'