package net.elemental.tileentity;

import java.util.Random;

import net.elemental.lib.GeneralHelper;
import net.elemental.lib.ShrineHelper;
import net.minecraft.tileentity.TileEntity;

public class TileEntityBowl extends TileEntity
{
	private int timer = 50;
	
	@Override
	public void updateEntity() 
	{
		if (timer > 0)
		{
			--timer;
			return;
		}
		
		ShrineHelper.buildNextBlock(this.worldObj, this.xCoord, this.yCoord, this.zCoord, GeneralHelper.PARTICLES[(new Random()).nextInt(4)]);
		timer = 50;
	}
	
	@Override
	public boolean canUpdate()
    {
        return this.getBlockMetadata() == 0;
    }
}