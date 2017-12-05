##listas 2 
##pruebas iniciales 1

texto= "Esto es una prueba"
fecha=  "16/10/2000"

###ej 1
###ap 1
#print len(texto)
###ap 2
#print fecha + "-" + texto
###ap 3
#if("prueba" in texto):
#    print "si"
#if("esto" in texto):
#    print "tambien"

##ap 4
#print(texto.split())
#print(texto.split("e"))

##ap 5
#print(fecha.split("/"))

##ap 6
#print(texto.replace("es", "era"))

### ej 2
#ap 7
f=open("Entorno.txt","r")
#ap 8
datos=f.readlines()
print(datos)
#ap 9
print(len(datos))
print(len(datos[0]))
print(datos[0])
##ap 10
linea=datos[0].rstrip()
print (linea)

##Ej 2
##ap1
def abrirDatos():
    f=open("datos.txt")
    lista=[]
    for linea in f:
        lista.append(int(linea))    
        suma=sum(lista)
    print(suma)
abrirDatos()

##ap 2
##punto 1
#def cambiosAlumnos():
#    w=open("alumnos.txt")
#    lista1=[]
#    for linea in w:
#        lista1.append(str(linea))
#    a=len(lista1)
#    print a
#cambiosAlumnos()
#
##punto 2
#
#def cambiosAlumnos2(linea,apellido):
#    
#    trozos=linea.split(",")
#    apellidos=trozos[0].split()
#    if(apellidos[0]== apellido or apellidos[1]==apellido):
#        return  True
#    else:
#        return False
#        
#cambiosAlumnos2("Lopez Alvarez, Andres", "Lopez")
#
###punto 3
#
#def busquedaAlumnos():
#    cont=0
#    q=open("alumnos.txt","r")
#    listA=[]
#    for linea in q:
#        listA.append(str(linea))
#  
#        if cambiosAlumnos2(linea,"Fernandez")==True:
#            cont=cont+1
#    print cont
#    
#    porcentaje=(100*cont)/len(listA)
#    print porcentaje
#    
#busquedaAlumnos()

##punto 4

#def numNombre():
#    w=open("alumnos.txt")
#    lista1=[]
#    listaDeNombres=[]
#    for linea in w:
#        lista1.append(str(linea))
#    num=int(raw_input("dame numeros"))
#    if(num<=len(lista1)):
#        a=lista1[num]
#        trozos=a.split(",")
#        nombres=trozos[1].split()
#        for i in nombres:
#            listaDeNombres.append(str(nombres))
#        print len(listaDeNombres)
#numNombre()

###punto 5
#def numerosDeNombres():
#    cont=0
#    cont1=0
#    cont2=0
#    cont3=0
#    cont4=0
#    cont5=0
#    cont6=0
#    w=open("alumnos.txt")
#    lista1=[]
#    listaDeNombres=[]
#    listaFinal=[]
#    for linea in w:
#                trozos=linea.split(",")
#                nombres=trozos[1].split()
#            if (len(nombres)==1):
#                cont=cont+1
#            if (len(nombres)==2):
#                 cont1=cont1+1
#            if len((nombres)==3):
#                 cont2=cont2+1
#            if len((nombres)==4):
#                 cont3=cont3+1
#            if len((nombres)==5):
#                 cont4=cont4+1
#            if len((nombres)==6):
#                 cont5=cont5+1
#            if len((nombres)==7):
#                 cont6=cont6+1
#        print("el numero de nombres simples es: "+cont)
#        print("el numero de nombres dobles es: "+cont1)
#        print("el numero de nombres triples es: "+cont2)
#        print("el numero de nombres cuadruples es: "+cont3)
#        print("el numero de nombres quintuples es: "+cont4)
#        print("el numero de nombres sextuples es: "+cont5)
#        print("el numero de nombres septuples es: "+cont6)
#numerosDeNombres()
            
        
        
        
    
