<?php
/**
 * Created by PhpStorm.
 * User: boaz
 * Date: 04/05/18
 * Time: 17:32
 */

require_once "config.php";

class DbConnect
{
    public $pdo;
    private $host = DB_HOST;
    private $dbName = DB_NAME;
    private $dbUser = DB_USER;

    function __construct()
    {

        $this->connect();

    }

    function connect() {
        try{
        $this->pdo = new PDO('mysql:host='.$this->host.';dbname='.$this->dbName, $this->dbUser);
        }catch (PDOException $exception){
            echo $exception->getMessage();
        }
    }

    function prepareSmt($smt){
        try{
            $smt = $this->pdo->prepare($smt);
            return $smt;
        }catch (PDOException $exception){
            echo $exception->getMessage();
        }

    }


}