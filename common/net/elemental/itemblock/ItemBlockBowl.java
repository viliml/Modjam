package net.elemental.itemblock;

import java.util.List;

import net.elemental.block.Blocks;
import net.elemental.lib.GeneralHelper;
import net.elemental.lib.Reference;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
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
	
	@SideOnly(Side.CLIENT)
	@Override
	public int getSpriteNumber()
	{
		return 1;
	}
	
	@Override
	public int getMetadata(int meta)
    {
        return meta;
    }
	
	@Override
	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float par8, float par9, float par10)
    {
		if(world.isRemote)
			return false;
		
		if (ForgeDirection.UP.ordinal() != side)
			return false;
		
		world.setBlock(x, y + 1, z, getBlockID(), itemstack.getItemDamage(), 3);
		
		if (!player.capabilities.isCreativeMode)
			--itemstack.stackSize;
		
		return true;
    }
	
	@Override
	public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata)
    {
		if(world.isRemote)
			return false;
		
		if (ForgeDirection.UP.ordinal() != side)
			return false;
		
		world.setBlock(x, y, z, getBlockID(), stack.getItemDamage(), 3);
		
		if (!player.capabilities.isCreativeMode)
			--stack.stackSize;
		
		return true;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean canPlaceItemBlockOnSide(World par1World, int par2, int par3, int par4, int par5, EntityPlayer par6EntityPlayer, ItemStack par7ItemStack)
    {
		return ForgeDirection.UP.ordinal() == par5;
    }
}
