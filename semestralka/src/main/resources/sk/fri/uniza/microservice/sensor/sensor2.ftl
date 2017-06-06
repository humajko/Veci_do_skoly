<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SENZOR</title>
   <#include "stajl.css">

    <script charset="UTF-8" type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    
    <#include "skript.js">
        
        

</head>
<body onload="startTime()">
<div class="senzor">
<p class="senzorNadpis"><b> SENSOR </b></p>

<form method="get" action="/sensor">
    <button class="getUdaje" type="submit">Get all</button><br>
</form>
<form method="get" id="frmGet" action="">
    <button class="continue" onClick="setAction()" type="submit">Get by ID</button>
    <input class="vstup" type="text" id="senzorId" placeholder="Write ID number"><br>
</form>

<form method="get" id="frmDelete" action="">
    <button class="continue" onClick="deleteAction()" type="submit">Delete by ID</button>
    <input class="vstup" type="text" id="txtDelete" placeholder="Write ID number"><br>
</form>

<form method="post" action="/sensor">
    <button class="continue" type="submit">Insert</button>
    <input class="vstup" type="text" name="newContent" placeholder="Write content"><br>
</form><br>

<div class="dataList"><#list list as item>
   <p class="senzorData">${item.id?html}: ${item.content?html} </p>
</#list>
</div>
</div>
 <p class="cas"></p>
 <p class="datum"></p>

</body>
</html>

