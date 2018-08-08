<?php
session_start();
?>
<?php if (isset($_SESSION['email'])): ?>
    <!DOCTYPE html>

    <html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title>UTS/year</title>
        <link rel="stylesheet" href="bootstrap.min.css">
        <link rel="stylesheet" href="uts.css">
    </head>
    <body class="index">

    <h1>UNIVERSITY-TIMETABLING-SYSTEM(UTS)</h1>
    <div class="logoutdiv">
        <a href="logout.php">
            <button class="btn btn-warning">Logout</button>
        </a>
    </div>

    <div class="yeardiv">
        <h3>Select the academic year to fill in requirements</h3>
        <p></p><br>
        <button class="btn-link"><a href="uts.php?year=1">First year</a></button>
        <br>
        <p></p><br>
        <button class="btn-link"><a href="uts.php?year=2">Second Year</a></button>
        <br>
        <p></p><br>
        <button class="btn-link"><a href="uts.php?year=3">Third Year</a></button>
        <br>
        <p></p><br>
        <button class="btn-link"><a href="uts.php?year=4">Fourth Year</a></button>
        <br>
        <p></p><br>
        <button class="btn-link"><a href="uts.php?year=5">Fifth Year</a></button>
        <br>
        <p><i>(For engineering department)</i></p><br>
    </div>
    </body>
    </html>

<?php else: ?>
    <?php
    header("Location: index.php");
    ?>
<?php endif; ?>
