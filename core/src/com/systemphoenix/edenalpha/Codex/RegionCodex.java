package com.systemphoenix.edenalpha.Codex;

public class RegionCodex {

    public static final String[]
        codes = {
            "    CAR     ",
            "  Region I  ",
            " Region  II ",
            " Region III ",
            " Region IVA ",
            " Region IVB ",
            "  Region V  ",
            " Region  VI ",
            " Region VII ",
            " Region VIII",
            " Region  IX ",
            "  Region X  ",
            " Region  XI ",
            " Region XII ",
            " Region XIII",
            "    ARMM    ",
            "     NCR    "
        },
//            names = {
//            "  Cordillera Administrative Region  ",
//            "                Ilocos              ",
//            "            Cagayan Valley          ",
//            "            Central  Luzon          ",
//            "              CALABARZON            ",
//            "               MIMAROPA             ",
//            "                Bicol               ",
//            "           Western Visayas          ",
//            "           Central Visayas          ",
//            "           Eastern Visayas          ",
//            "         Zamboanga Peninsula        ",
//            "          Northern Mindanao         ",
//            "                Davao               ",
//            "             SOCCSKSARGEN           ",
//            "                Caraga              ",
//            "Autonomous Region in Muslim Mindanao",
//            "       National Capital Region      "
//        };
        names = {
            "Cordillera Administrative Region",
            "Ilocos",
            "Cagayan Valley",
            "Central Luzon",
            "CALABARZON",
            "MIMAROPA",
            "Bicol",
            "Western Visayas",
            "Central Visayas",
            "Eastern Visayas",
            "Zamboanga Peninsula",
            "Northern Mindanao",
            "Davao",
            "SOCCSKSARGEN",
            "Caraga",
            "Autonomous Region in Muslim Mindanao",
            "National Capital Region"
        };


    public static final float[]
        forestPercentage = {
            81, 37, 64, 44, 35, 64, 31, 30, 35, 52, 54, 52, 63, 61, 71, 51, 24
        },
        startingResource = {
            50, 100, 150, 200, 250, 300, 325, 350, 375, 400, 425, 450, 475, 500, 550, 600, 700
        },
        camX = {
            685f,   645f,  725f, 685f, 745f, 645f, 875f, 795f, 905f, 995f, 825f, 965f, 1065f, 985f, 1075f, 765f, 685f
        },
        camY = {
            1055f, 1095f, 1125f, 905f, 795f, 675f, 735f, 525f, 465f, 565f, 275f, 325f,  225f, 195f,  405f, 195f, 835f
        };

    public static final int mapIndeces[] = {
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16
        };

    public static final int timeStart[] = {
            64, 64, 64, 64, 64, 64, 64, 64, 65, 64, 64, 64, 66, 65, 64, 64, 65
        };

    public static final float sunlight[] = {
            1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.5f
        };

    public static final int waves[][][] = {{
                    {0},        {1},        {0, 1},         {1, 0},         {0, 1, 1},      {1, 0},         {0, 1},         {1, 0},         {0, 1},         {1}  //0
            }, {
                    {0, 1},     {1, 0},     {0, 1},         {1, 0},         {0, 1},         {0, 0, 0, 2},   {0, 0, 2},      {0, 1, 2},      {0, 2},         {1, 2}  //1
            }, {
                    {0},        {0, 0, 1},  {0, 0, 1},      {0, 1},         {1},            {2, 0},         {0, 1, 2},      {2, 1, 0},      {0, 1, 2},      {2}  //2
            }, {
                    {1, 0},     {1, 2},     {0, 1, 2},      {0, 0, 0, 2},   {2},            {2, 1},         {2, 1, 0},      {2, 1},         {0, 1},         {3}  //3
            }, {
                    {3},        {2, 1},     {0, 1},         {1, 0},         {2},            {2, 3},         {0, 1, 2},      {2, 1, 0},      {1, 2, 3},      {3}  //4
            }, {
                    {0, 0, 3},  {1, 3},     {0, 1, 3},      {3, 1, 2, 0},   {3, 2},         {3, 0, 3},      {2, 1},         {1, 2, 3},      {3, 0},         {4}  //5
            }, {
                    {0},        {1, 0},     {2, 3},         {3, 4},         {4},            {0, 4},         {1, 4},         {0, 4},         {3, 4},         {4}  //6
            }, {
                    {1, 2, 3},  {2, 3, 4},  {0, 1, 2},      {0, 2, 4},      {1, 2, 3, 4},   {4, 3},         {3, 4},         {2, 3, 4},      {4, 1, 2},      {4}  //7
            }, {
                    {3},        {4},        {3, 4},         {4, 3},         {3, 4},         {4, 3},         {3, 4},         {4, 3},         {3, 4},         {4}  //3
            }, {
                    {3, 4},     {4, 3},     {3, 4},         {4, 3},         {4},            {0, 1, 2, 4},   {3, 1, 2, 4},   {1, 2, 3, 4},   {3, 4},         {4, 5}  //4
            }, {
                    {3},        {3, 3, 4},  {3, 3, 5},      {3, 4},         {4, 5},         {5, 3},         {3, 4, 5},      {5, 4, 3},      {3, 4, 5},      {5}  //5
            }, {
                    {3},        {3, 3, 5},  {3, 4, 5},      {3, 4},         {5},            {5, 4, 3},      {3, 4, 5},      {3, 4},         {3, 4, 5},      {6}  //6
            }, {
                    {3, 4},     {5, 3, 4},  {3, 4},         {4, 3},         {6, 5},         {3, 6},         {3, 4, 5},      {5, 4, 3},      {4, 3, 6},      {6}  //7
            }, {
                    {3, 4, 5},  {4, 5, 6},  {3, 4, 5, 6},   {6, 4, 5, 3},   {6},            {6, 3},         {6, 4},         {6, 5},         {4, 5, 6},      {7}  //4
            }, {
                    {3, 3, 7},  {7, 3},     {7, 4, 3},      {7, 5, 3},      {6, 6, 6, 7},   {3, 7},         {4, 7},         {5, 7},         {6, 7},         {7}  //5
            }, {
                    {4, 5, 6},  {5, 6, 7},  {3, 4, 5},      {3, 5, 7},      {6, 7},         {7, 6},         {6, 7},         {5, 6, 7},      {7, 4, 5},      {7}  //6
            }, {
                    {3},        {4},        {5},            {6},            {3, 4, 5, 6, 7},{3, 3, 3, 3, 7},{4, 4, 7, 4, 7},{7, 5, 7, 5, 7},{7, 6, 7, 7, 7},{7}  //57
            },
        };

    public static final String mapSound[] = {
            "01.ogg", "02.mp3", "03.ogg", "04.mp3", "05.ogg", "06.mp3", "07.ogg", "02.mp3", "04.mp3", "06.mp3", "01.ogg", "02.mp3", "03.ogg", "04.mp3", "05.ogg", "06.mp3", "07.ogg"
    };

}
