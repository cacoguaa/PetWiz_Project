
<!DOCTYPE html>
<head>
    <title>index</title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta name="layout" content="login"/>

</head>
<body>

<main>
    <div class="parallax-container">
        <div class="parallax"><asset:image src="login11.jpg"/></div>
        <br><br><br><br><br><br>
        <div class="container center">
            <h1 class="petwiz-font big-text font-white petwiz-opacity"> PetWiz </h1>
            <div class="row">
                <h5 class="header font-teal petwiz-font medium-text italic trans-hover petwiz-opacity">Lo mejor para ti y tus mascotas</h5>
            </div>
            <div class="row">
                <!--<div class="fb-login-button",  data-max-rows="1" onlogin="checkLoginState();" data-size="xlarge" data-show-faces="false" data-auto-logout-link="true"></div>-->
                <div class="fb-login-button" data-max-rows="5" data-size="xlarge" data-show-faces="false" data-auto-logout-link="true", scope="public_profile,email,user_birthday,user_hometown", onlogin="checkLoginState(); entrar();"></div><!--,user_birthday,user_hometown-->
            </div>

        </div>
    </div>
</main>

</body>
</html>

