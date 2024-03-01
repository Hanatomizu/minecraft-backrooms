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

import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.item.BlockItem
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

class MinecraftBackrooms : ModInitializer {

    val NAMESPACE = "backrooms"
    // Add blocks
    val ENTRANCE_FLOOR = Block(FabricBlockSettings.create())

    override fun onInitialize (){

        // Register blocks
        Registry.register(Registries.BLOCK, Identifier(NAMESPACE, "entrance_floor"), ENTRANCE_FLOOR)
        Registry.register(Registries.ITEM, Identifier(NAMESPACE, "entrance_floor"), BlockItem(ENTRANCE_FLOOR, FabricItemSettings()))

    }
}