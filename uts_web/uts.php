<?php
session_start();
?>
<?php if (isset($_SESSION['email'])): ?>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
    <meta charset="utf-8">
    <title>University-Timetabling-System</title>
    <link rel="stylesheet" href="uts.css">
    <link rel="stylesheet" href="bootstrap.min.css">
</head>
<body class="index">
<h1>University-Timetabling-System(UTS)</h1>
<a href="year.php">
    <button type="button" class="btn">Back</button>
</a>

<?php if (isset($_GET['year'])): ?>
    <?php
    $year = $_GET['year'];
    ?>
    <?php if ($_GET['year'] == 1): ?>
        <h3 class="text-center">Year 1</h3>
    <?php elseif ($_GET['year'] == 2): ?>
        <h3 class="text-center">Year 2</h3>
    <?php elseif ($_GET['year'] == 3): ?>
        <h3 class="text-center">Year 3</h3>
    <?php elseif ($_GET['year'] == 4): ?>
        <h3 class="text-center">Year 4</h3>
    <?php elseif ($_GET['year'] == 5): ?>
        <h3 class="text-center">Year 5</h3>
    <?php endif; ?>
<?php endif; ?>

<form action="add-unit.php" method="get">
    <table class="table-bordered" id="myTable">
        <tr>
            <th>UNIT NAME</th>
            <th>UNIT CODE</th>
            <th>CF</th>
            <th>LECTURE</th>
            <th>PRACTICAL</th>
            <th>NO.OF GROUPS</th>
            <th>NO. OF STUDENTS </br> IN EACH GROUP</th>
            <th>LECTURER'S NAME</th>
        </tr>
        <tr>
            <td><input name="unit_name" type="text"></td>
            <td><input type="text"></td>
            <td><input type="text"></td>
            <td><input type="text"></td>
            <td><input type="text"></td>
            <td><input type="text"></td>
            <td><input type="text"></td>
            <td><input type="text"></td>
        </tr>
        <tr>
            <td><input name="unit_name" type="text"></td>
            <td><input type="text"></td>
            <td><input type="text"></td>
            <td><input type="text"></td>
            <td><input type="text"></td>
            <td><input type="text"></td>
            <td><input type="text"></td>
            <td><input type="text"></td>
        </tr>
        <tr>
            <td><input name="unit_name" type="text"></td>
            <td><input type="text"></td>
            <td><input type="text"></td>
            <td><input type="text"></td>
            <td><input type="text"></td>
            <td><input type="text"></td>
            <td><input type="text"></td>
            <td><input type="text"></td>
        </tr>
        <tr>
            <td><input name="unit_name" type="text"></td>
            <td><input type="text"></td>
            <td><input type="text"></td>
            <td><input type="text"></td>
            <td><input type="text"></td>
            <td><input type="text"></td>
            <td><input type="text"></td>
            <td><input type="text"></td>
        </tr>
        <tr>
            <td><input name="unit_name" type="text"></td>
            <td><input type="text"></td>
            <td><input type="text"></td>
            <td><input type="text"></td>
            <td><input type="text"></td>
            <td><input type="text"></td>
            <td><input type="text"></td>
            <td><input type="text"></td>
        </tr>
        <tr>
            <td><input name="unit_name" type="text"></td>
            <td><input type="text"></td>
            <td><input type="text"></td>
            <td><input type="text"></td>
            <td><input type="text"></td>
            <td><input type="text"></td>
            <td><input type="text"></td>
            <td><input type="text"></td>
        </tr>
        <tr>
            <td><input name="unit_name" type="text"></td>
            <td><input type="text"></td>
            <td><input type="text"></td>
            <td><input type="text"></td>
            <td><input type="text"></td>
            <td><input type="text"></td>
            <td><input type="text"></td>
            <td><input type="text"></td>
        </tr>
    </table>
    <br>
    <button id="add_row" class="btn">row +</button>
    <button id="remove_row" class="btn">row -</button>

    <button type="button" class="btn btn-primary">Submit</button>
</form>

<script src="js/jquery.min.js"></script>
<script src="js/index.js"></script>
</body>
</html>
<?php else: ?>
    <?php
    header("Location: index.php");
    ?>
<?php endif; ?>