package net.elemental.block;

import java.util.List;

import net.elemental.Elemental;
import net.minecraft.block.BlockPressurePlate;
import net.minecraft.block.EnumMobType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockElementalPressurePlate extends BlockPressurePlate {

	public BlockElementalPressurePlate(int id) {
		super(id, null, Material.rock, EnumMobType.players);
		setCreativeTab(Elemental.creativeTabElemental);
		setHardness(0.5F);
	}
	
	@Override
    protected int getMetaFromWeight(int weight)
    {
        return weight > 0 ? 4 : 0;
    }
	
	protected int getMetaFromWeight(int weight, int prevMeta)
	{
		return (prevMeta & 3) + getMetaFromWeight(weight);
	}
	
	@Override
    protected int getPowerSupply(int meta)
    {
        return (meta & 4) == 4 ? 15 : 0;
    }
	
	@Override
    public boolean canPlaceBlockAt(World world, int x, int y, int z)
    {
        return world.doesBlockHaveSolidTopSurface(x, y - 1, z) ||
        		world.getBlockId(x, y - 1, z) == Blocks.elementalWallBlock.blockID;
    }
	
	@Override
    public void onNeighborBlockChange(World world, int x, int y, int z, int id)
    {
        boolean flag = false;

        if (!world.doesBlockHaveSolidTopSurface(x, y - 1, z) &&
        		world.getBlockId(x, y - 1, z) != Blocks.elementalWallBlock.blockID)
        {
            flag = true;
        }

        if (flag)
        {
            dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
            world.setBlockToAir(x, y, z);
        }
    }
	
	@Override
    protected void setStateIfMobInteractsWithPlate(World world, int x, int y, int z, int prev)
    {
        int state = this.getPlateState(world, x, y, z);
        boolean flag = prev > 0;
        boolean flag1 = state > 0;

        if (prev != state)
        {
            world.setBlockMetadataWithNotify(x, y, z,
            		getMetaFromWeight(state, world.getBlockMetadata(x, y, z)), 2);
            func_94354_b_(world, x, y, z);
            world.markBlockRangeForRenderUpdate(x, y, z, x, y, z);
        }

        if (!flag1 && flag)
        {
            world.playSoundEffect((double)x + 0.5D, (double)y + 0.1D, (double)z + 0.5D, "random.click", 0.3F, 0.5F);
        }
        else if (flag1 && !flag)
        {
            world.playSoundEffect((double)x + 0.5D, (double)y + 0.1D, (double)z + 0.5D, "random.click", 0.3F, 0.6F);
        }

        if (flag1)
        {
            world.scheduleBlockUpdate(x, y, z, blockID, tickRate(world));
        }
    }
	
	@Override
	public void registerIcons(IconRegister icon)
	{
	}
	
	@Override
	public Icon getIcon(int side, int meta)
	{
		return Blocks.elementalStoneBlock.getIcon(side, meta & 3);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void getSubBlocks(int id, CreativeTabs tab, List list)
	{
		for (int i = 0; i < 4; ++i)
			list.add(new ItemStack(id, 1, i));
	}
	
	public int damageDropped(int meta)
    {
        return meta & 3;
    }
}
