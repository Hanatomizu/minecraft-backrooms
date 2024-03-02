/*
* Copyright 2024 Hanatomizu
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package moe.hanatomizu.minecraftbackrooms

import moe.hanatomizu.minecraftbackrooms.objects.ModBlockItems
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents.ModifyEntries
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.text.Text
import net.minecraft.util.Identifier


class MinecraftBackrooms : ModInitializer {

    private val NAMESPACE = "backrooms"

    // add Item Groups
    val ENTRANCE_BLOCKS: RegistryKey<ItemGroup> = RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier(NAMESPACE, "entrance_blocks"))

    override fun onInitialize (){
        // Register Item Groups
        Registry.register(Registries.ITEM_GROUP, ENTRANCE_BLOCKS, FabricItemGroup.builder()
            .icon{ ItemStack(ModBlockItems.ENTRANCE_WALL_ITEM) }
            .displayName(Text.translatable("itemGroup.backrooms.entrance_blocks"))
            .build()
        )

        // Add Items into item groups
        ItemGroupEvents.modifyEntriesEvent(ENTRANCE_BLOCKS)
            .register(ModifyEntries { content: FabricItemGroupEntries ->
                content.add(ModBlockItems.ENTRANCE_FLOOR_ITEM)
                content.add(ModBlockItems.ENTRANCE_WALL_ITEM)
            })

        // Register blocks and block items
        moe.hanatomizu.minecraftbackrooms.registry.Blocks.init()
        moe.hanatomizu.minecraftbackrooms.registry.BlockItems.init()
    }
}
