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
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class MinecraftBackrooms : ModInitializer {
    companion object {
        const val NAMESPACE: String = "backrooms"
        val LOGGER: Logger = LoggerFactory.getLogger(NAMESPACE)
    }
    override fun onInitialize (){
        LOGGER.info("Start loading minecraft-backrooms!")
        // Register Item Groups
        moe.hanatomizu.minecraftbackrooms.registry.Groups.init()

        // Register blocks and block items
        moe.hanatomizu.minecraftbackrooms.registry.Blocks.init()
        moe.hanatomizu.minecraftbackrooms.registry.BlockItems.init()
        // Register Dimensions
        // TODO("Implement dimensions")
    }
}
