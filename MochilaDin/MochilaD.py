#!/usr/bin/python
from time import time
import random


TAM = 10000
#w: peso (weight)
#p: bneficio (profit) 	
def mochila(w,p,capacidad,T):
    for c in range(capacidadW+1):
      T[0][c]=0
    for j in range(1,len(w)+1):
      T[j][0]=0
    for j in range(1,len(w)+1):
    	c =1
    	for c in range(capacidadW+1):
	        if c >= w[j-1]:
	            T[j][c]=max(T[j-1][c],T[j-1][c-w[j-1]]+p[j-1])
	        else:
	            T[j][c]=T[j-1][c]

def llenaArreglo(p):
	for i in range(TAM):
		p.append(random.randint(1, TAM))

def writeFile(fTime):
	archivo = open("datos.txt", "r+")
	contenido = archivo.read()
	final_de_archivo = archivo.tell()	 
	archivo.write(fTime+" "+str(TAM)+"\n")
	archivo.seek(final_de_archivo)
	archivo.close()



w=[]
p=[]
capacidadW = random.randint(1,TAM); 
llenaArreglo(w);
llenaArreglo(p);

T = []
for i in range(len(w)+1):
  ea_row = []
  for j in range(capacidadW+1):
    ea_row.append(0)
  T.append(ea_row)



init_time = time()
x = mochila(w,p,capacidadW,T);
final_time = time()
e_time = final_time - init_time
str_time = str("%.20f" % e_time)
writeFile(str_time)
print "Time: %.20f" % e_time
print "TAM:" + str(TAM);
