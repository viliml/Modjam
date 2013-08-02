package net.elemental.blocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockCauldron;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

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
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int par1, int par2)
    {
        return par1 == 1 ? this.topIcon : (par1 == 0 ? this.bottomIcon : this.blockIcon);
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
}
