<?php
session_start();//start session
require_once "./database/DbConnect.php";

//instantiate DbConnect class
$db = new DbConnect();

//get input values from login form
$email = $_POST['email'];
$password = $_POST['password'];

//query database
$query = "SELECT * FROM ieo WHERE email=:email AND password=:pwd";

$query = $db->prepareSmt($query);

$query->bindParam(":pwd", $password);
$query->bindParam(":email", $email);

$query->execute();//execute query

if ($query->rowCount() > 0) {
    $user = $query->fetch(PDO::FETCH_OBJ);
    $_SESSION['email'] = $user->email;
    header("Location: year.php");
} else {
    header("Location: index.php?error=invalid");
}
