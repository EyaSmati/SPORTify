<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Salledesport
 *
 * @ORM\Table(name="salledesport", uniqueConstraints={@ORM\UniqueConstraint(name="Nom_Salle", columns={"Nom_Salle"})})
 * @ORM\Entity
 */
class Salledesport
{
    /**
     * @var string
     *
     * @ORM\Column(name="ID_Salle", type="string", length=255, nullable=false)

     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idSalle;

    /**
     * @var string
     *
     * @ORM\Column(name="Nom_Salle", type="string", length=255, nullable=false)
     * @ORM\Id
     */
    private $nomSalle;

    /**
     * @var string
     *
     * @ORM\Column(name="Adresse", type="string", length=255, nullable=false)
     */
    private $adresse;

    /**
     * @var string
     *
     * @ORM\Column(name="Region", type="string", length=255, nullable=false)
     */
    private $region;

    /**
     * @var int
     *
     * @ORM\Column(name="HDebut", type="integer", nullable=false)
     */
    private $hdebut;

    /**
     * @var int
     *
     * @ORM\Column(name="HFin", type="integer", nullable=false)
     */
    private $hfin;

    /**
     * @var int
     *
     * @ORM\Column(name="Min", type="integer", nullable=false)
     */
    private $min;

    /**
     * @var int
     *
     * @ORM\Column(name="NumTel", type="integer", nullable=false)
     */
    private $numtel;

    /**
     * @return string
     */
    public function getNomSalle(): string
    {
        return $this->nomSalle;
    }

    /**
     * @param string $nomSalle
     */
    public function setNomSalle(string $nomSalle): void
    {
        $this->nomSalle = $nomSalle;
    }

    public function __toString() {
        return $this->getNomSalle();
    }

}
