/*
 * This file is part of Deathly Chambers Mod. Copyright (c) 2017, p455w0rd
 * (aka TheRealp455w0rd), All rights reserved unless otherwise stated.
 *
 * Deathly Chambers Mod is free software: you can redistribute it and/or
 * modify it under the terms of the MIT License.
 *
 * Deathly Chambers Mod is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the MIT License for
 * more details.
 *
 * You should have received a copy of the MIT License along with Deathly
 * Chambers Mod. If not, see <https://opensource.org/licenses/MIT>.
 */
package p455w0rd.deathlychambers.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.FMLCommonHandler;
import p455w0rd.deathlychambers.api.IModelProvider;
import p455w0rd.deathlychambers.init.ModConfig;
import p455w0rd.deathlychambers.init.ModCreativeTab;
import p455w0rd.deathlychambers.init.ModGlobals;
import p455w0rd.deathlychambers.world.WorldTeleporter;

/**
 * @author p455w0rd on Jul 29, 2018
 *
 */
public class BlockPortal extends Block implements IModelProvider {

	private static final String NAME = ModGlobals.MODID + ":portal";

	public BlockPortal() {
		super(Material.PORTAL);
		setCreativeTab(CreativeTabs.MISC);
		setRegistryName(new ResourceLocation(NAME));
		setUnlocalizedName(NAME);
		setCreativeTab(ModCreativeTab.getInstance());
		setHardness(5.0F);
		setResistance(2000.0F);
		setSoundType(SoundType.STONE);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (!worldIn.isRemote && !playerIn.isSneaking()) {
			if (worldIn.provider.getDimension() != ModConfig.dimID) {
				FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().transferPlayerToDimension((EntityPlayerMP) playerIn, ModConfig.dimID, new WorldTeleporter(playerIn.getServer().getWorld(ModConfig.dimID), pos));
			}
			else {
				FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().transferPlayerToDimension((EntityPlayerMP) playerIn, 0, new WorldTeleporter(playerIn.getServer().getWorld(0), pos));
			}
			return true;
		}
		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, side, hitX, hitY, hitZ);
	}

	@Override
	public float getBlockHardness(IBlockState blockState, World worldIn, BlockPos pos) {
		if (worldIn.provider.getDimension() == ModConfig.dimID) {
			return 1000F;
		}
		return super.getBlockHardness(blockState, worldIn, pos);
	}

	@Override
	public void registerModel() {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}

}
