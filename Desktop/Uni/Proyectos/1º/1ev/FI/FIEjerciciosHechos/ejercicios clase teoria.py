##print "EL AREA ES=" ,area
####
###escribir un programa que nos diga si un numero es par o impar
##x=int(raw_input("introducir entero"))
###par= x%2==0
##print x,
##if x%2==0:
##
##    print x , "es par"
##    print x , "es par"
##else:
##    print x , "es impar"
##    print x , "es impar"
##print "fin"
###ejercicio
##a=int(raw_input("dame a"))
##b=int(raw_input("dame b"))
##rango= a>=5 and a<30
##par = b%2==0
##if rango and par:
##    print "todo correcto"
##elif rango:
##    print "falla par"
##elif par:
##    print "falla rango"
##else:
##    print "fallan las dos cosas"
#####escribir un programa que nos diga si un entero es positivo o negativo o nulo
#####x=int(raw_input("dame entero"))
#####if x>0:
#####    print x, "es positivo"
#####elif x==0:
#####    print x, "es nulo"
#####elif x<0:
#####    print x, "es negativo"
##else:
##    print "nunca"
###ESTE PROGRAMA
###CALCULA EL AREA DE UN TRIANGULO
##base= raw_input("DAME BASE")
##altura= raw_input("DAME ALTURA")
##base=float(base)
##altura=float(altura)
##area=float(base)*altura/2
##print "EL AREA ES=" ,area
###EJERCICIO 3
###leer 3 enteros y decir si son ascendentes
##a=int(raw_input("introduzca a"))
##b=int(raw_input("introduzca b"))
##c=int(raw_input("introduzca c"))
##if(a<b<c):
##    print a,b,c, "son ascendentes"
##else:
##    print a,b,c, "no son ascendentes"
##    #EJERCICIO 4
###leer 3 enteros y decir si son ascendentes
##a=int(raw_input("introduzca a"))
##b=int(raw_input("introduzca b"))
##c=int(raw_input("introduzca c"))
##d=int(raw_input("introduzca d"))
##if(a<b<c<d):
##    print a,b,c,d, "son ascendentes"
##else:
##    print a,b,c,d, "no son ascendentes"
###ejercicio 5
###leer 5 enteros e indicar el mayor de los 5
##a=int(raw_input("introduzca a"))
##b=int(raw_input("introduzca b"))
##c=int(raw_input("introduzca c"))
##d=int(raw_input("introduzca d"))
##e=int(raw_input("introduzca e"))
##if a>b and a>c and a>d and a>e:
##    print a, "es el mayor"
##elif b>a and b>c and b>d and b>e:
##    print b, "es el mayor"
##elif c>b and c>a and c>d and c>e:
##    print c, "es el mayor"
##elif d>b and d>c and d>a and a>e:
##    print d, "es el mayor"
##elif e>b and e>c and e>d and e>a:
##    print e, "es el mayor"
##else:
##    print "no hay ningun mayor"
###ejercicio 6
###ecuacion de primer grado
##a=float(raw_input("introduzca numero real"))
##b=float(raw_input("introduzca numero real"))
##if(a!=0):
##    print "la raiz es" , -b/a
##else:
##    print "a no puede ser 0, repase usted las matematicas"
###ejercicio 7
###escoger opcion :a)cuadrado b)cubo c)doble
##entero=int(raw_input("introduzca numero"))
##print "pulse a si quiere cuadrado"
##print "pulse b si quiere cubo"
##print "pulse c si quiere doble"
##opcion=raw_input("escoja opcion")
##if opcion=="a" or opcion=="A":
##    print entero **2
##elif opcion=="b" or opcion=="B":
##    print entero**3
##elif opcion=="c" or opcion=="C":
##    print entero*2
##else:
##    print "opcion incorrecta"
###ejercicio8
###leer 4 notas entre 0 y 100. Media. Nivel
##nota1=int(raw_input("dame nota entre 0 y 100"))
##nota2=int(raw_input("dame nota entre 0 y 100"))
##nota3=int(raw_input("dame nota entre 0 y 100"))
##nota4=int(raw_input("dame nota entre 0 y 100"))
##media=(nota1+nota2+nota3+nota4)/4
##if media>=90 and media <=100:
##    print media, "nivel a"
##elif media>=80 and media <=90:
##    print media, "nivel b"
##elif media>=70 and media <=80:
##    print media, "nivel c"
##elif media>=60 and media <=70:
##    print media, "nivel d"
##elif:
##    print media, "nivel e"
##else:
##    print "nota no valida"
###ejercicio 9
###annus, bisiesto
##annus=int(raw_input("introduzca annus"))
##if annus%4==0 and annus%100!=0 or annus%400==0:
##    print annus, "es bisiesto"
##else:
##    print annus, "no es bisiesto"
###ejercicio 10
###introducir annus y mes y decir los dias del mes
###ejercicio 9
###annus, bisiesto
##annus=int(raw_input("introduzca annus"))
##mes=int(raw_input("introduzca mes 1-12"))
##print mes, annus, "tiene "
##if mes==2:
##    bisiesto= annus%4==0 and annus%100!=0 or annus%400==0
##    if bisiesto:
##         print "29 dias"
##    else:
##         print "28 dias"
##elif mes==1 or mes==3 or mes==5 or mes==7 or mes==9 or mes==11:
##    print "31 dias"
##elif mes==4 or mes==6 or mes==8 or mes==10 or mes==12:
##    print "30 dias"
##else:
##    print "datos incorrectos"
###programa apuntes
###sumar numero hasya que se introduzca 0
##n=int(raw_input("dame entero"))
##s=0
##while n<>0:
##    s=s+n
##    n=int(raw_input("dame entero"))
##print "la suma es= " , s
###multiplicar numeros
##p=1
##n=int(raw_input("dame entero"))
##while n<>0:
##    p=p*n
##    n=int(raw_input("dame entero"))
##print "la multiplicacion es= " , p
###leer un real OBLIGATORIAMENTE >=0 y calcular su raiz cuadrada
##n=-2.0
##while n<0:
##    n=float(raw_input("dame real >=0"))
##print n**(1.0/2)
###ejercicio 1 de guion de while
###leer caracter a caracter por teclado
###se finaliza por el punto
###contar y escribir el numero de "a"
##c=raw_input("meta caracter")
##conta=0
##while c!="." :
##    if c=="a" or c=="A":
##        conta=conta+1
##    c=raw_input("meta caracter")
##print "numero de a=" , conta
###ejercicio 2
###leer un numero entero OBLIGATORIAMENTE mayor que 0
###al final simplemente escribir el numero
##n=0
##while n<=0 :
##    n=int(raw_input("dame numero >0"))
##print n
###ejercicio 3
###leer numeros reales>=0 hasta meter un negativo
###al final se debe indicar la media
##n=float(raw_input("dame numero "))
##suma=0.0
##cont=0
##while n>=0:
##    suma=suma+n
##    cont=cont+1
##    n=float(raw_input("dame numero "))
##print suma/cont
###ejercicio 4
###leer numeros enteros >=0 hasta meter un negativo
###indicar la media de los pares y la media de los impares
##n=int(raw_input("dame numero "))
##spar=0
##simpar=0
##cpar=0
##cimpar=0
##while n>=0:
##    if n%2==0:
##        spar=spar+n
##        cpar=cpar+1
##    else:
##        simpar=simpar+n
##        cimpar=cimpar+1
##    n=int(raw_input("dame numero "))
##print float(simpar)/cpar
##print float(simpar)/cimpar
###ejercicio 5
###leer numero entero OBLIGATORIAMENTE >=1 y calcular su raiz cuadrada
##n=0
##while n<1:
##    n=int(raw_input("dame numero entero >1"))
##print "la parte entera de la raiz cuadrada de",
##print n, "es", int(n**0.5)
###ejercicio 6
###leer 2 enteros a>0 y b>0 y calcular por estas sucesivas el cociente resto
##a=-1
##while a<0:
##    a=int(raw_input("dame a>=0"))
##b=-1
##while b<=0:
##    b=int(raw_input("dame b>=0"))
###print a/b, a%b
##cociente=0
##while a>=b:
##    cociente=cociente+1
##    a=a-b
##print cociente , a
###ejercicio 7
###programa que lea numero enteros hasta que lea 0, debe calcular mayor introducido y su posterior
##x=int(raw_input("dame entero"))
##i=1
##mayor=x
##pos=1
##while x!=0:
##    if x>=mayor:
##        mayor=x
##        pos=i
##    x=int(raw_input("dame entero"))
##    i=i+1
##print mayor, pos
###ejercicio 8
###leer numero entero OBLIGATORIAMENTE >0 programa que escriba cifras de la menos a la mas significativa
##n=0
##while n<=0:
##    n=int(raw_input("dame numero"))
##
##while n>0:
##    print n%10,
##    n=n/10
###ejercicio 9
###leer un numero entero umbral >=10 y <=10000 y escribir los numeros de la sucesion de fibonacci >=umbral
##umbral=0
##while umbral<10 or umbral>10000:
###while not (umbral >=10 and umbral <=10000)
##    umbral=int(raw_input("dame umbral"))
##x=0
##y=1
##print x, y,
##z=x+y
##while z<=umbral :
##    print z,
##    x=y
##    y=z
##    z=x+y
###ejercicio 11
###dado un numero OBLIGATORIAMENTE >0 calcularlo en binario
##x=0
##while x<=0:
##    x=int(raw_input("dame entero >0"))
##res=""
##while x>0:
##    if x%2==0:
##        res="0"+ res
##    else:
##        res="1"+ res
##
##    x=x/2
##print res
###ejercicio 12
###dado un entero>=1 determinar si es primo
##n=0
##while n<=0:
##    n=int(raw_input("dame entero natural "))
##primo=True
##i=2
##while i<n:
##    print i
##    if n%i==0:
##        primo=False
##    i=i+1
##if primo:
##    print n, "es primo"
##else:
##    print n, "no es primo"
###bucle for
##x=8
##for i in range(2*x,x**2+1,x):
##    print i,
###factorial
##fact=1
##x=5
##for i in range(1,x+1,1):
##    fact=fact*i
##print fact,
###for
##p=1
##for i in range(2,4,1):
##    p=p*i
##print p
##
##p=1
##i=6
##while i>0:
##    p=p*i
##    i=i-2
##print p
###leer entero a>0
###leer entero b>=0
###calcular la suma de los pares en [a,b] y el producto de los impares en [a,b]
##a=0
##while a<=0:
##    a=int(raw_input("dame a>0"))
##b=a-1
##while b<a:
##    b=int(raw_input("dame b>" + str(a)))
##s=0
##p=1
##for i in range(a,b+1,1):
##    if i%2==0:
##        s=s+i
##    else:
##        p=p*i
##print s, p
###leer un numero entero >=1 y decir si es primo o no
##n=0
##while n<=0:
##    n=int(raw_input("dame entero >=1"))
##primo=True
##i=2
##while i<n and primo:
##    if n%i==0:
##        primo=False
##    i=i+1
##for i in range(2,n,1):
##    print i
##    if n%i==0:
##        primo=False
##        break
##if primo:
##    print n, "es primo"
##else:
##    print n, "no es primo"
###leer entero >=1 y escribir linea de n asteriscos
##n=0
##while n<=0:
##    n=int(raw_input("dame entero>=1"))
####print "*"*n
##for i in range(1,n+1,1):
##    print "*",
###ler dos numeros enteros n y me y crear rectangulo
##n=5
##m=7
##for i in range(0,n,1):
####    for j in range (0,m,1):
##    for j in range(0,n,1):
##        print "*",
##    print
###ejercicio
##for i in range(-2,2,1):
##    print "*",
##for j in range(2,-1,-1):
##    print "*",
##for k in range(2,6,2):
##    print "*",
###otra forma
##for i in range(-2,2,1):
##    for j in range(2,-1,-1):
##        for k in range(2,6,2):
##            print "*",
###ejercicio 6 extra
###leer n>=1, crear matriz
##n=0
##while n<=0:
##    n=int(raw_input("dame natural"))
##for i in range(1,n+1):
##    for j in range(1,n+1):
##        print "A"+str(i) + str(j),
##    print
###ejercicio 7 extra
###leer n>=1 y escribir triangulo
##n=0
##while n<=0:
##    n=int(raw_input("dame natural"))
##for i in range(1,n+1):
##    for j in range(1,i+1):
##        print j,
##    print
###ejercicio 11 for
###dado un numero n>=1, imprimir los divisores entre 1 y n
##n=0
##while n<=0:
##    n=int(raw_input("dame natural"))
##print "Los divisores de" , n , "son:"
##for i in range(1,n+1):
##    if n%i==0:
##        print i,",",
###ejercicio 12
##n=0
##while n<=0:
##    n=int(raw_input("dame natural"))
##suma=0
##for i in range(1,n):
##    if n%i==0:
##        suma=suma+i
##print suma
##if suma==1:
##    print "primo y defectivo"
##elif suma<n:
##    print "defectivo"
##elif suma==n:
##    print "perfecto"
##elif suma>n:
##    print "abundante"
###ejercicio 10
###dados dos enteros a>=0 y b>=0 calcular su multiplicacin mediante sumas sucesivas
a=-1
while a<0:
    a=int(raw_input("dame primer factor"))
b=-1
while b<0:
    b=int(raw_input("dame segundo factor"))
producto=0
for i in range(0,b):
    producto=producto+a
print producto,
###ejercicio 8
###leer un entero a>0 y b>=a, calcular
##a=0
##while a<=0:
##    a=int(raw_input("dame entero"))
##b=a-1
##while b<a:
##    b=int(raw_input("dame entero >a"))
##s=0
##for i in range(a,b+1):
##s=s+(i**2+1+0.0)/i
##print s
