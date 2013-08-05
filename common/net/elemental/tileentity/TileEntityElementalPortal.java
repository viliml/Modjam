package net.elemental.tileentity;

import java.util.Random;

import net.elemental.lib.GeneralHelper;
import net.elemental.lib.ShrineHelper;
import net.minecraft.tileentity.TileEntity;

public class TileEntityElementalPortal extends TileEntity
{
	private int timer;
	
	public TileEntityElementalPortal()
	{
		timer = 0;
	}
	
	@Override
	public void updateEntity() 
	{
		if (worldObj.getBlockMetadata(xCoord, yCoord, zCoord) != 0)
			return;
		if (timer > 0)
			--timer;
		else
		{
			ShrineHelper.buildNextBlock(worldObj, xCoord, yCoord - 1, zCoord, GeneralHelper.PARTICLES[(new Random()).nextInt(4)]);
			timer = 0;
		}
		if (ShrineHelper.canMakePortal(worldObj, xCoord, yCoord - 1, zCoord))
			worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 1, 3);
	}
	
	@Override
	public boolean canUpdate()
    {
        return true;
    }
}