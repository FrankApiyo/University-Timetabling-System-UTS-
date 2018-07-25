<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>University-Timetabling-System</title>
    <link rel="stylesheet" href="uts.css">
    <link rel="stylesheet" href="bootstrap.min.css">
  </head>
  <body class="uts">
    <h1>University-Timetabling-System(UTS)</h1>
    <button type="button" class="btn">Back</button>
    <form>
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

      <button type="button" class="btn btn-primary" >Submit</button>
    </form>

    <script src="js/jquery.min.js"></script>
    <script src="js/index.js"></script>
  </body>
</html>
