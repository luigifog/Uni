##listas 1
##ejercicio 1
#
#lista1=[5,8,10]
#lista2=[3,2,9,12,4]
##apartado 1
#len(lista1)
#len(lista2)
##ap 2
#listisima=lista1+lista2
#len(listisima)

##ap3
#lista1=[5,8,10]
#lista2=[3,2,9,12,4]
#def mayor(lista1,lista2):
#    listaTot=lista1+lista2
#    print max(listaTot)
#mayor(lista1,lista2)

##ap4
#suma=lista1[0]+lista2[0]
#print suma
##ap5
#suma=lista1[2]+lista2[2]
#print suma

##ap6
#lista1=[5,8,10]
#lista1[1]=0
#print lista1

##ap7
#lista2=[3,2,9,12,4]
#lista3 = lista2
#print lista3
##ap8
#lista3[0]=7
#print lista3
##ap9
#print lista2

##ap10
#lista1=[5,8,10]
#for i in range(0,3):
#    a=lista1[i]
#    print a
#
##ap11
#lista2=[3,2,9,12,4]
#for j in range(4,-1,-1):
#    b=lista2[j]
#    print b

##ap12
#lista2=[3,2,9,12,4]
#suma=0
#for j in range(0,5):
#    b=lista2[j]
#    suma=suma+b
#print suma
#
#z=sum(lista2)
#print z




##ejercicio 2 coleccion
#
##ejercico 1
#
#def sumaLista(lista):
#    suma=0
#    for n in lista:
#        suma=suma+n
#    return suma
#    
#lista=[1,2,5,10]
#print"la suma es%i" % sumaLista(lista)
#
##ejercicio 2
#
#lista1= [4, 2, 7, 10, 3] 
#def posicion(lista1):
#    a=max(lista1)
#    b=lista1.index(a)
#    print b
#posicion (lista1)
#    
##ejercicio 3
#lista=[-1,3,4,-2,-9,0,10,-8]
#def todoPos(lisya):
#    for i in range(0,len(lista),1):
#        if lista[i]<0:
#            lista[i]=0
#    print lista
#todoPos(lista)
#   
##ejercicio 4
#lista=[2,-1,4]
#n=int(raw_input("dame numero"))
#def sumaPotencias(lista, n):
#    cont=0
#    for i in range(0,len(lista),1):
#        b=lista[i]**n
#        cont=cont+b
#    print cont
#sumaPotencias(lista,n)
#        
