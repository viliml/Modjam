package net.elemental.block;

import java.util.List;

import net.elemental.client.render.RenderHandlers;
import net.elemental.lib.GeneralHelper;
import net.elemental.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockElementalOre extends Block {
	
	public static Icon[] overlays;
	
	public BlockElementalOre(int id) {
		super(id, Material.rock);
		setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public int getRenderType()
	{
		return RenderHandlers.RENDER_ORE_RENDER_ID;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
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
		if (overlays != null)
			return;
		overlays = new Icon[8];
		for (int i = 0; i < 7; ++i)
			overlays[i] = iconRegister.registerIcon(
				Reference.MOD_ID + ":" + GeneralHelper.ORES[i].toLowerCase() + "_ore_overlay");
		overlays[7] = overlays[4];
	}
	
	@SideOnly(Side.CLIENT)
	
    public int getLightValue(IBlockAccess world, int x, int y, int z)
    {
        if (world.getBlockId(x, y, z) == Blocks.elementalOreBlock2.blockID &&
        		(world.getBlockMetadata(x, y, z) & 3) == 3)
        	return 15;
        return 0;
    }
	
	public int damageDropped(int meta)
    {
        return meta;
    }
	
	@Override
	public int getRenderBlockPass()
	{
		return 1;
	}
}
