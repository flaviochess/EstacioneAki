<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:p="http://primefaces.org/ui"
      xmlns:h="http://java.sun.com/jsf/html">
    <head>
        <title>Index</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    </head>
    <body>
        <p:layout fullPage="true" >
            <p:layoutUnit id="top" position="north" size="100">EstacioneAki</p:layoutUnit>
            
            <p:layoutUnit id="bottom" position="south" size="100">south</p:layoutUnit>
            
            <p:layoutUnit id="left" position="west" size="100">west</p:layoutUnit>
            
            <p:layoutUnit id="right" position="east" size="100">east</p:layoutUnit>
            
            <p:layoutUnit id="center" position="center" size="100">
                <div>EstacioneAki</div>
        
                <h:form prependId="false">
                    <p:button outcome="/pages/estacionamento/cadastro" value="Novo Estacionamento"/>
                </h:form>
            </p:layoutUnit>
            
        </p:layout>
        
    </body>
</html>