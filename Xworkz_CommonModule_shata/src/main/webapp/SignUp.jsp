<%@page isELIgnored = "false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Course Form Page</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .form-container {
            max-width: 500px;
            margin: 0 auto;
            padding: 20px;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <!-- Card for the form -->
        <div class="card shadow-lg form-container">
            <div class="card-body">
                <h2 class="card-title text-center mb-4">Sign Up Form</h2>

                <c:forEach items="${error}" var="i">
                    <span style = "color:red">${i.message}</span>
                </c:forEach>

                <form action="signup" method="post">
                    <div class="mb-3">
                        <label for="name" class="form-label">Name</label>
                        <input type="text" class="form-control" id="name" onChange="onNameChange()" name="name" placeholder="Enter Name"  onblur="validData(event)">
                        <span  id="nameDemo" style="color:red;"></span>
                    </div>

                    <div class="mb-3">
                        <label for="email" class="form-label">Email</label>
                        <input type="email" class="form-control" id="email" name="email" onChange="onEmailChange()" placeholder="Enter Email" onblur="validData(event)" required>
                        <span id="emailDemo" style="color:red;"></span>
                    </div>

                    <div class="mb-3">
                        <label for="phoneNo" class="form-label">Phone Number</label>
                        <input type="number" class="form-control" id="phoneNo" onChange="onPhoneChange()" name="phone"  placeholder="Enter Phone Number" pattern="[0-9]{10}" onblur="validData(event)" required>
                        <span id="phoneDemo" style="color:red;"></span>
                    </div>

                     <div class="mb-3">
                          <label for="alterEmail" class="form-label">Alter Email</label>
                          <input type="emil" class="form-control" id="alterEmail" onChange="onAltEmailChange()" name="alterEmail"  placeholder="Enter Alter Email" onblur="validData(event)" required>
                     <span id="altEmailDemo" style="color:red;"></span>
                     </div>

                        <div class="mb-3">
                              <label for="phoneNo" class="form-label">Alternate Phone Number</label>
                              <input type="number" class="form-control" id="alterPhone" onChange="onAltPhoneChange()" name="alterPhone"  placeholder="Enter Alter Number" onblur="validData(event)" required>
                            <span id="altPhoneNumberDemo" style="color:red;"></span>
                         </div>

                        <div class="mb-3">
                        <label for="location" class="form-label">Location</label>
                                <input type="text" class="form-control" id="location" onChange="onLocationChange()" name="location"  placeholder="Enter Location" required>
                                <span id="locationDemo" style="color:red;"></span>
                         </div>

                    <button type="submit" class="btn btn-warning w-100">Login</button>
                </form>
                </div>
                <h3>${name}</h3>
        </div>
    </div>
                 <!-- JavaScript Functions -->
                    <script>

                    var emailvalue = "";
                    var alternateemailvalue = "";
                    var phoneNumbervalue = "";
                    var alternatephonevalue = "";

                        function onNameChange() {
                            var name = document.getElementById('name');
                            var namevalue = name.value;

                              if (namevalue.trim().length < 4)
                              {
                                document.getElementById("nameDemo").innerHTML = "Name must be at least 4 characters long.";
                                return;
                              }

                            var xhttp = new XMLHttpRequest();
                            xhttp.open("GET", "http://localhost:8080/Xworkz_CommonModule_shata/name/" + name, true);
                            xhttp.send();

                            xhttp.onload=function(){
                            document.getElementById("nameDemo").innerHTML=this.responseText;
                            }
                        };

                        function onEmailChange() {
                            var email = document.getElementById('email');
                            emailvalue = email.value;


  if (!emailvalue.includes('@gmail.com') && !emailvalue.includes('@yahoo.com') && !emailvalue.includes('@outlook.com') && !emailvalue.includes('@hotmail.com') && !emailvalue.includes('.edu')
      && !emailvalue.includes('.org') && !emailvalue.includes('.info') && !emailvalue.includes('.net'))
      {
    document.getElementById("emailDemo").innerHTML = "Enter a valid email address.";
    return;
  }
                            var xhttp = new XMLHttpRequest();
                            xhttp.open("GET", "http://localhost:8080/Xworkz_CommonModule_shata/email/" + email, true);
                            xhttp.send();

                            xhttp.onload=function(){
                            document.getElementById("emailDemo").innerHTML=this.responseText;
                            }
                        };

                         function onPhoneChange() {
                             var phone = document.getElementById('phone');
                              phoneNumbervalue = phone.value;

                               if (phoneNumbervalue.trim().length !== 10 || (!phoneNumbervalue.startsWith("6") && !phoneNumbervalue.startsWith("7")
                                && !phoneNumbervalue.startsWith("8") && !phoneNumbervalue.startsWith("9")))
                                {
                                  document.getElementById("phoneDemo").innerHTML = "Phone number must contain 10 digits and should be valid.";
                                  return;
                                }

                              var xhttp = new XMLHttpRequest();
                              xhttp.open("GET", "http://localhost:8080/Xworkz_CommonModule_shata/phone/" + phone, true);
                               xhttp.send();

                               xhttp.onload=function(){
                               document.getElementById("phoneDemo").innerHTML=this.responseText;
                               }
                          };

                        function onAltEmailChange() {
                            var alterEmail = document.getElementById('alterEmail');
                             alternateemailvalue = alterEmail.value;


  if (!alternateemailvalue.includes('@gmail.com') && !alternateemailvalue.includes('@yahoo.com') && !alternateemailvalue.includes('@outlook.com')
    && !alternateemailvalue.includes('@hotmail.com') && !alternateemailvalue.includes('.edu') && !alternateemailvalue.includes('.org') && !alternateemailvalue.includes('.info') && !alternateemailvalue.includes('.net'))
    {
    document.getElementById("altEmailDemo").innerHTML = "Enter a valid email address.";
    return;
  }

  if (emailvalue === alternateemailvalue)
  {
    document.getElementById("altEmailDemo").innerHTML = "Email and Alternate Email should be different.";
    return;
  }

                            var xhttp = new XMLHttpRequest();
                            xhttp.open("GET", "http://localhost:8080/Xworkz_CommonModule_shata/alterEmail/" + alterEmail, true);
                            xhttp.send();

                             xhttp.onload=function()
                             {
                             document.getElementById("altEmailDemo").innerHTML=this.responseText;
                            }
                        };

                         function onAltPhoneChange()
                         {
                            var alterPhone = document.getElementById('alterPhone');
                             alternatephonevalue = alterPhone.value;

                              if (alternatephonevalue.trim().length !== 10 || (!alternatephonevalue.startsWith("6") && !alternatephonevalue.startsWith("7") && !alternatephonevalue.startsWith("8") && !alternatephonevalue.startsWith("9"))) {
                                 document.getElementById("altPhoneNumberDemo").innerHTML = "Phone number must contain 10 digits and should be valid.";
                                 return;
                               }

                               if (alternatephonevalue === phoneNumbervalue)
                               {
                                 document.getElementById("altPhoneNumberDemo").innerHTML = "Phone number and Alternate Phone number should be different";
                                 return;
                               }

                            var xhttp = new XMLHttpRequest();
                            xhttp.open("GET", "http://localhost:8080/Xworkz_CommonModule_shata/alterPhone/" + alterPhone, true);
                            xhttp.send();

                            xhttp.onload=function(){
                            document.getElementById("altPhoneNumberDemo").innerHTML=this.responseText;
                         }
                         };

                         function onLocationChange() {
                           var location = document.getElementById('location').value;
                            var xhttp = new XMLHttpRequest();
                            xhttp.open("GET", "http://localhost:8080/Xworkz_CommonModule_shata/location/" + location, true);
                            xhttp.send();

                               xhttp.onload=function()
                               {
                                document.getElementById("altPhoneDemo").innerHTML=this.responseText;
                              }
                         }
                      </script>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>




