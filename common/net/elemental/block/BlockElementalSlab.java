package net.elemental.block;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockElementalSlab extends Block
{

	public BlockElementalSlab(int id)
	{
		super(id, Material.rock);
		setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
	{
		int meta = world.getBlockMetadata(x, y, z);
		if ((meta & (1 << 3)) > 0) setBlockBounds(0F, .5F, 0F, 1F, 1F, 1F);
		else setBlockBounds(0F, 0F, 0F, 1F, .5F, 1F);
	}

	@Override
	public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int meta)
	{
		if (side != 1 && hitY > .5F) return meta | (1 << 3);
		return meta;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister iconRegister)
	{

	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int side, int meta)
	{
		return Blocks.elementalStoneBlock.getIcon(side, (meta & 7) + 4);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		if (player == null)
			return false;
		ItemStack item = player.getCurrentEquippedItem();
		if (item == null)
			return false;
		if (item.itemID != blockID)
			return false;
		int meta = world.getBlockMetadata(x, y, z);
		if (side == 0)
		{
			if (item.getItemDamage() != (meta ^ (1 << 3)))
				return false;
			world.setBlock(x, y, z,
					Blocks.elementalStoneBlock.blockID, (meta & 7) + 4, 3);
			if (!player.capabilities.isCreativeMode)
				item.stackSize--;
			return true;
		}
		if (side == 1)
		{
			if (item.getItemDamage() != meta)
				return false;
			world.setBlock(x, y, z,
					Blocks.elementalStoneBlock.blockID, (meta & 7) + 4, 3);
			if (!player.capabilities.isCreativeMode)
				item.stackSize--;
			return true;
		}
		return false;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void getSubBlocks(int id, CreativeTabs tab, List list)
	{
		for (int i = 0; i < 8; ++i) list.add(new ItemStack(id, 1, i));
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public int getDamageValue(World world, int x, int y, int z)
	{
		return damageDropped(world.getBlockMetadata(x, y, z));
	}

	@Override
	public int damageDropped(int meta)
	{
		return meta & 7;
	}
	
	@Override
	public void setBlockBoundsForItemRender()
	{
		setBlockBounds(0F, 0F, 0F, 1F, .5F, 1F);
	}
}
