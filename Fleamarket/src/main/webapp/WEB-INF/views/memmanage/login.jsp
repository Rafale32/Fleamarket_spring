<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 제이쿼리 -->
<script src="../resources/product/jquery-3.1.0.js"></script>
<!-- 부트스트랩 -->
<link href="../resources/boot/bootstrap/css/bootstrap.min.css"
  rel="stylesheet" type="text/css" />
<script src="../resources/boot/bootstrap/js/bootstrap.min.js"></script>
<title>Login</title>

<style type="text/css">
body {
  padding-top: 40px;
  padding-bottom: 40px;
/*   background-color: #eee; */
}

.form-signin {
  max-width: 330px;
  padding: 15px;
  margin: 0 auto;
}
.form-signin .form-signin-heading,
.form-signin .checkbox {
  margin-bottom: 10px;
}
.form-signin .checkbox {
  font-weight: normal;
}
.form-signin .form-control {
  position: relative;
  height: auto;
  -webkit-box-sizing: border-box;
     -moz-box-sizing: border-box;
          box-sizing: border-box;
  padding: 10px;
  font-size: 16px;
}
.form-signin .form-control:focus {
  z-index: 2;
}
.form-signin input[type="email"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}
.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}
</style>
</head>
<body>
  <div id="login" class="container">
    <form class="form-signin"
      action="/fleamarket/memmanage/loginpost" method="post" name="frm">
      <h2 class="form-signin-heading">LOGIN</h2>
      <label for="inputEmail" class="sr-only">Email address</label>
      <input type="email" id="member_email" class="form-control"
             name="member_email" value="${member_email }"
             placeholder="Email address" required autofocus>
      <label for="inputPassword" class="sr-only">Password</label>
      <input type="password" id="member_pw"
             class="form-control" placeholder="Password"
             name="member_pw" required>
      <div class="checkbox">
        <label><input type="checkbox" value="remember-me"> Remember me </label>
      </div>
      <button class="btn btn-lg btn-primary btn-block"
        type="submit" > Login </button>
    </form>
  </div>
  <!-- /container -->
</body>
</html>