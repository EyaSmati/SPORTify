<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;

/**
 * Evennement
 *
 * @ORM\Table(name="evennement")
 * @ORM\Entity
 */
class Evennement
{
    /**
     * @var int
     *
     * @ORM\Column(name="id_evennement", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */    private $idEvennement;

    /**
     * @var string
     *
     * @ORM\Column(name="nom_evennement", type="string", length=50, nullable=false)
     *@Assert\NotBlank(message="nomennement is required")
     */
    private $nomEvennement;

    /**
     * @var int
     *
     * @ORM\Column(name="nbplaces", type="integer", nullable=false)
     * @Assert\NotBlank(message="nbplaces is required")
     * @Assert\Length(
     *
     *      max = 8,
     *      maxMessage = "Your nbplaces cannot be longer than {{ limit }} characters"
     * )
     */
    private $nbplaces;

    /**
     * @var string
     *
     * @ORM\Column(name="description", type="string", length=255, nullable=false)
     *@Assert\NotBlank(message="description is required")
     */
    private $description;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="date", type="datetime", nullable=false)
     */
    private $date;

    /**
     * @var \Salledesport
     *
     * @ORM\ManyToOne(targetEntity="Salledesport")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="Nom_Salle", referencedColumnName="Nom_Salle")
     * })
     */
    private $nomSalle;

    /**
     * @return int
     */
    public function getIdEvennement(): ?int
    {
        return $this->idEvennement;
    }

    /**
     * @param int $idEvennement
     */
    public function setIdEvennement(int $idEvennement): void
    {
        $this->idEvennement = $idEvennement;
    }

    /**
     * @return string
     */
    public function getNomEvennement(): ?string
    {
        return $this->nomEvennement;
    }

    /**
     * @param string $nomEvennement
     */
    public function setNomEvennement(string $nomEvennement): void
    {
        $this->nomEvennement = $nomEvennement;
    }

    /**
     * @return int
     */
    public function getNbplaces(): ?int
    {
        return $this->nbplaces;
    }

    /**
     * @param int $nbplaces
     */
    public function setNbplaces(int $nbplaces): void
    {
        $this->nbplaces = $nbplaces;
    }

    /**
     * @return string
     */
    public function getDescription(): ?string
    {
        return $this->description;
    }

    /**
     * @param string $description
     */
    public function setDescription(string $description): void
    {
        $this->description = $description;
    }

    /**
     * @return \DateTime
     */
    public function getDate(): ?\DateTime
    {
        return $this->date;
    }

    /**
     * @param \DateTime $date
     */
    public function setDate(\DateTime $date): void
    {
        $this->date = $date;
    }

    /**
     * @return Salledesport
     */
    public function getNomSalle(): ?Salledesport
    {
        return $this->nomSalle;
    }

    /**
     * @param Salledesport $nomSalle
     */
    public function setNomSalle(Salledesport $nomSalle): void
    {
        $this->nomSalle = $nomSalle;
    }


}
