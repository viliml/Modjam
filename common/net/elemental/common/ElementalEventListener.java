package net.elemental.common;

import net.elemental.lib.ShrineHelper;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;

public class ElementalEventListener
{
	@ForgeSubscribe
	public void playerInteractListener(PlayerInteractEvent event)
	{
		ShrineHelper.buildShrine(event.entityPlayer.worldObj, event.x, event.y, event.z);
		if (event.action != Action.RIGHT_CLICK_BLOCK)
			return;
		if (event.face != 1)
			return;
		if (event.entityPlayer.getCurrentEquippedItem() == null)
			return;
		if (event.entityPlayer.getCurrentEquippedItem().getItem().itemID !=
				ShrineHelper.ACTIVATOR_ITEM_ID)
			return;
		if (!ShrineHelper.canMakePortal(event.entityPlayer.worldObj, event.x, event.x, event.z))
			return;
		
	}
}
