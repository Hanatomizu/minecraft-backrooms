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

import moe.hanatomizu.minecraftbackrooms.NAMESPACE
import moe.hanatomizu.minecraftbackrooms.objects.ModBlockItems
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

object BlockItems {
    private fun register(itemPath: String, item: net.minecraft.item.Item): Unit{
        Registry.register(Registries.ITEM, Identifier(NAMESPACE, itemPath), item)
    }
    fun init(): Unit{
        register("entrance_floor", ModBlockItems.ENTRANCE_FLOOR_ITEM)
        register("entrance_wall", ModBlockItems.ENTRANCE_WALL_ITEM)
    }
}