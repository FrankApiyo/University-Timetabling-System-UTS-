<?php
/**
 * Created by PhpStorm.
 * User: Kogie
 * Date: 12/08/2018
 * Time: 23:11
 */
session_start();//start session
require_once "./database/DbConnect.php";

$db = new DbConnect();

$response = array();

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    //get input values
    $unit_name = $_POST['unit_name'];
    $unit_code = $_POST['unit_code'];
    $unit_cf = $_POST['unit_cf'];
    $lecture = $_POST['lecture'];
    $practical = $_POST['practical'];
    $students = $_POST['students'];
    $lec_name = $_POST['lec_name'];

    $query = 'SELECT * FROM requirements WHERE code=:code OR name=:name';
    $query = $db->prepareSmt($query);
    $query->bindParam(":code", $unit_code);
    $query->bindParam(":name", $unit_name);

    $query->execute();

    if($query->rowCount() > 0) {
        $response['error'] = true;
        $response['message'] = 'unit code or title exists';
    } else {
        $query = 'INSERT INTO requirements(name, code, cf, lecture, practical, students, lecturer) VALUES (:unit_name, :code, :cf, :lecture, :practical, :students, :lecturer)';
        $query = $db->prepareSmt($query);

        $query->bindParam(":code", $unit_code);
        $query->bindParam(":unit_name", $unit_name);
        $query->bindParam(":cf", $unit_cf);
        $query->bindParam(":lecture", $lecture);
        $query->bindParam(":practical", $practical);
        $query->bindParam(":students", $students);
        $query->bindParam(":lecturer", $lec_name);

        $query->execute();

        $query = 'SELECT * FROM requirements WHERE code=:code';
        $query = $db->prepareSmt($query);
        $query->bindParam(":code", $unit_code);

        $query->execute();

        $unit = $query->fetch(PDO::FETCH_OBJ);

        $response['error'] = false;
        $response['name'] = $unit->name;
        $response['code'] = $unit->code;
        $response['cf'] = $unit->cf;
        $response['lecture'] = $unit->lecture;
        $response['practical'] = $unit->practical;
        $response['students'] = $unit->students;
        $response['lecturer'] = $unit->lecturer;
        $response['id'] = $unit->id;
    }
} else {
    $response['error'] = true;
    $response['message'] = 'method not allowed';
}

echo json_encode($response);