package net.elemental.block;

import java.util.List;
import java.util.Random;

import net.elemental.lib.GeneralHelper;
import net.elemental.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockElementalOre extends Block {

	private Icon[] icons;
	private boolean second;

	public BlockElementalOre(int id, boolean isSecond) {
		super(id, Material.rock);
		setCreativeTab(CreativeTabs.tabBlock);
		second = isSecond;
		setHardness(3F);
		setResistance(5F);
		setStepSound(soundStoneFootstep);
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
		icons = new Icon[16];
		int i, j;
		if (second)
			for (i = 0; i < 4; ++i)
				for (j = 0; j < 4; ++j)
					icons[i * 4 + j] = iconRegister.registerIcon(
						Reference.MOD_ID + ":" +
							GeneralHelper.ELEMENTS[j].toLowerCase() + "_" +
							GeneralHelper.ORES[i + 4].toLowerCase() + "_ore");
		else
			for (i = 0; i < 4; ++i)
				for (j = 0; j < 4; ++j)
					icons[i * 4 + j] = iconRegister.registerIcon(
						Reference.MOD_ID + ":" +
								GeneralHelper.ELEMENTS[j].toLowerCase() + "_" +
								GeneralHelper.ORES[i].toLowerCase() + "_ore");
		//Register the active redstone icons. Simpler than to make an if in getIcon()
		if (second)
			for (i = 0; i < 4; i++) icons[12 + i] = icons[i];
	}
	
	@Override
	public Icon getIcon(int side, int meta)
	{
		return icons[meta];
	}

	@SideOnly(Side.CLIENT)
	@Override
	public int getLightValue(IBlockAccess world, int x, int y, int z)
	{
		if (second && (world.getBlockMetadata(x, y, z) >> 3) == 3)
			return 15;
		return 0;
	}

	@Override
	public int damageDropped(int meta)
	{
		return meta;
	}

    /**
     * How many world ticks before ticking
     */
    public int tickRate(World world)
    {
        return second ? 30 : 0;
    }

    /**
     * Called when the block is clicked by a player. Args: x, y, z, entityPlayer
     */
    public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player)
    {
    	if (second && )
        this.glow(world, x, y, z);
        super.onBlockClicked(world, x, y, z, player);
    }

    /**
     * Called whenever an entity is walking on top of this block. Args: world, x, y, z, entity
     */
    public void onEntityWalking(World world, int x, int y, int z, Entity par5Entity)
    {
        this.glow(world, x, y, z);
        super.onEntityWalking(world, x, y, z, par5Entity);
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float par7, float par8, float par9)
    {
        this.glow(world, x, y, z);
        return super.onBlockActivated(world, x, y, z, player, side, par7, par8, par9);
    }

    /**
     * The redstone ore glows.
     */
    private void glow(World world, int x, int y, int z)
    {
        this.sparkle(world, x, y, z);

        if (this.blockID == Block.oreRedstone.blockID)
        {
            world.setBlock(x, y, z, Block.oreRedstoneGlowing.blockID);
        }
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World world, int x, int y, int z, Random random)
    {
        if (this.blockID == Block.oreRedstoneGlowing.blockID)
        {
            world.setBlock(x, y, z, Block.oreRedstone.blockID);
        }
    }
}
