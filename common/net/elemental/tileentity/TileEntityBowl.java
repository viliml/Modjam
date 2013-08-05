package net.elemental.tileentity;

import java.util.Random;

import net.elemental.lib.GeneralHelper;
import net.elemental.lib.ShrineHelper;
import net.minecraft.tileentity.TileEntity;

public class TileEntityBowl extends TileEntity
{
	private int timer;
	
	public TileEntityBowl()
	{
		timer = 25;
	}
	
	@Override
	public void updateEntity() 
	{
		if (this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord) != 0)
			return;
		if (timer > 0)
			--timer;
		else
		{
			ShrineHelper.buildNextBlock(this.worldObj, this.xCoord, this.yCoord, this.zCoord, GeneralHelper.PARTICLES[(new Random()).nextInt(4)]);
			timer = 25;
		}
	}
	
	@Override
	public boolean canUpdate()
    {
        return true;
    }
}