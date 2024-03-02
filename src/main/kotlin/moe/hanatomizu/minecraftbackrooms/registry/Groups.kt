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
package moe.hanatomizu.minecraftbackrooms.registry

import moe.hanatomizu.minecraftbackrooms.objects.ModBlockItems
import moe.hanatomizu.minecraftbackrooms.objects.ModGroups.ENTRANCE_BLOCKS
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.text.Text

object Groups {
    private fun register(registryKey: RegistryKey<ItemGroup>, iconItem: Item, translation: String): Unit {
        Registry.register(Registries.ITEM_GROUP, registryKey, FabricItemGroup.builder()
            .icon{ ItemStack(iconItem) }
            .displayName(Text.translatable(translation))
            .build()
        )
    }
    private fun addItem(registryKey: RegistryKey<ItemGroup>, item: Item): Unit {
        ItemGroupEvents.modifyEntriesEvent(registryKey)
            .register(ItemGroupEvents.ModifyEntries { content: FabricItemGroupEntries ->
                content.add(item)
            })
    }
    fun init(): Unit {
        // Register entrance
        register(ENTRANCE_BLOCKS, ModBlockItems.ENTRANCE_WALL_ITEM, "itemGroup.backrooms.entrance_block")
        addItem(ENTRANCE_BLOCKS, ModBlockItems.ENTRANCE_WALL_ITEM)
        addItem(ENTRANCE_BLOCKS, ModBlockItems.ENTRANCE_FLOOR_ITEM)
    }
}