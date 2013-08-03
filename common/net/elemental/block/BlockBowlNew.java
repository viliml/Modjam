package net.elemental.block;

import net.elemental.tileentity.TileEntityBowl;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockBowlNew extends BlockContainer
{
	public BlockBowlNew(int id) 
	{
		super(id, Material.wood);
		setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public TileEntity createNewTileEntity(World world) 
	{
		return new TileEntityBowl();
	}
	
	@Override
	public int getRenderType()
	{
		return -1;
	}
	
	@Override
    public boolean isOpaqueCube()
	{
            return false;
    }
	
	@Override
    public boolean renderAsNormalBlock()
	{
            return false;
    }
	
	@Override
    public void registerIcons(IconRegister icon)
	{
            this.blockIcon = icon.registerIcon(Blocks.BOWL_BLOCK_UNLOCALIZED_NAME);
    }
}
