<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * SalleDeSport
 *
 * @ORM\Table(name="salledesport")
 * @ORM\Entity
 */
class SalleDeSport
{
    /**
     * @var int
     *
     * @ORM\Column(name="ID_Salle", type="integer", nullable=false)
     */
    private $idSalle;

    /**
     * @var string
     *
     * @ORM\Column(name="Nom_Salle", type="string", length=50, nullable=false)
     * @ORM\Id
     */
    private $nomSalle;

    /**
     * @var string
     *
     * @ORM\Column(name="Adresse", type="string", length=50, nullable=false)
     */
    private $adresse;

    /**
     * @var string
     *
     * @ORM\Column(name="HDebut", type="string", length=50, nullable=false)
     */
    private $hdebut;

    /**
     * @var string
     *
     * @ORM\Column(name="HFin", type="string", length=50, nullable=false)
     */
    private $hfin;

    /**
     * @var string
     *
     * @ORM\Column(name="Minn", type="string", length=50, nullable=false)
     */
    private $min;

    /**
     * @var string
     *
     * @ORM\Column(name="NumTel", type="string", length=50, nullable=false)
     */
    private $numtel;

    /**
     * @return int
     */
    public function getIdSalle(): ?int
    {
        return $this->idSalle;
    }

    /**
     * @param int $idSalle
     */
    public function setIdSalle(?int $idSalle): void
    {
        $this->idSalle = $idSalle;
    }

    /**
     * @return string
     */
    public function getNomSalle(): ?string
    {
        return $this->nomSalle;
    }

    /**
     * @param string $nomSalle
     */
    public function setNomSalle(?string $nomSalle): void
    {
        $this->nomSalle = $nomSalle;
    }

    /**
     * @return string
     */
    public function getAdresse(): ?string
    {
        return $this->adresse;
    }

    /**
     * @param string $adresse
     */
    public function setAdresse(?string $adresse): void
    {
        $this->adresse = $adresse;
    }

    /**
     * @return string
     */
    public function getHdebut(): ?string
    {
        return $this->hdebut;
    }

    /**
     * @param string $hdebut
     */
    public function setHdebut(?string $hdebut): void
    {
        $this->hdebut = $hdebut;
    }

    /**
     * @return string
     */
    public function getHfin(): ?string
    {
        return $this->hfin;
    }

    /**
     * @param string $hfin
     */
    public function setHfin(?string $hfin): void
    {
        $this->hfin = $hfin;
    }

    /**
     * @return string
     */
    public function getMin(): ?string
    {
        return $this->min;
    }

    /**
     * @param string $min
     */
    public function setMin(?string $min): void
    {
        $this->min = $min;
    }

    /**
     * @return string
     */
    public function getNumtel(): ?string
    {
        return $this->numtel;
    }

    /**
     * @param string $numtel
     */
    public function setNumtel(?string $numtel): void
    {
        $this->numtel = $numtel;
    }

    public function __toString() {
        return $this->getNomSalle();
    }


}
