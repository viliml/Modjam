package net.elemental.common;

import net.elemental.biome.BasicElementalBiomeGen;
import net.elemental.block.Blocks;
import net.elemental.entity.passive.IElementalEntity;
import net.elemental.lib.ShrineHelper;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingSpawnEvent.SpecialSpawn;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;

public class ElementalEventListener
{
	@ForgeSubscribe
	public void playerInteractListener(PlayerInteractEvent event)
	{
		if (event.action != Action.RIGHT_CLICK_BLOCK)
			return;
		if (event.face != 1)
			return;
		if (event.entityPlayer.getCurrentEquippedItem() == null)
			return;
		if (event.entityPlayer.getCurrentEquippedItem().getItem().itemID !=
				ShrineHelper.ACTIVATOR_ITEM_ID)
			return;
		if (event.entityPlayer.capabilities.isCreativeMode)
			ShrineHelper.buildShrine(event.entityPlayer.worldObj, event.x, event.y, event.z);
		if (!ShrineHelper.canMakePortal(event.entityPlayer.worldObj, event.x, event.y, event.z))
			return;
		event.entityPlayer.worldObj.setBlock(event.x, event.y + 1, event.z, Blocks.portalBlock.blockID);
	}
	
	@ForgeSubscribe
	public void elementalSpawn(SpecialSpawn event)
	{
		if (!(event.entity instanceof IElementalEntity))
			return;
		if (!(event.entity.worldObj.
				getBiomeGenForCoords((int) event.x, (int) event.z) instanceof BasicElementalBiomeGen))
		{
			event.setCanceled(true);
			return;
		}
		((IElementalEntity)event.entity).setBiome(((BasicElementalBiomeGen)event.entity.worldObj.
				getBiomeGenForCoords((int) event.x, (int) event.z)).getBiome());
		event.setCanceled(false);
	}
}
