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

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

/**
 * @author p455w0rd on Jul 29, 2018
 *
 */
public class ModCreativeTab extends CreativeTabs {

	private static final ModCreativeTab INSTANCE = new ModCreativeTab();

	private ModCreativeTab() {
		super(ModGlobals.MODID);
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModBlocks.PORTAL);
	}

	public static final ModCreativeTab getInstance() {
		return INSTANCE;
	}
}