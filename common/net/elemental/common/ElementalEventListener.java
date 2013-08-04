package net.elemental.common;

import net.elemental.biome.BasicElementalBiomeGen;
import net.elemental.biome.EnumBiomes;
import net.elemental.block.Blocks;
import net.elemental.dimension.Dimensions;
import net.elemental.lib.ShrineHelper;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import net.minecraftforge.event.terraingen.BiomeEvent.GetVillageBlockID;
import net.minecraftforge.event.terraingen.BiomeEvent.GetVillageBlockMeta;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;

public class ElementalEventListener
{
	@ForgeSubscribe
	public void playerInteractListener(PlayerInteractEvent event)
	{
		if (event.action != Action.RIGHT_CLICK_BLOCK)
			return;
		if (event.face != 1)
			return;
		if (event.entityPlayer.getCurrentEquippedItem() == null)
			return;
		if (event.entityPlayer.getCurrentEquippedItem().getItem().itemID ==
				ShrineHelper.ACTIVATOR_ITEM_ID)
		{
			if (event.entityPlayer.capabilities.isCreativeMode)
				ShrineHelper.buildShrine(event.entityPlayer.worldObj, event.x, event.y, event.z);
			if (!ShrineHelper.canMakePortal(event.entityPlayer.worldObj, event.x, event.y, event.z))
				return;
			event.entityPlayer.worldObj.setBlock(event.x, event.y + 1, event.z, Blocks.portalBlock.blockID);
			
			event.setCanceled(true);
		}
		if (event.entityPlayer.getCurrentEquippedItem().getItem().itemID ==
				Item.bowlEmpty.itemID)
		{
			event.entityPlayer.worldObj.setBlock(event.x, event.y + 1, event.z, Blocks.bowlBlock.blockID);
			if (!event.entityPlayer.capabilities.isCreativeMode)
				event.entityPlayer.getCurrentEquippedItem().stackSize--;
			
			event.setCanceled(true);
		}
	}

	@ForgeSubscribe
	public void getVillageBlock(GetVillageBlockID event)
	{
		if (!(event.biome instanceof BasicElementalBiomeGen))
		{
			event.setResult(Result.ALLOW);
			return;
		}
		EnumBiomes biome = ((BasicElementalBiomeGen) event.biome).getBiome();
		if (event.original == Block.wood.blockID)
		{
			event.replacement = Blocks.elementalStoneBlock.blockID;
			event.setResult(Result.DENY);
			return;
		}
		if (event.original == Block.cobblestone.blockID)
		{
			event.replacement = Blocks.elementalStoneBlock.blockID;
			event.setResult(Result.DENY);
			return;
		}
		if (event.original == Block.planks.blockID)
		{
			event.replacement = Blocks.elementalStoneBlock.blockID;
			event.setResult(Result.DENY);
			return;
		}
		if (event.original == Block.stairsWoodOak.blockID)
		{
			event.replacement = Blocks.elementalStairsBlocks[1][biome.ordinal()].blockID;
			event.setResult(Result.DENY);
			return;
		}
		if (event.original == Block.stairsCobblestone.blockID)
		{
			event.replacement = Blocks.elementalStairsBlocks[0][biome.ordinal()].blockID;
			event.setResult(Result.DENY);
			return;
		}
		/*if (event.original == Block.gravel.blockID)
		{
			event.replacement = Blocks.elementalStoneBlock.blockID;
			event.setResult(Result.DENY);
			return;
		}*/
		if (event.original == Block.stoneSingleSlab.blockID)
		{
			event.replacement = Blocks.elementalSlabBlock.blockID;
			event.setResult(Result.DENY);
			return;
		}
		if (event.original == Block.stoneDoubleSlab.blockID)
		{
			event.replacement = Blocks.elementalStoneBlock.blockID;
			event.setResult(Result.DENY);
			return;
		}
		if (event.original == Block.fence.blockID)
		{
			event.replacement = Blocks.elementalWallBlock.blockID;
			event.setResult(Result.DENY);
			return;
		}
		event.setResult(Result.ALLOW);
	}

