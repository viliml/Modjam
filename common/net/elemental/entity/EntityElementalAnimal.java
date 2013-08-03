package net.elemental.entity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.world.World;

public class EntityElementalAnimal extends EntityAnimal {

	private EntityAnimal wrapped;

	public EntityElementalAnimal(World par1World, EntityAnimal entity) {
		super(par1World);
		wrapped = entity;
		setSize(wrapped.width, wrapped.height);
		getNavigator().setAvoidsWater(wrapped.getNavigator().getAvoidsWater());
		getNavigator().setBreakDoors(wrapped.getNavigator().getCanBreakDoors());
		tasks.taskEntries = wrapped.tasks.taskEntries;
	}

	@Override
	public EntityAgeable createChild(EntityAgeable entityageable) {
		return wrapped.createChild(entityageable);
	}

	@Override
	public boolean isAIEnabled()
	{
		return true;
	}
	
	public boolean canBeSteered()
    {
        return wrapped.canBeSteered();
    }
}
