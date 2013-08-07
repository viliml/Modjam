package net.elemental.block;

import java.util.Random;

import net.elemental.client.render.RenderHandlers;
import net.elemental.tileentity.TileEntityBowl;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class BlockBowlNew extends BlockContainer
{
	public BlockBowlNew(int id)
	{
		super(id, Material.wood);
		setBlockBounds(1F / 16F, 0F, 1F / 16F, 15F / 16F, 5F / 16F, 15F / 16F);
	}

	@Override
	public TileEntity createNewTileEntity(World world)
	{
		return new TileEntityBowl();
	}

	@Override
	public int getRenderType()
	{
		return RenderHandlers.RENDER_BOWL_RENDER_ID;
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
	public void registerIcons(IconRegister iconRegister)
	{
		blockIcon = iconRegister.registerIcon("elemental:bowlBlock_bottom");
	}

	@Override
	public void randomDisplayTick(World world, int x, int y, int z, Random rand)
	{
		if(world.getBlockMetadata(x, y, z) == 2)
		{
			world.spawnParticle("smoke", x + 2. / 16. + rand.nextDouble() * (14. / 16. - 2. / 16.), y + 0.375D, z + 2. / 16. + rand.nextDouble() * (14. / 16. - 2. / 16.), 0D, 0D, 0D);
		}
		if(world.getBlockMetadata(x, y, z) == 3)
		{
			world.spawnParticle("flame", x + 2. / 16. + rand.nextDouble() * (14. / 16. - 2. / 16.), y + 0.375D, z + 2. / 16. + rand.nextDouble() * (14. / 16. - 2. / 16.), 0D, 0D, 0D);
		}
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int side, float hitXx, float hitY, float hitZ)
	{
		if (world.getBlockMetadata(x, y, z) != 0)
			return false;
		if (entityPlayer.getCurrentEquippedItem() == null)
			return false;
		
		if (entityPlayer.getCurrentEquippedItem().getItem().itemID == Block.dirt.blockID ||
				entityPlayer.getCurrentEquippedItem().getItem().itemID == Block.grass.blockID ||
				entityPlayer.getCurrentEquippedItem().getItem().itemID == Block.mycelium.blockID)
		{
			world.setBlockMetadataWithNotify(x, y, z, 1, 3); //earth
			if (!entityPlayer.capabilities.isCreativeMode)
				entityPlayer.getCurrentEquippedItem().stackSize--;//
			
			return true;
		}
		if (entityPlayer.getCurrentEquippedItem().getItem().itemID ==
				Block.blockNetherQuartz.blockID)
		{
			world.setBlockMetadataWithNotify(x, y, z, 2, 3); //air
			if (!entityPlayer.capabilities.isCreativeMode)
				entityPlayer.getCurrentEquippedItem().stackSize--;
			
			return true;
		}
		if (entityPlayer.getCurrentEquippedItem().getItem().itemID == Item.flintAndSteel.itemID ||
				entityPlayer.getCurrentEquippedItem().getItem().itemID == Block.fire.blockID ||
				entityPlayer.getCurrentEquippedItem().getItem().itemID == Item.fireballCharge.itemID ||
				entityPlayer.getCurrentEquippedItem().getItem().itemID == Block.torchWood.blockID)
		{
			world.setBlockMetadataWithNotify(x, y, z, 3, 3); //fire
			if (!entityPlayer.capabilities.isCreativeMode)
			{
				if (entityPlayer.getCurrentEquippedItem().getItem().itemID == Item.flintAndSteel.itemID)
					entityPlayer.getCurrentEquippedItem().damageItem(1, entityPlayer);
				else
					entityPlayer.getCurrentEquippedItem().stackSize--;
			}
			
			return true;
		}
		if (entityPlayer.getCurrentEquippedItem().getItem().itemID == Block.ice.blockID ||
				entityPlayer.getCurrentEquippedItem().getItem().itemID == Block.snow.blockID ||
				entityPlayer.getCurrentEquippedItem().getItem().itemID == Item.bucketWater.itemID ||
				entityPlayer.getCurrentEquippedItem().getItem().itemID == Item.potion.itemID)
		{
			entityPlayer.worldObj.setBlockMetadataWithNotify(x, y, z, 4, 3); //water
			if (!entityPlayer.capabilities.isCreativeMode)
			{
				if (entityPlayer.getCurrentEquippedItem().getItem().itemID == Item.bucketWater.itemID)
					entityPlayer.setCurrentItemOrArmor(0, new ItemStack(Item.bucketEmpty));
				else
					entityPlayer.getCurrentEquippedItem().stackSize--;
			}
			
			return true;
		}
	
		return false;
	}
	
	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z)
    {
        return new ItemStack(Item.bowlEmpty);
    }
	
	@Override
	public int idDropped(int meta, Random rand, int fortune)
    {
        return Item.bowlEmpty.itemID;
    }
	
	@Override
	public boolean canSilkHarvest(World world, EntityPlayer player, int x, int y, int z, int meta)
    {
		return false;
    }
}