package net.elemental.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.elemental.Elemental;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCauldron;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
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
        return par0Str.equals("inner") ? Elemental.bowlBlock.innerIcon :
        	(par0Str.equals("bottom") ? Elemental.bowlBlock.bottomIcon : null);
    }
}
