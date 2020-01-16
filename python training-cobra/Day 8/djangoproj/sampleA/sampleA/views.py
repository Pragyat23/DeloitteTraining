from django.http import HttpResponse
from django.shortcuts import render

def niit(requests):
    return HttpResponse('<h1>Hello World</h1>')
def home(requests):
    return render(requests,'home.html',{'city':['Hyderabad','blr'],'company':'Deloitte'})

def home1(requests):
    return render(requests,'home1.html',{'city':['Hyderabad','blr'],'company':'Deloitte'})
#def count(requests):
#    return render(requests,'count.html')
def count1(requests):
    data=requests.GET['full']
    listw=data.split()
    wordict={}
    for word in listw:
        if word in wordict:
            wordict[word]+=1
        else:
            wordict[word]=1
    l=sorted(wordict.items(), key = lambda kv:(kv[1]),reverse=True)
    return render(requests,'count1.html',{'dataone':data,'len':len(listw),'wordict':wordict,'l':l,'wordict1':wordict.items()})
