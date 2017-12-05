def getSite(line):
    partes=line.split(";")
    return partes[0]
#print getSite("Hao123;hao123.com;")

#def getDomain(line):
#    partes=line.split(";")
#    return partes[1]
#print getDomain("YouTube;youtube.com;3")

def getRanking(line):
    partes=line.split(";")
    print partes
    if(partes[2]!="\n" and partes[2]!=""):
        return int(partes[2])
    else:
        return -1

#print getRanking("Hao123;hao123.com;")
#

def getRankingAl(line):
    partes=line.split(";")
    if(partes[3]!=""):
        return partes[3]
    else:
        return -1
#print getRankingAl("Hao123;hao123.com;dwfr;")
#def getType(line):
#    g=open("Alexa.csv","r")
#    lista=[]
#    datos=g.readlines()
#    partes=datos[line].split(";")
#    lista.append(partes[2])
#    return lista
#print getType(1)

#def getContent(inputfile):
#    f=open(inputfile,"r")
#    datos=f.readlines()
#    lista1=[]
#    for i in range(1,len(datos)):
#        if(getRanking(datos[i])!=str(-1)):
#            lista1.append(datos[i])
#    return lista1
#print getContent("SimilarWeb.txt")

def getAllCont(inputfile):
    f=open(inputfile,"r")
    datos=f.readlines()
    lista2=[]
    for i in range(1,len(datos)):
        lista2.append(datos[i])
    return lista2
#print getAllCont("SimilarWeb.txt")
#
##def getLine(l,s):
##    for i in range(1,len(l)):
##        if(getSite(l[i])==s):
##            return l[i]
def getDatosAl(a):
    g=open("Alexa.csv","r")
    datos=g.readlines()
    for i in range(1,len(datos)):
        partes=datos[i].split(";")
        if(partes[0]==a):
            return datos[i]
getDatosAl("Yahoo!")
#print getLine(getAllCont("SimilarWeb.txt"),"Facebook")
#
#def createLine(L):
#    cadena=""
#    ult=L[len(L)-1]
#    for i in range(0,len(L)-1):
#        cadena=cadena+L[i]+"-"
#    cadena=cadena+ult
#    return cadena
#print createLine(["Shangai","Asia","Pirate"])
#
def compareRanks(inputfile1,inputfile2,output):
    f=open(inputfile1,"r")
    g=open(inputfile2,"r")
    h=open(output,"w")
    datos=f.readlines()
    datos2=g.readlines()
    h.write("WebSite-Alexa Rank.SimilarWeb rank"+"\n")
    for i in range(1,len(datos)):
        if getRanking(datos[i])!=-1:
            print datos[i]
            print getRanking(datos[i])
            a=getSite(datos[i])
            linea=getDatosAl(a)
            h.write(getSite(datos[i])+" "+str(getRanking(datos[i]))+" "+getRankingAl(linea))
    f.close()
    g.close()
    h.close()

compareRanks("SimilarWeb.txt","Alexa.csv","inCommon.txt")













