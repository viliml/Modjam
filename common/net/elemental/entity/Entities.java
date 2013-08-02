package net.elemental.entity;

import net.elemental.Elemental;
import net.elemental.entity.passive.*;
import cpw.mods.fml.common.registry.EntityRegistry;

public class Entities {
	public static void init()
	{
		EntityRegistry.registerModEntity(EntityElementalBat.class, "elementalBat",
				0, Elemental.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityElementalChicken.class, "elementalChicken",
				1, Elemental.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityElementalCow.class, "elementalCow",
				2, Elemental.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityElementalHorse.class, "elementalHorse",
				3, Elemental.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityElementalOcelot.class, "elementalOcelot",
				4, Elemental.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityElementalPig.class, "elementalPig",
				5, Elemental.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityElementalSheep.class, "elementalSheep",
				6, Elemental.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityElementalSquid.class, "elementalSquid",
				7, Elemental.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityElementalWolf.class, "elementalWold",
				8, Elemental.instance, 80, 3, true);
	}
}
