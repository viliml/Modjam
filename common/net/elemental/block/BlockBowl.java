package net.elemental.block;

import java.util.List;
import java.util.Random;

import net.elemental.block.Blocks;
import net.elemental.client.render.RenderHandlers;
import net.elemental.lib.GeneralHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBowl extends Block
{
	@SideOnly(Side.CLIENT)
	private Icon innerIcon;
	
	@SideOnly(Side.CLIENT)
	private Icon topIcon;
	
	@SideOnly(Side.CLIENT)
	private Icon bottomIcon;

	public BlockBowl(int id) 
	{
		super(id, Material.wood);
		setCreativeTab(CreativeTabs.tabBlock);
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 5F / 16F, 1.0F);
	}
	
	@SuppressWarnings("rawtypes")
	public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB boundingBox, List list, Entity entity)
    {
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
        super.addCollisionBoxesToList(world, x, y, z, boundingBox, list, entity);
        float f = 0.125F;
        setBlockBounds(0.0F, 0.0F, 0.0F, f, 5F / 16F, 1.0F);
        super.addCollisionBoxesToList(world, x, y, z, boundingBox, list, entity);
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 5F / 16F, f);
        super.addCollisionBoxesToList(world, x, y, z, boundingBox, list, entity);
        setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 5F / 16F, 1.0F);
        super.addCollisionBoxesToList(world, x, y, z, boundingBox, list, entity);
        setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 5F / 16F, 1.0F);
        super.addCollisionBoxesToList(world, x, y, z, boundingBox, list, entity);
        setBlockBoundsForItemRender();
    }

    public void setBlockBoundsForItemRender()
    {
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 5F / 16F, 1.0F);
    }
	
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int side, int meta)
    {
		if (side == 1)
			return topIcon;
		if (side == 0)
			return bottomIcon;
		return blockIcon;
        //return side == 1 ? topIcon : (side == 0 ? bottomIcon : blockIcon);
    }
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
		System.out.println(func_111023_E());
		innerIcon = iconRegister.registerIcon(func_111023_E() + "_inner");
        topIcon = iconRegister.registerIcon(func_111023_E() + "_top");
        bottomIcon = iconRegister.registerIcon(func_111023_E() + "_bottom");
        blockIcon = iconRegister.registerIcon(func_111023_E() + "_side");
	}
	
	@SideOnly(Side.CLIENT)
    public static Icon func_94375_b(String par0Str)
    {
        return par0Str.equals("inner") ? Blocks.bowlBlock.innerIcon :
        	(par0Str.equals("bottom") ? Blocks.bowlBlock.bottomIcon : null);
    }
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs tabs, List list)
	{
		for(int i = 0; i < GeneralHelper.ELEMENTS.length; ++i)
		{
			list.add(new ItemStack(blockID, 0, i));
		}
	}
	
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	@Override
	public int getRenderType()
    {
        return RenderHandlers.RENDER_BOWL_RENDER_ID;
    }
	
	@Override
	public boolean hasComparatorInputOverride()
    {
        return false;
    }
	
	@Override
	public int idPicked(World world, int x, int y, int z)
	{
		return blockID;
	}

	@Override
	public int idDropped(int par1, Random random, int par3)
    {
        return blockID;
    }

	@Override
	public void fillWithRain(World world, int x, int y, int z)
	{
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	{
		return false;
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
}
