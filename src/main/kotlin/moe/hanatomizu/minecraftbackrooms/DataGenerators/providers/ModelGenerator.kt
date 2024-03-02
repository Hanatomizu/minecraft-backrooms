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
package moe.hanatomizu.minecraftbackrooms.DataGenerators.providers

import moe.hanatomizu.minecraftbackrooms.objects.ModBlockItems.ENTRANCE_FLOOR_ITEM
import moe.hanatomizu.minecraftbackrooms.objects.ModBlockItems.ENTRANCE_WALL_ITEM
import moe.hanatomizu.minecraftbackrooms.objects.ModBlocks.ENTRANCE_FLOOR
import moe.hanatomizu.minecraftbackrooms.objects.ModBlocks.ENTRANCE_WALL
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.minecraft.data.client.BlockStateModelGenerator
import net.minecraft.data.client.ItemModelGenerator
import net.minecraft.data.client.Models

class ModelGenerator(output: FabricDataOutput?) : FabricModelProvider(output) {
    override fun generateBlockStateModels(blockStateModelGenerator: BlockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ENTRANCE_FLOOR)
        blockStateModelGenerator.registerSimpleCubeAll(ENTRANCE_WALL)
    }

    override fun generateItemModels(itemModelGenerator: ItemModelGenerator) {

    }
}
