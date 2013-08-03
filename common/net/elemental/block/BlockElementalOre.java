package net.elemental.block;

import java.util.List;
import java.util.Random;

import net.elemental.lib.GeneralHelper;
import net.elemental.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockElementalOre extends Block {

	private Icon[] icons;
	private boolean second;

	public BlockElementalOre(int id, boolean isSecond) {
		super(id, Material.rock);
		setCreativeTab(CreativeTabs.tabBlock);
		second = isSecond;
		setHardness(3F);
		setResistance(5F);
		setStepSound(soundStoneFootstep);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void getSubBlocks(int id, CreativeTabs tab, List list)
	{
		for (int i = 0; i < 16; ++i)
			list.add(new ItemStack(id, 1, i));
	}

	@Override
	public void registerIcons(IconRegister iconRegister)
	{
		icons = new Icon[16];
		int i, j;
		if (second)
			for (i = 0; i < 4; ++i)
				for (j = 0; j < 4; ++j)
					icons[i * 4 + j] = iconRegister.registerIcon(
							Reference.MOD_ID + ":" +
									GeneralHelper.ELEMENTS[j].toLowerCase() + "_" +
									GeneralHelper.ORES[i + 4].toLowerCase() + "_ore");
		else
			for (i = 0; i < 4; ++i)
				for (j = 0; j < 4; ++j)
					icons[i * 4 + j] = iconRegister.registerIcon(
							Reference.MOD_ID + ":" +
									GeneralHelper.ELEMENTS[j].toLowerCase() + "_" +
									GeneralHelper.ORES[i].toLowerCase() + "_ore");
		//Register the active redstone icons. Simpler than to make an if in getIcon()
		if (second)
			for (i = 0; i < 4; i++) icons[12 + i] = icons[i];
	}

	@Override
	public Icon getIcon(int side, int meta)
	{
		return icons[meta];
	}

	@SideOnly(Side.CLIENT)
	@Override
	public int getLightValue(IBlockAccess world, int x, int y, int z)
	{
		if (second && (world.getBlockMetadata(x, y, z) >> 2) == 3)
			return 15;
		return 0;
	}

	@Override
	public int damageDropped(int meta)
	{
		return meta;
	}

	@Override
	public int tickRate(World world)
	{
		return second ? 30 : 0;
	}

	@Override
	public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player)
	{
		glow(world, x, y, z);
		super.onBlockClicked(world, x, y, z, player);
	}

	@Override
	public void onEntityWalking(World world, int x, int y, int z, Entity par5Entity)
	{
		glow(world, x, y, z);
		super.onEntityWalking(world, x, y, z, par5Entity);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float par7, float par8, float par9)
	{
		glow(world, x, y, z);
		return super.onBlockActivated(world, x, y, z, player, side, par7, par8, par9);
	}

	private void glow(World world, int x, int y, int z)
	{
		sparkle(world, x, y, z);

		if (second && (world.getBlockMetadata(x, y, z) >> 2) == 0)
		{
			world.setBlock(x, y, z, blockID, world.getBlockMetadata(x, y, z) + 12, 3);
		}
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
	{
		if (second && (world.getBlockMetadata(x, y, z) >> 2) == 3)
		{
			world.setBlock(x, y, z, blockID, world.getBlockMetadata(x, y, z) - 12, 3);
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void randomDisplayTick(World world, int x, int y, int z, Random par5Random)
	{
		if (second && (world.getBlockMetadata(x, y, z) >> 2) == 3)
		{
			sparkle(world, x, y, z);
		}
	}

	private void sparkle(World world, int x, int y, int z)
	{
		Random random = world.rand;
		double d0 = 0.0625D;

		for (int l = 0; l < 6; ++l)
		{
			double d1 = (double)((float)x + random.nextFloat());
			double d2 = (double)((float)y + random.nextFloat());
			double d3 = (double)((float)z + random.nextFloat());

			if (l == 0 && !world.isBlockOpaqueCube(x, y + 1, z))
			{
				d2 = (double)(y + 1) + d0;
			}

			if (l == 1 && !world.isBlockOpaqueCube(x, y - 1, z))
			{
				d2 = (double)(y + 0) - d0;
			}

			if (l == 2 && !world.isBlockOpaqueCube(x, y, z + 1))
			{
				d3 = (double)(z + 1) + d0;
			}

			if (l == 3 && !world.isBlockOpaqueCube(x, y, z - 1))
			{
				d3 = (double)(z + 0) - d0;
			}

			if (l == 4 && !world.isBlockOpaqueCube(x + 1, y, z))
			{
				d1 = (double)(x + 1) + d0;
			}

			if (l == 5 && !world.isBlockOpaqueCube(x - 1, y, z))
			{
				d1 = (double)(x + 0) - d0;
			}

			if (d1 < (double)x || d1 > (double)(x + 1) || d2 < 0.0D || d2 > (double)(y + 1) || d3 < (double)z || d3 > (double)(z + 1))
			{
				world.spawnParticle("reddust", d1, d2, d3, 0.0D, 0.0D, 0.0D);
			}
		}
	}
}
