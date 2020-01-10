#!/usr/bin/env python
# coding: utf-8

# In[9]:


eq='x2+2x-8=0'
 #splitting the equation on '='
l1=eq.split('=') 
#further splitting the result on '+'
l2=l1[0].split('+')
#splitting on  '-'
l3=l2[1].split('-') 
#checking for coffecient of x 
if len(l2[0])==3:    
    a=int(l2[0][0])
elif len(l2[0])==2:  
    a=1
b=int(l2[1][0])
c=int(l3[1])
import math
#calculating b2
b1=b*b
c1=(-4)*a*c   
d=b1-c1  
#finding roots
x1=((-b)+(math.sqrt(d)))/(2*a)   
x2=((-b)-(math.sqrt(d)))/(2*a)  
print('ans1 : ',x1)
print('ans2 : ',x2)


# In[ ]:




