#numero total de personas, separando adultos, niños y en total
def ap1y2():
    fr=open("resumen.csv","w")
    f=open("boda.csv","r")
    datos=f.readlines()
    numAd=0
    numMen=0
    costeSinIVA=0
    for i in range(1,len(datos)):
        col=datos[i].split(";")
        numAd=float(col[5])+numAd
        numMen=float(col[6])+numMen
    numTot=numAd+numMen  
#ap2
    costeSinIVA=numAd*27+(numMen*27*0.67)
    costeTot=costeSinIVA*0.21
    fr.write("numero de adultos: "+str(numAd)+";"+"numero de menores: " +";"+str(numMen)+";"+"numero de gente en total: "+str(numTot)+"\n")
    fr.write("El coste total es: "+str(costeTot)+"\n")
    f.close()
    fr.close()
ap1y2()
#ap3
#Que invitados fueron por la novia o el novio
def ap3():
    fr=open("resumen.csv","a ")
    invNovia=0
    invNovio=0
    f=open("boda.csv","r")
    datos=f.readlines()
    for i in range(1,len(datos)):
        col=datos[i].split(";")
        if(col[2]=="Novia"):
            invNovia=invNovia+1
        else:
            invNovio=invNovio+1
    fr.write("los invitados de la novia son: "+str(invNovia)+"los invitados del novio son. "+str(invNovio))
    f.close()
    fr.close()
ap3()

