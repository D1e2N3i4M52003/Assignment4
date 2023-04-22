package model;

import multiton.Ore;
import multiton.Valuable;

import java.util.Random;

public abstract class Mine
{
    public static boolean copperMined = false;
    public static boolean ironMined = false;
    public static boolean goldMined = false;
    public static boolean emeraldMined = false;
    public static boolean diamondMined = false;

    public static Valuable mine()
    {
        Random random = new Random();
        int code = random.nextInt(5);
        switch (code)
        {
            case 0:
                if (!copperMined)
                {
                    copperMined = true;
                    return Valuable.getOre(Ore.COPPER);
                }
                else
                {
                    System.out.println("Copper already mined!");
                }
                break;
            case 1:
                if (!ironMined)
                {
                    ironMined = true;
                    return Valuable.getOre(Ore.IRON);
                }
                else
                {
                    System.out.println("Iron already mined!");
                }
                break;
            case 2:
                if (!goldMined)
                {
                    goldMined = true;
                    return Valuable.getOre(Ore.GOLD);
                }
                else
                {
                    System.out.println("Gold already mined!");
                }
                break;
            case 3:
                if (!emeraldMined)
                {
                    emeraldMined = true;
                    return Valuable.getOre(Ore.EMERALD);
                }
                else
                {
                    System.out.println("Emerald already mined!");
                }
                break;
            case 4:
                if (!diamondMined)
                {
                    diamondMined = true;
                    return Valuable.getOre(Ore.DIAMOND);
                }
                else
                {
                    System.out.println("Diamond already mined!");
                }
                break;
        }
		return null;
    }
}
