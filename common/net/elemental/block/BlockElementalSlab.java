package net.elemental.block;

import java.util.List;

import net.elemental.Elemental;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockElementalSlab extends BlockHalfSlab
{
	private static String[] names =
		{ "cobbleEarth", "cobbleAir", "cobbleFire", "cobbleWater", "brickEarth", "brickAir", "brickFire", "brickWater" };

	public BlockElementalSlab(int id, boolean isDouble)
	{
		super(id, isDouble, Material.rock);
		setCreativeTab(Elemental.creativeTabElemental);
		setResistance(10.0F);
		setStepSound(soundStoneFootstep);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
	}

	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int side, int meta)
	{
		return Blocks.elementalStoneBlock.getIcon(side, (meta & 7) + 4);
	}

	@Override
	public String getFullSlabName(int id)
	{
		return super.getUnlocalizedName() + "." + names[id];
	}

	@SideOnly(Side.CLIENT)
	@Override
	public int idPicked(World par1World, int par2, int par3, int par4)
	{
		return !isDoubleSlab ? blockID : Blocks.elementalSingleSlabBlock.blockID;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void getSubBlocks(int id, CreativeTabs tab, List list)
	{
		for (int i = 0; i < 8; ++i) list.add(new ItemStack(id, 1, i));
	}
	
	@Override
	public float getBlockHardness(World world, int x, int y, int z)
    {
		int meta = world.getBlockMetadata(x, y, z) & 7;
        return meta < 4 ? Block.cobblestone.blockHardness : Block.stoneBrick.blockHardness;
    }
}
