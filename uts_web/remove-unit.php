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

if ($_SERVER['REQUEST_METHOD'] == 'GET') {
    //get input values

    if(!isset($_GET['id'])) {
        $response['error'] = true;
        $response['message'] = 'id not provided';
    } else {
        $query = 'SELECT * FROM requirements WHERE id=:id';
        $query = $db->prepareSmt($query);
        $query->bindParam(":id", $_GET['id']);

        $query->execute();

        if(!$query->rowCount() > 0) {
            $response['error'] = true;
            $response['message'] = 'unit with that id does not exist';
        } else {
            $query = 'DELETE FROM requirements WHERE id=:id';
            $query = $db->prepareSmt($query);
            $query->bindParam(':id', $_GET['id']);
            $query->execute();

            $response['error'] = false;
            $response['id'] = $_GET['id'];
        }
    }
} else {
    $response['error'] = true;
    $response['message'] = 'method not allowed';
}

echo json_encode($response);