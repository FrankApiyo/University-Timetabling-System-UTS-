<?php
/**
 * Created by PhpStorm.
 * User: Kogie
 * Date: 07/08/2018
 * Time: 20:38
 */
session_start();
session_unset();

header("Location: index.php");