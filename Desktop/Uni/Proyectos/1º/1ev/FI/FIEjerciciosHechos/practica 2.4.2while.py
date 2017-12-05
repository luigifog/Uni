###ejercicio 1
##c=raw_input("dame caracter")
##conta=0
##while c!=".":
##    if c=="a" or c=="A":
##        conta=conta+1
##    c=raw_input("dame caracter")
##print "El numero de a es=" , conta


###ejercicio 2
##n=int(raw_input("dame entero"))
##while n<0:
##    n=int(raw_input("dame entero"))
##print n


###ejercicio 3
##c=float(raw_input("dame numero"))
##suma=0.0
##conta=0.0
##while c>=0:
##    suma=suma+c
##    conta=conta+1
##    c=float(raw_input("dame numero"))
##print suma/conta


##ejercicio 4
#c=int(raw_input("dame numero"))
#spar=0
#simpar=0
#cpar=0
#cimpar=0
#while c>=0:
#    if c%2==0:
#        spar=spar+c
#        cpar=cpar+1
#    else:
#        simpar=simpar+c
#        cimpar=cimpar+1
#    c=int(raw_input("dame numero"))
#print float(spar)/cpar
#print float(simpar)/cimpar


##ejercicio 5
#n=int(raw_input("dame entero>0"))
#while n<1:
#    n=int(raw_input("dame entero>0"))
#print "La parte entera de la raiz", n, "es=" , n**(0.5)


###ejercicio 6
##a=-1
##while a<0:
##    a=int(raw_input("dame a>=0"))
##b=-1
##while b<=0:
##    b=int(raw_input("dame b>0"))
##print a/b , a%b
##cociente=0
##while a>=b:
##    cociente=cociente+1
##    a=a-b
##print cociente, a

###ejercicio 7
##n=int(raw_input("dame numero"))
##pos=0
##mayor=n
##while n!=0:
##    if n>=mayor:
##        mayor=n
##        pos=pos
##    n=int(raw_input("dame numero"))
##    pos=pos+1
##print "el numero mayor es", mayor, "y esta en la posicion", pos

###ejercicio 8
###IMPORTANTE
##n=0
##while n<=0:
##    n=int(raw_input("dame numero"))
##
##while n>0:
##    print n%10,
##    n=n/10

###ejercicio 9
##def fib(n):
##    a, b=0,1
##    while a<n:
##        print (a, "end=",1000)
##        a, b = b, a+b
##    print ()
##fib(1000)

###ejercicio 12
##n=0
##while n<=0:
##    n=int(raw_input("dame n >=1"))
##primo=True
##i=2
##while i<n and primo:
##    if n%i==0:
##        primo=False
##    i=i+1
##if primo==True:
##    print n, "es primo"
##else:
##    print n, "no es primo"








