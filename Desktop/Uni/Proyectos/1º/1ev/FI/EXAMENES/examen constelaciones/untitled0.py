def hallarMayor():
    f=open("constelaciones.txt","r")
    datos=f.readlines()
    mayor=0
    for i in range(0,len(datos)):
        nombres=datos[i].split(",")
        d=float(nombres[1])
        m=float(nombres[2])
        form=m/d
        if(form>mayor):
            mayor=form
        if(mayor*d==m):
            nombreMay=nombres[0]
    print nombreMay
    print mayor
    f.close()
hallarMayor()
def cambiarLetras(sust):
    f=open("constelaciones.txt","r")
    fr=open("fSalida.txt","w")
    for linea in f:
        for i in linea:
            if i=='a' or i=='e' or i=='i' or i=='o' or i=='u':
                fr.write(sust)
            else:
                fr.write(i)
    f
cambiarLetras("#")