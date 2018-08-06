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
package p455w0rd.deathlychambers.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import p455w0rd.deathlychambers.api.IModelProvider;
import p455w0rd.deathlychambers.block.BlockPortal;

/**
 * @author p455w0rd on Jul 29, 2018
 *
 */
public class ModBlocks {

	public static final BlockPortal PORTAL = new BlockPortal();
	private static List<Block> list = new ArrayList<>();

	public static List<Block> getList() {
		if (list.isEmpty()) {
			list.add(PORTAL);
		}
		return list;
	}

	@SideOnly(Side.CLIENT)
	public static void registerModels() {
		for (Block block : list) {
			if (block instanceof IModelProvider) {
				((IModelProvider) block).registerModel();
			}
		}
	}

}
