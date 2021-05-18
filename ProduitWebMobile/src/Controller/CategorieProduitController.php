<?php

namespace App\Controller;


use App\Entity\CategorieProduit;
use App\Form\CategorieProduitType;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Doctrine\ORM\Query\ResultSetMapp;
use Doctrine\ORM\Query\ResultSetMapping;
use Symfony\Component\Serializer\Normalizer\NormalizerInterface;
use Symfony\Component\Serializer\SerializerInterface;

/**
 * @Route("/categorie")
 */
class CategorieProduitController extends AbstractController
{
    /**
     * @Route("/AllCategories", name="AllCategories")
     */
    public function AllCategories(NormalizerInterface $Normalizer)
    {
        $repository = $this->getDoctrine()->getRepository(CategorieProduit::class);
        $categorieproduit = $repository->findAll();
        $jsonContent = $Normalizer->normalize($categorieproduit, 'json', ['groups' => 'post:read']);
        return new Response(json_encode($jsonContent));
    }

    /**
     * @Route("/addCategorieJSON", name="addCategorieJSON")
     */
    public function addCategorieJSON(Request $request, NormalizerInterface $Normalizer)
    {
        $em = $this->getDoctrine()->getManager();
        $categorieproduit = new CategorieProduit();
        $categorieproduit->setIdcategorie($request->get('idCategorie'));
        $categorieproduit->setTypecategorie($request->get('typeCategorie'));
        $categorieproduit->setDescription($request->get('Description'));
        $categorieproduit->setImage($request->get('Image'));

        $em->persist($categorieproduit);
        $em->flush();
        $jsonContent = $Normalizer->normalize($categorieproduit, 'json', ['groups' => 'post:read']);
        return new Response(json_encode($jsonContent));


    }

    /**
     * @Route("/{idcategorie}/updateCategorieJSON", name="updateCategorieJSON")
     */
    public function updateCategorieJSON(Request $request, NormalizerInterface $Normalizer, $idcategorie)
    {
        $em = $this->getDoctrine()->getManager();
        $categorieproduit = $em->getRepository(CategorieProduit::class)->find($idcategorie);
        $categorieproduit->setIdcategorie($request->get('idCategorie'));
        $categorieproduit->setTypecategorie($request->get('typeCategorie'));
        $categorieproduit->setDescription($request->get('Description'));
        $categorieproduit->setImage($request->get('Image'));
        $em->flush();
        $jsonContent = $Normalizer->normalize($categorieproduit, 'json', ['groups' => 'post:read']);
        return new Response("info updated successfully" . json_encode($jsonContent));


    }

    /**
     * @Route("/{idcategorie}/deleteCategorieJSON", name="deleteCategorieJSON")
     */
    public function deleteCategorieJSON(Request $request, NormalizerInterface $Normalizer, $idcategorie)
    {
        $em = $this->getDoctrine()->getManager();
        $categorieproduit = $em->getRepository(CategorieProduit::class)->find($idcategorie);
        $em->remove($categorieproduit);
        $em->flush();
        $jsonContent = $Normalizer->normalize($categorieproduit, 'json', ['groups' => 'post:read']);
        return new Response("Category deleted successfully" . json_encode($jsonContent));


    }
}