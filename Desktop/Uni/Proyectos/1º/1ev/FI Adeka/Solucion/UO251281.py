def separarInvitacion(linea):
    """Esta funcion separa la linea pasada por parametro y devuelve por quien ha sido invitada la persona"""
    separar=linea.split(";")
    limpio=separar[2]
    return limpio

def separarAdultos(linea):
    """Esta funcion separa la linea pasada por parametro y devuelve el numero de adultos de esa invitacion"""
    separar=linea.split(";")
    limpio=separar[5]
    return limpio

def separarMenores(linea):
    """Esta funcion separa la linea pasada por parametro y devuelve el numero de menores de esa invitacion"""
    separar=linea.split(";")
    limpio=separar[6].rstrip("\n")
    return limpio


def invitados(filename):
    """Esta funcion recibe como parametro un fichero con la lista de invitados, adultos, menores, etc
    Devuelve el numero total de invitados, el numero de adultos, menores, el coste total del banquete y el numero de invitados por la novia
    y el novio
    Posteriormente escribe esta informacion en un fichero csv"""
    #Declaracion de contadores y listas
    listaT=[]
    cont=0
    contA=0
    contM=0
    contNA=0
    contNO=0
    total=0
    #Abrimos los ficheros de lectura y escritura
    f=open(filename,"r")
    f1=open("resumen.csv","w")
    #Pasamos las lineas a una lista para facilitar su uso
    for linea in f:
        listaT.append(linea)
    #Recorremos cada elemento de la lista y vamos incrementando los diferentes contadores, se empieza desde 1 para evitar la cabecera del excel
    for i in range(1,len(listaT),1):
        contA=contA+int(separarAdultos(listaT[i])) #Contador de adultos
        contM=contM+int(separarMenores(listaT[i])) #Contador de menores
        if(separarInvitacion(listaT[i])=="Novia"): #Contador de invitados por la novia
            contNA=contNA+1
        else:                                      #Contador de invitados por el novio
            contNO=contNO+1
    cont=contA+contM                               #Numero total de invitados, correspondiente al total de menores y adultos que han confirmado asistencia
    total=(contA*27+contM*27*0.67)*1.21            #Precio total del banquete aplicando IVA

    #Escribimos
    f1.write(str(cont)+";"+str(contA)+";"+str(contM)+"\n")
    f1.write(str(total).replace(".",",")+"\n")
    f1.write(str(contNA)+";"+str(contNO)+"\n")

    #Cerramos
    f.close()
    f1.close()
    return cont,contA,contM,total,contNA,contNO

a=invitados("boda.csv")
print a