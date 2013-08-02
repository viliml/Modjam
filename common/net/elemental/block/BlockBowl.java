package net.elemental.block;

import java.util.List;
import java.util.Random;

import net.elemental.block.Blocks;
import net.elemental.client.render.RenderHandlers;
import net.minecraft.block.BlockCauldron;
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

public class BlockBowl extends BlockCauldron 
{
	@SideOnly(Side.CLIENT)
	private Icon innerIcon;
	
	@SideOnly(Side.CLIENT)
	private Icon topIcon;
	
	@SideOnly(Side.CLIENT)
	private Icon bottomIcon;

	public BlockBowl(int id) 
	{
		super(id);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	@SuppressWarnings("rawtypes")
	public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB boundingBox, List list, Entity entity)
    {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.3125F, 1.0F);
        super.addCollisionBoxesToList(world, x, y, z, boundingBox, list, entity);
        float f = 0.125F;
        this.setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
        super.addCollisionBoxesToList(world, x, y, z, boundingBox, list, entity);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
        super.addCollisionBoxesToList(world, x, y, z, boundingBox, list, entity);
        this.setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        super.addCollisionBoxesToList(world, x, y, z, boundingBox, list, entity);
        this.setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
        super.addCollisionBoxesToList(world, x, y, z, boundingBox, list, entity);
        this.setBlockBoundsForItemRender();
    }
	
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int side, int meta)
    {
        return side == 1 ? this.topIcon : (side == 0 ? this.bottomIcon : this.blockIcon);
    }
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
		this.innerIcon = iconRegister.registerIcon(this.func_111023_E() + "_inner");
        this.topIcon = iconRegister.registerIcon(this.func_111023_E() + "_top");
        this.bottomIcon = iconRegister.registerIcon(this.func_111023_E() + "_bottom");
        this.blockIcon = iconRegister.registerIcon(this.func_111023_E() + "_side");
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
		// 4 bowls, 4 elements
		list.add(new ItemStack(par1, 1, 0));
		list.add(new ItemStack(par1, 1, 1));
		list.add(new ItemStack(par1, 1, 2));
		list.add(new ItemStack(par1, 1, 3));
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
}
