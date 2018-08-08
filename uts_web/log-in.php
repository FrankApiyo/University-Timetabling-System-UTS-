<?php
session_start();
require_once "./database/DbConnect.php";

$db=new DbConnect();

//get user's information
$email=$_POST['email'];
$password=$_POST['password'];

$result="SELECT * FROM users WHERE email=:email";

$result = $db->prepareSmt($result);

$result->bindParam(":email", $email);

$result->execute();

if($result->rowCount() > 0) {
    $user = $result->FETCH(PDO::FETCH_OBJ);
    if(password_verify($password, $user->password)){
$_SESSION['email'] = $user->email;
        header("Location: year.php");
    } else {
        header("Location: index.php?error=invalid");
    }
} else {
    header("Location: index.php?error=invalid");
}
