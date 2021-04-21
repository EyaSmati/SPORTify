<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Utilisateur
 *
 * @ORM\Table(name="utilisateur", uniqueConstraints={@ORM\UniqueConstraint(name="surnom", columns={"surnom"})})
 * @ORM\Entity
 */
class Utilisateur
{
    /**
     * @var int
     *
     * @ORM\Column(name="id", type="integer", nullable=false)

     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $id;

    /**
     * @var string
     *
     * @ORM\Column(name="surnom", type="string", length=255, nullable=false)
     * @ORM\Id
     */
    private $surnom;

    /**
     * @var string
     *
     * @ORM\Column(name="prenom", type="string", length=255, nullable=false)
     */
    private $prenom;

    /**
     * @var string
     *
     * @ORM\Column(name="nom", type="string", length=255, nullable=false)
     */
    private $nom;

    /**
     * @var string
     *
     * @ORM\Column(name="numeroDeTelephone", type="string", length=255, nullable=false)
     */
    private $numerodetelephone;

    /**
     * @var string
     *
     * @ORM\Column(name="email", type="string", length=255, nullable=false)
     */
    private $email;

    /**
     * @var string
     *
     * @ORM\Column(name="password", type="string", length=255, nullable=false)
     */
    private $password;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="dateDeNaissance", type="date", nullable=false)
     */
    private $datedenaissance;

    /**
     * @var string
     *
     * @ORM\Column(name="sexe", type="string", length=255, nullable=false)
     */
    private $sexe;

    /**
     * @var string
     *
     * @ORM\Column(name="role", type="string", length=255, nullable=false)
     */
    private $role;

    /**
     * @var int|null
     *
     * @ORM\Column(name="nbrEvaluation", type="integer", nullable=true)
     */
    private $nbrevaluation;

    /**
     * @var float|null
     *
     * @ORM\Column(name="evaluationCoach", type="float", precision=10, scale=0, nullable=true)
     */
    private $evaluationcoach;

    /**
     * @var string|null
     *
     * @ORM\Column(name="image", type="blob", length=0, nullable=true)
     */
    private $image;

    /**
     * @return string
     */
    public function getSurnom(): ?string
    {
        return $this->surnom;
    }

    /**
     * @param string $surnom
     */
    public function setSurnom(string $surnom): void
    {
        $this->surnom = $surnom;
    }
    public function __toString() {
        return $this->getSurnom();
    }

}
