<?php

namespace App\Controller;
use App\Entity\Produits;
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
     * @Route("/product", name="product")
     */
    public function product(Request $request): Response
    {
        $var=$request->query->get('users');
        if ($var!="")
        {
            $produits = $this->getDoctrine()->getRepository(Produits::class)->findBy(array('libelle' => $var));
        }
        else
        {
            $produits = $this->getDoctrine()
                ->getRepository(Produits::class)
                ->findAll();
        }


        return $this->render('Front/produits.html.twig', [
            'produits' => $produits,
        ]);
    }


}

