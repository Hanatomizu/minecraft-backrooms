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

package moe.hanatomizu.minecraftbackrooms.objects

import net.minecraft.item.BlockItem
import net.minecraft.item.Item

object ModBlockItems {
    val ENTRANCE_FLOOR_ITEM: BlockItem = BlockItem(ModBlocks.ENTRANCE_FLOOR, Item.Settings())
    val ENTRANCE_WALL_ITEM: BlockItem = BlockItem(ModBlocks.ENTRANCE_WALL, Item.Settings())
}