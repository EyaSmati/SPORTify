<?php

namespace App\Controller;

use App\Entity\Salledesport;
use App\Entity\Zone;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
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

    /**
     * @Route("/Salle", name="Salle")
     */
    public function Salle(Request $request): Response
    {
        $var=$request->query->get('users');
        if ($var!="")
        {
            $Salles = $this->getDoctrine()->getRepository(Salledesport::class)->findBy(array('nomSalle' => $var));
        }
        else
        {
            $Salles = $this->getDoctrine()
                ->getRepository(Salledesport::class)
                ->findAll();
        }


        return $this->render('Front/Salle.html.twig', [
            'Salles' => $Salles,
        ]);
    }



}
