package net.elemental.biome;

import net.elemental.block.Blocks;
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;

public class ElementalBiomeDecorator extends BiomeDecorator {
	
	EnumBiomes enumBiome;
	
	public ElementalBiomeDecorator(BiomeGenBase biome) {
		super(biome);
		enumBiome = ((BasicElementalBiomeGen) biome).getBiome();
	}
	
	@Override
	protected void decorate()
	{
		super.decorate();
		System.out.println(chunk_X * 16 + " " + chunk_Z * 16);
		int i, j, k;
		for (i = chunk_X * 16; i < (chunk_X + 1) * 16; ++i)
			for (j = 0; j < 256; ++j)
				for (k = chunk_Z * 16; k < (chunk_Z * 16); ++k)
				{
					if (currentWorld.getBlockId(i, j, k) == Block.stone.blockID)
					{
						System.out.println(i + " " + j + " " + k + " " + enumBiome.ordinal());
						currentWorld.setBlock(i, j, k,
								Blocks.elementalStoneBlock.blockID, enumBiome.ordinal(), 3);
					}
				}
	}
}
