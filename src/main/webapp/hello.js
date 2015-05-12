
document.getElementById("a").onclick = function() {
    alert('dfdf') ;
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("GET","/servlet",true);
    xmlhttp.send("name=myName");
    /*var req = new XMLHttpRequest();
    req.open("GET", "http://localhost:8080/servlet", true);
    req.send("name=myName");*/
}