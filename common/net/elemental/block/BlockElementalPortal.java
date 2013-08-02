package net.elemental.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

import net.elemental.dimension.TutorialTeleporter;
import net.elemental.lib.Reference;
import net.elemental.lib.ShrineHelper;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockElementalPortal extends BlockBreakable
{
	public BlockElementalPortal(int par1)
	{
		super(par1, "elemental:portalElemental", Material.portal, false);
		setTickRandomly(true);
		setHardness(-1.0F);
		setStepSound(soundGlassFootstep);
		setLightValue(0.75F);
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockBounds(0F, 0F, 0F, 1F, 0.5F, 1F);
	}
	/**
	 * Ticks the block if it's been scheduled
	 */
	public void updateTick(World world, int par2, int par3, int par4, Random par5Random)
	{
		super.updateTick(world, par2, par3, par4, par5Random);
		if (world.provider.isSurfaceWorld() && par5Random.nextInt(2000) < world.difficultySetting)
		{
			int l;
			for (l = par3; !world.doesBlockHaveSolidTopSurface(par2, l, par4) && l > 0; --l)
			{
				;
			}
			if (l > 0 && !world.isBlockNormalCube(par2, l + 1, par4))
			{
				Entity entity = ItemMonsterPlacer.spawnCreature(world, 57, (double)par2 + 0.5D, (double)l + 1.1D, (double)par4 + 0.5D);
				if (entity != null)
				{
					entity.timeUntilPortal = entity.getPortalCooldown();
				}
			}
		}
	}
	/**
	 * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
	 * cleared to be reused)
	 */
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int par2, int par3, int par4)
	{
		return null;
	}
	
	/**
	 * Is this block (a) opaque and (B) a full 1m cube? This determines whether or not to render the shared face of two
	 * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
	 */
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	/**
	 * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
	 */
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	/**
	 * Checks to see if this location is valid to create a portal and will return True if it does. Args: world, x, y, z
	 */
	public boolean tryToCreatePortal(World world, int x, int y, int z)
	{
		return ShrineHelper.canMakePortal(world, x, y - 1, z);
	}
	
	/**
	 * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
	 * their own) Args: x, y, z, neighbor blockID
	 */
	public void onNeighborBlockChange(World world, int x, int y, int z, int par5)
	{
		if (!ShrineHelper.canMakePortal(world, x, y - 1, z)) world.setBlockToAir(x, y, z);
	}
	
	@SideOnly(Side.CLIENT)
	/**
	 * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
	 * coordinates. Args: blockAccess, x, y, z, side
	 */
	public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
	{
		if (par1IBlockAccess.getBlockId(par2, par3, par4) == blockID)
		{
			return false;
		}
		else
		{
			boolean flag = par1IBlockAccess.getBlockId(par2 - 1, par3, par4) == blockID && par1IBlockAccess.getBlockId(par2 - 2, par3, par4) != blockID;
			boolean flag1 = par1IBlockAccess.getBlockId(par2 + 1, par3, par4) == blockID && par1IBlockAccess.getBlockId(par2 + 2, par3, par4) != blockID;
			boolean flag2 = par1IBlockAccess.getBlockId(par2, par3, par4 - 1) == blockID && par1IBlockAccess.getBlockId(par2, par3, par4 - 2) != blockID;
			boolean flag3 = par1IBlockAccess.getBlockId(par2, par3, par4 + 1) == blockID && par1IBlockAccess.getBlockId(par2, par3, par4 + 2) != blockID;
			boolean flag4 = flag || flag1;
			boolean flag5 = flag2 || flag3;
			return flag4 && par5 == 4 ? true : (flag4 && par5 == 5 ? true : (flag5 && par5 == 2 ? true : flag5 && par5 == 3));
		}
	}
	
	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	public int quantityDropped(Random par1Random)
	{
		return 0;
	}
	
	/**
	 * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
	 */
	public void onEntityCollidedWithBlock(World world, int par2, int par3, int par4, Entity par5Entity)
	{
		if ((par5Entity.ridingEntity == null) && (par5Entity.riddenByEntity == null) && ((par5Entity instanceof EntityPlayerMP)))
		{
			EntityPlayerMP thePlayer = (EntityPlayerMP)par5Entity;
			if (thePlayer.timeUntilPortal > 0)
			{
				thePlayer.timeUntilPortal = 10;
			}
			else if (thePlayer.dimension != Reference.dimensionID)
			{
				thePlayer.timeUntilPortal = 10;
				thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, Reference.dimensionID, new TutorialTeleporter(thePlayer.mcServer.worldServerForDimension(Reference.dimensionID)));
			}
			else {
				thePlayer.timeUntilPortal = 10;
				thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, 0, new TutorialTeleporter(thePlayer.mcServer.worldServerForDimension(0)));
			}
		}
	}
	
	@SideOnly(Side.CLIENT)
	/**
	 * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
	 */
	public int getRenderBlockPass()
	{
		return 1;
	}
	
	@SideOnly(Side.CLIENT)
	/**
	 * A randomly called display update to be able to add particles or other items for display
	 */
	public void randomDisplayTick(World world, int par2, int par3, int par4, Random par5Random)
	{
		if (par5Random.nextInt(100) == 0)
		{
			world.playSound((double)par2 + 0.5D, (double)par3 + 0.5D, (double)par4 + 0.5D, "portal.portal", 0.5F, par5Random.nextFloat() * 0.4F + 0.8F, false);
		}
		for (int l = 0; l < 4; ++l)
		{
			double d0 = (double)((float)par2 + par5Random.nextFloat());
			double d1 = (double)((float)par3 + par5Random.nextFloat());
			double d2 = (double)((float)par4 + par5Random.nextFloat());
			double d3 = 0.0D;
			double d4 = 0.0D;
			double d5 = 0.0D;
			int i1 = par5Random.nextInt(2) * 2 - 1;
			d3 = ((double)par5Random.nextFloat() - 0.5D) * 0.5D;
			d4 = ((double)par5Random.nextFloat() - 0.5D) * 0.5D;
			d5 = ((double)par5Random.nextFloat() - 0.5D) * 0.5D;
			if (world.getBlockId(par2 - 1, par3, par4) != blockID && world.getBlockId(par2 + 1, par3, par4) != blockID)
			{
				d0 = (double)par2 + 0.5D + 0.25D * (double)i1;
				d3 = (double)(par5Random.nextFloat() * 2.0F * (float)i1);
			}
			else
			{
				d2 = (double)par4 + 0.5D + 0.25D * (double)i1;
				d5 = (double)(par5Random.nextFloat() * 2.0F * (float)i1);
			}
			world.spawnParticle("portal", d0, d1, d2, d3, d4, d5);
		}
	}
	
	@SideOnly(Side.CLIENT)
	/**
	 * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
	 */
	public int idPicked(World world, int par2, int par3, int par4)
	{
		return 0;
	}
}