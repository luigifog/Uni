################# ap -1##################
#def getContentFile(filename):
#    f=open(filename,"r")
#    fr=open("Ex1.txt","a")
#    datos=f.readlines()
#    trozo=datos[0].split("{")
#    primNom=trozo[1]
#    fr.write("["+primNom)
#    for i in range(1,len(datos)):
#        fr.write(datos[i])
#    f.close()
#    fr.close()
#getContentFile("dialCodes.json")


################# ap 2##################

#def getContent(filename):
#    f=open(filename,"r")
#    lista=[]
#    for linea in f:
#        lista.append(linea)
#        for i in range(0,len(lista)):
#            trozos=lista[i].split("\r")
#            for j in range(0,len(trozos)):
#                print trozos[j]
#        
#
#getContent("dialCodes.json")
################# ap 3##################


#def getCode(value):
#    print value[6]
#            
#getCode("{name:Aruba,dial_code:+297,code:AW}")
#    

################# ap 3 del otro ex##################

#def getDialCode(value):
#    partes=value.split(",")
#    subpartes=partes[1].split(":")
#    print subpartes[1]     
#getDialCode("{name:Aruba,dial_code:+297,code:AW}")

################# ap 4##################

#def getCountry(value):
#        partes=value.split(",")
#        subPartes=partes[0].split(":")
#        print subPartes[1]
#getCountry("{name:Aruba,dial_code:+297,code:AW}")


################# ap 5##################


#def getCountries(letter, content):
#    f=open(content,"r")
#    datos=f.readlines()
#    for i in range(0,len(datos)):
#        if (datos[i][6]==letter):
#            print datos[i]
#getCountries("A","Ex1.txt")


################# ap 5 del otro ex ##################

#def getCountries2(codemin,codemax,content):
#    f=open(content,"r")
#    datos=f.readlines()
#    for i in range(0,len(datos)):
#        partes=datos[i].split(",")
#        code=partes[1].split("+")
#        if(int(code[1])>=codemin and int(code[1])<=codemax):
#            print datos[i]
#getCountries2(0,100,"Ex1.txt")

##en windows lo de crear archivos y tal con python, se comporta igual que aqui?


################# ap 6##################

#def createFile(filename,letter):
#    f=open(filename,"r")
#    fr=open("example.txt","a")
#    datos=f.readlines()
#    for i in range(0,len(filename)):
#        if (datos[i][6]==letter):
#            trozos=datos[i].split(",")
#            pais=trozos[0].split(":")
#            code=trozos[2].split(":")
#            soloCodigo=code[1].split("}")
#            fr.write( pais[1]+ " : "+soloCodigo[0]+"\n")
#    f.close()
#    fr.close()
#createFile("Ex1.txt", "A")

################# ap 6 del otro ex ##################
def createFile2(filename,dialmin,dialmax):
       f=open(filename,"r")
       fr=open("example2.txt","w")
       datos=f.readlines()
       for i in range(0,len(datos)):
           partes=datos[i].split(",")
           code=partes[1].split("+")
           if(int(code[1])>=dialmin and int(code[1])<=dialmax):
               fr.write(datos[i])
createFile2("Ex1.txt",0,100) 
#            

##hay algo mal, como en el ap 5bis
        
        
        
        
        
        
        
        
        