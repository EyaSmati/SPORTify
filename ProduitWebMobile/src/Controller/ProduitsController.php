<?php

namespace App\Controller;

use App\Entity\CategorieProduit;
use App\Entity\Produits;
use App\Form\ProduitsType;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\Serializer\Normalizer\NormalizerInterface;
use Symfony\Component\Serializer\SerializerInterface;

/**
 * @Route("/produits")
 */
class ProduitsController extends AbstractController
{
    /**
     * @Route("/AllProducts", name="AllProducts")
     */
    public function AllProducts(NormalizerInterface $Normalizer)
    {
        $repository = $this->getDoctrine()->getRepository(Produits::class);
        $Produit = $repository->findAll();
        $jsonContent = $Normalizer->normalize($Produit, 'json',['groups'=>'post:read']);
        return new Response(json_encode($jsonContent));
    }

    /**
     * @Route("/addProductJSON", name="addProductJSON")
     */
    public function addProductJSON(Request $request,NormalizerInterface $Normalizer)
    {
        $em = $this->getDoctrine()->getManager();
        $produit = new Produits();
        $categorieproduit=new CategorieProduit();
        $categorieproduit = $this->getDoctrine()->getManager()->getRepository(CategorieProduit::class)->find($request->get("type"));
        $produit ->setId($request->get('id'));
        $produit ->setLibelle($request->get('libelle'));
        $produit ->setQuantites($request->get('quantites'));
        $produit ->setPrix($request->get('prix'));
        $produit->setType($categorieproduit);
        $em->persist($produit );
        $em->flush();
        $jsonContent = $Normalizer->normalize($produit ,'json',['groups'=>'post:read']);
        return new Response(json_encode($jsonContent));


    }

    /**
     * @Route("/{id}/updateProductJSON", name="updateProductJSON")
     */
    public function updateProductJSON(Request $request,NormalizerInterface $Normalizer,$id)
    {
        $em = $this->getDoctrine()->getManager();
        $produit = $em->getRepository(Produits::class)->find($id);

        $categorieproduit=new CategorieProduit();
        $categorieproduit = $this->getDoctrine()->getManager()->getRepository(CategorieProduit::class)->find($request->get("type"));
        $produit ->setId($request->get('id'));
        $produit ->setLibelle($request->get('libelle'));
        $produit ->setQuantites($request->get('quantites'));
        $produit ->setPrix($request->get('prix'));
        $produit->setType($categorieproduit);
        $em->flush();
        $jsonContent = $Normalizer->normalize($produit,'json',['groups'=>'post:read']);
        return new Response("info updated successfully".json_encode($jsonContent));


    }

    /**
     * @Route("/{id}/deleteProductJSON", name="deleteProductJSON")
     */
    public function deleteProductJSON(Request $request,NormalizerInterface $Normalizer,$id)
    {
        $em = $this->getDoctrine()->getManager();
        $produit = $em->getRepository(Produits::class)->find($id);
        $em->remove($produit);
        $em->flush();
        $jsonContent = $Normalizer->normalize($produit,'json',['groups'=>'post:read']);
        return new Response("Product deleted successfully".json_encode($jsonContent));


    }
}