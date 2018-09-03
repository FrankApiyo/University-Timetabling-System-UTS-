<?php
session_start();
?>
<?php if (isset($_SESSION['email'])): ?>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>University-Timetabling-System</title>
    <link rel="stylesheet" href="UTS.css">
    <link rel="stylesheet" href="bootstrap.min.css">
  </head>
  <body class="uts">
    <h1>University-Timetabling-System(UTS)</h1>
    <a href="year.php">
        <button type="button" class="btn">Back</button>
    </a>
    <div class="logout">
        <a href="logout.php">
            <button class="btn btn-warning">Logout</button>
        </a>
    </div>


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
    <div class="form">
      <form id="add">
      <table class="table-bordered" id="myTable">
        <tr>
          <th>UNIT NAME</th>
          <th>UNIT CODE</th>
          <th>CF</th>
          <th>LECTURE HOURS</th>
          <th>PRACTICAL HOURS</th>
          <th>NO. OF STUDENTS</th>
          <th>LECTURER'S NAME</th>
        </tr>
        <tr>
          <td><input name="unit_name" type="text" id="unit_name" required></td>
          <td><input type="text" name="unit_code" required></td>
          <td><input type="number" name="unit_cf" required></td>
          <td><input type="number" name="lecture" required></td>
          <td><input type="number" name="practical" required></td>
          <td><input type="number" name="students" required></td>
          <td><input type="text" name="lec_name" required></td>
        </tr>
      </table>
        <button type="submit" class="btn btn-primary" id="add-note">ADD</button>

      </form><br>
      <div class="alert alert-danger" id="alertDanger"></div>
      </div>
      <div class="cardd" style="width: 100%;height: auto;margin-top: 20px;">
        <h5 class="allunits">UNITS ADDED</h5>
      </div>

      <table class="table-bordered" id="myPrevTable">
        <tr>
          <th>UNIT NAME</th>
          <th>UNIT CODE</th>
          <th>CF</th>
          <th>LECTURE</th>
          <th>PRACTICAL</th>
          <th>NO. OF STUDENTS</th>
          <th>LECTURER'S NAME</th>
          <th></th>

        </tr>
        
      </table>

      <div class="main">
<script src="js/jquery.min.js"></script>
        <script src="js/index.js"></script>
      </div>

  </body>
</html>
<?php else: ?>
    <?php
    header("Location: index.php");
    ?>
<?php endif; ?>