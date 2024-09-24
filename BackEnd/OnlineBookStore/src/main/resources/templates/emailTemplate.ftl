<html xmlns="http://www.w3.org/1999/xhtml">
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
   <title>Book Store</title>
   <style>
      body {
         background-color: #f5f5f5;
         margin: 0;
         padding: 0;
      }
      
      .container {
         max-width: 600px;
         margin: 0 auto;
         padding: 20px;
         background-color: #ffffff;
         font-family: Arial, Helvetica, sans-serif;
         font-size: 16px;
         color: #333333;
      }
      
      .button {
         display: inline-block;
         padding: 10px 20px;
         background-color: blue;
         color: white;
         text-decoration: none;
         border-radius: 4px;
      }
      
      h6 {
         font-size: 18px;
         font-weight: normal;
      }
      
      h3 {
         margin-top: 20px;
         color: blue;
      }
   </style>
</head>
<body>
   <div class="container">
      Hi <b>${name}</b>,
      <br/><br/>
      <h6>Thanks for registering with the Online Book Store. To confirm your registration, please enter the verification code below on the webpage.</h6>
      <br/>
      <h3>Verification code for verifying email: ${verificationCode}.</h3>
      <br/>
      <p>Thank you.</p>
   </div>
</body>
</html>
