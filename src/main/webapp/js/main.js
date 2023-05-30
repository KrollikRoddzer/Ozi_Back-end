function myFunction() {
    var x = document.getElementById("password");
    var y = document.getElementById("password2");
         if (x.type === "password") {
            x.type = "text";
            y.type = "text";
        } 
     else {      
         x.type = "password"; 
         y.type = "password";        
        }      
}


//function isEmail(email){
//  return  /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.text(email);
//}