<?php

namespace App\Controller;

use App\Entity\Categories;
use App\Entity\Cours;
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
     * @Route("/front", name="front")
     */
    public function front(): Response
    {



        return $this->render('Front/index.html.twig');
    }
    /**
     * @Route("/course", name="course")
     */
    public function course(Request $request): Response
    {
        $var=$request->query->get('users');
        if ($var!="")
        {
            $cours = $this->getDoctrine()->getRepository(cours::class)->findBy(array('typeCours' => $var));
            $categories = $this->getDoctrine()
                ->getRepository(Categories::class)
                ->findAll();
        }
        else
        {
            $cours = $this->getDoctrine()
                ->getRepository(Cours::class)
                ->findAll();
            $categories = $this->getDoctrine()
                ->getRepository(Categories::class)
                ->findAll();
        }


        return $this->render('Front/cours.html.twig', [
            'cours' => $cours,
            'categories' => $categories,
        ]);
    }


}
