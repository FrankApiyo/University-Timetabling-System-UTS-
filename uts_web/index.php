<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
    <meta charset="utf-8">
    <title>UTS/login</title>
    <link rel="stylesheet" href="uts.css">
    <link rel="stylesheet" href="bootstrap.min.css">
</head>
<body class="index">
<h1>UNIVERSITY-TIMETABLING-SYSTEM(UTS)</h1>
<form method="post" class="loginform" action="log-in.php">

    <div class="top">
        <strong>E-mail:</strong>
        <input type="email" name="email" placeholder="Enter E-mail" class="form-control" required>
    </div>
    <div class="btwn">
        <strong>Password:</strong>
        <input type="password" placeholder="Enter Password" class="form-control" name="password" required>
    </div>
    <div class="low">
        <button type="submit" name="button" class="btn btn-primary">login</button>
    </div>

    <?php if (isset($_GET['error']) && $_GET['error'] == 'invalid'): ?>
        <div class="alert alert-danger">Invalid credentials</div>

    <?php endif; ?>


</form>

</body>
</html>
