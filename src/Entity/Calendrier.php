<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Calendrier
 *
 * @ORM\Table(name="calendrier")
 * @ORM\Entity
 */
class Calendrier
{
    /**
     * @var int
     *
     * @ORM\Column(name="id_calendrier", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idCalendrier;

    /**
     * @var string
     *
     * @ORM\Column(name="title", type="string", length=255, nullable=false)
     */
    private $title;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="start", type="datetime", nullable=false)
     */
    private $start;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="end", type="datetime", nullable=false)
     */
    private $end;

    /**
     * @var string
     *
     * @ORM\Column(name="description", type="text", length=65535, nullable=false)
     */
    private $description;

    /**
     * @var bool
     *
     * @ORM\Column(name="all_day", type="boolean", nullable=false)
     */
    private $allDay;

    /**
     * @var string
     *
     * @ORM\Column(name="background_color", type="string", length=7, nullable=false)
     */
    private $backgroundColor;

    /**
     * @var string
     *
     * @ORM\Column(name="border_color", type="string", length=7, nullable=false)
     */
    private $borderColor;

    /**
     * @var string
     *
     * @ORM\Column(name="text_color", type="string", length=7, nullable=false)
     */
    private $textColor;


}
