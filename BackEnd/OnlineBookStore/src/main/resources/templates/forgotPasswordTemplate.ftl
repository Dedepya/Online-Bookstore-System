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
         background-color: #007bff;
         color: #ffffff;
         text-decoration: none;
         border-radius: 4px;
      }
      
      h6 {
         font-size: 24px;
      }
      
      h3 {
         margin-top: 20px;
         color: #007bff;
      }
   </style>
</head>
<body>
   <div class="container">
      <h6>Hi <b>${name}</b>,</h6>
      <br/>
      <h3>OTP for changing password: ${OTP}</h3>
      <p>Please enter the OTP on the webpage for resetting your password.</p>
      <br/><br/>
      <p>Thank you.</p>
   </div>
</body>
</html>
