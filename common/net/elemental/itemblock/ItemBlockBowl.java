package net.elemental.itemblock;

import java.util.List;

import net.elemental.block.Blocks;
import net.elemental.lib.GeneralHelper;
import net.elemental.lib.Reference;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBlockBowl extends ItemBlock
{
	private Icon[] icons;
	
	public ItemBlockBowl(int id)
	{
		super(id);
		hasSubtypes = true;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemstack)
	{
		return Blocks.BOWL_BLOCK_UNLOCALIZED_NAME + ":" + GeneralHelper.ELEMENTS[itemstack.getItemDamage()];
	}
	
	@Override
	public CreativeTabs getCreativeTab()
	{
		return CreativeTabs.tabBlock;
	}
	
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void getSubItems(int par1, CreativeTabs creativeTab, List list)
	{
		for(int i = 0; i < GeneralHelper.ELEMENTS.length; ++i)
		{
			list.add(new ItemStack(itemID, 0, i));
		}
	}
	
	@SideOnly(Side.CLIENT)
	@Override
    public boolean requiresMultipleRenderPasses()
    {
        return true;
    }
	
	@Override
	public Icon getIconFromDamageForRenderPass(int meta, int pass)
    {
        if (pass == 0)
        {
        	return Item.bowlEmpty.getIconFromDamage(0);
        }
        if (pass == 1)
        {
        	return icons[meta];
        }
        return null;
    }
	
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
		icons = new Icon[4];
		//TODO Add the air overlay
		for (int i = 0; i < 4; i++)
			icons[i] = iconRegister.registerIcon(Reference.MOD_ID + ":" +
						"overlay" + GeneralHelper.ELEMENTS[i]);
	}
	
	@Override
	public int getRenderPasses(int meta)
	{
		return meta == 1 ? 1 : 2;
	}
}