	@ForgeSubscribe
	public void getVillageBlockMeta(GetVillageBlockMeta event)
	{
		if (!(event.biome instanceof BasicElementalBiomeGen))
		{
			event.setResult(Result.ALLOW);
			return;
		}
		EnumBiomes biome = ((BasicElementalBiomeGen) event.biome).getBiome();
		System.out.println(event.biome + " " + event.original);
		if (event.original == Block.wood.blockID)
		{
			event.replacement = biome.ordinal();
			System.out.println(event.replacement);
			event.setResult(Result.DENY);
			return;
		}
		if (event.original == Block.cobblestone.blockID)
		{
			event.replacement = 4 + biome.ordinal();
			System.out.println(event.replacement);
			event.setResult(Result.DENY);
			return;
		}
		if (event.original == Block.planks.blockID)
		{
			event.replacement = 8 + biome.ordinal();
			System.out.println(event.replacement);
			event.setResult(Result.DENY);
			return;
		}
		/*if (event.original == Block.gravel.blockID)
		{
			event.replacement = 8 + biome.ordinal();
			System.out.println(event.replacement);
			event.setResult(Result.DENY);
			return;
		}*/
		if (event.original == Block.stoneSingleSlab.blockID)
		{
			event.replacement = 4 + biome.ordinal();
			System.out.println(event.replacement);
			event.setResult(Result.DENY);
			return;
		}
		if (event.original == Block.stoneDoubleSlab.blockID)
		{
			event.replacement = 12 + biome.ordinal();
			event.setResult(Result.DENY);
			return;
		}
		if (event.original == Block.fence.blockID)
		{
			event.replacement = biome.ordinal();
			event.setResult(Result.DENY);
			return;
		}
		event.setResult(Result.ALLOW);
	}

	@ForgeSubscribe
	public void decorateBiome(DecorateBiomeEvent.Post event)
	{
		if (event.world.provider.dimensionId != Dimensions.ELEMENTAL_DIMENSION_ID)
			return;
		int i, j, k;
		for (i = event.chunkX; i < event.chunkX + 16; ++i)
			for (k = event.chunkZ; k < event.chunkZ + 16; ++k)
			{
				EnumBiomes enumBiome =
						((BasicElementalBiomeGen) event.world.getBiomeGenForCoords(i, k)).getBiome();
				for (j = 0; j < 256; ++j)
					changeIt(event.world, i, j, k, enumBiome);
			}
	}

	private void changeIt(World world, int i, int j, int k, EnumBiomes enumBiome)
	{
		if (world.getBlockId(i, j, k) == Block.stone.blockID)
			world.setBlock(i, j, k,
					Blocks.elementalStoneBlock.blockID, enumBiome.ordinal(), 2);
		if (world.getBlockId(i, j, k) == Block.oreCoal.blockID)
			world.setBlock(i, j, k,
					Blocks.elementalOreBlock1.blockID, enumBiome.ordinal(), 2);
		if (world.getBlockId(i, j, k) == Block.oreIron.blockID)
			world.setBlock(i, j, k,
					Blocks.elementalOreBlock1.blockID, 4 + enumBiome.ordinal(), 2);
		if (world.getBlockId(i, j, k) == Block.oreGold.blockID)
			world.setBlock(i, j, k,
					Blocks.elementalOreBlock1.blockID, 8 + enumBiome.ordinal(), 2);
		if (world.getBlockId(i, j, k) == Block.oreLapis.blockID)
			world.setBlock(i, j, k,
					Blocks.elementalOreBlock1.blockID, 12 + enumBiome.ordinal(), 2);
		if (world.getBlockId(i, j, k) == Block.oreRedstone.blockID)
			world.setBlock(i, j, k,
					Blocks.elementalOreBlock2.blockID, enumBiome.ordinal(), 2);
		if (world.getBlockId(i, j, k) == Block.oreDiamond.blockID)
			world.setBlock(i, j, k,
					Blocks.elementalOreBlock2.blockID, 8 + enumBiome.ordinal(), 2);
	}
}
