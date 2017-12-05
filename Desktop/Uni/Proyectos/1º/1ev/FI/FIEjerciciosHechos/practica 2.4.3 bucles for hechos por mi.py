#Practica 2.4.3
###ejercicio 1
##
##n=int(raw_input("dame num"))
##suma=0
##for n in range(1,n+1):
##    suma=suma+n
##    print suma

###ejercicio 2
##
##i=int(raw_input("dame numero"))
##fact=1
##while i<0:
##    i=int(raw_input("dame numero"))
##for i in range(1,i+1,1):
##    fact=fact*i
##    print fact

###ejercicio 3
##
##f=int(raw_input("dame num positivo"))
##while f<0:
##    f=int(raw_input("dame num positivo"))
##for f in range(1,f+1):
##    ast="*"
##print "Ejemplo de salida del programa para f ="+ str(f)+ast

###Ejercicio 4
##
##for i in range(20,9,-1):
##    print i

###ejerciocio 5
##
##for i in range(40,19,-2):
##    print i

###ejercicio 6
###IMP
##for i in range(0,101,3):
##    print i

###ejercicio 7

##i=1
##formula=((i**2)+1)/i
##sum=0
##for i in range(1,101,1):
##    sum=sum+formula
##print sum

###ejercicio 8

##a=int(raw_input("dame num"))
##b=int(raw_input("dame num limite"))
##while b<a:
##    a=int(raw_input("dame num"))
##    b=int(raw_input("dame num limite"))
##i=a
##formula=((i**2)+1)/i
##sum=0
##for i in range(i,b+1,1):
##    sum=sum+formula
##print sum

###ejercicio 9
##
##a=int(raw_input("dame un num"))
##b=int(raw_input("dame un numero mayor que el anterior"))
##while b<a:
##    a=int(raw_input("dame un num"))
##    b=int(raw_input("dame un numero mayor que el anterior"))
##for i in range(a,b+1):
##    if i%2!=0:
##        print str(i)+"(impar)"
##    if i%2==0:
##        print str(i)+"(par)"

###ejercicio 11
##
##n=int(raw_input("dame numero para calcular sus divisores"))
##while n<0:
##    n=int(raw_input("dame numero para calcular sus divisores"))
##for i in range(1,n+1):
##    if n%i==0:
##        print i

###ejercicio 12
##n=int(raw_input("dame un numero"))
##suma=0
##while n<0:
##    n=int(raw_input("dame un numero"))
##for i in range(1,n):
##    if n%i==0:
##        suma=suma+i
##
##if suma<n:
##        print str(n)+ " es defectivo"
##elif suma==n:
##        print str(n)+" es perfecto"
##else:
##        print str(n)+" es abundante"



