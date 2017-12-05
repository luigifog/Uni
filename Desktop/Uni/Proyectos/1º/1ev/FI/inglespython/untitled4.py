#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Sun Jan  8 12:46:19 2017

@author: luismartinezmoreno
"""
#def cuentas():
#    f=open("ALUMNOS ETC 2.csv","r")
#    fr=open("cuentas.txt","a")
#    datos=f.readlines()
#    for i in range(1,len(datos)):
#        trozos=datos[i].split(";")
#        name=trozos[0]
#        importe=trozos[7]
#        fr.write(name+" -> "+importe+"\n")
#    f.close()
#    fr.close()
#cuentas()
    
def cuentasTodos():
    precio=0
    f=open("ALUMNOS ETC 2.csv","r")
    fr=open("cuentasTodos.txt","a")
    datos=f.readlines()
    for i in range(1,len(datos)):
        trozos=datos[i].split(";")
        name=trozos[0]
        apellidos=trozos[1]
        modalidad=trozos[3]
        socio=trozos[4]
        if (modalidad=="8 horas"):
            precio=75
            if(socio=="si" or socio=="s"):
                precio=precio-10
        if(modalidad=="gym and english"):
            precio=40
        if(modalidad=="Secundaria"):
            precio=65
            if(socio=="si" or socio=="s"):
                precio=precio-10
        if(modalidad=="12 horas"):
            precio=95
            if(socio=="si" or socio=="s"):
                precio=precio-10
        fr.write(name+" "+apellidos+" -> "+str(precio)+"\n")
    f.close()
    fr.close()
cuentasTodos()