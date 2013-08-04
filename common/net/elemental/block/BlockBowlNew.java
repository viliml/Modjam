package net.elemental.block;

import java.util.Random;

import net.elemental.lib.GeneralHelper;
import net.elemental.tileentity.TileEntityBowl;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockBowlNew extends BlockContainer
{
	public BlockBowlNew(int id)
	{
		super(id, Material.wood);
		setBlockBounds(1F / 16F, 0F, 1F / 16F, 15F / 16F, 5F / 16F, 15F / 16F);
	}

	@Override
	public TileEntity createNewTileEntity(World world)
	{
		return new TileEntityBowl();
	}

	@Override
	public int getRenderType()
	{
		return -1;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public void registerIcons(IconRegister iconRegister)
	{
		blockIcon = iconRegister.registerIcon("bowlBlock_bottom");
	}
	
	@Override
	public void randomDisplayTick(World world, int x, int y, int z, Random rand)
	{
		if(world.getBlockMetadata(x, y, z) == 0)
		{System.out.println(GeneralHelper.nextDouble(rand, 2 / 16, 14 / 16));
			world.spawnParticle("flame", x + GeneralHelper.nextDouble(rand, 2 / 16, 14 / 16), y + 0.25D, z + GeneralHelper.nextDouble(rand, 2 / 16, 14 / 16), 0D, 0D, 0D);
		}
	}
}