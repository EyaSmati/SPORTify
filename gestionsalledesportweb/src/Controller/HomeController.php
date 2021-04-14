<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class HomeController extends AbstractController
{
    /**
     * @Route("/home", name="home")
     */
    public function index(): Response
    {
        return $this->render('home/index.html.twig');

    }
    /**
     * @Route("/ajouter", name="ajouter")
     */
    public function ajouter(): Response
    {
        return $this->render('home/ajouter.html.twig');

    }
    /**
     * @Route("/Front", name="front")
     */
    public function index_Front(): Response
    {
        return $this->render('Front/index.html.twig');

    }



}
