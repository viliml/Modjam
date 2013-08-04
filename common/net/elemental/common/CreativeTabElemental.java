package net.elemental.common;

import net.elemental.lib.ShrineHelper;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CreativeTabElemental extends CreativeTabs {

	public CreativeTabElemental(String label) {
		super(label);
	}

	public CreativeTabElemental(int par1, String par2Str) {
		super(par1, par2Str);
	}
	
	@SideOnly(Side.CLIENT)
    public int getTabIconItemIndex()
    {
        return ShrineHelper.ACTIVATOR_ITEM_ID;
    }
	
	@SideOnly(Side.CLIENT)
    public String getTranslatedTabLabel()
    {
        return getTabLabel();
    }
}
