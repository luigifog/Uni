#-------------------------------------------------------------------------------
# Name:        module1
# Purpose:
#
# Author:      adeka
#
# Created:     03/06/2016
# Copyright:   (c) adeka 2016
# Licence:     <your licence>
#-------------------------------------------------------------------------------

def getContent (filename):
    f1=open(filename,"r")
    list=[]
    for line in f1:
        line=line[:-1]
        line= line.lstrip("[")
        list.append(line)

    return list

print getContent("dialCodes.json")
